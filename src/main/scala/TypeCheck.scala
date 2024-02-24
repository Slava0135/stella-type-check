package io.github.slava0135.stella

import stellaParser._

import org.antlr.v4.runtime.misc.Interval
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream, ParserRuleContext}

import scala.collection.{immutable, mutable}

object TypeCheck {
  def go(text: String): Result = {
    val tree = getTree(text)
    tree.accept(new TypeVisitor(immutable.Map.empty)) match {
      case Left(msg) => Bad(msg)
      case Right(_) => Ok()
    }
  }

  def isSupported(text: String): Boolean = {
    val tree = getTree(text)
    val listener = new stellaParserBaseListener {
      var supported = true
      override def enterAnExtension(ctx: AnExtensionContext): Unit = {
        supported = false
      }
    }
    ParseTreeWalker.DEFAULT.walk(listener, tree)
    listener.supported
  }

  private def getTree(text: String): ProgramContext = {
    val lexer = new stellaLexer(CharStreams.fromString(text))
    val parser = new stellaParser(new CommonTokenStream(lexer))
    parser.program()
  }
}

private class TypeVisitor(val vars: immutable.Map[String, Type]) extends stellaParserBaseVisitor[Either[String, Type]] {

  override def visitProgram(ctx: ProgramContext): Either[String, Type] = {
    val topLevelDecl = mutable.Map[String, Type]()
    ctx.decl().stream().forEach(it => {
      val func = it.asInstanceOf[DeclFunContext]
      (func.paramDecl(0).accept(this), func.returnType.accept(this)) match {
        case (Right(p), Right(r)) => topLevelDecl.put(func.name.getText, Fun(p, r))
      }
    })
    val ts = ctx.decl().stream().map(it => it.accept(new TypeVisitor(vars ++ topLevelDecl)))
    val err = ts.filter(it => it.isLeft).findFirst()
    if (err.isPresent) {
      return err.get()
    }
    if (!topLevelDecl.contains("main")) {
      return Left("ERROR_MISSING_MAIN")
    }
    Right(null)
  }

  override def visitDeclFun(ctx: DeclFunContext): Either[String, Type] = {
    val param = ctx.paramDecl(0)
    val funT = (param.accept(this), ctx.returnType.accept(this)) match {
      case (Right(p), Right(r)) => Fun(p, r)
    }
    ctx.returnExpr.accept(new TypeVisitor(vars ++ Seq((param.name.getText, funT.param)))) match {
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
    val condT = ctx.condition.accept(this) match {
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

  override def visitConstInt(ctx: ConstIntContext): Either[String, Type] = {
    Right(Nat())
  }

  override def visitTypeNat(ctx: TypeNatContext): Either[String, Type] = {
    Right(Nat())
  }

  override def visitTypeBool(ctx: TypeBoolContext): Either[String, Type] = {
    Right(Bool())
  }

  override def visitConstFalse(ctx: ConstFalseContext): Either[String, Type] = {
    Right(Bool())
  }

  override def visitConstTrue(ctx: ConstTrueContext): Either[String, Type] = {
    Right(Bool())
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

  override def defaultResult(): Either[String, Type] = Right(Unknown())

  private def unexpectedTypeForExpression(ctx: ExprContext, expected: Type, actual: Type): Either[String, Type] = {
    val msg =
      s"""An error occurred during typechecking!
         |Type Error Tag: [ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION]
         |expected type
         |  $expected
         |but got
         |  $actual
         |for expression at ${pos(ctx)}
         |  ${prettyPrint(ctx)}
         |""".stripMargin
    Left(msg)
  }

  private def prettyPrint(ctx: ParserRuleContext): String = {
    if (ctx.start == null || ctx.stop == null || ctx.start.getStartIndex < 0 || ctx.stop.getStopIndex < 0)
      return ctx.getText
    ctx.start.getInputStream.getText(Interval.of(ctx.start.getStartIndex, ctx.stop.getStopIndex))
  }

  private def pos(ctx: ParserRuleContext): String = {
    s"line ${ctx.start.getLine}"
  }
}
