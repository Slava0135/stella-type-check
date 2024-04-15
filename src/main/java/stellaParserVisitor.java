// Generated from stellaParser.g4 by ANTLR 4.13.1
package io.github.slava0135.stella;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link stellaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface stellaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link stellaParser#start_Program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_Program(stellaParser.Start_ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link stellaParser#start_Expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_Expr(stellaParser.Start_ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link stellaParser#start_Type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_Type(stellaParser.Start_TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link stellaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(stellaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LanguageCore}
	 * labeled alternative in {@link stellaParser#languageDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguageCore(stellaParser.LanguageCoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnExtension}
	 * labeled alternative in {@link stellaParser#extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnExtension(stellaParser.AnExtensionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclFun}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclFun(stellaParser.DeclFunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclFunGeneric}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclFunGeneric(stellaParser.DeclFunGenericContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclTypeAlias}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclTypeAlias(stellaParser.DeclTypeAliasContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclExceptionType}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclExceptionType(stellaParser.DeclExceptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclExceptionVariant}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclExceptionVariant(stellaParser.DeclExceptionVariantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InlineAnnotation}
	 * labeled alternative in {@link stellaParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineAnnotation(stellaParser.InlineAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link stellaParser#paramDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamDecl(stellaParser.ParamDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Fold}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFold(stellaParser.FoldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(stellaParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsZero}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsZero(stellaParser.IsZeroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(stellaParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeAbstraction}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAbstraction(stellaParser.TypeAbstractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(stellaParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(stellaParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DotRecord}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotRecord(stellaParser.DotRecordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThan(stellaParser.GreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(stellaParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Throw}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrow(stellaParser.ThrowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(stellaParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstMemory}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstMemory(stellaParser.ConstMemoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code List}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(stellaParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TryCatch}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryCatch(stellaParser.TryCatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TryCastAs}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryCastAs(stellaParser.TryCastAsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Head}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHead(stellaParser.HeadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TerminatingSemicolon}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminatingSemicolon(stellaParser.TerminatingSemicolonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqual(stellaParser.NotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstUnit}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstUnit(stellaParser.ConstUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(stellaParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstFalse(stellaParser.ConstFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Abstraction}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstraction(stellaParser.AbstractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstInt}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInt(stellaParser.ConstIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variant}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariant(stellaParser.VariantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstTrue(stellaParser.ConstTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtract}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtract(stellaParser.SubtractContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeCast}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCast(stellaParser.TypeCastContext ctx);
	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(stellaParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Application}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplication(stellaParser.ApplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Deref}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeref(stellaParser.DerefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsEmpty}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsEmpty(stellaParser.IsEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Panic}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPanic(stellaParser.PanicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThanOrEqual}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanOrEqual(stellaParser.LessThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Succ}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSucc(stellaParser.SuccContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Inl}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInl(stellaParser.InlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThanOrEqual}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanOrEqual(stellaParser.GreaterThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Inr}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInr(stellaParser.InrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Match}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch(stellaParser.MatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicNot}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicNot(stellaParser.LogicNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisedExpr}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisedExpr(stellaParser.ParenthesisedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Tail}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTail(stellaParser.TailContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Record}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecord(stellaParser.RecordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicAnd}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicAnd(stellaParser.LogicAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeApplication}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeApplication(stellaParser.TypeApplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetRec}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetRec(stellaParser.LetRecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicOr}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOr(stellaParser.LogicOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TryWith}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryWith(stellaParser.TryWithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Pred}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred(stellaParser.PredContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeAsc}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAsc(stellaParser.TypeAscContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NatRec}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNatRec(stellaParser.NatRecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Unfold}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnfold(stellaParser.UnfoldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ref}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRef(stellaParser.RefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DotTuple}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotTuple(stellaParser.DotTupleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Fix}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFix(stellaParser.FixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Let}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(stellaParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(stellaParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Tuple}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(stellaParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConsList}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsList(stellaParser.ConsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link stellaParser#patternBinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternBinding(stellaParser.PatternBindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link stellaParser#binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinding(stellaParser.BindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link stellaParser#matchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchCase(stellaParser.MatchCaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternCons}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternCons(stellaParser.PatternConsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternTuple}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternTuple(stellaParser.PatternTupleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternList}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternList(stellaParser.PatternListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternRecord}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternRecord(stellaParser.PatternRecordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternVariant}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternVariant(stellaParser.PatternVariantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternAsc}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternAsc(stellaParser.PatternAscContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternInt}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternInt(stellaParser.PatternIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternInr}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternInr(stellaParser.PatternInrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternTrue}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternTrue(stellaParser.PatternTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternInl}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternInl(stellaParser.PatternInlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternVar}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternVar(stellaParser.PatternVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisedPattern}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisedPattern(stellaParser.ParenthesisedPatternContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternSucc}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternSucc(stellaParser.PatternSuccContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternFalse}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternFalse(stellaParser.PatternFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternUnit}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternUnit(stellaParser.PatternUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PatternCastAs}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternCastAs(stellaParser.PatternCastAsContext ctx);
	/**
	 * Visit a parse tree produced by {@link stellaParser#labelledPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelledPattern(stellaParser.LabelledPatternContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeTuple}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeTuple(stellaParser.TypeTupleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeTop}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeTop(stellaParser.TypeTopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBool}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBool(stellaParser.TypeBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeRef}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRef(stellaParser.TypeRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeRec}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRec(stellaParser.TypeRecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeAuto}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAuto(stellaParser.TypeAutoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeSum}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSum(stellaParser.TypeSumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeVar}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVar(stellaParser.TypeVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeVariant}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariant(stellaParser.TypeVariantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeUnit}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeUnit(stellaParser.TypeUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeNat}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNat(stellaParser.TypeNatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBottom}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBottom(stellaParser.TypeBottomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeParens}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParens(stellaParser.TypeParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeFun}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeFun(stellaParser.TypeFunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeForAll}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeForAll(stellaParser.TypeForAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeRecord}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRecord(stellaParser.TypeRecordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeList}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(stellaParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link stellaParser#recordFieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordFieldType(stellaParser.RecordFieldTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link stellaParser#variantFieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariantFieldType(stellaParser.VariantFieldTypeContext ctx);
}