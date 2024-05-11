package io.github.slava0135.stella

import stellaParser._

import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

import scala.annotation.tailrec
import scala.collection.{immutable, mutable}
import scala.jdk.CollectionConverters.IteratorHasAsScala

object TypeCheck {
  def go(text: String): Result = {
    val tree = getTree(text)
    tree.accept(TypeCheckVisitor(mutable.Set.empty, immutable.Map.empty)) match {
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
      "#natural-literals",
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

private case class Constraint(left: Type, right: Type) {
  def substitute(from: FreshTypeVar, to: Type): Constraint = Constraint(left.substitute(from, to), right.substitute(from, to))
}

private case class TypeCheckVisitor(c: mutable.Set[Constraint], vars: immutable.Map[String, Type]) extends stellaParserBaseVisitor[Either[Error, Type]] {

  @tailrec
  private def unify(c: immutable.List[Constraint]): Either[Error, Unit] = {
    if (c.isEmpty) {
      Right()
    } else {
      c match {
        case Constraint(left, right)::tail =>
          (left, right) match {
            case _ if left == right => unify(tail)
            case (left@FreshTypeVar(), right) =>
              if (right.contains(left)) {
                Left(ERROR_OCCURS_CHECK_INFINITE_TYPE())
              } else {
                unify(tail.map(_.substitute(left, right)))
              }
            case (left, right@FreshTypeVar()) =>
              if (left.contains(right)) {
                Left(ERROR_OCCURS_CHECK_INFINITE_TYPE())
              } else {
                unify(tail.map(_.substitute(right, left)))
              }
            case (Fun(argL, retL), Fun(argR, retR)) => unify(tail :+ Constraint(argL, argR) :+ Constraint(retL, retR))
            case _ => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(left, right))
          }
      }
    }
  }

  override def visitProgram(ctx: ProgramContext): Either[Error, Type] = {
    val topLevelDecl = mutable.Map[String, Type]()
    ctx.decl().stream().forEach {
      case func: DeclFunContext =>
        topLevelDecl.put(func.name.getText, Fun(func.paramDecl.paramType.accept(TypeContextVisitor()), func.returnType.accept(TypeContextVisitor())))
    }
    EitherLift.liftEither(ctx.decl().iterator().asScala.map(_.accept(copy(c, vars ++ topLevelDecl))).toSeq) match {
      case Left(err) => return Left(err)
      case _ =>
    }
    if (!topLevelDecl.contains("main")) {
      return Left(ERROR_MISSING_MAIN())
    }
    unify(c.toList) match {
      case Right(_) => Right(null)
      case Left(err) => Left(err)
    }
  }

  override def visitDeclFun(ctx: DeclFunContext): Either[Error, Type] = {
    val funT = vars.get(ctx.name.getText) match {
      case Some(t@Fun(_, _)) => t
      case _ => ??? // TODO: nested function declartions
    }
    for {
      returnT <- ctx.returnExpr.accept(copy(c, vars + (ctx.paramDecl.name.getText -> funT.param)))
    } yield {
      c.add(Constraint(returnT, funT.res))
      funT
    }
  }

  override def visitIf(ctx: IfContext): Either[Error, Type] = {
    for {
      condT <- ctx.condition.accept(this)
      thenT <- ctx.thenExpr.accept(this)
      elseT <- ctx.elseExpr.accept(this)
    } yield {
      c.add(Constraint(condT, Bool()))
      c.add(Constraint(thenT, elseT))
      thenT
    }
  }

  override def visitVar(ctx: VarContext): Either[Error, Type] = {
    vars.get(ctx.name.getText) match {
      case Some(t) => Right(t)
      case _ => Left(ERROR_UNDEFINED_VARIABLE(ctx))
    }
  }

  override def visitConstInt(ctx: ConstIntContext): Either[Error, Type] = Right(Nat())
  override def visitConstFalse(ctx: ConstFalseContext): Either[Error, Type] = Right(Bool())
  override def visitConstTrue(ctx: ConstTrueContext): Either[Error, Type] = Right(Bool())

  override def visitSucc(ctx: SuccContext): Either[Error, Type] = {
    for {
      exprT <- ctx.n.accept(this)
    } yield {
      c.add(Constraint(exprT, Nat()))
      Nat()
    }
  }

  override def visitIsZero(ctx: IsZeroContext): Either[Error, Type] = {
    for {
      exprT <- ctx.n.accept(this)
    } yield {
      c.add(Constraint(exprT, Nat()))
      Bool()
    }
  }

  override def visitPred(ctx: PredContext): Either[Error, Type] = {
    for {
      exprT <- ctx.n.accept(this)
    } yield {
      c.add(Constraint(exprT, Nat()))
      Nat()
    }
  }

  override def visitAbstraction(ctx: AbstractionContext): Either[Error, Type] = {
    val paramT = ctx.paramDecl.paramType.accept(TypeContextVisitor())
    for {
      returnT <- ctx.returnExpr.accept(copy(c, vars + (ctx.paramDecl.name.getText -> paramT)))
    } yield {
      Fun(paramT, returnT)
    }
  }

  override def visitApplication(ctx: ApplicationContext): Either[Error, Type] = {
    for {
      funT <- ctx.fun.accept(this)
      argT <- ctx.args.get(0).accept(this)
    } yield {
      val t = FreshTypeVar()
      c.add(Constraint(funT, Fun(argT, t)))
      t
    }
  }

  override def visitNatRec(ctx: NatRecContext): Either[Error, Type] = {
    for {
      nT <- ctx.n.accept(this)
      initT <- ctx.initial.accept(this)
      stepT <- ctx.step.accept(this)
    } yield {
      c.add(Constraint(nT, Nat()))
      c.add(Constraint(stepT, Fun(Nat(), Fun(initT, initT))))
      initT
    }
  }

  override def visitParenthesisedExpr(ctx: ParenthesisedExprContext): Either[Error, Type] = ctx.expr().accept(this)
  override def visitTerminatingSemicolon(ctx: TerminatingSemicolonContext): Either[Error, Type] = ctx.expr().accept(this)

  override def defaultResult(): Right[Nothing, FreshTypeVar] = Right(FreshTypeVar())
}

private case class TypeContextVisitor() extends stellaParserBaseVisitor[Type] {

  override def visitTypeFun(ctx: TypeFunContext): Type = Fun(ctx.paramTypes.get(0).accept(this), ctx.returnType.accept(this))

  override def visitTypeParens(ctx: TypeParensContext): Type = ctx.type_.accept(this)
  override def visitTypeUnit(ctx: TypeUnitContext): Type = UnitT()
  override def visitTypeBool(ctx: TypeBoolContext): Type = Bool()
  override def visitTypeNat(ctx: TypeNatContext): Type = Nat()
  override def visitTypeSum(ctx: TypeSumContext): Type = Sum(ctx.left.accept(this), ctx.right.accept(this))
  override def visitTypeList(ctx: TypeListContext): Type = ListT(ctx.type_.accept(this))

  override def visitTypeVar(ctx: TypeVarContext): Type = FreshTypeVar()

  override def defaultResult(): Type = throw new UnsupportedOperationException()
}
