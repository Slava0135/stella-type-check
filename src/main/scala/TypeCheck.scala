package io.github.slava0135.stella

import stellaParser._

import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream, ParserRuleContext}

import scala.collection.{immutable, mutable}
import scala.jdk.CollectionConverters.IteratorHasAsScala

object TypeCheck {
  def go(text: String): Result = {
    val tree = getTree(text)
    tree.accept(TypeCheckVisitor(immutable.Map.empty, None, Seq.empty)) match {
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
      "#nested-function-declarations",
      "#universal-types",
//      "#structural-patterns",
    )
    val listener: stellaParserBaseListener = new stellaParserBaseListener {
      override def enterAnExtension(ctx: AnExtensionContext): Unit = {
        ctx.extensionNames.iterator().asScala.foreach(required += _.getText)
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

private case class TypeCheckVisitor(vars: immutable.Map[String, Type], expectedT: Option[Type], typeVars: Seq[GenericType]) extends stellaParserBaseVisitor[Either[Error, Type]] {

  override def visitProgram(ctx: ProgramContext): Either[Error, Type] = {
    val topLevelDecl = mutable.Map[String, Type]()
    ctx.decl().stream().forEach{
      case func: DeclFunContext =>
        val paramT = func.paramDecl(0).paramType.accept(TypeContextVisitor(typeVars)) match {
          case Right(t) => t
          case err => return err
        }
        val returnT = func.returnType.accept(TypeContextVisitor(typeVars)) match {
          case Right(t) => t
          case err => return err
        }
        topLevelDecl.put(
          func.name.getText,
          Fun(paramT, returnT)
        )
      case genericFunc: DeclFunGenericContext =>
        val generics = genericFunc.generics.iterator().asScala.map(it => GenericType(it.getText)).toSeq
        val paramT = genericFunc.paramDecl(0).paramType.accept(TypeContextVisitor(generics)) match {
          case Right(t) => t
          case err => return err
        }
        val returnT = genericFunc.returnType.accept(TypeContextVisitor(generics)) match {
          case Right(t) => t
          case err => return err
        }
        topLevelDecl.put(
          genericFunc.name.getText,
          ForAll(generics, Fun(paramT, returnT))
        )
    }
    ctx.decl().iterator().asScala.foreach { it =>
      it.accept(copy(vars ++ topLevelDecl, None)) match {
        case err@Left(_) => return err
        case _ =>
      }
    }
    if (!topLevelDecl.contains("main")) {
      return Left(ERROR_MISSING_MAIN())
    }
    Right(null)
  }

  override def visitDeclFun(ctx: DeclFunContext): Either[Error, Type] = {
    val param = ctx.paramDecl(0)
    val paramT = param.paramType.accept(TypeContextVisitor(typeVars)) match {
      case Right(t) => t
      case err => return err
    }
    val returnT = ctx.returnType.accept(TypeContextVisitor(typeVars)) match {
      case Right(t) => t
      case err => return err
    }
    val funT = Fun(paramT, returnT)
    EitherLift.liftEither(ctx.localDecls.iterator().asScala.map(copy(vars + (param.name.getText -> funT.param), None) visit _).toSeq) match {
      case Right(localDecl) =>
        val localVars = vars + (param.name.getText -> funT.param) ++
          ctx.localDecls.iterator().asScala.map(_.asInstanceOf[DeclFunContext].name.getText)
            .zip(localDecl)
        copy(localVars, Some(funT.res)) visit ctx.returnExpr match {
          case err@Left(_) => err
          case Right(_) => Right(funT)
        }
      case Left(err) => Left(err)
    }
  }

  override def visitDeclFunGeneric(ctx: DeclFunGenericContext): Either[Error, Type] = {
    val param = ctx.paramDecl(0)
    val generics = ctx.generics.iterator().asScala.map(it => GenericType(it.getText)).toSeq
    val paramT = param.paramType.accept(TypeContextVisitor(generics)) match {
      case Right(t) => t
      case err => return err
    }
    val returnT = ctx.returnType.accept(TypeContextVisitor(generics)) match {
      case Right(t) => t
      case err => return err
    }
    val funT = Fun(paramT, returnT)
    val t = ForAll(generics, funT)
    EitherLift.liftEither(ctx.localDecls.iterator().asScala.map(copy(vars + (param.name.getText -> funT.param), None, typeVars ++ generics) visit _).toSeq) match {
      case Right(localDecl) =>
        val localVars = vars + (param.name.getText -> funT.param) ++
          ctx.localDecls.iterator().asScala.map(_.asInstanceOf[DeclFunContext].name.getText)
            .zip(localDecl)
        copy(localVars, Some(funT.res), typeVars ++ generics) visit ctx.returnExpr match {
          case err@Left(_) => err
          case Right(_) => Right(t)
        }
      case Left(err) => Left(err)
    }
  }

  override def visitIf(ctx: IfContext): Either[Error, Type] = {
    for {
      _ <- copy(vars, Some(Bool())) visit ctx.condition
      thenT <- this visit ctx.thenExpr
      elseT <- copy(vars, Some(thenT)) visit ctx.elseExpr
    } yield {
      elseT
    }
  }

  override def visitSucc(ctx: SuccContext): Either[Error, Type] = copy(vars, Some(Nat())) visit ctx.expr()

  override def visitIsZero(ctx: IsZeroContext): Either[Error, Type] = {
    for {
      _ <- copy(vars, Some(Nat())) visit ctx.expr()
    } yield {
      Bool()
    }
  }

  override def visitVar(ctx: VarContext): Either[Error, Type] = {
    vars.get(ctx.name.getText) match {
      case None => Left(ERROR_UNDEFINED_VARIABLE(ctx))
      case Some(t) => Right(t)
    }
  }

  override def visitNatRec(ctx: NatRecContext): Either[Error, Type] = {
    for {
      _ <- copy(vars, Some(Nat())) visit ctx.n
      initT <- copy(vars, None) visit ctx.initial
      _ <- copy(vars, Some(Fun(Nat(), Fun(initT, initT)))) visit ctx.step
    } yield {
      initT
    }
  }

  override def visitApplication(ctx: ApplicationContext): Either[Error, Type] = {
    copy(vars, None) visit ctx.fun match {
      case Right(Fun(param, res)) =>
        copy(vars, Some(param)).visit(ctx.args.get(0)) match {
          case Right(_) => Right(res)
          case err => err
        }
      case Right(t) => Left(ERROR_NOT_A_FUNCTION(t, Left(ctx)))
      case err => err
    }
  }

  override def visitAbstraction(ctx: AbstractionContext): Either[Error, Type] = {
    val paramT = ctx.paramDecl.paramType.accept(TypeContextVisitor(typeVars)) match {
      case Right(t) => t
      case err => return err
    }
    expectedT match {
      case None =>
        for {
          returnT <- copy(vars + (ctx.paramDecl.name.getText -> paramT), None) visit ctx.returnExpr
        } yield {
          Fun(paramT, returnT)
        }
      case Some(Fun(t, r)) if t == paramT =>
        for {
          returnT <- copy(vars + (ctx.paramDecl.name.getText -> paramT), Some(r)) visit ctx.returnExpr
        } yield {
          Fun(paramT, returnT)
        }
      case Some(Fun(t, _)) => Left(ERROR_UNEXPECTED_TYPE_FOR_PARAMETER(t, paramT, ctx))
      case Some(t) => Left(ERROR_UNEXPECTED_LAMBDA(t, ctx))
    }
  }

  override def visitDotTuple(ctx: DotTupleContext): Either[Error, Type] = {
    copy(vars, None) visit ctx.expr() match {
      case Right(t@Tuple(a)) =>
        val index = ctx.index.getText.toInt
        if (index < 1 || index > a.length) {
          Left(ERROR_TUPLE_INDEX_OUT_OF_BOUNDS(index, a.length, t, ctx))
        } else {
          Right(a.apply(index - 1))
        }
      case Right(t) => Left(ERROR_NOT_A_TUPLE(t, ctx))
      case err => err
    }
  }

  override def visitDotRecord(ctx: DotRecordContext): Either[Error, Type] = {
    copy(vars, None) visit ctx.expr() match {
      case Right(r@Record(_)) =>
        val name = ctx.label.getText
        r.field(name) match {
          case None => Left(ERROR_UNEXPECTED_FIELD_ACCESS(r, ctx))
          case Some(t) =>Right(t)
        }
      case Right(t) => Left(ERROR_NOT_A_RECORD(t, ctx))
      case err@Left(_) => err
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
    val typesOrErr = ctx.exprs.iterator().asScala.map[Either[Error, Type]](copy(vars, None) visit _).toSeq
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
        copy(vars, newExpectedT) visit it.expr() match {
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
            val unexpectedFields = fields.map(_.name).filterNot(expectedFields.map(_.name).contains(_))
            if (unexpectedFields.nonEmpty) {
              return Left(ERROR_UNEXPECTED_RECORD_FIELDS(unexpectedFields, r, ctx))
            }
            val missingFields = expectedFields.map(_.name).filterNot(fields.map(_.name).contains(_))
            if (missingFields.nonEmpty) {
              return Left(ERROR_MISSING_RECORD_FIELDS(missingFields, r, ctx))
            }
            Right(r)
        }
      case Some(t) => Left(ERROR_UNEXPECTED_RECORD(t, ctx))
    }
  }

  override def visitTerminatingSemicolon(ctx: TerminatingSemicolonContext): Either[Error, Type] = visit(ctx.expr_)

  override def visitTypeAsc(ctx: TypeAscContext): Either[Error, Type] = {
    val actual = ctx.type_.accept(TypeContextVisitor(typeVars)) match {
      case Right(t) => t
      case err => return err
    }
    copy(vars, Some(actual)) checkIgnoreType ctx.expr() match {
      case Right(expected) =>
        if (expected == actual || expected.isInstanceOf[Unknown]) {
          Right(actual)
        } else {
          Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx, expected, actual))
        }
      case err@Left(_) => err
    }
  }

  override def visitLet(ctx: LetContext): Either[Error, Type] = {
    copy(vars, None) visit ctx.patternBinding.rhs match {
      case Right(t) =>
        ctx.patternBinding.pat.accept(PatternVisitor(t)) match {
          case Left(err) => Left(err)
          case Right(patVars) => copy(vars ++ patVars, expectedT) visit ctx.body
        }
      case err@Left(_) => err
    }
  }

  override def visitParenthesisedExpr(ctx: ParenthesisedExprContext): Either[Error, Type] = visit(ctx.expr())

  override def visitInl(ctx: InlContext): Either[Error, Type] = {
    expectedT match {
      case Some(s@Sum(left, _)) =>
        copy(vars, Some(left)) visit ctx.expr() match {
          case Right(_) => Right(s)
          case err@Left(_) => err
        }
      case Some(t) => Left(ERROR_UNEXPECTED_INJECTION(t, ctx))
      case None => Left(ERROR_AMBIGUOUS_SUM_TYPE())
    }
  }

  override def visitInr(ctx: InrContext): Either[Error, Type] = {
    expectedT match {
      case Some(s@Sum(_, right)) =>
        copy(vars, Some(right)) visit ctx.expr() match {
          case Right(_) => Right(s)
          case err@Left(_) => err
        }
      case Some(t) => Left(ERROR_UNEXPECTED_INJECTION(t, ctx))
      case None => Left(ERROR_AMBIGUOUS_SUM_TYPE())
    }
  }

  override def visitMatch(ctx: MatchContext): Either[Error, Type] = {
    if (ctx.cases.isEmpty) {
      return Left(ERROR_ILLEGAL_EMPTY_MATCHING(ctx))
    }
    val matchT = copy(vars, None) visit ctx.expr() match {
      case Right(t) => t
      case err@Left(_) => return err
    }
    EitherLift.liftEither(ctx.cases.iterator().asScala.map(_.pattern().accept(PatternVisitor(matchT))).toSeq) match {
      case Right(caseVars) =>
        Exhaustiveness.check(matchT, ctx) match {
          case Left(err) => Left(err)
          case _ =>
            EitherLift.liftEither(ctx.cases.iterator().asScala.zip(caseVars).map { case (c, v) => copy(vars ++ v) visit c }.toSeq) match {
              case Right(ts) =>
                val t = ts.head
                ts.find(_ != t) match {
                  case Some(otherT) => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx, t, otherT))
                  case None => Right(t)
                }
              case Left(err) => Left(err)
            }
        }
      case Left(err) => Left(err)
    }
  }

