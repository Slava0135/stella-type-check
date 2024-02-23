package io.github.slava0135.stella

import TypeFactory.{evalFunType, evalType}
import stellaParser.{DeclFunContext, ParamDeclContext, ProgramContext}

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

private class TypeVisitor extends stellaParserBaseVisitor[Either[String, TypeInfo]] {
  private val topLevelDecl = mutable.Map[String, Type]()

  override def visitProgram(ctx: ProgramContext): Either[String, TypeInfo] = {
    ctx.decl().stream().forEach(it => {
      val func = it.asInstanceOf[DeclFunContext]
      topLevelDecl.put(func.name.getText, Fun(evalType(func.paramDecl.paramType), evalType(func.returnType)))
    })
    topLevelDecl.foreach(it => println(s"${it._1} : ${it._2}"))
    if (!ctx.decl().stream.anyMatch(it => it.isInstanceOf[DeclFunContext] && it.asInstanceOf[DeclFunContext].name.getText == "main")) {
      return Left("ERROR_MISSING_MAIN")
    }
    Right(null)
  }
}

private class TypeInfo {
}
