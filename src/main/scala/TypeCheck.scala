package io.github.slava0135.stella

import stellaParser._

import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream, ParserRuleContext}

import scala.collection.{immutable, mutable}
import scala.jdk.CollectionConverters.IteratorHasAsScala

object TypeCheck {
  def go(text: String): Result = {
    val tree = getTree(text)
    val enabled = enabledExtensions(text)
    val tc = TypeCheckVisitor(
      immutable.Map.empty,
      None,
      None,
      ambiguousTypeAsBottom = enabled.contains("#ambiguous-type-as-bottom")
    )(subtypingEnabled = enabled.contains("#structural-subtyping"))
    tree.accept(tc) match {
      case Left(err) => Bad(err.toString)
      case Right(_) => Ok()
    }
  }

  private def enabledExtensions(text: String): Set[String] = {
    val tree = getTree(text)
    var enabled = Set.empty[String]
    val listener: stellaParserBaseListener = new stellaParserBaseListener {
      override def enterAnExtension(ctx: AnExtensionContext): Unit = {
        ctx.extensionNames.iterator().asScala.foreach(enabled += _.getText)
      }
    }
    ParseTreeWalker.DEFAULT.walk(listener, tree)
    enabled
  }

  def unsupportedExtensions(text: String): Set[String] = {
    val supported = Set(
      "#unit-type",
      "#pairs",
      "#tuples",
      "#records",
      "#natural-literals",
      "#type-ascriptions",
      "#let-bindings",
      "#sum-types",
      "#lists",
      "#fixpoint-combinator",
      "#variants",
      "#nested-function-declarations",
      "#sequencing",
      "#references",
      "#panic",
      "#exceptions",
      "#exception-type-declaration",
      "#structural-subtyping",
      "#top-type",
      "#bottom-type",
      "#ambiguous-type-as-bottom",
    )
    val enabled = enabledExtensions(text)
    enabled -- supported
  }

  private def getTree(text: String): ProgramContext = {
    val lexer = new stellaLexer(CharStreams.fromString(text))
    val parser = new stellaParser(new CommonTokenStream(lexer))
    parser.program()
  }
}

