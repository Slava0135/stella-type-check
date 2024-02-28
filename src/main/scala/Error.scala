package io.github.slava0135.stella

import stellaParser.ExprContext

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.misc.Interval

object Error {
  def prettyPrint(ctx: ParserRuleContext): String = {
    if (ctx.start == null || ctx.stop == null || ctx.start.getStartIndex < 0 || ctx.stop.getStopIndex < 0)
      return ctx.getText
    ctx.start.getInputStream.getText(Interval.of(ctx.start.getStartIndex, ctx.stop.getStopIndex)).indent(2)
  }

  def pos(ctx: ParserRuleContext): String = {
    s"line ${ctx.start.getLine}"
  }
}

sealed class Error(why: String) {
  override def toString: String =
      s"""
       |An error occurred during typechecking!
       |Type Error Tag: [${getClass.getSimpleName}]
       |$why
       |""".stripMargin
}

final case class ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx: ExprContext, expected: Type, actual: Type) extends Error(
    s"""
     |expected type
     |  $expected
     |but got
     |  $actual
     |for expression at ${Error.pos(ctx)}
     |${Error.prettyPrint(ctx)}
     |""".stripMargin
)