  override def visitList(ctx: ListContext): Either[Error, Type] = {
    def go(t: Option[Type]) = {
      if (ctx.expr().isEmpty) {
        t match {
          case Some(t) => Right(ListT(t))
          case None =>
            ctx.parent match {
              case _: TypeAscContext => Right(Unknown())
              case _ => Left(ERROR_AMBIGUOUS_LIST_TYPE())
            }
        }
      } else {
        copy(vars, t) visit ctx.expr match {
          case Right(t) =>
            EitherLift.liftEither(ctx.expr().iterator().asScala.map(copy(vars, Some(t)) visit _).toSeq) match {
              case Right(_) => Right(ListT(t))
              case Left(err) => Left(err)
            }
          case err@Left(_) => err
        }
      }
    }
    expectedT match {
      case Some(ListT(t)) => go(Some(t))
      case Some(t) => Left(ERROR_UNEXPECTED_LIST(t, ctx))
      case None => go(None)
    }
  }

  override def visitConsList(ctx: ConsListContext): Either[Error, Type] = {
    def go(t: Option[Type]): Either[Error, Type] = {
      copy(vars, t) visit ctx.head match {
        case Right(t) =>
          copy(vars, Some(ListT(t))) visit ctx.tail match {
            case Right(_) => Right(ListT(t))
            case err@Left(_) => err
          }
        case err@Left(_) => err
      }
    }
    expectedT match {
      case Some(ListT(t)) => go(Some(t))
      case Some(t) => Left(ERROR_UNEXPECTED_LIST(t, ctx))
      case None => go(None)
    }
  }