private case class TypeCheckVisitor(vars: immutable.Map[String, Type], expectedT: Option[Type], throwT: Option[Type], ambiguousTypeAsBottom: Boolean)
                                   (implicit subtypingEnabled: Boolean)
  extends stellaParserBaseVisitor[Either[Error, Type]] {

  override def visitProgram(ctx: ProgramContext): Either[Error, Type] = {
    val topLevelDecl = mutable.Map[String, Type]()
    var throwT: Option[Type] = None
    ctx.decl().stream().forEach {
      case func: DeclFunContext =>
        topLevelDecl.put(func.name.getText, Fun(func.paramDecl(0).paramType.accept(new TypeContextVisitor), func.returnType.accept(new TypeContextVisitor)))
      case exceptionTypeDecl: DeclExceptionTypeContext =>
        throwT = Some(exceptionTypeDecl.exceptionType.accept(TypeContextVisitor()))
    }
    EitherLift.liftEither(ctx.decl().iterator().asScala.map(_.accept(copy(vars ++ topLevelDecl, None, throwT))).toSeq) match {
      case Left(err) => return Left(err)
      case _ =>
    }
    if (!topLevelDecl.contains("main")) {
      return Left(ERROR_MISSING_MAIN())
    }
    Right(null)
  }

  override def visitDeclFun(ctx: DeclFunContext): Either[Error, Type] = {
    val param = ctx.paramDecl(0)
    val funT = Fun(param.paramType.accept(TypeContextVisitor()), ctx.returnType.accept(TypeContextVisitor()))
    EitherLift.liftEither(ctx.localDecls.iterator().asScala.map(copy(vars + (param.name.getText -> funT.param), None) check _).toSeq) match {
      case Right(localDecl) =>
        val localVars = vars + (param.name.getText -> funT.param) ++
          ctx.localDecls.iterator().asScala.map(_.asInstanceOf[DeclFunContext].name.getText)
            .zip(localDecl)
        copy(localVars, Some(funT.res)) check ctx.returnExpr match {
          case err@Left(_) => err
          case Right(_) => Right(funT)
        }
      case Left(err) => Left(err)
    }
  }

  override def visitIf(ctx: IfContext): Either[Error, Type] = {
    copy(vars, Some(Bool())) check ctx.condition match {
      case err@Left(_) => return err
      case _ =>
    }
    this check ctx.thenExpr match {
      case Right(thenT) =>
        copy(vars, Some(thenT)) check ctx.elseExpr match {
          case Right(elseT) => Right(elseT)
          case err@Left(_) => err
        }
      case err@Left(_) => err
    }
  }

  override def visitSucc(ctx: SuccContext): Either[Error, Type] = copy(vars, Some(Nat())) check ctx.expr()

  override def visitIsZero(ctx: IsZeroContext): Either[Error, Type] = {
    copy(vars, Some(Nat())) check ctx.expr() match {
      case Right(_) => Right(Bool())
      case err@Left(_) => err
    }
  }

  override def visitVar(ctx: VarContext): Either[Error, Type] = {
    vars.get(ctx.name.getText) match {
      case None => Left(ERROR_UNDEFINED_VARIABLE(ctx))
      case Some(t) => Right(t)
    }
  }

  override def visitNatRec(ctx: NatRecContext): Either[Error, Type] = {
    copy(vars, Some(Nat())) check ctx.n match {
      case err@Left(_) => return err
      case Right(_) =>
    }
    val initialT = copy(vars, None) check ctx.initial match {
      case Right(t) => t
      case err@Left(_) => return err
    }
    val expectedStepT = Fun(Nat(), Fun(initialT, initialT))
    copy(vars, Some(expectedStepT)) check ctx.step match {
      case Right(_) =>
      case err@Left(_) => return err
    }
    Right(initialT)
  }

  override def visitApplication(ctx: ApplicationContext): Either[Error, Type] = {
    copy(vars, None) check ctx.fun match {
      case Right(Fun(param, res)) =>
        copy(vars, Some(param)).check(ctx.args.get(0)) match {
          case Right(_) => Right(res)
          case err@Left(_) => err
        }
      case Right(t) => Left(ERROR_NOT_A_FUNCTION(t, Left(ctx)))
      case err@Left(_) => err
    }
  }

  override def visitAbstraction(ctx: AbstractionContext): Either[Error, Type] = {
    val paramT = ctx.paramDecl.paramType.accept(TypeContextVisitor())
    expectedT match {
      case None =>
        copy(vars + (ctx.paramDecl.name.getText -> paramT), None) check ctx.returnExpr match {
          case Right(returnT) => Right(Fun(paramT, returnT))
          case err@Left(_) => err
        }
      case Some(Fun(t, r)) if t.isSubtypeOf(paramT) =>
        copy(vars + (ctx.paramDecl.name.getText -> paramT), Some(r)) check ctx.returnExpr match {
          case Right(returnT) => Right(Fun(paramT, returnT))
          case err@Left(_) => err
        }
      case Some(Fun(t, _)) => Left(if (!subtypingEnabled) ERROR_UNEXPECTED_TYPE_FOR_PARAMETER(t, paramT, ctx) else ERROR_UNEXPECTED_SUBTYPE(ctx, t, paramT))
      case Some(t) => Left(ERROR_UNEXPECTED_LAMBDA(t, ctx))
    }
  }

  override def visitDotTuple(ctx: DotTupleContext): Either[Error, Type] = {
    copy(vars, None) check ctx.expr() match {
      case Right(t@Tuple(a)) =>
        val index = ctx.index.getText.toInt
        if (index < 1 || index > a.length) {
          Left(ERROR_TUPLE_INDEX_OUT_OF_BOUNDS(index, a.length, t, ctx))
        } else {
          Right(a.apply(index - 1))
        }
      case Right(t) => Left(ERROR_NOT_A_TUPLE(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitDotRecord(ctx: DotRecordContext): Either[Error, Type] = {
    copy(vars, None) check ctx.expr() match {
      case Right(r@Record(_)) =>
        val name = ctx.label.getText
        r.field(name) match {
          case None => Left(ERROR_UNEXPECTED_FIELD_ACCESS(r, ctx))
          case Some(t) =>Right(t)
        }
      case Right(t) => Left(ERROR_NOT_A_RECORD(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitConstInt(ctx: ConstIntContext): Either[Error, Type] = Right(Nat())
  override def visitConstFalse(ctx: ConstFalseContext): Either[Error, Type] = Right(Bool())
  override def visitConstTrue(ctx: ConstTrueContext): Either[Error, Type] = Right(Bool())
  override def visitConstUnit(ctx: ConstUnitContext): Either[Error, Type] = Right(UnitT())

  override def visitTuple(ctx: TupleContext): Either[Error, Type] = {
    expectedT match {
      case None =>
      case Some(t@Tuple(a)) =>
        val expected = a.size
        val actual = ctx.exprs.size
        if (expected != actual) {
          return Left(ERROR_UNEXPECTED_TUPLE_LENGTH(expected, actual, t, ctx))
        }
      case Some(t) =>
        return Left(ERROR_UNEXPECTED_TUPLE(t, ctx))
    }
    val typesOrErr = ctx.exprs.iterator().asScala.map[Either[Error, Type]](copy(vars, None) check _).toSeq
    EitherLift.liftEither(typesOrErr) match {
      case Right(types) => Right(Tuple(types))
      case Left(err) => Left(err)
    }
  }

  override def visitRecord(ctx: RecordContext): Either[Error, Type] = {
    def getFields = {
      EitherLift.liftEither(ctx.bindings.iterator().asScala.map[Either[Error, RecordField]] { it =>
        val newExpectedT = expectedT match {
          case Some(r@Record(_)) => r.field(it.name.getText) // TODO: missing field here?
          case None => None
        }
        copy(vars, newExpectedT) check it.expr() match {
          case Left(err) => Left(err)
          case Right(t) => Right(RecordField(it.name.getText, t))
        }
      }.toSeq)
    }
    expectedT match {
      case None =>
        getFields match {
          case Left(err) => Left(err)
          case Right(fields) => Right(Record(fields))
        }
      case Some(r@Record(expectedFields)) =>
        getFields match {
          case Left(err) => Left(err)
          case Right(fields) =>
            if (subtypingEnabled) {
              Right(Record(fields))
            } else {
              val unexpectedFields = fields.map(_.name).filterNot(expectedFields.map(_.name).contains(_))
              if (unexpectedFields.nonEmpty) {
                return Left(ERROR_UNEXPECTED_RECORD_FIELDS(unexpectedFields, r, ctx))
              }
              val missingFields = expectedFields.map(_.name).filterNot(fields.map(_.name).contains(_))
              if (missingFields.nonEmpty) {
                return Left(ERROR_MISSING_RECORD_FIELDS(missingFields, r, ctx))
              }
              Right(r)
            }
        }
      case Some(t) => Left(ERROR_UNEXPECTED_RECORD(t, ctx))
    }
  }

  override def visitTerminatingSemicolon(ctx: TerminatingSemicolonContext): Either[Error, Type] = check(ctx.expr_)

  override def visitTypeAsc(ctx: TypeAscContext): Either[Error, Type] = {
    val actual = ctx.type_.accept(TypeContextVisitor())
    copy(vars, Some(actual)) checkIgnoreType ctx.expr() match {
      case Right(expected) =>
        if (actual.isSubtypeOf(expected)) {
          Right(actual)
        } else {
          Left(unexpectedType(ctx, expected, actual))
        }
      case err@Left(_) => err
    }
  }

  override def visitLet(ctx: LetContext): Either[Error, Type] = {
    copy(vars, None) check ctx.patternBinding.rhs match {
      case Right(t) =>
        ctx.patternBinding.pat.accept(PatternVisitor(t)) match {
          case Left(err) => Left(err)
          case Right(patVars) => copy(vars ++ patVars, expectedT) check ctx.body
        }
      case err@Left(_) => err
    }
  }

  override def visitParenthesisedExpr(ctx: ParenthesisedExprContext): Either[Error, Type] = check(ctx.expr())

  override def visitInl(ctx: InlContext): Either[Error, Type] = {
    expectedT match {
      case Some(s@Sum(left, _)) =>
        copy(vars, Some(left)) check ctx.expr() match {
          case Right(_) => Right(s)
          case err@Left(_) => err
        }
      case Some(t) => Left(ERROR_UNEXPECTED_INJECTION(t, ctx))
      case None if ambiguousTypeAsBottom => Right(Bot())
      case None => Left(ERROR_AMBIGUOUS_SUM_TYPE())
    }
  }

  override def visitInr(ctx: InrContext): Either[Error, Type] = {
    expectedT match {
      case Some(s@Sum(_, right)) =>
        copy(vars, Some(right)) check ctx.expr() match {
          case Right(_) => Right(s)
          case err@Left(_) => err
        }
      case Some(t) => Left(ERROR_UNEXPECTED_INJECTION(t, ctx))
      case None if ambiguousTypeAsBottom => Right(Bot())
      case None => Left(ERROR_AMBIGUOUS_SUM_TYPE())
    }
  }

  override def visitMatch(ctx: MatchContext): Either[Error, Type] = {
    if (ctx.cases.isEmpty) {
      return Left(ERROR_ILLEGAL_EMPTY_MATCHING(ctx))
    }
    val matchT = copy(vars, None) check ctx.expr() match {
      case Right(t) => t
      case err@Left(_) => return err
    }
    EitherLift.liftEither(ctx.cases.iterator().asScala.map(_.pattern().accept(PatternVisitor(matchT))).toSeq) match {
      case Right(caseVars) =>
        Exhaustiveness.check(matchT, ctx) match {
          case Left(err) => Left(err)
          case _ =>
            EitherLift.liftEither(ctx.cases.iterator().asScala.zip(caseVars).map { case (c, v) => copy(vars ++ v) check c }.toSeq) match {
              case Right(ts) =>
                val t = ts.head
                ts.find(_ != t) match {
                  case Some(otherT) => Left(unexpectedType(ctx, t, otherT))
                  case None => Right(t)
                }
              case Left(err) => Left(err)
            }
        }
      case Left(err) => Left(err)
    }
  }

  override def visitList(ctx: ListContext): Either[Error, Type] = {
    def go(t: Option[Type]) = {
      if (ctx.expr().isEmpty) {
        t match {
          case Some(t) => Right(ListT(t))
          case None =>
            ctx.parent match {
              case _: TypeAscContext => Right(Unknown())
              case _ if ambiguousTypeAsBottom => Right(Bot())
              case _ => Left(ERROR_AMBIGUOUS_LIST_TYPE())
            }
        }
      } else {
        copy(vars, t) check ctx.expr match {
          case Right(t) =>
            EitherLift.liftEither(ctx.expr().iterator().asScala.map(copy(vars, Some(t)) check _).toSeq) match {
              case Right(_) => Right(ListT(t))
              case Left(err) => Left(err)
            }
          case err@Left(_) => err
        }
      }
    }
    expectedT match {
      case Some(Top()) if subtypingEnabled => go(None)
      case Some(ListT(t)) => go(Some(t))
      case Some(t) => Left(ERROR_UNEXPECTED_LIST(t, ctx))
      case None => go(None)
    }
  }

  override def visitConsList(ctx: ConsListContext): Either[Error, Type] = {
    def go(t: Option[Type]): Either[Error, Type] = {
      copy(vars, t) check ctx.head match {
        case Right(t) =>
          copy(vars, Some(ListT(t))) check ctx.tail match {
            case Right(_) => Right(ListT(t))
            case err@Left(_) => err
          }
        case err@Left(_) => err
      }
    }
    expectedT match {
      case Some(Top()) if subtypingEnabled => go(None)
      case Some(ListT(t)) => go(Some(t))
      case Some(t) => Left(ERROR_UNEXPECTED_LIST(t, ctx))
      case None => go(None)
    }
  }

  override def visitHead(ctx: HeadContext): Either[Error, Type] = {
    copy(vars, expectedT.map(ListT)) checkIgnoreType ctx.list match {
      case Right(ListT(t)) => Right(t)
      case Right(t) => Left(ERROR_NOT_A_LIST(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitTail(ctx: TailContext): Either[Error, Type] = {
    copy(vars, expectedT) checkIgnoreType ctx.list match {
      case Right(ListT(t)) => Right(ListT(t))
      case Right(t) => Left(ERROR_NOT_A_LIST(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitIsEmpty(ctx: IsEmptyContext): Either[Error, Type] = {
    copy(vars, None) checkIgnoreType ctx.list match {
      case Right(ListT(_)) => Right(Bool())
      case Right(t) => Left(ERROR_NOT_A_LIST(t, ctx))
      case err@Left(_) => err
    }
  }

  override def visitFix(ctx: FixContext): Either[Error, Type] = {
    copy(vars, expectedT.map(it => Fun(it, it))) checkIgnoreType ctx.expr() match {
      case Right(Fun(p, r)) if p == r => Right(r)
      case Right(f@Fun(p, _)) => Left(unexpectedType(ctx, Fun(p, p), f))
      case Right(t) => Left(ERROR_NOT_A_FUNCTION(t, Right(ctx)))
      case err@Left(_) => err
    }
  }

  override def visitVariant(ctx: VariantContext): Either[Error, Type] = {
    expectedT match {
      case Some(v@Variant(_)) =>
        v.tag(ctx.label.getText) match {
          case Some(t) =>
            copy(vars, Some(t)) check ctx.rhs match {
              case Right(_) => Right(v)
              case err@Left(_) => err
            }
          case None => Left(ERROR_UNEXPECTED_VARIANT_LABEL(ctx.label.getText, v, ctx))
        }
      case Some(t) => Left(ERROR_UNEXPECTED_VARIANT(t, ctx))
      case None if ambiguousTypeAsBottom => Right(Bot())
      case None => Left(ERROR_AMBIGUOUS_VARIANT_TYPE())
    }
  }

  override def visitSequence(ctx: SequenceContext): Either[Error, Type] = {
    copy(vars, Some(UnitT())) check ctx.expr1 match {
      case err@Left(_) => err
      case _ => this check ctx.expr2
    }
  }

  override def visitRef(ctx: RefContext): Either[Error, Type] = {
    expectedT match {
      case None => this check ctx.expr() match {
        case Right(t) => Right(Ref(t))
        case err@Left(_) => err
      }
      case Some(t@Ref(tt)) => copy(vars, Some(tt)) check ctx.expr() match {
        case Right(_) => Right(t)
        case err@Left(_) => err
      }
      case Some(Top()) if subtypingEnabled => copy(vars, Some(Top())) check ctx.expr() match {
        case Right(t) => Right(t)
        case err@Left(_) => err
      }
      case Some(t) => Left(ERROR_UNEXPECTED_REFERENCE(t, ctx))
    }
  }

  override def visitDeref(ctx: DerefContext): Either[Error, Type] = {
    expectedT match {
      case None => this check ctx.expr() match {
        case Right(Ref(t)) => Right(t)
        case Right(t) => Left(ERROR_NOT_A_REFERENCE(t, Left(ctx)))
        case err@Left(_) => err
      }
      case Some(t) => copy(vars, Some(Ref(t))) checkIgnoreType ctx.expr() match {
        case Right(Ref(t)) => Right(t)
        case Right(t) => Left(ERROR_NOT_A_REFERENCE(t, Left(ctx)))
        case err@Left(_) => err
      }
    }
  }

  override def visitAssign(ctx: AssignContext): Either[Error, Type] = {
    copy(vars, None) check ctx.lhs match {
      case Right(Ref(t)) =>
        copy(vars, Some(t)) check ctx.rhs match {
          case Right(_) => Right(UnitT())
          case err@Left(_) => err
      }
      case Right(t) => Left(ERROR_NOT_A_REFERENCE(t, Right(ctx)))
      case err@Left(_) => err
    }
  }

  override def visitConstMemory(ctx: ConstMemoryContext): Either[Error, Type] = {
    expectedT match {
      case None if ambiguousTypeAsBottom => Right(Bot())
      case None => Left(ERROR_AMBIGUOUS_REFERENCE_TYPE())
      case Some(t@Ref(_)) => Right(t)
      case Some(t) => Left(ERROR_UNEXPECTED_MEMORY_ADDRESS(t, ctx))
    }
  }

  override def visitPanic(ctx: PanicContext): Either[Error, Type] = {
    expectedT match {
      case None if ambiguousTypeAsBottom => Right(Bot())
      case None => Left(ERROR_AMBIGUOUS_PANIC_TYPE())
      case Some(t) => Right(t)
    }
  }

  override def visitTryWith(ctx: TryWithContext): Either[Error, Type] = {
    this check ctx.tryExpr match {
      case Right(_) => this check ctx.fallbackExpr
      case err@Left(_) => err
    }
  }

  override def visitThrow(ctx: ThrowContext): Either[Error, Type] = {
    expectedT match {
      case Some(t) =>
        throwT match {
          case None => Left(ERROR_EXCEPTION_TYPE_NOT_DECLARED())
          case Some(tt) =>
            copy(vars, Some(tt)) check ctx.expr() match {
              case Right(_) => Right(t) // TODO: add test with different throw and expected type
              case err@Left(_) => err
            }
        }
      case None if ambiguousTypeAsBottom => Right(Bot())
      case None => Left(ERROR_AMBIGUOUS_THROW_TYPE())
    }
  }

  override def visitTryCatch(ctx: TryCatchContext): Either[Error, Type] = {
    this check ctx.tryExpr match {
      case Right(_) =>
        throwT match {
          case None => Left(ERROR_EXCEPTION_TYPE_NOT_DECLARED())
          case Some(tt) =>
            ctx.pat.accept(PatternVisitor(tt)) match {
              case Right(patVars) => copy(vars ++ patVars, expectedT) check ctx.fallbackExpr
              case Left(err) => Left(err)
            }
        }
      case err@Left(_) => err
    }
  }

  private def unexpectedType(ctx: ParserRuleContext, expectedT: Type, actualT: Type): Error = {
    (expectedT, actualT) match {
      case (expectedT@Tuple(exp), Tuple(act)) =>
        if (exp.length != act.length) {
          return ERROR_UNEXPECTED_TUPLE_LENGTH(exp.length, act.length, expectedT, ctx)
        }
      case (expectedT@Record(expectedFields), Record(fields)) => // TODO: this is awful
        if (!fields.forall { f =>
          expectedFields.find(_.name == f.name) match {
            case Some(expectedF) => f.t.isSubtypeOf(expectedF.t)
            case None => true
          }})
        {
          if (!subtypingEnabled) {
            return ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx, expectedT, actualT)
          } else {
            return ERROR_UNEXPECTED_SUBTYPE(ctx, expectedT, actualT)
          }
        }
        val unexpectedFields = fields.map(_.name).filterNot(expectedFields.map(_.name).contains(_))
        if (unexpectedFields.nonEmpty && subtypingEnabled) {
          return ERROR_UNEXPECTED_RECORD_FIELDS(unexpectedFields, expectedT, ctx)
        }
        val missingFields = expectedFields.map(_.name).filterNot(fields.map(_.name).contains(_))
        if (missingFields.nonEmpty) {
          return ERROR_MISSING_RECORD_FIELDS(missingFields, expectedT, ctx)
        }
      case (expectedT@Variant(expectedTags), actualT@Variant(actualTags)) =>
        if (!actualTags.forall { actualTag =>
          expectedT.tag(actualTag.name) match {
            case Some(expectedTag) => actualTag.t.isSubtypeOf(expectedTag)
            case None => true
          }
        }) {
          if (!subtypingEnabled) {
            return ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx, expectedT, actualT)
          } else {
            return ERROR_UNEXPECTED_SUBTYPE(ctx, expectedT, actualT)
          }
        }
        val unexpected = actualTags.filterNot(expectedTags.contains(_))
        if (unexpected.nonEmpty) {
          return ERROR_UNEXPECTED_VARIANT_LABEL(unexpected.head.name, expectedT, ctx)
        }
      case _ =>
    }
    if (!subtypingEnabled) {
      ERROR_UNEXPECTED_TYPE_FOR_EXPRESSION(ctx, expectedT, actualT)
    } else {
      ERROR_UNEXPECTED_SUBTYPE(ctx, expectedT, actualT)
    }
  }

  override def defaultResult(): Either[Error, Type] = Right(Unknown())

  private def check(ctx: ParserRuleContext): Either[Error, Type] = {
    (ctx.accept(this), expectedT) match {
      case (Right(t), None) => Right(t)
      case (Right(t), Some(expectedT)) if t.isSubtypeOf(expectedT) => Right(t)
      case (Right(t), Some(expectedT)) => Left(unexpectedType(ctx, expectedT, t))
      case (err@Left(_), _) => err
    }
  }

  private def checkIgnoreType(ctx: ParserRuleContext): Either[Error, Type] = {
    ctx.accept(this) match {
      case Right(t) => Right(t)
      case err@Left(_) => err
    }
  }
}

private case class TypeContextVisitor() extends stellaParserBaseVisitor[Type] {
  override def visitTypeFun(ctx: TypeFunContext): Type = Fun(ctx.paramTypes.get(0).accept(this), ctx.returnType.accept(this))
  override def visitTypeParens(ctx: TypeParensContext): Type = ctx.type_.accept(this)
  override def visitTypeTuple(ctx: TypeTupleContext): Type = {
    val types = ctx.types.iterator().asScala.map[Type](_.accept(this))
    Tuple(types.toSeq)
  }
  override def visitTypeRecord(ctx: TypeRecordContext): Type = {
    val fields = ctx.fieldTypes.iterator().asScala.map[RecordField](it => RecordField(it.label.getText, it.type_.accept(this)))
    Record(fields.toSeq)
  }
  override def visitTypeUnit(ctx: TypeUnitContext): Type = UnitT()
  override def visitTypeBool(ctx: TypeBoolContext): Type = Bool()
  override def visitTypeNat(ctx: TypeNatContext): Type = Nat()
  override def visitTypeSum(ctx: TypeSumContext): Type = Sum(ctx.left.accept(this), ctx.right.accept(this))
  override def visitTypeList(ctx: TypeListContext): Type = ListT(ctx.type_.accept(this))
  override def visitTypeVariant(ctx: TypeVariantContext): Type = {
    val tags = ctx.fieldTypes.iterator().asScala.map[VariantTag](it => VariantTag(it.label.getText, it.type_.accept(this)))
    Variant(tags.toSeq)
  }
  override def visitTypeRef(ctx: TypeRefContext): Type = Ref(ctx.type_.accept(this))
  override def visitTypeTop(ctx: TypeTopContext): Type = Top()
  override def visitTypeBottom(ctx: TypeBottomContext): Type = Bot()

  override def defaultResult(): Type = Unknown()
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

  override def visitPatternVariant(ctx: PatternVariantContext): Either[Error, immutable.Map[String, Type]] = {
    t match {
      case v@Variant(_) =>
        v.tag(ctx.label.getText) match {
          case Some(t) =>
            ctx.pattern().accept(copy(t)) match {
              case ok@Right(_) => ok
              case err@Left(_) => err
            }
          case None => Left(ERROR_UNEXPECTED_PATTERN_FOR_TYPE(t, ctx))
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
