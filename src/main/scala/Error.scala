package io.github.slava0135.stella

import stellaParser.{AbstractionContext, ApplicationContext, DotRecordContext, DotTupleContext, ExprContext, RecordContext, TupleContext, VarContext}

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

final case class ERROR_MISSING_MAIN() extends Error(
  "main function is not found in the program"
)
final case class ERROR_UNDEFINED_VARIABLE(ctx: VarContext) extends Error(
  s"undefined variable ${ctx.name.getText} at ${Error.pos(ctx)}"
)
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
final case class ERROR_NOT_A_FUNCTION(t: Type, ctx: ApplicationContext) extends Error(
  s"""
  |expected a function type but got
  |  $t
  |for the expression
  |${Error.prettyPrint(ctx.fun)}
  |in the function call at ${Error.pos(ctx)}
  |${Error.prettyPrint(ctx)}
  |""".stripMargin
)
final case class ERROR_UNEXPECTED_TYPE_FOR_PARAMETER(t: Type, paramT: Type, ctx: AbstractionContext) extends Error(
  s"""
  |expected type
  |  $t
  |but got
  |  $paramT
  |for the parameter ${ctx.paramDecl.name.getText}
  |in function at ${Error.pos(ctx)}
  |${Error.prettyPrint(ctx)}
  |""".stripMargin
)
final case class ERROR_UNEXPECTED_LAMBDA(t: Type, ctx: AbstractionContext) extends Error(
  s"""
  |expected an expression of a non-function type
  |  $t
  |but got an anonymous function at ${Error.pos(ctx)}
  |${Error.prettyPrint(ctx)}
  |""".stripMargin
)
final case class ERROR_TUPLE_INDEX_OUT_OF_BOUNDS(index: Int, len: Int, t: Type, ctx: DotTupleContext) extends Error(
  s"""
  |unexpected access to component number $index
  |in a tuple
  |${Error.prettyPrint(ctx.expr_)}
  |of length $len
  |of type $t
  |at ${Error.pos(ctx)}
  |""".stripMargin
)
final case class ERROR_NOT_A_TUPLE(t: Type, ctx: DotTupleContext) extends Error(
  s"""
  |expected an expression of tuple type
  |but got expression
  |${Error.prettyPrint(ctx.expr_)}
  |of type
  |  $t
  |in expression
  |${Error.prettyPrint(ctx)}
  |""".stripMargin
)
final case class ERROR_UNEXPECTED_FIELD_ACCESS(r: Type, ctx: DotRecordContext) extends Error(
  s"""
  |unexpected access to field ${ctx.label.getText}
  |in a record of type
  |  $r
  |in the expression
  |  ${Error.prettyPrint(ctx.expr_)}
  |""".stripMargin
)
final case class ERROR_NOT_A_RECORD(t: Type, ctx: DotRecordContext) extends Error(
  s"""
  |expected a record type but got
  |  $t
  |for the expression
  |${Error.prettyPrint(ctx.expr_)}
  |in the expression
  |${Error.prettyPrint(ctx)}
  |""".stripMargin
)
final case class ERROR_UNEXPECTED_TUPLE_LENGTH(expected: Int, actual: Int, t: Type, ctx: TupleContext) extends Error(
  s"""
  |expected $expected components
  |for a tuple of type
  |  $t
  |but got $actual
  |in tuple
  |${Error.prettyPrint(ctx)}
  |""".stripMargin
)
final case class ERROR_UNEXPECTED_TUPLE(t: Type, ctx: TupleContext) extends Error(
  s"""
  |expected an expression of a non-tuple type
  |  $t
  |but got a tuple
  |${Error.prettyPrint(ctx)}
  |""".stripMargin
)
final case class ERROR_UNEXPECTED_RECORD(t: Type, ctx: RecordContext) extends Error(
  s"""
  |expected an expression of a non-record type
  |  $t
  |but got a record
  |${Error.prettyPrint(ctx)}
  |""".stripMargin
)
final case class ERROR_UNEXPECTED_RECORD_FIELDS(fields: Seq[String], t: Type) extends Error(
  s"""
  |unexpected fields
  |  ${fields.addString(new StringBuilder(), ", ")}
  |for an expected record of type
  |  $t
  |""".stripMargin
)
