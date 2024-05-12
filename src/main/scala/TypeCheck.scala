package io.github.slava0135.stella

import EitherLift.liftEither
import stellaParser._

import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream, ParserRuleContext}

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
      "#unit-type",
      "#pairs",
      "#natural-literals",
      "#type-ascriptions",
//      "#let-bindings",
      "#sum-types",
//      "#lists",
      "#fixpoint-combinator",
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

protected case class Constraint(left: Type, right: Type, ctx: ParserRuleContext) {
  def substitute(from: FreshTypeVar, to: Type): Constraint = copy(left.substitute(from, to), right.substitute(from, to))
}

private case class TypeCheckVisitor(c: mutable.Set[Constraint], vars: immutable.Map[String, Type]) extends stellaParserBaseVisitor[Either[Error, Type]] {
  private type Unifier = mutable.ArrayBuffer[(FreshTypeVar, Type)]

  @tailrec
  private def unify(c: immutable.List[Constraint], u: Unifier): Either[Error, Unit] = {
    if (c.isEmpty) {
      Right()
    } else {
      c match {
        case Constraint(left, right, ctx)::tail =>
          (left, right) match {
            case _ if left == right => unify(tail, u)
            case (left@FreshTypeVar(), right) =>
              if (right.contains(left)) {
                Left(ERROR_OCCURS_CHECK_INFINITE_TYPE())
              } else {
                u.addOne((left, right))
                unify(tail.map(_.substitute(left, right)), u)
              }
            case (left, right@FreshTypeVar()) =>
              if (left.contains(right)) {
                Left(ERROR_OCCURS_CHECK_INFINITE_TYPE())
              } else {
                u.addOne((right, left))
                unify(tail.map(_.substitute(right, left)), u)
              }
            case (Fun(argL, retL), Fun(argR, retR)) => unify(tail :+ Constraint(argL, argR, ctx) :+ Constraint(retL, retR, ctx), u)
            case (Pair(argL, retL), Pair(argR, retR)) => unify(tail :+ Constraint(argL, argR, ctx) :+ Constraint(retL, retR, ctx), u)
            case (Sum(argL, retL), Sum(argR, retR)) => unify(tail :+ Constraint(argL, argR, ctx) :+ Constraint(retL, retR, ctx), u)
            case _ =>
              ctx match {
                case ctx: PatternContext => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(left, ctx))
                case _ => Left(ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(left, right))
              }
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
    val unifier: Unifier = mutable.ArrayBuffer.empty
    unify(c.toList, unifier) match {
      case Right(_) =>
        println(unifier)
        Right(null)
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
      c.add(Constraint(returnT, funT.res, ctx))
      funT
    }
  }

  override def visitIf(ctx: IfContext): Either[Error, Type] = {
    for {
      condT <- ctx.condition.accept(this)
      thenT <- ctx.thenExpr.accept(this)
      elseT <- ctx.elseExpr.accept(this)
    } yield {
      c.add(Constraint(condT, Bool(), ctx))
      c.add(Constraint(thenT, elseT, ctx))
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
  override def visitConstUnit(ctx: ConstUnitContext): Either[Error, Type] = Right(UnitT())

  override def visitSucc(ctx: SuccContext): Either[Error, Type] = {
    for {
      exprT <- ctx.n.accept(this)
    } yield {
      c.add(Constraint(exprT, Nat(), ctx))
      Nat()
    }
  }

  override def visitIsZero(ctx: IsZeroContext): Either[Error, Type] = {
    for {
      exprT <- ctx.n.accept(this)
    } yield {
      c.add(Constraint(exprT, Nat(), ctx))
      Bool()
    }
  }

  override def visitPred(ctx: PredContext): Either[Error, Type] = {
    for {
      exprT <- ctx.n.accept(this)
    } yield {
      c.add(Constraint(exprT, Nat(), ctx))
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
      c.add(Constraint(funT, Fun(argT, t), ctx))
      t
    }
  }

  override def visitNatRec(ctx: NatRecContext): Either[Error, Type] = {
    for {
      nT <- ctx.n.accept(this)
      initT <- ctx.initial.accept(this)
      stepT <- ctx.step.accept(this)
    } yield {
      c.add(Constraint(nT, Nat(), ctx))
      c.add(Constraint(stepT, Fun(Nat(), Fun(initT, initT)), ctx))
      initT
    }
  }

  override def visitMatch(ctx: MatchContext): Either[Error, Type] = {
    for {
      exprT <- ctx.expr().accept(this)
      cases <- liftEither(
        ctx.matchCase().iterator().asScala.map { it =>
          val patternVars = it.pattern().accept(PatternVisitor(exprT, c))
          it.expr().accept(copy(c, vars ++ patternVars))
        }.toSeq
      )
    } yield {
      cases.dropRight(1).zip(cases.drop(1)).foreach {
        case (t1, t2) => c.add(Constraint(t1, t2, ctx))
      }
      cases.head
    }
  }

  override def visitFix(ctx: FixContext): Either[Error, Type] = {
    for {
      exprT <- ctx.expr().accept(this)
    } yield {
      val fv = FreshTypeVar()
      c.add(Constraint(exprT, Fun(fv, fv), ctx))
      fv
    }
  }

  override def visitTuple(ctx: TupleContext): Either[Error, Type] = {
    assert(ctx.expr().size() == 2)
    for {
      fstT <- ctx.expr(0).accept(this)
      sndT <- ctx.expr(1).accept(this)
    } yield {
      Pair(fstT, sndT)
    }
  }

  override def visitDotTuple(ctx: DotTupleContext): Either[Error, Type] = {
    val index = ctx.index.getText.toInt
    assert(index == 1 || index == 2)
    for {
      pairT <- ctx.expr().accept(this)
    } yield {
      val fv1 = FreshTypeVar()
      val fv2 = FreshTypeVar()
      c.add(Constraint(pairT, Pair(fv1, fv2), ctx))
      if (index == 1) {
        fv1
      } else {
        fv2
      }
    }
  }

  override def visitTypeAsc(ctx: TypeAscContext): Either[Error, Type] = {
    for {
      exprT <- ctx.expr().accept(this)
    } yield {
      c.add(Constraint(exprT, ctx.type_.accept(TypeContextVisitor()), ctx))
      exprT
    }
  }

  override def visitInl(ctx: InlContext): Either[Error, Type] = {
    for {
      exprT <- ctx.expr().accept(this)
    } yield {
      Sum(exprT, FreshTypeVar())
    }
  }

  override def visitInr(ctx: InrContext): Either[Error, Type] = {
    for {
      exprT <- ctx.expr().accept(this)
    } yield {
      Sum(FreshTypeVar(), exprT)
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
  override def visitTypeTuple(ctx: TypeTupleContext): Type = {
    val types = ctx.types.iterator().asScala.map(_.accept(this)).toSeq
    assert(types.length == 2)
    Pair(types.head, types.last)
  }
  override def visitTypeSum(ctx: TypeSumContext): Type = Sum(ctx.left.accept(this), ctx.right.accept(this))
  override def visitTypeList(ctx: TypeListContext): Type = ListT(ctx.type_.accept(this))

  override def visitTypeAuto(ctx: TypeAutoContext): Type = FreshTypeVar()

  override def defaultResult(): Type = ???
}

final case class PatternVisitor(t: Type, c: mutable.Set[Constraint]) extends stellaParserBaseVisitor[immutable.Map[String, Type]] {
  override def visitPatternVar(ctx: PatternVarContext): Map[String, Type] = {
    immutable.Map(ctx.name.getText -> t)
  }

  override def visitPatternInl(ctx: PatternInlContext): Map[String, Type] = {
    val fv1 = FreshTypeVar()
    val fv2 = FreshTypeVar()
    c.add(Constraint(t, Sum(fv1, fv2), ctx))
    ctx.pattern().accept(PatternVisitor(fv1, c))
  }

  override def visitPatternInr(ctx: PatternInrContext): Map[String, Type] = {
    val fv1 = FreshTypeVar()
    val fv2 = FreshTypeVar()
    c.add(Constraint(t, Sum(fv1, fv2), ctx))
    ctx.pattern().accept(PatternVisitor(fv2, c))
  }

  override def defaultResult(): Map[String, Type] = ???
}
