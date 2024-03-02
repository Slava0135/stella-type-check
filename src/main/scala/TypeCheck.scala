package io.github.slava0135.stella

import stellaParser._

import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream, ParserRuleContext}

import scala.collection.{immutable, mutable}
import scala.jdk.CollectionConverters.IteratorHasAsScala

object TypeCheck {
  def go(text: String): Result = {
    val tree = getTree(text)
    tree.accept(TypeCheckVisitor(immutable.Map.empty, None)) match {
      case Left(err) => Bad(err.toString)
      case Right(_) => Ok()
    }
  }

  def unsupportedExtensions(text: String): Set[String] = {
    val tree = getTree(text)
    var required = Set.empty[String]
    val supported = Set(
      "#unit-type",
      "#pairs",
      "#tuples",
      "#records",
      "#natural-literals",
      "#type-ascriptions",
      "#let-bindings",
      "#sum-types",
      "#lists",
      "#fixpoint-combinator",
      "#variants",
      "#structural-patterns",
    )
    val listener: stellaParserBaseListener = new stellaParserBaseListener {
      override def enterAnExtension(ctx: AnExtensionContext): Unit = {
        ctx.extensionNames.iterator().asScala.foreach(it => required += it.getText)
      }
    }
    ParseTreeWalker.DEFAULT.walk(listener, tree)
    required -- supported
  }

  private def getTree(text: String): ProgramContext = {
    val lexer = new stellaLexer(CharStreams.fromString(text))
    val parser = new stellaParser(new CommonTokenStream(lexer))
    parser.program()
  }
}