  override def visitHead(ctx: HeadContext): Either[Error, Type] = {
    copy(vars, expectedT.map(ListT)) checkIgnoreType ctx.list match {
      case Right(ListT(t)) => Right(t)
      case Right(t) => Left(ERROR_NOT_A_LIST(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitTail(ctx: TailContext): Either[Error, Type] = {
    copy(vars, expectedT) checkIgnoreType ctx.list match {
      case Right(ListT(t)) => Right(ListT(t))
      case Right(t) => Left(ERROR_NOT_A_LIST(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitIsEmpty(ctx: IsEmptyContext): Either[Error, Type] = {
    copy(vars, None) checkIgnoreType ctx.list match {
      case Right(ListT(_)) => Right(Bool())
      case Right(t) => Left(ERROR_NOT_A_LIST(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitFix(ctx: FixContext): Either[Error, Type] = {
    copy(vars, expectedT.map(it => Fun(it, it))) checkIgnoreType ctx.expr() match {
      case Right(Fun(p, r)) if p == r => Right(r)
      case Right(f@Fun(p, _)) => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx, Fun(p, p), f))
      case Right(t) => Left(ERROR_NOT_A_FUNCTION(t, Right(ctx)))
      case err@Left(_) => err
    }
  }

  override def visitVariant(ctx: VariantContext): Either[Error, Type] = {
    expectedT match {
      case Some(v@Variant(_)) =>
        v.tag(ctx.label.getText) match {
          case Some(t) =>
            copy(vars, Some(t)) visit ctx.rhs match {
              case Right(_) => Right(v)
              case err@Left(_) => err
            }
          case None => Left(ERROR_UNEXPECTED_VARIANT_LABEL(ctx.label.getText, v, ctx))
        }
      case Some(t) => Left(ERROR_UNEXPECTED_VARIANT(t, ctx))
      case None => Left(ERROR_AMBIGUOUS_VARIANT_TYPE())
    }
  }

  override def visitTypeAbstraction(ctx: TypeAbstractionContext): Either[Error, Type] = {
    val generics = ctx.generics.iterator().asScala.map(it => GenericType(it.getText)).toSeq
    expectedT match {
      case Some(ForAll(_, funT)) =>
        for {
          _ <- copy(vars, Some(funT), typeVars ++ generics) visit ctx.expr()
        } yield {
          ForAll(generics, funT)
        }
      case Some(t) => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx, ForAll(Seq.empty, Fun(Unknown(), Unknown())), t))
      case None => ???
    }
  }

  override def visitTypeApplication(ctx: TypeApplicationContext): Either[Error, Type] = {
    this visit ctx.expr() match {
      case Right(ForAll(generics, funT)) =>
        val expected = generics.size
        val actual = ctx.types.size()
        if (expected != actual) {
          Left(ERROR_INCORRECT_NUMBER_OF_TYPE_ARGUMENTS(expected, actual, ctx))
        } else {
          val types = EitherLift.liftEither(ctx.types.iterator().asScala.map(_.accept(TypeContextVisitor(typeVars))).toSeq) match {
            case Right(t) => t
            case Left(err) => return Left(err)
          }
          val genericToType = generics.zip(types)
          var paramT = funT.param
          genericToType.foreach {
            case (genericType, value) => paramT = paramT.replace(genericType, value)
          }
          var resT = funT.res
          genericToType.foreach {
            case (genericType, value) => resT = resT.replace(genericType, value)
          }
          Right(Fun(paramT, resT))
        }
      case Right(t) => Left(ERROR_NOT_A_GENERIC_FUNCTION(t, ctx))
      case err => err
    }
  }

  override def defaultResult(): Either[Error, Type] = Right(Unknown())

  private def visit(ctx: ParserRuleContext): Either[Error, Type] = {
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

private case class TypeContextVisitor(typeVars: Seq[GenericType]) extends stellaParserBaseVisitor[Either[Error, Type]] {
  override def visitTypeFun(ctx: TypeFunContext): Either[Error, Type] = {
    for {
      paramT <- ctx.paramTypes.get(0).accept(this)
      returnT <- ctx.returnType.accept(this)
    } yield {
      Fun(paramT, returnT)
    }
  }
  override def visitTypeParens(ctx: TypeParensContext): Either[Error, Type] = ctx.type_.accept(this)
  override def visitTypeTuple(ctx: TypeTupleContext): Either[Error, Type] = {
    for {
      types <- EitherLift.liftEither(ctx.types.iterator().asScala.map(_.accept(this)).toSeq)
    } yield {
      Tuple(types)
    }
  }
  override def visitTypeRecord(ctx: TypeRecordContext): Either[Error, Type] = {
    for {
      fields <- EitherLift.liftEither(ctx.fieldTypes.iterator().asScala.map[Either[Error, RecordField]]{ it =>
        for {
          t <- it.type_.accept(this)
        } yield {
          RecordField(it.label.getText, t)
        }
      }.toSeq)
    } yield {
      Record(fields)
    }
  }
  override def visitTypeUnit(ctx: TypeUnitContext): Either[Error, Type] = Right(UnitT())
  override def visitTypeBool(ctx: TypeBoolContext): Either[Error, Type] = Right(Bool())
  override def visitTypeNat(ctx: TypeNatContext): Either[Error, Type] = Right(Nat())
  override def visitTypeSum(ctx: TypeSumContext): Either[Error, Type] = {
    for {
      leftT <- ctx.left.accept(this)
      rightT <- ctx.right.accept(this)
    } yield {
      Sum(leftT, rightT)
    }
  }
  override def visitTypeList(ctx: TypeListContext): Either[Error, Type] = {
    for {
      t <- ctx.type_.accept(this)
    } yield {
      ListT(t)
    }
  }
  override def visitTypeVariant(ctx: TypeVariantContext): Either[Error, Type] = {
    for {
      tags <- EitherLift.liftEither(ctx.fieldTypes.iterator().asScala.map[Either[Error, VariantTag]]{ it =>
        for {
          t <- it.type_.accept(this)
        } yield {
          VariantTag(it.label.getText, t)
        }
      }.toSeq)
    } yield {
      Variant(tags)
    }
  }

  override def visitTypeVar(ctx: TypeVarContext): Either[Error, Type] = {
    typeVars.find(_.name == ctx.name.getText) match {
      case Some(t) => Right(t)
      case None => Left(ERROR_UNDEFINED_TYPE_VARIABLE(ctx.name.getText, ctx))
    }
  }

  override def visitTypeForAll(ctx: TypeForAllContext): Either[Error, Type] = {
    val vars = ctx.types.iterator().asScala.map(it => GenericType(it.getText)).toSeq
    for {
      t <- ctx.type_.accept(TypeContextVisitor(typeVars ++ vars))
    } yield {
      ForAll(vars, t.asInstanceOf[Fun])
    }
  }

  override def defaultResult(): Either[Error, Type] = Right(Unknown())
}

private case class PatternVisitor(t: Type) extends stellaParserBaseVisitor[Either[Error, immutable.Map[String, Type]]] {
  override def visitPatternVar(ctx: PatternVarContext): Either[Error, immutable.Map[String, Type]] = {
    Right(Map.apply(ctx.name.getText -> t))
  }

  override def visitPatternInl(ctx: PatternInlContext): Either[Error, immutable.Map[String, Type]] = {
    t match {
      case Sum(left, _) => ctx.pattern().accept(copy(left))
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternInr(ctx: PatternInrContext): Either[Error, immutable.Map[String, Type]] = {
    t match {
      case Sum(_, right) => ctx.pattern().accept(copy(right))
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternVariant(ctx: PatternVariantContext): Either[Error, immutable.Map[String, Type]] = {
    t match {
      case v@Variant(_) =>
        v.tag(ctx.label.getText) match {
          case Some(t) => ctx.pattern().accept(copy(t))
          case None => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
        }
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternUnit(ctx: PatternUnitContext): Either[Error, Map[String, Type]] = {
    t match {
      case UnitT() => Right(Map.empty)
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternFalse(ctx: PatternFalseContext): Either[Error, Map[String, Type]] = {
    t match {
      case Bool() => Right(Map.empty)
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternTrue(ctx: PatternTrueContext): Either[Error, Map[String, Type]] = {
    t match {
      case Bool() => Right(Map.empty)
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternInt(ctx: PatternIntContext): Either[Error, Map[String, Type]] = {
    t match {
      case Nat() => Right(Map.empty)
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternSucc(ctx: PatternSuccContext): Either[Error, Map[String, Type]] = {
    t match {
      case Nat() => ctx.pattern().accept(this)
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def defaultResult(): Either[Error, immutable.Map[String, Type]] = throw new UnsupportedOperationException()
}
