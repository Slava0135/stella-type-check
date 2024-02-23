package io.github.slava0135.stella

import stellaParser.{DeclFunContext, ProgramContext}

import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

import scala.Left

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

private class TypeVisitor extends stellaParserBaseVisitor[Either[String, TypeInfo]] {
  override def visitProgram(ctx: ProgramContext): Either[String, TypeInfo] = {
    if (!ctx.decl().stream.anyMatch(it => it.isInstanceOf[DeclFunContext] && it.asInstanceOf[DeclFunContext].name.getText == "main")) {
      Left("ERROR_MISSING_MAIN")
    } else {
      Right(new TypeInfo)
    }
  }
}

private class TypeInfo {
}
