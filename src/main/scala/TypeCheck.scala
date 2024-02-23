package io.github.slava0135.stella

import stellaParser.ProgramContext

import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object TypeCheck {
  def go(text: String): Result = {
    Ok()
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

