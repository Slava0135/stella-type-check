package io.github.slava0135.stella

import stellaParser._

import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

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
    val listener = new stellaParserBaseListener {
      var required = Set.empty[String]
      private val supported = Set(
        "#unit-type",
        "#pairs",
        "#tuples",
        "#records",
        "#natural-literals",
        "#type-ascriptions",
        "#let-bindings",
        "#sum-types",
      )

      override def enterAnExtension(ctx: AnExtensionContext): Unit = {
        ctx.extensionNames.iterator().asScala.foreach(it => required += it.getText)
      }

      def unsupported(): Set[String] = required -- supported
    }
    ParseTreeWalker.DEFAULT.walk(listener, tree)
    listener.unsupported()
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
    val ts = ctx.decl().stream().map(it => it.accept(copy(vars ++ topLevelDecl, None)))
    val err = ts.filter(it => it.isLeft).findFirst()
    if (err.isPresent) {
      return err.get()
    }
    if (!topLevelDecl.contains("main")) {
      return Left(ERROR_MISSING_MAIN())
    }
    Right(null)
  }

  override def visitDeclFun(ctx: DeclFunContext): Either[Error, Type] = {
    val param = ctx.paramDecl(0)
    val funT = Fun(param.paramType.accept(TypeContextVisitor()), ctx.returnType.accept(TypeContextVisitor()))
    ctx.returnExpr.accept(copy(vars ++ Seq((param.name.getText, funT.param)), Some(funT.res))) match {
      case err@Left(_) => err
      case Right(returnT) =>
        if (returnT != funT.res) {
          Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.returnExpr, funT.res, returnT))
        } else {
          Right(funT)
        }
    }
  }

  override def visitIf(ctx: IfContext): Either[Error, Type] = {
    val condT = ctx.condition.accept(copy(vars, Some(Bool()))) match {
      case Right(t) => t
      case err@Left(_) => return err
    }
    if (condT != Bool()) {
      return Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.condition, Bool(), condT))
    }
    (ctx.thenExpr.accept(this), ctx.elseExpr.accept(this)) match {
      case (Right(thenT), Right(elseT)) if thenT == elseT => Right(thenT)
      case (Right(thenT), Right(elseT)) => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.elseExpr, thenT, elseT))
      case (err@Left(_), _) => err
      case (_, err@Left(_)) => err
    }
  }

  override def visitSucc(ctx: SuccContext): Either[Error, Type] = {
    ctx.expr().accept(copy(vars, Some(Nat()))) match {
      case Right(t) if t == Nat() => Right(t)
      case Right(t) => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.expr(), Nat(), t))
      case err@Left(_) => err
    }
  }

  override def visitIsZero(ctx: IsZeroContext): Either[Error, Type] = {
    ctx.expr().accept(copy(vars, Some(Nat()))) match {
      case Right(t) if t == Nat() => Right(Bool())
      case Right(t) => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.expr(), Nat(), t))
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
    ctx.n.accept(copy(vars, Some(Nat()))) match {
      case Right(Nat()) =>
      case err@Left(_) => return err
      case Right(t) => return Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.n, Nat(), t))
    }
    val initialT = ctx.initial.accept(this) match {
      case Right(t) => t
      case err@Left(_) => return err
    }
    val expectedStepT = Fun(Nat(), Fun(initialT, initialT))
    ctx.step.accept(copy(vars, Some(expectedStepT))) match {
      case Right(t) if t == expectedStepT =>
      case Right(t) => return Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.step, expectedStepT, t))
      case err@Left(_) => return err
    }
    Right(initialT)
  }

  override def visitApplication(ctx: ApplicationContext): Either[Error, Type] = {
    ctx.fun.accept(copy(vars, None)) match {
      case Right(Fun(param, res)) =>
        ctx.args.get(0).accept(copy(vars, Some(param))) match {
          case Right(arg) if param == arg => Right(res)
          case Right(arg) => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.fun, param, arg))
          case err@Left(_) => err
        }
      case Right(t) => Left(ERROR_NOT_A_FUNCTION(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitAbstraction(ctx: AbstractionContext): Either[Error, Type] = {
    val paramT = ctx.paramDecl.paramType.accept(TypeContextVisitor())
    expectedT match {
      case None =>
        ctx.returnExpr.accept(copy(vars ++ Seq((ctx.paramDecl.name.getText, paramT)), None)) match {
          case Right(returnT) => Right(Fun(paramT, returnT))
          case err@Left(_) => err
        }
      case Some(Fun(t, r)) if t == paramT =>
        ctx.returnExpr.accept(copy(vars ++ Seq((ctx.paramDecl.name.getText, paramT)), Some(r))) match {
          case Right(returnT) => Right(Fun(paramT, returnT))
          case err@Left(_) => err
        }
      case Some(Fun(t, _)) => Left(ERROR_UNEXPECTED_TYPE_FOR_PARAMETER(t, paramT, ctx))
      case Some(t) => Left(ERROR_UNEXPECTED_LAMBDA(t, ctx))
    }
  }

  override def visitDotTuple(ctx: DotTupleContext): Either[Error, Type] = {
    ctx.expr_.accept(copy(vars, None)) match {
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
    ctx.expr_.accept(copy(vars, None)) match {
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
    val typesOrErr = ctx.exprs.iterator().asScala.map[Either[Error, Type]](it => it.accept(copy(vars, None))).toSeq
    liftEither(typesOrErr) match {
      case Right(types) => Right(Tuple(immutable.ArraySeq.from(types)))
      case Left(err) => Left(err)
    }
  }

  override def visitRecord(ctx: RecordContext): Either[Error, Type] = {
    def getFields = {
      liftEither(ctx.bindings.iterator().asScala.map[Either[Error, RecordField]] { it =>
        val newExpectedT = expectedT match {
          case Some(r@Record(_)) => r.field(it.name.getText) // TODO: missing field here?
          case None => None
        }
        it.expr().accept(copy(vars, newExpectedT)) match {
          case Left(err) => Left(err)
          case Right(t) => Right(RecordField(it.name.getText, t))
        }
      }.toSeq)
    }
    expectedT match {
      case None =>
        getFields match {
          case Left(err) => Left(err)
          case Right(fields) => Right(Record(immutable.ArraySeq.from(fields)))
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
            Right(Record(immutable.ArraySeq.from(fields)))
        }
      case Some(t) => Left(ERROR_UNEXPECTED_RECORD(t, ctx))
    }
  }

  override def visitTerminatingSemicolon(ctx: TerminatingSemicolonContext): Either[Error, Type] = {
    ctx.expr_.accept(this)
  }

  override def visitTypeAsc(ctx: TypeAscContext): Either[Error, Type] = {
    ctx.expr().accept(this) match {
      case Right(expected) =>
        val actual = ctx.type_.accept(TypeContextVisitor())
        if (expected == actual) { // TODO: Unknown???
          Right(actual)
        } else {
          Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx, expected, actual))
        }
      case err@Left(_) => err
    }
  }

  override def visitLet(ctx: LetContext): Either[Error, Type] = {
    ctx.patternBinding.rhs.accept(copy(vars, None)) match {
      case Right(t) =>
        ctx.patternBinding.pat.accept(PatternVisitor(t)) match {
          case Left(err) => Left(err)
          case Right(v) => ctx.body.accept(copy(vars ++ v, expectedT))
        }
      case err@Left(_) => err
    }
  }

  override def visitParenthesisedExpr(ctx: ParenthesisedExprContext): Either[Error, Type] = {
    ctx.expr().accept(this)
  }

  override def visitInl(ctx: InlContext): Either[Error, Type] = {
    expectedT match {
      case Some(s@Sum(left, _)) =>
        ctx.expr().accept(copy(vars, Some(left))) match {
          case Right(_) => Right(s)
          case err@Left(_) => err
        }
      case Some(t) => Left(ERROR_UNEXPECTED_INJECTION(t, ctx))
    }
  }

  override def visitInr(ctx: InrContext): Either[Error, Type] = {
    expectedT match {
      case Some(s@Sum(_, right)) =>
        ctx.expr().accept(copy(vars, Some(right))) match {
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
    val matchT = ctx.expr_.accept(copy(vars, None)) match {
      case Right(t) => t
      case err@Left(_) => return err
    }
    defaultResult()
  }

  override def defaultResult(): Either[Error, Type] = Right(Unknown())

  private def liftEither[A, B](s: Seq[Either[A, B]]): Either[A, Seq[B]] =
    s.foldRight(Right(Nil): Either[A, List[B]]) {
      (e, acc) => for (xs <- acc; x <- e) yield x :: xs
    }
}

private case class TypeContextVisitor() extends stellaParserBaseVisitor[Type] {
  override def visitTypeFun(ctx: TypeFunContext): Type = {
    Fun(ctx.paramTypes.get(0).accept(this), ctx.returnType.accept(this))
  }
  override def visitTypeParens(ctx: TypeParensContext): Type = {
    ctx.type_.accept(this)
  }
  override def visitTypeTuple(ctx: TypeTupleContext): Type = {
    val types = ctx.types.iterator().asScala.map[Type](it => it.accept(this))
    Tuple(immutable.ArraySeq.from(types))
  }
  override def visitTypeRecord(ctx: TypeRecordContext): Type = {
    val fields = ctx.fieldTypes.iterator().asScala.map[RecordField](it => RecordField(it.label.getText, it.type_.accept(this)))
    Record(immutable.ArraySeq.from(fields))
  }
  override def visitTypeUnit(ctx: TypeUnitContext): Type = UnitT()
  override def visitTypeBool(ctx: TypeBoolContext): Type = Bool()
  override def visitTypeNat(ctx: TypeNatContext): Type = Nat()

  override def visitTypeSum(ctx: TypeSumContext): Type = Sum(ctx.left.accept(this), ctx.right.accept(this))

  override def defaultResult(): Type = Unknown()
}

private case class PatternVisitor(t: Type) extends stellaParserBaseVisitor[Either[Error, immutable.Map[String, Type]]] {
  override def visitPatternVar(ctx: PatternVarContext): Either[Error, Map[String, Type]] = {
    Right(immutable.Map.from(Seq((ctx.name.getText, t))))
  }

  override def defaultResult(): Either[Error, Map[String, Type]] = Right(immutable.Map.empty)
}
