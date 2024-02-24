package io.github.slava0135.stella

import stellaParser.{DeclFunContext, ProgramContext}

import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

import scala.collection.mutable

object TypeCheck {
  def go(text: String): Result = {
    val tree = getTree(text)
    tree.accept(new TypeVisitor) match {
      case Left(msg) => Bad(msg)
      case Right(_) => Ok()
    }
  }

  def isSupported(text: String): Boolean = {
    val tree = getTree(text)
    val listener = new stellaParserBaseListener {
      var supported = true
      override def enterAnExtension(ctx: stellaParser.AnExtensionContext): Unit = {
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

private class TypeVisitor extends stellaParserBaseVisitor[Either[String, Type]] {
  private val topLevelDecl = mutable.Map[String, Type]()

  override def visitProgram(ctx: ProgramContext): Either[String, Type] = {
    ctx.decl().stream().forEach(it => {
      val func = it.asInstanceOf[DeclFunContext]
      (func.paramDecl(0).accept(this), func.returnType.accept(this)) match {
        case (Right(p), Right(r)) => topLevelDecl.put(func.name.getText, Fun(p, r))
      }
    })
    topLevelDecl.foreach(println)
    if (!ctx.decl().stream.anyMatch(it => it.isInstanceOf[DeclFunContext] && it.asInstanceOf[DeclFunContext].name.getText == "main")) {
      return Left("ERROR_MISSING_MAIN")
    }
    Right(null)
  }

  override def visitTypeNat(ctx: stellaParser.TypeNatContext): Either[String, Type] = {
    Right(Nat())
  }

  override def visitTypeBool(ctx: stellaParser.TypeBoolContext): Either[String, Type] = {
    Right(Bool())
  }

  override def visitTypeFun(ctx: stellaParser.TypeFunContext): Either[String, Type] = {
    (ctx.paramTypes.get(0).accept(this), ctx.returnType.accept(this)) match {
      case (Right(p), Right(r)) => Right(Fun(p, r))
      case (err@Left(_), _) => err
      case (_, err@Left(_)) => err
    }
  }

  override def visitTypeParens(ctx: stellaParser.TypeParensContext): Either[String, Type] = {
    ctx.type_.accept(this)
  }

  override def defaultResult(): Either[String, Type] = Right(null)
}
