package io.github.slava0135.stella

import stellaParser._

import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

import scala.collection.{immutable, mutable}
import scala.jdk.CollectionConverters.IteratorHasAsScala

object TypeCheck {
  def go(text: String): Result = {
    val tree = getTree(text)
    tree.accept(new TypeVisitor(immutable.Map.empty, None)) match {
      case Left(err) => Bad(err.toString)
      case Right(_) => Ok()
    }
  }

  def isSupported(text: String): Boolean = {
    val tree = getTree(text)
    val listener = new stellaParserBaseListener {
      var ok = true
      private val supported = Seq("#unit-type", "#pairs", "#tuples", "#records")
      override def enterAnExtension(ctx: AnExtensionContext): Unit = {
        ok = ok && ctx.extensionNames.stream().map(it => it.getText).allMatch(it => supported.contains(it))
      }
    }
    ParseTreeWalker.DEFAULT.walk(listener, tree)
    listener.ok
  }

  private def getTree(text: String): ProgramContext = {
    val lexer = new stellaLexer(CharStreams.fromString(text))
    val parser = new stellaParser(new CommonTokenStream(lexer))
    parser.program()
  }
}

private class TypeVisitor(val vars: immutable.Map[String, Type], val expectedT: Option[Type]) extends stellaParserBaseVisitor[Either[Error, Type]] {

  override def visitProgram(ctx: ProgramContext): Either[Error, Type] = {
    val topLevelDecl = mutable.Map[String, Type]()
    ctx.decl().stream().forEach(it => {
      val func = it.asInstanceOf[DeclFunContext]
      topLevelDecl.put(func.name.getText, Fun(func.paramDecl(0).paramType.accept(new TypeContextVisitor), func.returnType.accept(new TypeContextVisitor)))
    })
    val ts = ctx.decl().stream().map(it => it.accept(new TypeVisitor(vars ++ topLevelDecl, None)))
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
    val funT = Fun(param.paramType.accept(new TypeContextVisitor()), ctx.returnType.accept(new TypeContextVisitor()))
    ctx.returnExpr.accept(new TypeVisitor(vars ++ Seq((param.name.getText, funT.param)), Some(funT.res))) match {
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
    val condT = ctx.condition.accept(new TypeVisitor(vars, Some(Bool()))) match {
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
    ctx.expr().accept(new TypeVisitor(vars, Some(Nat()))) match {
      case Right(t) if t == Nat() => Right(t)
      case Right(t) => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.expr(), Nat(), t))
      case err@Left(_) => err
    }
  }

