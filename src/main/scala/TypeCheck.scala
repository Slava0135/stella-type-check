package io.github.slava0135.stella

import stellaParser._

import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream, ParserRuleContext}

import scala.collection.{immutable, mutable}
import scala.jdk.CollectionConverters.IteratorHasAsScala

object TypeCheck {
  def go(text: String): Result = {
    val tree = getTree(text)
    tree.accept(TypeCheckVisitor(immutable.Map.empty)) match {
      case Left(err) => Bad(err.toString)
      case Right(_) => Ok()
    }
  }

  def unsupportedExtensions(text: String): Set[String] = {
    val tree = getTree(text)
    var required = Set.empty[String]
    val supported = Set(
//      "#unit-type",
//      "#pairs",
//      "#natural-literals",
//      "#type-ascriptions",
//      "#let-bindings",
//      "#sum-types",
//      "#lists",
//      "#fixpoint-combinator",
//      "#nested-function-declarations",
      "#type-reconstruction",
    )
    val listener: stellaParserBaseListener = new stellaParserBaseListener {
      override def enterAnExtension(ctx: AnExtensionContext): Unit = {
        ctx.extensionNames.iterator().asScala.foreach(required += _.getText)
      }
    }
    ParseTreeWalker.DEFAULT.walk(listener, tree)
    if (required.contains("#type-reconstruction")) {
      required -- supported
    } else {
      (required -- supported) + "*** no type reconstruction ***"
    }
  }

  private def getTree(text: String): ProgramContext = {
    val lexer = new stellaLexer(CharStreams.fromString(text))
    val parser = new stellaParser(new CommonTokenStream(lexer))
    parser.program()
  }
}

private case class TypeCheckVisitor(vars: immutable.Map[String, Type]) extends stellaParserBaseVisitor[Either[Error, Type]] {

}

private case class TypeContextVisitor() extends stellaParserBaseVisitor[Type] {
  override def visitTypeFun(ctx: TypeFunContext): Type = Fun(ctx.paramTypes.get(0).accept(this), ctx.returnType.accept(this))
  override def visitTypeParens(ctx: TypeParensContext): Type = ctx.type_.accept(this)
  override def visitTypeTuple(ctx: TypeTupleContext): Type = {
    val types = ctx.types.iterator().asScala.map[Type](_.accept(this))
    Tuple(types.toSeq)
  }
  override def visitTypeUnit(ctx: TypeUnitContext): Type = UnitT()
  override def visitTypeBool(ctx: TypeBoolContext): Type = Bool()
  override def visitTypeNat(ctx: TypeNatContext): Type = Nat()
  override def visitTypeSum(ctx: TypeSumContext): Type = Sum(ctx.left.accept(this), ctx.right.accept(this))
  override def visitTypeList(ctx: TypeListContext): Type = ListT(ctx.type_.accept(this))

  override def defaultResult(): Type = throw new UnsupportedOperationException()
}

private case class PatternVisitor(t: Type) extends stellaParserBaseVisitor[Either[Error, immutable.Map[String, Type]]] {
  override def visitPatternVar(ctx: PatternVarContext): Either[Error, immutable.Map[String, Type]] = {
    Right(Map.apply(ctx.name.getText -> t))
  }

  override def visitPatternInl(ctx: PatternInlContext): Either[Error, immutable.Map[String, Type]] = {
    t match {
      case Sum(left, _) =>
        ctx.pattern().accept(copy(left)) match {
          case ok@Right(_) => ok
          case err@Left(_) => err
        }
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternInr(ctx: PatternInrContext): Either[Error, immutable.Map[String, Type]] = {
    t match {
      case Sum(_, right) =>
        ctx.pattern().accept(copy(right)) match {
          case ok@Right(_) => ok
          case err@Left(_) => err
        }
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternUnit(ctx: PatternUnitContext): Either[Error, Map[String, Type]] = {
    t match {
      case UnitT() => Right(Map.empty)
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternFalse(ctx: PatternFalseContext): Either[Error, Map[String, Type]] = {
    t match {
      case Bool() => Right(Map.empty)
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternTrue(ctx: PatternTrueContext): Either[Error, Map[String, Type]] = {
    t match {
      case Bool() => Right(Map.empty)
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternInt(ctx: PatternIntContext): Either[Error, Map[String, Type]] = {
    t match {
      case Nat() => Right(Map.empty)
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def visitPatternSucc(ctx: PatternSuccContext): Either[Error, Map[String, Type]] = {
    t match {
      case Nat() =>
        ctx.pattern().accept(this) match {
          case ok@Right(_) => ok
          case err@Left(_) => err
        }
      case _ => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
    }
  }

  override def defaultResult(): Either[Error, immutable.Map[String, Type]] = throw new UnsupportedOperationException()
}