private case class TypeCheckVisitor(vars: immutable.Map[String, Type], expectedT: Option[Type]) extends stellaParserBaseVisitor[Either[Error, Type]] {

  override def visitProgram(ctx: ProgramContext): Either[Error, Type] = {
    val topLevelDecl = mutable.Map[String, Type]()
    ctx.decl().stream().forEach(it => {
      val func = it.asInstanceOf[DeclFunContext]
      topLevelDecl.put(func.name.getText, Fun(func.paramDecl(0).paramType.accept(new TypeContextVisitor), func.returnType.accept(new TypeContextVisitor)))
    })
    EitherLift.liftEither(ctx.decl().iterator().asScala.map(it => it.accept(copy(vars ++ topLevelDecl, None))).toSeq) match {
      case Left(err) => return Left(err)
      case _ =>
    }
    if (!topLevelDecl.contains("main")) {
      return Left(ERROR_MISSING_MAIN())
    }
    Right(null)
  }

  override def visitDeclFun(ctx: DeclFunContext): Either[Error, Type] = {
    val param = ctx.paramDecl(0)
    val funT = Fun(param.paramType.accept(TypeContextVisitor()), ctx.returnType.accept(TypeContextVisitor()))
    copy(vars ++ Seq((param.name.getText, funT.param)), Some(funT.res)) check ctx.returnExpr match {
      case err@Left(_) => err
      case Right(_) => Right(funT)
    }
  }

  override def visitIf(ctx: IfContext): Either[Error, Type] = {
    copy(vars, Some(Bool())).check(ctx.condition) match {
      case err@Left(_) => return err
      case _ =>
    }
    check(ctx.thenExpr) match {
      case Right(thenT) =>
        copy(vars, Some(thenT)).check(ctx.elseExpr) match {
          case Right(elseT) => Right(elseT)
          case err@Left(_) => err
        }
      case err@Left(_) => err
    }
  }

  override def visitSucc(ctx: SuccContext): Either[Error, Type] = copy(vars, Some(Nat())) check ctx.expr()

  override def visitIsZero(ctx: IsZeroContext): Either[Error, Type] = {
    copy(vars, Some(Nat())) check ctx.expr() match {
      case Right(_) => Right(Bool())
      case err@Left(_) => err
    }
  }

  override def visitVar(ctx: VarContext): Either[Error, Type] = {
    vars.get(ctx.name.getText) match {
      case None => Left(ERROR_UNDEFINED_VARIABLE(ctx))
      case Some(t) => Right(t)
    }
  }

  override def visitNatRec(ctx: NatRecContext): Either[Error, Type] = {
    copy(vars, Some(Nat())) check ctx.n match {
      case err@Left(_) => return err
      case Right(_) =>
    }
    val initialT = copy(vars, None) check ctx.initial match {
      case Right(t) => t
      case err@Left(_) => return err
    }
    val expectedStepT = Fun(Nat(), Fun(initialT, initialT))
    copy(vars, Some(expectedStepT)) check ctx.step match {
      case Right(_) =>
      case err@Left(_) => return err
    }
    Right(initialT)
  }

  override def visitApplication(ctx: ApplicationContext): Either[Error, Type] = {
    copy(vars, None) check ctx.fun match {
      case Right(Fun(param, res)) =>
        copy(vars, Some(param)).check(ctx.args.get(0)) match {
          case Right(_) => Right(res)
          case err@Left(_) => err
        }
      case Right(t) => Left(ERROR_NOT_A_FUNCTION(t, Left(ctx)))
      case err@Left(_) => err
    }
  }

  override def visitAbstraction(ctx: AbstractionContext): Either[Error, Type] = {
    val paramT = ctx.paramDecl.paramType.accept(TypeContextVisitor())
    expectedT match {
      case None =>
        copy(vars ++ Seq((ctx.paramDecl.name.getText, paramT)), None) check ctx.returnExpr match {
          case Right(returnT) => Right(Fun(paramT, returnT))
          case err@Left(_) => err
        }
      case Some(Fun(t, r)) if t == paramT =>
        copy(vars ++ Seq((ctx.paramDecl.name.getText, paramT)), Some(r)) check ctx.returnExpr match {
          case Right(returnT) => Right(Fun(paramT, returnT))
          case err@Left(_) => err
        }
      case Some(Fun(t, _)) => Left(ERROR_UNEXPECTED_TYPE_FOR_PARAMETER(t, paramT, ctx))
      case Some(t) => Left(ERROR_UNEXPECTED_LAMBDA(t, ctx))
    }
  }

  override def visitDotTuple(ctx: DotTupleContext): Either[Error, Type] = {
    copy(vars, None) check ctx.expr() match {
      case Right(t@Tuple(a)) =>
        val index = ctx.index.getText.toInt
        if (index < 1 || index > a.length) {
          Left(ERROR_TUPLE_INDEX_OUT_OF_BOUNDS(index, a.length, t, ctx))
        } else {
          Right(a.apply(index - 1))
        }
      case Right(t) => Left(ERROR_NOT_A_TUPLE(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitDotRecord(ctx: DotRecordContext): Either[Error, Type] = {
    copy(vars, None) check ctx.expr() match {
      case Right(r@Record(_)) =>
        val name = ctx.label.getText
        r.field(name) match {
          case None => Left(ERROR_UNEXPECTED_FIELD_ACCESS(r, ctx))
          case Some(t) =>Right(t)
        }
      case Right(t) => Left(ERROR_NOT_A_RECORD(t, ctx))
    }
  }

  override def visitConstInt(ctx: ConstIntContext): Either[Error, Type] = Right(Nat())
  override def visitConstFalse(ctx: ConstFalseContext): Either[Error, Type] = Right(Bool())
  override def visitConstTrue(ctx: ConstTrueContext): Either[Error, Type] = Right(Bool())
  override def visitConstUnit(ctx: ConstUnitContext): Either[Error, Type] = Right(UnitT())

  override def visitTuple(ctx: TupleContext): Either[Error, Type] = {
    expectedT match {
      case None =>
      case Some(t@Tuple(a)) =>
        val expected = a.size
        val actual = ctx.exprs.size
        if (expected != actual) {
          return Left(ERROR_UNEXPECTED_TUPLE_LENGTH(expected, actual, t, ctx))
        }
      case Some(t) =>
        return Left(ERROR_UNEXPECTED_TUPLE(t, ctx))
    }
    val typesOrErr = ctx.exprs.iterator().asScala.map[Either[Error, Type]](it => copy(vars, None) check it).toSeq
    EitherLift.liftEither(typesOrErr) match {
      case Right(types) => Right(Tuple(types))
      case Left(err) => Left(err)
    }
  }

  override def visitRecord(ctx: RecordContext): Either[Error, Type] = {
    def getFields = {
      EitherLift.liftEither(ctx.bindings.iterator().asScala.map[Either[Error, RecordField]] { it =>
        val newExpectedT = expectedT match {
          case Some(r@Record(_)) => r.field(it.name.getText) // TODO: missing field here?
          case None => None
        }
        copy(vars, newExpectedT) check it.expr() match {
          case Left(err) => Left(err)
          case Right(t) => Right(RecordField(it.name.getText, t))
        }
      }.toSeq)
    }
    expectedT match {
      case None =>
        getFields match {
          case Left(err) => Left(err)
          case Right(fields) => Right(Record(fields))
        }
      case Some(r@Record(expectedFields)) =>
        getFields match {
          case Left(err) => Left(err)
          case Right(fields) =>
            val unexpectedFields = fields.map(it => it.name).filterNot(it => expectedFields.map(it => it.name).contains(it))
            if (unexpectedFields.nonEmpty) {
              return Left(ERROR_UNEXPECTED_RECORD_FIELDS(unexpectedFields, r, ctx))
            }
            val missingFields = expectedFields.map(it => it.name).filterNot(it => fields.map(it => it.name).contains(it))
            if (missingFields.nonEmpty) {
              return Left(ERROR_MISSING_RECORD_FIELDS(missingFields, r, ctx))
            }
            Right(Record(fields))
        }
      case Some(t) => Left(ERROR_UNEXPECTED_RECORD(t, ctx))
    }
  }

  override def visitTerminatingSemicolon(ctx: TerminatingSemicolonContext): Either[Error, Type] = check(ctx.expr_)

  override def visitTypeAsc(ctx: TypeAscContext): Either[Error, Type] = {
    this checkIgnoreType ctx.expr() match {
      case Right(expected) =>
        val actual = ctx.type_.accept(TypeContextVisitor())
        if (expected == actual || expected.isInstanceOf[Unknown]) {
          Right(actual)
        } else {
          Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx, expected, actual))
        }
      case err@Left(_) => err
    }
  }

  override def visitLet(ctx: LetContext): Either[Error, Type] = {
    copy(vars, None) check ctx.patternBinding.rhs match {
      case Right(t) =>
        ctx.patternBinding.pat.accept(PatternVisitor(t)) match {
          case Left(err) => Left(err)
          case Right(m) => copy(vars ++ m.vars, expectedT) check ctx.body
        }
      case err@Left(_) => err
    }
  }

  override def visitParenthesisedExpr(ctx: ParenthesisedExprContext): Either[Error, Type] = check(ctx.expr())

  override def visitInl(ctx: InlContext): Either[Error, Type] = {
    expectedT match {
      case Some(s@Sum(left, _)) =>
        copy(vars, Some(left)) check ctx.expr() match {
          case Right(_) => Right(s)
          case err@Left(_) => err
        }
      case Some(t) => Left(ERROR_UNEXPECTED_INJECTION(t, ctx))
    }
  }

  override def visitInr(ctx: InrContext): Either[Error, Type] = {
    expectedT match {
      case Some(s@Sum(_, right)) =>
        copy(vars, Some(right)) check ctx.expr() match {
          case Right(_) => Right(s)
          case err@Left(_) => err
        }
      case Some(t) => Left(ERROR_UNEXPECTED_INJECTION(t, ctx))
    }
  }

  override def visitMatch(ctx: MatchContext): Either[Error, Type] = {
    if (ctx.cases.isEmpty) {
      return Left(ERROR_ILLEGAL_EMPTY_MATCHING(ctx))
    }
    val matchT = copy(vars, None) check ctx.expr() match {
      case Right(t) => t
      case err@Left(_) => return err
    }
    EitherLift.liftEither(ctx.cases.iterator().asScala.map(it => it.pattern().accept(PatternVisitor(matchT))).toSeq) match {
      case Right(matches) =>
        val unmatched = matchT.unmatchedPatterns(matches.map(it => it.matched))
        if (unmatched.nonEmpty) {
          return Left(ERROR_NONEXHAUSTIVE_MATCH_PATTERNS(unmatched, ctx))
        }
        val matchedVars = matches.map(it => it.vars)
        EitherLift.liftEither(ctx.cases.iterator().asScala.zip(matchedVars).map { case (c, v) => copy(vars ++ v) check c }.toSeq) match {
          case Right(_) => Right(expectedT.get) // TODO: check all types?
          case Left(err) => Left(err)
        }
      case Left(err) => Left(err)
    }
  }

  override def visitList(ctx: ListContext): Either[Error, Type] = {
    def go(t: Option[Type]) = { // TODO: check expected type?
      if (ctx.expr().isEmpty) {
        ctx.parent match {
          case _: TypeAscContext => Right(Unknown())
          case _ => Left(ERROR_AMBIGUOUS_LIST_TYPE())
        }
      } else {
        copy(vars, None) check ctx.expr match {
          case Right(listT) =>
            EitherLift.liftEither(ctx.expr().iterator().asScala.map(it => copy(vars, Some(listT)) check it).toSeq) match {
              case Right(_) => Right(ListT(listT))
              case Left(err) => Left(err)
            }
          case err@Left(_) => err
        }
      }
    }
    expectedT match {
      case Some(ListT(t)) => go(Some(t))
      case Some(t) =>Left(ERROR_UNEXPECTED_LIST(t, ctx))
      case None => go(None)
    }
  }

  override def visitConsList(ctx: ConsListContext): Either[Error, Type] = {
    this check ctx.head match {
      case Right(t) =>
        copy(vars, Some(ListT(t))) check ctx.tail match {
          case Right(_) => Right(ListT(t))
          case err@Left(_) => err
        }
      case err@Left(_) => err
    }
  }

  override def visitHead(ctx: HeadContext): Either[Error, Type] = {
    copy(vars, expectedT.map(it => ListT(it))) checkIgnoreType ctx.list match {
      case Right(ListT(t)) => Right(t)
      case Right(t) => Left(ERROR_NOT_A_LIST(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitTail(ctx: TailContext): Either[Error, Type] = {
    copy(vars, expectedT.map(it => ListT(it))) checkIgnoreType ctx.list match {
      case Right(ListT(t)) => Right(ListT(t))
      case Right(t) => Left(ERROR_NOT_A_LIST(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitIsEmpty(ctx: IsEmptyContext): Either[Error, Type] = {
    copy(vars, expectedT.map(it => ListT(it))) checkIgnoreType ctx.list match {
      case Right(ListT(_)) => Right(Bool())
      case Right(t) => Left(ERROR_NOT_A_LIST(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitFix(ctx: FixContext): Either[Error, Type] = {
    copy(vars, expectedT.map(it => Fun(it, it))) checkIgnoreType ctx.expr() match {
      case Right(Fun(_, r)) => Right(r)
      case Right(t) => Left(ERROR_NOT_A_FUNCTION(t, Right(ctx)))
      case err@Left(_) => err
    }
  }

  override def visitVariant(ctx: VariantContext): Either[Error, Type] = {
    expectedT match {
      case Some(v@Variant(_)) =>
        v.tag(ctx.label.getText) match {
          case Some(t) =>
            copy(vars, Some(t)) check ctx.rhs match {
              case Right(_) => Right(v)
              case err@Left(_) => err
            }
          case None => Left(ERROR_UNEXPECTED_VARIANT_LABEL(ctx.label.getText, v, ctx))
        }
      case Some(t) => Left(ERROR_UNEXPECTED_VARIANT(t, ctx))
      case None => Right(Unknown())
    }
  }

  override def defaultResult(): Either[Error, Type] = Right(Unknown())

  private def check(ctx: ParserRuleContext): Either[Error, Type] = {
    ctx.accept(this) match {
      case Right(t) if expectedT.isEmpty || expectedT.contains(t) => Right(t)
      case Right(t) => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx, expectedT.get, t))
      case err@Left(_) => err
    }
  }

  private def checkIgnoreType(ctx: ParserRuleContext): Either[Error, Type] = {
    ctx.accept(this) match {
      case Right(t) => Right(t)
      case err@Left(_) => err
    }
  }
}

private case class TypeContextVisitor() extends stellaParserBaseVisitor[Type] {
  override def visitTypeFun(ctx: TypeFunContext): Type = Fun(ctx.paramTypes.get(0).accept(this), ctx.returnType.accept(this))
  override def visitTypeParens(ctx: TypeParensContext): Type = ctx.type_.accept(this)
  override def visitTypeTuple(ctx: TypeTupleContext): Type = {
    val types = ctx.types.iterator().asScala.map[Type](it => it.accept(this))
    Tuple(types.toSeq)
  }
  override def visitTypeRecord(ctx: TypeRecordContext): Type = {
    val fields = ctx.fieldTypes.iterator().asScala.map[RecordField](it => RecordField(it.label.getText, it.type_.accept(this)))
    Record(fields.toSeq)
  }
  override def visitTypeUnit(ctx: TypeUnitContext): Type = UnitT()
  override def visitTypeBool(ctx: TypeBoolContext): Type = Bool()
  override def visitTypeNat(ctx: TypeNatContext): Type = Nat()
  override def visitTypeSum(ctx: TypeSumContext): Type = Sum(ctx.left.accept(this), ctx.right.accept(this))
  override def visitTypeList(ctx: TypeListContext): Type = ListT(ctx.type_.accept(this))
  override def visitTypeVariant(ctx: TypeVariantContext): Type = {
    val tags = ctx.fieldTypes.iterator().asScala.map[VariantTag](it => VariantTag(it.label.getText, it.type_.accept(this)))
    Variant(tags.toSeq)
  }

  override def defaultResult(): Type = Unknown()
}

private case class MatchedPattern(vars: immutable.Map[String, Type], matched: PatternContext)

private case class PatternVisitor(t: Type) extends stellaParserBaseVisitor[Either[Error, MatchedPattern]] {
  override def visitPatternVar(ctx: PatternVarContext): Either[Error, MatchedPattern] = {
    Right(MatchedPattern(Map.from(Seq((ctx.name.getText, t))), ctx))
  }

  override def visitPatternInl(ctx: PatternInlContext): Either[Error, MatchedPattern] = {
    t match {
      case Sum(left, _) =>
        ctx.pattern().accept(copy(left)) match {
          case Right(m) => Right(m.copy(matched = ctx))
          case err@Left(_) => err
        }
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternInr(ctx: PatternInrContext): Either[Error, MatchedPattern] = {
    t match {
      case Sum(_, right) =>
        ctx.pattern().accept(copy(right)) match {
          case Right(m) => Right(m.copy(matched = ctx))
          case err@Left(_) => err
        }
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternVariant(ctx: PatternVariantContext): Either[Error, MatchedPattern] = {
    t match {
      case v@Variant(_) =>
        v.tag(ctx.label.getText) match {
          case Some(t) =>
            ctx.pattern().accept(copy(t)) match {
              case Right(m) => Right(m.copy(matched = ctx))
              case err@Left(_) => err
            }
          case None => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
        }
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternUnit(ctx: PatternUnitContext): Either[Error, MatchedPattern] = {
    t match {
      case UnitT() => Right(MatchedPattern(Map.empty, ctx))
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternFalse(ctx: PatternFalseContext): Either[Error, MatchedPattern] = {
    t match {
      case Bool() => Right(MatchedPattern(Map.empty, ctx))
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternTrue(ctx: PatternTrueContext): Either[Error, MatchedPattern] = {
    t match {
      case Bool() => Right(MatchedPattern(Map.empty, ctx))
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternInt(ctx: PatternIntContext): Either[Error, MatchedPattern] = {
    t match {
      case Nat() => Right(MatchedPattern(Map.empty, ctx))
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternSucc(ctx: PatternSuccContext): Either[Error, MatchedPattern] = {
    t match {
      case Nat() => Right(MatchedPattern(Map.empty, ctx))
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternTuple(ctx: PatternTupleContext): Either[Error, MatchedPattern] = {
    t match {
      case t@Tuple(fields) =>
        if (fields.length != ctx.patterns.size()) {
          Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
        } else {
          EitherLift.liftEither(ctx.patterns.iterator().asScala.zipWithIndex.map {
            case (p, i) => p.accept(copy(t.types.apply(i)))
          }.toSeq) match {
            case Right(mp) => Right(MatchedPattern(Map.from(mp.flatMap(it => it.vars)), ctx))
            case Left(err) => Left(err)
          }
        }
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def defaultResult(): Either[Error, MatchedPattern] = throw new UnsupportedOperationException()
}