  override def visitIsZero(ctx: IsZeroContext): Either[Error, Type] = {
    ctx.expr().accept(new TypeVisitor(vars, Some(Nat()))) match {
      case Right(t) if t == Nat() => Right(Bool())
      case Right(t) => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.expr(), Nat(), t))
      case err@Left(_) => err
    }
  }

  override def visitVar(ctx: VarContext): Either[Error, Type] = {
    vars.get(ctx.name.getText) match {
      case None =>
        Left(ERROR_UNDEFINED_VARIABLE(ctx))
      case Some(t) => Right(t)
    }
  }

  override def visitNatRec(ctx: NatRecContext): Either[Error, Type] = {
    ctx.n.accept(new TypeVisitor(vars, Some(Nat()))) match {
      case Right(Nat()) =>
      case err@Left(_) => return err
      case Right(t) => return Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.n, Nat(), t))
    }
    val initialT = ctx.initial.accept(this) match {
      case Right(t) => t
      case err@Left(_) => return err
    }
    val expectedStepT = Fun(Nat(), Fun(initialT, initialT))
    ctx.step.accept(new TypeVisitor(vars, Some(expectedStepT))) match {
      case Right(t) if t == expectedStepT =>
      case Right(t) => return Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.step, expectedStepT, t))
      case err@Left(_) => return err
    }
    Right(initialT)
  }

  override def visitApplication(ctx: ApplicationContext): Either[Error, Type] = {
    (ctx.fun.accept(new TypeVisitor(vars, None)), ctx.args.get(0).accept(this)) match { // TODO
      case (Right(Fun(param, res)), Right(arg)) =>
        if (param == arg) {
          Right(res)
        } else {
          Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx.fun, param, arg))
        }
      case (Right(Fun(_, _)), err@Left(_)) =>
        err
      case (Right(t), _) =>
        Left(ERROR_NOT_A_FUNCTION(t, ctx))
      case (err@Left(_), _) => err
      case (_, err@Left(_)) => err
    }
  }

  override def visitAbstraction(ctx: AbstractionContext): Either[Error, Type] = {
    val paramT = ctx.paramDecl.paramType.accept(new TypeContextVisitor)
    expectedT match {
      case Some(Fun(t, r)) if t == paramT =>
        ctx.returnExpr.accept(new TypeVisitor(vars ++ Seq((ctx.paramDecl.name.getText, paramT)), Some(r))) match {
          case Right(returnT) => Right(Fun(paramT, returnT))
          case err@Left(_) => err
        }
      case Some(Fun(t, _)) =>
        Left(ERROR_UNEXPECTED_TYPE_FOR_PARAMETER(t, paramT, ctx))
      case Some(t) =>
        Left(ERROR_UNEXPECTED_LAMBDA(t, ctx))
    }
  }

  override def visitDotTuple(ctx: DotTupleContext): Either[Error, Type] = {
    ctx.expr_.accept(new TypeVisitor(vars, None)) match {
      case Right(t@Tuple(a)) =>
        val index = ctx.index.getText.toInt
        if (index < 1 || index > a.length) {
          Left(ERROR_TUPLE_INDEX_OUT_OF_BOUNDS(index, a.length, t, ctx))
        } else {
          Right(a.apply(index - 1))
        }
      case Right(t) =>
        Left(ERROR_NOT_A_TUPLE(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitDotRecord(ctx: DotRecordContext): Either[Error, Type] = {
    ctx.expr_.accept(new TypeVisitor(vars, None)) match {
      case Right(r@Record(_)) =>
        val name = ctx.label.getText
        r.field(name) match {
          case None =>
            Left(ERROR_UNEXPECTED_FIELD_ACCESS(r, ctx))
          case Some(t) =>
            Right(t)
        }
      case Right(t) =>
        Left(ERROR_NOT_A_RECORD(t, ctx))
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
    val types = ctx.exprs.iterator().asScala.map[Either[Error, Type]](it => it.accept(new TypeVisitor(vars, None))).toSeq
    types.find(it => it.isLeft) match {
      case Some(err@Left(_)) => err
      case _ => Right(Tuple(immutable.ArraySeq.from(types.map(it => it.getOrElse(Unknown()))))) // TODO: error handling maybe
    }
  }

  override def visitRecord(ctx: RecordContext): Either[Error, Type] = {
    def getFields = { // TODO handle errors
      ctx.bindings.iterator().asScala.map[RecordField](it => RecordField(it.name.getText, it.expr().accept(new TypeVisitor(vars, None)).getOrElse(Unknown())))
    }
    expectedT match {
      case None =>
        Right(Record(immutable.ArraySeq.from(getFields)))
      case Some(r@Record(expectedFields)) =>
        val unexpectedFields = getFields.filterNot(it => expectedFields.contains(it)).map(it => it.name).toSeq
        if (unexpectedFields.nonEmpty) {
          return Left(ERROR_UNEXPECTED_RECORD_FIELDS(unexpectedFields, r))
        }
        val missingFields = expectedFields.filterNot(it => getFields.contains(it)).map(it => it.name)
        if (missingFields.nonEmpty) {
          return Left(ERROR_MISSING_RECORD_FIELDS(missingFields, r))
        }
        Right(Record(immutable.ArraySeq.from(getFields)))
      case Some(t) =>
        Left(ERROR_UNEXPECTED_RECORD(t, ctx))
    }
  }

  override def visitTerminatingSemicolon(ctx: TerminatingSemicolonContext): Either[Error, Type] = {
    ctx.expr_.accept(this)
  }

  override def defaultResult(): Either[Error, Type] = Right(Unknown())
}

private class TypeContextVisitor extends stellaParserBaseVisitor[Type] {
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

  override def defaultResult(): Type = Unknown()
}
