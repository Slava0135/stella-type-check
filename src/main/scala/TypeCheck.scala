package io.github.slava0135.stella

import stellaParser._

import org.antlr.v4.runtime.misc.Interval
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream, ParserRuleContext}

import scala.collection.{immutable, mutable}
import scala.jdk.CollectionConverters.IteratorHasAsScala

object TypeCheck {
  def go(text: String): Result = {
    val tree = getTree(text)
    tree.accept(new TypeVisitor(immutable.Map.empty, None)) match {
      case Left(msg) => Bad(msg)
      case Right(_) => Ok()
    }
  }

  def isSupported(text: String): Boolean = {
    val tree = getTree(text)
    val listener = new stellaParserBaseListener {
      var ok = true
      private val supported = Seq("#unit-type", "#pairs", "#tuples")
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

private class TypeVisitor(val vars: immutable.Map[String, Type], val expectedT: Option[Type]) extends stellaParserBaseVisitor[Either[String, Type]] {

  override def visitProgram(ctx: ProgramContext): Either[String, Type] = {
    val topLevelDecl = mutable.Map[String, Type]()
    ctx.decl().stream().forEach(it => {
      val func = it.asInstanceOf[DeclFunContext]
      (func.paramDecl(0).accept(this), func.returnType.accept(this)) match {
        case (Right(p), Right(r)) => topLevelDecl.put(func.name.getText, Fun(p, r))
      }
    })
    val ts = ctx.decl().stream().map(it => it.accept(new TypeVisitor(vars ++ topLevelDecl, None)))
    val err = ts.filter(it => it.isLeft).findFirst()
    if (err.isPresent) {
      return err.get()
    }
    if (!topLevelDecl.contains("main")) {
      return error("ERROR_MISSING_MAIN", "main function is not found in the program")
    }
    Right(null)
  }

  override def visitDeclFun(ctx: DeclFunContext): Either[String, Type] = {
    val param = ctx.paramDecl(0)
    val funT = (param.accept(this), ctx.returnType.accept(this)) match {
      case (Right(p), Right(r)) => Fun(p, r)
    }
    ctx.returnExpr.accept(new TypeVisitor(vars ++ Seq((param.name.getText, funT.param)), Some(funT.res))) match {
      case err@Left(_) => err
      case Right(returnT) =>
        if (returnT != funT.res) {
          unexpectedTypeForExpression(ctx.returnExpr, funT.res, returnT)
        } else {
          Right(funT)
        }
    }
  }

  override def visitIf(ctx: IfContext): Either[String, Type] = {
    val condT = ctx.condition.accept(new TypeVisitor(vars, Some(Bool()))) match {
      case Right(t) => t
      case err@Left(_) => return err
    }
    if (condT != Bool()) {
      return unexpectedTypeForExpression(ctx.condition, Bool(), condT)
    }
    (ctx.thenExpr.accept(this), ctx.elseExpr.accept(this)) match {
      case (Right(thenT), Right(elseT)) if thenT == elseT => Right(thenT)
      case (Right(thenT), Right(elseT)) => unexpectedTypeForExpression(ctx.elseExpr, thenT, elseT)
      case (err@Left(_), _) => err
      case (_, err@Left(_)) => err
    }
  }

  override def visitSucc(ctx: SuccContext): Either[String, Type] = {
    ctx.expr().accept(new TypeVisitor(vars, Some(Nat()))) match {
      case Right(t) if t == Nat() => Right(t)
      case Right(t) => unexpectedTypeForExpression(ctx.expr(), Nat(), t)
      case err@Left(_) => err
    }
  }

  override def visitIsZero(ctx: IsZeroContext): Either[String, Type] = {
    ctx.expr().accept(new TypeVisitor(vars, Some(Nat()))) match {
      case Right(t) if t == Nat() => Right(Bool())
      case Right(t) => unexpectedTypeForExpression(ctx.expr(), Nat(), t)
      case err@Left(_) => err
    }
  }

  override def visitVar(ctx: VarContext): Either[String, Type] = {
    val name = ctx.name.getText
    vars.get(name) match {
      case None =>
        error("ERROR_UNDEFINED_VARIABLE", s"undefined variable $name at ${pos(ctx)}")
      case Some(t) => Right(t)
    }
  }

  override def visitNatRec(ctx: NatRecContext): Either[String, Type] = {
    ctx.n.accept(new TypeVisitor(vars, Some(Nat()))) match {
      case Right(Nat()) =>
      case err@Left(_) => return err
      case Right(t) => return unexpectedTypeForExpression(ctx.n, Nat(), t)
    }
    val initialT = ctx.initial.accept(this) match {
      case Right(t) => t
      case err@Left(_) => return err
    }
    val expectedStepT = Fun(Nat(), Fun(initialT, initialT))
    ctx.step.accept(new TypeVisitor(vars, Some(expectedStepT))) match {
      case Right(t) if t == expectedStepT =>
      case Right(t) => return unexpectedTypeForExpression(ctx.step, expectedStepT, t)
      case err@Left(_) => return err
    }
    Right(initialT)
  }

  override def visitApplication(ctx: ApplicationContext): Either[String, Type] = {
    (ctx.fun.accept(new TypeVisitor(vars, None)), ctx.args.get(0).accept(this)) match { // TODO
      case (Right(Fun(param, res)), Right(arg)) =>
        if (param == arg) {
          Right(res)
        } else {
          unexpectedTypeForExpression(ctx.fun, param, arg)
        }
      case (Right(Fun(_, _)), err@Left(_)) =>
        err
      case (Right(t), _) =>
        val msg =
          s"""
            |expected a function type but got
            |  $t
            |for the expression
            |${prettyPrint(ctx.fun)}
            |in the function call at ${pos(ctx)}
            |${prettyPrint(ctx)}
            |""".stripMargin
        error("ERROR_NOT_A_FUNCTION", msg)
      case (err@Left(_), _) => err
      case (_, err@Left(_)) => err
    }
  }

  override def visitAbstraction(ctx: AbstractionContext): Either[String, Type] = {
    val paramT = ctx.paramDecl.accept(this).getOrElse(Unknown())
    expectedT match {
      case Some(Fun(t, r)) if t == paramT =>
        ctx.returnExpr.accept(new TypeVisitor(vars ++ Seq((ctx.paramDecl.name.getText, paramT)), Some(r))) match {
          case Right(returnT) => Right(Fun(paramT, returnT))
          case err@Left(_) => err
        }
      case Some(Fun(t, _)) =>
        val msg =
          s"""
          |expected type
          |  $t
          |but got
          |  $paramT
          |for the parameter ${ctx.paramDecl.name.getText}
          |in function at ${pos(ctx)}
          |${prettyPrint(ctx)}
          |""".stripMargin
        error("ERROR_UNEXPECTED_TYPE_FOR_PARAMETER", msg)
      case Some(t) =>
        val msg =
          s"""
            |expected an expression of a non-function type
            |  $t
            |but got an anonymous function at ${pos(ctx)}
            |${prettyPrint(ctx)}
            |""".stripMargin
        error("ERROR_UNEXPECTED_LAMBDA", msg)
    }
  }

  override def visitDotTuple(ctx: DotTupleContext): Either[String, Type] = {
    ctx.expr_.accept(new TypeVisitor(vars, None)) match {
      case Right(t@Tuple(a)) =>
        val index = ctx.index.getText.toInt
        if (index < 1 || index > a.length) {
          val why =
            s"""
              |unexpected access to component number $index
              |in a tuple
              |${prettyPrint(ctx.expr_)}
              |of length ${a.length}
              |of type $t
              |at ${pos(ctx)}
              |""".stripMargin
          error("ERROR_TUPLE_INDEX_OUT_OF_BOUNDS", why)
        } else {
          Right(a.apply(index - 1))
        }
      case Right(t) =>
        val why =
          s"""
            |expected an expression of tuple type
            |but got expression
            |${prettyPrint(ctx.expr_)}
            |of type
            |  $t
            |in expression
            |${prettyPrint(ctx)}
            |""".stripMargin
          error("ERROR_NOT_A_TUPLE", why)
      case err@Left(_) => err
    }
  }

  override def visitConstInt(ctx: ConstIntContext): Either[String, Type] = Right(Nat())
  override def visitTypeNat(ctx: TypeNatContext): Either[String, Type] = Right(Nat())

  override def visitTypeBool(ctx: TypeBoolContext): Either[String, Type] = Right(Bool())
  override def visitConstFalse(ctx: ConstFalseContext): Either[String, Type] = Right(Bool())
  override def visitConstTrue(ctx: ConstTrueContext): Either[String, Type] = Right(Bool())

  override def visitTypeUnit(ctx: TypeUnitContext): Either[String, Type] = Right(UnitT())
  override def visitConstUnit(ctx: ConstUnitContext): Either[String, Type] = Right(UnitT())

  override def visitTypeTuple(ctx: TypeTupleContext): Either[String, Type] = {
    val types = ctx.types.iterator().asScala.map[Type](it => it.accept(this).getOrElse(Unknown()))
    Right(Tuple(immutable.ArraySeq.from(types)))
  }

  override def visitTuple(ctx: TupleContext): Either[String, Type] = {
    expectedT match {
      case None =>
      case Some(t@Tuple(a)) =>
        val expected = a.size
        val actual = ctx.exprs.size
        if (expected != actual) {
          val msg =
            s"""
              |expected $expected components
              |for a tuple of type
              |  $t
              |but got $actual
              |in tuple
              |${prettyPrint(ctx)}
              |""".stripMargin
          return error("ERROR_UNEXPECTED_TUPLE_LENGTH", msg)
        }
      case Some(t) =>
        val msg =
          s"""
            |expected an expression of a non-tuple type
            |  $t
            |but got a tuple
            |${prettyPrint(ctx)}
            |""".stripMargin
        return error("ERROR_UNEXPECTED_TUPLE",msg)
    }
    val types = ctx.exprs.iterator().asScala.map[Type](it => it.accept(new TypeVisitor(vars, None)).getOrElse(Unknown()))
    Right(Tuple(immutable.ArraySeq.from(types)))
  }

  override def visitTypeFun(ctx: TypeFunContext): Either[String, Type] = {
    (ctx.paramTypes.get(0).accept(this), ctx.returnType.accept(this)) match {
      case (Right(p), Right(r)) => Right(Fun(p, r))
      case (err@Left(_), _) => err
      case (_, err@Left(_)) => err
    }
  }

  override def visitTypeParens(ctx: TypeParensContext): Either[String, Type] = {
    ctx.type_.accept(this)
  }

  override def visitTerminatingSemicolon(ctx: TerminatingSemicolonContext): Either[String, Type] = {
    ctx.expr_.accept(this)
  }

  override def defaultResult(): Either[String, Type] = Right(Unknown())

  private def unexpectedTypeForExpression(ctx: ExprContext, expected: Type, actual: Type): Either[String, Type] = {
    val why =
      s"""
         |expected type
         |  $expected
         |but got
         |  $actual
         |for expression at ${pos(ctx)}
         |${prettyPrint(ctx)}
         |""".stripMargin
    error("ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION", why)
  }

  private def error(tag: String, why: String): Left[String, Type] = {
    Left(
      s"""
       |An error occurred during typechecking!
       |Type Error Tag: [$tag]
       |$why
       |""".stripMargin
    )
  }

  private def prettyPrint(ctx: ParserRuleContext): String = {
    if (ctx.start == null || ctx.stop == null || ctx.start.getStartIndex < 0 || ctx.stop.getStopIndex < 0)
      return ctx.getText
    ctx.start.getInputStream.getText(Interval.of(ctx.start.getStartIndex, ctx.stop.getStopIndex)).indent(2)
  }

  private def pos(ctx: ParserRuleContext): String = {
    s"line ${ctx.start.getLine}"
  }
}
