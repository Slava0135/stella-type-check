// Generated from stellaParser.g4 by ANTLR 4.13.1
package io.github.slava0135.stella;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link stellaParser}.
 */
public interface stellaParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link stellaParser#start_Program}.
	 * @param ctx the parse tree
	 */
	void enterStart_Program(stellaParser.Start_ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link stellaParser#start_Program}.
	 * @param ctx the parse tree
	 */
	void exitStart_Program(stellaParser.Start_ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link stellaParser#start_Expr}.
	 * @param ctx the parse tree
	 */
	void enterStart_Expr(stellaParser.Start_ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link stellaParser#start_Expr}.
	 * @param ctx the parse tree
	 */
	void exitStart_Expr(stellaParser.Start_ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link stellaParser#start_Type}.
	 * @param ctx the parse tree
	 */
	void enterStart_Type(stellaParser.Start_TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link stellaParser#start_Type}.
	 * @param ctx the parse tree
	 */
	void exitStart_Type(stellaParser.Start_TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link stellaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(stellaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link stellaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(stellaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LanguageCore}
	 * labeled alternative in {@link stellaParser#languageDecl}.
	 * @param ctx the parse tree
	 */
	void enterLanguageCore(stellaParser.LanguageCoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LanguageCore}
	 * labeled alternative in {@link stellaParser#languageDecl}.
	 * @param ctx the parse tree
	 */
	void exitLanguageCore(stellaParser.LanguageCoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnExtension}
	 * labeled alternative in {@link stellaParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterAnExtension(stellaParser.AnExtensionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnExtension}
	 * labeled alternative in {@link stellaParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitAnExtension(stellaParser.AnExtensionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclFun}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclFun(stellaParser.DeclFunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclFun}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclFun(stellaParser.DeclFunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclFunGeneric}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclFunGeneric(stellaParser.DeclFunGenericContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclFunGeneric}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclFunGeneric(stellaParser.DeclFunGenericContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclTypeAlias}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclTypeAlias(stellaParser.DeclTypeAliasContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclTypeAlias}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclTypeAlias(stellaParser.DeclTypeAliasContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclExceptionType}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclExceptionType(stellaParser.DeclExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclExceptionType}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclExceptionType(stellaParser.DeclExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclExceptionVariant}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclExceptionVariant(stellaParser.DeclExceptionVariantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclExceptionVariant}
	 * labeled alternative in {@link stellaParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclExceptionVariant(stellaParser.DeclExceptionVariantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InlineAnnotation}
	 * labeled alternative in {@link stellaParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterInlineAnnotation(stellaParser.InlineAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InlineAnnotation}
	 * labeled alternative in {@link stellaParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitInlineAnnotation(stellaParser.InlineAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link stellaParser#paramDecl}.
	 * @param ctx the parse tree
	 */
	void enterParamDecl(stellaParser.ParamDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link stellaParser#paramDecl}.
	 * @param ctx the parse tree
	 */
	void exitParamDecl(stellaParser.ParamDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Fold}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFold(stellaParser.FoldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Fold}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFold(stellaParser.FoldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd(stellaParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd(stellaParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsZero}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIsZero(stellaParser.IsZeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsZero}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIsZero(stellaParser.IsZeroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(stellaParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(stellaParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeAbstraction}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTypeAbstraction(stellaParser.TypeAbstractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeAbstraction}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTypeAbstraction(stellaParser.TypeAbstractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivide(stellaParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivide(stellaParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(stellaParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(stellaParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DotRecord}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDotRecord(stellaParser.DotRecordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DotRecord}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDotRecord(stellaParser.DotRecordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThan(stellaParser.GreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThan(stellaParser.GreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqual(stellaParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqual(stellaParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Throw}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterThrow(stellaParser.ThrowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Throw}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitThrow(stellaParser.ThrowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(stellaParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(stellaParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstMemory}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstMemory(stellaParser.ConstMemoryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstMemory}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstMemory(stellaParser.ConstMemoryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code List}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterList(stellaParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code List}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitList(stellaParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TryCatch}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTryCatch(stellaParser.TryCatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TryCatch}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTryCatch(stellaParser.TryCatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Head}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterHead(stellaParser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Head}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitHead(stellaParser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TerminatingSemicolon}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTerminatingSemicolon(stellaParser.TerminatingSemicolonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TerminatingSemicolon}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTerminatingSemicolon(stellaParser.TerminatingSemicolonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotEqual(stellaParser.NotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotEqual(stellaParser.NotEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstUnit}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstUnit(stellaParser.ConstUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstUnit}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstUnit(stellaParser.ConstUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSequence(stellaParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSequence(stellaParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstFalse(stellaParser.ConstFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstFalse(stellaParser.ConstFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Abstraction}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAbstraction(stellaParser.AbstractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Abstraction}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAbstraction(stellaParser.AbstractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstInt}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstInt(stellaParser.ConstIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstInt}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstInt(stellaParser.ConstIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variant}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariant(stellaParser.VariantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variant}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariant(stellaParser.VariantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstTrue(stellaParser.ConstTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstTrue(stellaParser.ConstTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtract}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubtract(stellaParser.SubtractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtract}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubtract(stellaParser.SubtractContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeCast}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTypeCast(stellaParser.TypeCastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeCast}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTypeCast(stellaParser.TypeCastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code If}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIf(stellaParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code If}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIf(stellaParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Application}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterApplication(stellaParser.ApplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Application}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitApplication(stellaParser.ApplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Deref}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDeref(stellaParser.DerefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Deref}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDeref(stellaParser.DerefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsEmpty}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIsEmpty(stellaParser.IsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsEmpty}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIsEmpty(stellaParser.IsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Panic}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPanic(stellaParser.PanicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Panic}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPanic(stellaParser.PanicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThanOrEqual}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLessThanOrEqual(stellaParser.LessThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThanOrEqual}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLessThanOrEqual(stellaParser.LessThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Succ}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSucc(stellaParser.SuccContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Succ}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSucc(stellaParser.SuccContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Inl}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInl(stellaParser.InlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Inl}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInl(stellaParser.InlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThanOrEqual}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanOrEqual(stellaParser.GreaterThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThanOrEqual}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanOrEqual(stellaParser.GreaterThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Inr}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInr(stellaParser.InrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Inr}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInr(stellaParser.InrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Match}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMatch(stellaParser.MatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Match}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMatch(stellaParser.MatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicNot}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicNot(stellaParser.LogicNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicNot}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicNot(stellaParser.LogicNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisedExpr}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisedExpr(stellaParser.ParenthesisedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisedExpr}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisedExpr(stellaParser.ParenthesisedExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Tail}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTail(stellaParser.TailContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Tail}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTail(stellaParser.TailContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Record}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRecord(stellaParser.RecordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Record}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRecord(stellaParser.RecordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicAnd}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicAnd(stellaParser.LogicAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicAnd}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicAnd(stellaParser.LogicAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeApplication}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTypeApplication(stellaParser.TypeApplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeApplication}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTypeApplication(stellaParser.TypeApplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetRec}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLetRec(stellaParser.LetRecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetRec}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLetRec(stellaParser.LetRecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicOr}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicOr(stellaParser.LogicOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicOr}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicOr(stellaParser.LogicOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TryWith}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTryWith(stellaParser.TryWithContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TryWith}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTryWith(stellaParser.TryWithContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pred}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPred(stellaParser.PredContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pred}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPred(stellaParser.PredContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeAsc}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTypeAsc(stellaParser.TypeAscContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeAsc}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTypeAsc(stellaParser.TypeAscContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NatRec}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNatRec(stellaParser.NatRecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NatRec}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNatRec(stellaParser.NatRecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unfold}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnfold(stellaParser.UnfoldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unfold}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnfold(stellaParser.UnfoldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ref}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRef(stellaParser.RefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ref}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRef(stellaParser.RefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DotTuple}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDotTuple(stellaParser.DotTupleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DotTuple}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDotTuple(stellaParser.DotTupleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Fix}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFix(stellaParser.FixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Fix}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFix(stellaParser.FixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Let}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLet(stellaParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Let}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLet(stellaParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign(stellaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign(stellaParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Tuple}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTuple(stellaParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Tuple}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTuple(stellaParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConsList}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConsList(stellaParser.ConsListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConsList}
	 * labeled alternative in {@link stellaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConsList(stellaParser.ConsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link stellaParser#patternBinding}.
	 * @param ctx the parse tree
	 */
	void enterPatternBinding(stellaParser.PatternBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link stellaParser#patternBinding}.
	 * @param ctx the parse tree
	 */
	void exitPatternBinding(stellaParser.PatternBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link stellaParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterBinding(stellaParser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link stellaParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitBinding(stellaParser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link stellaParser#matchCase}.
	 * @param ctx the parse tree
	 */
	void enterMatchCase(stellaParser.MatchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link stellaParser#matchCase}.
	 * @param ctx the parse tree
	 */
	void exitMatchCase(stellaParser.MatchCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternVariant}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternVariant(stellaParser.PatternVariantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternVariant}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternVariant(stellaParser.PatternVariantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternInl}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternInl(stellaParser.PatternInlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternInl}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternInl(stellaParser.PatternInlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternInr}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternInr(stellaParser.PatternInrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternInr}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternInr(stellaParser.PatternInrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternTuple}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternTuple(stellaParser.PatternTupleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternTuple}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternTuple(stellaParser.PatternTupleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternRecord}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternRecord(stellaParser.PatternRecordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternRecord}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternRecord(stellaParser.PatternRecordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternList}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternList(stellaParser.PatternListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternList}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternList(stellaParser.PatternListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternCons}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternCons(stellaParser.PatternConsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternCons}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternCons(stellaParser.PatternConsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternFalse}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternFalse(stellaParser.PatternFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternFalse}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternFalse(stellaParser.PatternFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternTrue}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternTrue(stellaParser.PatternTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternTrue}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternTrue(stellaParser.PatternTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternUnit}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternUnit(stellaParser.PatternUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternUnit}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternUnit(stellaParser.PatternUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternInt}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternInt(stellaParser.PatternIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternInt}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternInt(stellaParser.PatternIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternSucc}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternSucc(stellaParser.PatternSuccContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternSucc}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternSucc(stellaParser.PatternSuccContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PatternVar}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPatternVar(stellaParser.PatternVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PatternVar}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPatternVar(stellaParser.PatternVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisedPattern}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisedPattern(stellaParser.ParenthesisedPatternContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisedPattern}
	 * labeled alternative in {@link stellaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisedPattern(stellaParser.ParenthesisedPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link stellaParser#labelledPattern}.
	 * @param ctx the parse tree
	 */
	void enterLabelledPattern(stellaParser.LabelledPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link stellaParser#labelledPattern}.
	 * @param ctx the parse tree
	 */
	void exitLabelledPattern(stellaParser.LabelledPatternContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeTuple}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeTuple(stellaParser.TypeTupleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeTuple}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeTuple(stellaParser.TypeTupleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeTop}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeTop(stellaParser.TypeTopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeTop}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeTop(stellaParser.TypeTopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeBool}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeBool(stellaParser.TypeBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeBool}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeBool(stellaParser.TypeBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeRef}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeRef(stellaParser.TypeRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeRef}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeRef(stellaParser.TypeRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeRec}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeRec(stellaParser.TypeRecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeRec}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeRec(stellaParser.TypeRecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeSum}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeSum(stellaParser.TypeSumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeSum}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeSum(stellaParser.TypeSumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeVar}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeVar(stellaParser.TypeVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeVar}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeVar(stellaParser.TypeVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeVariant}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariant(stellaParser.TypeVariantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeVariant}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariant(stellaParser.TypeVariantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeUnit}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeUnit(stellaParser.TypeUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeUnit}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeUnit(stellaParser.TypeUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeNat}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeNat(stellaParser.TypeNatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeNat}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeNat(stellaParser.TypeNatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeBottom}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeBottom(stellaParser.TypeBottomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeBottom}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeBottom(stellaParser.TypeBottomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeParens}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeParens(stellaParser.TypeParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeParens}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeParens(stellaParser.TypeParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeFun}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeFun(stellaParser.TypeFunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeFun}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeFun(stellaParser.TypeFunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeForAll}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeForAll(stellaParser.TypeForAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeForAll}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeForAll(stellaParser.TypeForAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeRecord}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeRecord(stellaParser.TypeRecordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeRecord}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeRecord(stellaParser.TypeRecordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeList}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(stellaParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeList}
	 * labeled alternative in {@link stellaParser#stellatype}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(stellaParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link stellaParser#recordFieldType}.
	 * @param ctx the parse tree
	 */
	void enterRecordFieldType(stellaParser.RecordFieldTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link stellaParser#recordFieldType}.
	 * @param ctx the parse tree
	 */
	void exitRecordFieldType(stellaParser.RecordFieldTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link stellaParser#variantFieldType}.
	 * @param ctx the parse tree
	 */
	void enterVariantFieldType(stellaParser.VariantFieldTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link stellaParser#variantFieldType}.
	 * @param ctx the parse tree
	 */
	void exitVariantFieldType(stellaParser.VariantFieldTypeContext ctx);
}