// Generated from stellaParser.g4 by ANTLR 4.13.1
package io.github.slava0135.stella;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class stellaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Surrogate_id_SYMB_0=1, Surrogate_id_SYMB_1=2, Surrogate_id_SYMB_2=3, Surrogate_id_SYMB_3=4, 
		Surrogate_id_SYMB_4=5, Surrogate_id_SYMB_5=6, Surrogate_id_SYMB_6=7, Surrogate_id_SYMB_7=8, 
		Surrogate_id_SYMB_8=9, Surrogate_id_SYMB_9=10, Surrogate_id_SYMB_10=11, 
		Surrogate_id_SYMB_11=12, Surrogate_id_SYMB_12=13, Surrogate_id_SYMB_13=14, 
		Surrogate_id_SYMB_14=15, Surrogate_id_SYMB_15=16, Surrogate_id_SYMB_16=17, 
		Surrogate_id_SYMB_17=18, Surrogate_id_SYMB_18=19, Surrogate_id_SYMB_19=20, 
		Surrogate_id_SYMB_20=21, Surrogate_id_SYMB_21=22, Surrogate_id_SYMB_22=23, 
		Surrogate_id_SYMB_23=24, Surrogate_id_SYMB_24=25, Surrogate_id_SYMB_25=26, 
		Surrogate_id_SYMB_26=27, Surrogate_id_SYMB_27=28, Surrogate_id_SYMB_28=29, 
		Surrogate_id_SYMB_29=30, Surrogate_id_SYMB_30=31, Surrogate_id_SYMB_31=32, 
		Surrogate_id_SYMB_32=33, Surrogate_id_SYMB_33=34, Surrogate_id_SYMB_34=35, 
		Surrogate_id_SYMB_35=36, Surrogate_id_SYMB_36=37, Surrogate_id_SYMB_37=38, 
		Surrogate_id_SYMB_38=39, Surrogate_id_SYMB_39=40, Surrogate_id_SYMB_40=41, 
		Surrogate_id_SYMB_41=42, Surrogate_id_SYMB_42=43, Surrogate_id_SYMB_43=44, 
		Surrogate_id_SYMB_44=45, Surrogate_id_SYMB_45=46, Surrogate_id_SYMB_46=47, 
		Surrogate_id_SYMB_47=48, Surrogate_id_SYMB_48=49, Surrogate_id_SYMB_49=50, 
		Surrogate_id_SYMB_50=51, Surrogate_id_SYMB_51=52, Surrogate_id_SYMB_52=53, 
		Surrogate_id_SYMB_53=54, Surrogate_id_SYMB_54=55, Surrogate_id_SYMB_55=56, 
		Surrogate_id_SYMB_56=57, Surrogate_id_SYMB_57=58, Surrogate_id_SYMB_58=59, 
		Surrogate_id_SYMB_59=60, Surrogate_id_SYMB_60=61, Surrogate_id_SYMB_61=62, 
		Surrogate_id_SYMB_62=63, Surrogate_id_SYMB_63=64, Surrogate_id_SYMB_64=65, 
		Surrogate_id_SYMB_65=66, EXCEPTION=67, VARIANT=68, CAST=69, ASSIGN=70, 
		REF_TYPE=71, REFERENCE=72, PANIC=73, THROW=74, TRY=75, CATCH=76, TOP_TYPE=77, 
		BOTTOM_TYPE=78, AUTO_TYPE=79, GENERIC=80, FORALL=81, COMMENT_antlr_builtin=82, 
		MULTICOMMENT_antlr_builtin=83, StellaIdent=84, ExtensionName=85, MemoryAddress=86, 
		INTEGER=87, WS=88, ErrorToken=89;
	public static final int
		RULE_start_Program = 0, RULE_start_Expr = 1, RULE_start_Type = 2, RULE_program = 3, 
		RULE_languageDecl = 4, RULE_extension = 5, RULE_decl = 6, RULE_annotation = 7, 
		RULE_paramDecl = 8, RULE_expr = 9, RULE_patternBinding = 10, RULE_binding = 11, 
		RULE_matchCase = 12, RULE_pattern = 13, RULE_labelledPattern = 14, RULE_stellatype = 15, 
		RULE_recordFieldType = 16, RULE_variantFieldType = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"start_Program", "start_Expr", "start_Type", "program", "languageDecl", 
			"extension", "decl", "annotation", "paramDecl", "expr", "patternBinding", 
			"binding", "matchCase", "pattern", "labelledPattern", "stellatype", "recordFieldType", 
			"variantFieldType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "';'", "'('", "')'", "'{'", "'}'", "'='", "':'", "'->'", 
			"'=>'", "'|'", "'<|'", "'|>'", "'['", "']'", "'<'", "'<='", "'>'", "'>='", 
			"'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'.'", "'List::head'", "'List::isempty'", 
			"'List::tail'", "'Nat::pred'", "'Nat::iszero'", "'Nat::rec'", "'Bool'", 
			"'Nat'", "'Unit'", "'and'", "'as'", "'cons'", "'core'", "'else'", "'extend'", 
			"'false'", "'fix'", "'fn'", "'fold'", "'if'", "'in'", "'inl'", "'inline'", 
			"'inr'", "'language'", "'let'", "'letrec'", "'match'", "'not'", "'or'", 
			"'return'", "'succ'", "'then'", "'throws'", "'true'", "'type'", "'unfold'", 
			"'unit'", "'with'", "'\\u00B5'", "'exception'", "'variant'", "'cast'", 
			"':='", "'&'", "'new'", "'panic!'", "'throw'", "'try'", "'catch'", "'Top'", 
			"'Bot'", "'auto'", "'generic'", "'forall'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
			"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", 
			"Surrogate_id_SYMB_6", "Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", 
			"Surrogate_id_SYMB_9", "Surrogate_id_SYMB_10", "Surrogate_id_SYMB_11", 
			"Surrogate_id_SYMB_12", "Surrogate_id_SYMB_13", "Surrogate_id_SYMB_14", 
			"Surrogate_id_SYMB_15", "Surrogate_id_SYMB_16", "Surrogate_id_SYMB_17", 
			"Surrogate_id_SYMB_18", "Surrogate_id_SYMB_19", "Surrogate_id_SYMB_20", 
			"Surrogate_id_SYMB_21", "Surrogate_id_SYMB_22", "Surrogate_id_SYMB_23", 
			"Surrogate_id_SYMB_24", "Surrogate_id_SYMB_25", "Surrogate_id_SYMB_26", 
			"Surrogate_id_SYMB_27", "Surrogate_id_SYMB_28", "Surrogate_id_SYMB_29", 
			"Surrogate_id_SYMB_30", "Surrogate_id_SYMB_31", "Surrogate_id_SYMB_32", 
			"Surrogate_id_SYMB_33", "Surrogate_id_SYMB_34", "Surrogate_id_SYMB_35", 
			"Surrogate_id_SYMB_36", "Surrogate_id_SYMB_37", "Surrogate_id_SYMB_38", 
			"Surrogate_id_SYMB_39", "Surrogate_id_SYMB_40", "Surrogate_id_SYMB_41", 
			"Surrogate_id_SYMB_42", "Surrogate_id_SYMB_43", "Surrogate_id_SYMB_44", 
			"Surrogate_id_SYMB_45", "Surrogate_id_SYMB_46", "Surrogate_id_SYMB_47", 
			"Surrogate_id_SYMB_48", "Surrogate_id_SYMB_49", "Surrogate_id_SYMB_50", 
			"Surrogate_id_SYMB_51", "Surrogate_id_SYMB_52", "Surrogate_id_SYMB_53", 
			"Surrogate_id_SYMB_54", "Surrogate_id_SYMB_55", "Surrogate_id_SYMB_56", 
			"Surrogate_id_SYMB_57", "Surrogate_id_SYMB_58", "Surrogate_id_SYMB_59", 
			"Surrogate_id_SYMB_60", "Surrogate_id_SYMB_61", "Surrogate_id_SYMB_62", 
			"Surrogate_id_SYMB_63", "Surrogate_id_SYMB_64", "Surrogate_id_SYMB_65", 
			"EXCEPTION", "VARIANT", "CAST", "ASSIGN", "REF_TYPE", "REFERENCE", "PANIC", 
			"THROW", "TRY", "CATCH", "TOP_TYPE", "BOTTOM_TYPE", "AUTO_TYPE", "GENERIC", 
			"FORALL", "COMMENT_antlr_builtin", "MULTICOMMENT_antlr_builtin", "StellaIdent", 
			"ExtensionName", "MemoryAddress", "INTEGER", "WS", "ErrorToken"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "stellaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public stellaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Start_ProgramContext extends ParserRuleContext {
		public ProgramContext x;
		public TerminalNode EOF() { return getToken(stellaParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public Start_ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_Program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterStart_Program(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitStart_Program(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitStart_Program(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_ProgramContext start_Program() throws RecognitionException {
		Start_ProgramContext _localctx = new Start_ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start_Program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			((Start_ProgramContext)_localctx).x = program();
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Start_ExprContext extends ParserRuleContext {
		public ExprContext x;
		public TerminalNode EOF() { return getToken(stellaParser.EOF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Start_ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_Expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterStart_Expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitStart_Expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitStart_Expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_ExprContext start_Expr() throws RecognitionException {
		Start_ExprContext _localctx = new Start_ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_start_Expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			((Start_ExprContext)_localctx).x = expr(0);
			setState(40);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Start_TypeContext extends ParserRuleContext {
		public StellatypeContext x;
		public TerminalNode EOF() { return getToken(stellaParser.EOF, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public Start_TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_Type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterStart_Type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitStart_Type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitStart_Type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_TypeContext start_Type() throws RecognitionException {
		Start_TypeContext _localctx = new Start_TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_start_Type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			((Start_TypeContext)_localctx).x = stellatype(0);
			setState(43);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ExtensionContext extension;
		public List<ExtensionContext> extensions = new ArrayList<ExtensionContext>();
		public DeclContext decl;
		public List<DeclContext> decls = new ArrayList<DeclContext>();
		public LanguageDeclContext languageDecl() {
			return getRuleContext(LanguageDeclContext.class,0);
		}
		public List<ExtensionContext> extension() {
			return getRuleContexts(ExtensionContext.class);
		}
		public ExtensionContext extension(int i) {
			return getRuleContext(ExtensionContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			languageDecl();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Surrogate_id_SYMB_40) {
				{
				{
				setState(46);
				((ProgramContext)_localctx).extension = extension();
				((ProgramContext)_localctx).extensions.add(((ProgramContext)_localctx).extension);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & 68728127521L) != 0)) {
				{
				{
				setState(52);
				((ProgramContext)_localctx).decl = decl();
				((ProgramContext)_localctx).decls.add(((ProgramContext)_localctx).decl);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LanguageDeclContext extends ParserRuleContext {
		public LanguageDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_languageDecl; }
	 
		public LanguageDeclContext() { }
		public void copyFrom(LanguageDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LanguageCoreContext extends LanguageDeclContext {
		public TerminalNode Surrogate_id_SYMB_50() { return getToken(stellaParser.Surrogate_id_SYMB_50, 0); }
		public TerminalNode Surrogate_id_SYMB_38() { return getToken(stellaParser.Surrogate_id_SYMB_38, 0); }
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(stellaParser.Surrogate_id_SYMB_1, 0); }
		public LanguageCoreContext(LanguageDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterLanguageCore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitLanguageCore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitLanguageCore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LanguageDeclContext languageDecl() throws RecognitionException {
		LanguageDeclContext _localctx = new LanguageDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_languageDecl);
		try {
			_localctx = new LanguageCoreContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(Surrogate_id_SYMB_50);
			setState(59);
			match(Surrogate_id_SYMB_38);
			setState(60);
			match(Surrogate_id_SYMB_1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExtensionContext extends ParserRuleContext {
		public ExtensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extension; }
	 
		public ExtensionContext() { }
		public void copyFrom(ExtensionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnExtensionContext extends ExtensionContext {
		public Token ExtensionName;
		public List<Token> extensionNames = new ArrayList<Token>();
		public TerminalNode Surrogate_id_SYMB_40() { return getToken(stellaParser.Surrogate_id_SYMB_40, 0); }
		public TerminalNode Surrogate_id_SYMB_64() { return getToken(stellaParser.Surrogate_id_SYMB_64, 0); }
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(stellaParser.Surrogate_id_SYMB_1, 0); }
		public List<TerminalNode> ExtensionName() { return getTokens(stellaParser.ExtensionName); }
		public TerminalNode ExtensionName(int i) {
			return getToken(stellaParser.ExtensionName, i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public AnExtensionContext(ExtensionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterAnExtension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitAnExtension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitAnExtension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtensionContext extension() throws RecognitionException {
		ExtensionContext _localctx = new ExtensionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_extension);
		int _la;
		try {
			_localctx = new AnExtensionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(Surrogate_id_SYMB_40);
			setState(63);
			match(Surrogate_id_SYMB_64);
			setState(64);
			((AnExtensionContext)_localctx).ExtensionName = match(ExtensionName);
			((AnExtensionContext)_localctx).extensionNames.add(((AnExtensionContext)_localctx).ExtensionName);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Surrogate_id_SYMB_0) {
				{
				{
				setState(65);
				match(Surrogate_id_SYMB_0);
				setState(66);
				((AnExtensionContext)_localctx).ExtensionName = match(ExtensionName);
				((AnExtensionContext)_localctx).extensionNames.add(((AnExtensionContext)_localctx).ExtensionName);
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(Surrogate_id_SYMB_1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	 
		public DeclContext() { }
		public void copyFrom(DeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclTypeAliasContext extends DeclContext {
		public Token name;
		public StellatypeContext atype;
		public TerminalNode Surrogate_id_SYMB_61() { return getToken(stellaParser.Surrogate_id_SYMB_61, 0); }
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(stellaParser.Surrogate_id_SYMB_6, 0); }
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public DeclTypeAliasContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterDeclTypeAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitDeclTypeAlias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitDeclTypeAlias(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclExceptionTypeContext extends DeclContext {
		public StellatypeContext exceptionType;
		public TerminalNode EXCEPTION() { return getToken(stellaParser.EXCEPTION, 0); }
		public TerminalNode Surrogate_id_SYMB_61() { return getToken(stellaParser.Surrogate_id_SYMB_61, 0); }
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(stellaParser.Surrogate_id_SYMB_6, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public DeclExceptionTypeContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterDeclExceptionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitDeclExceptionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitDeclExceptionType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclFunContext extends DeclContext {
		public AnnotationContext annotation;
		public List<AnnotationContext> annotations = new ArrayList<AnnotationContext>();
		public Token name;
		public ParamDeclContext paramDecl;
		public List<ParamDeclContext> paramDecls = new ArrayList<ParamDeclContext>();
		public StellatypeContext returnType;
		public StellatypeContext stellatype;
		public List<StellatypeContext> throwTypes = new ArrayList<StellatypeContext>();
		public DeclContext decl;
		public List<DeclContext> localDecls = new ArrayList<DeclContext>();
		public ExprContext returnExpr;
		public TerminalNode Surrogate_id_SYMB_43() { return getToken(stellaParser.Surrogate_id_SYMB_43, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(stellaParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode Surrogate_id_SYMB_56() { return getToken(stellaParser.Surrogate_id_SYMB_56, 0); }
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(stellaParser.Surrogate_id_SYMB_5, 0); }
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(stellaParser.Surrogate_id_SYMB_8, 0); }
		public TerminalNode Surrogate_id_SYMB_59() { return getToken(stellaParser.Surrogate_id_SYMB_59, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ParamDeclContext> paramDecl() {
			return getRuleContexts(ParamDeclContext.class);
		}
		public ParamDeclContext paramDecl(int i) {
			return getRuleContext(ParamDeclContext.class,i);
		}
		public List<StellatypeContext> stellatype() {
			return getRuleContexts(StellatypeContext.class);
		}
		public StellatypeContext stellatype(int i) {
			return getRuleContext(StellatypeContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public DeclFunContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterDeclFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitDeclFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitDeclFun(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclExceptionVariantContext extends DeclContext {
		public Token name;
		public StellatypeContext variantType;
		public TerminalNode EXCEPTION() { return getToken(stellaParser.EXCEPTION, 0); }
		public TerminalNode VARIANT() { return getToken(stellaParser.VARIANT, 0); }
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(stellaParser.Surrogate_id_SYMB_7, 0); }
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public DeclExceptionVariantContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterDeclExceptionVariant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitDeclExceptionVariant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitDeclExceptionVariant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclFunGenericContext extends DeclContext {
		public AnnotationContext annotation;
		public List<AnnotationContext> annotations = new ArrayList<AnnotationContext>();
		public Token name;
		public Token StellaIdent;
		public List<Token> generics = new ArrayList<Token>();
		public ParamDeclContext paramDecl;
		public List<ParamDeclContext> paramDecls = new ArrayList<ParamDeclContext>();
		public StellatypeContext returnType;
		public StellatypeContext stellatype;
		public List<StellatypeContext> throwTypes = new ArrayList<StellatypeContext>();
		public DeclContext decl;
		public List<DeclContext> localDecls = new ArrayList<DeclContext>();
		public ExprContext returnExpr;
		public TerminalNode GENERIC() { return getToken(stellaParser.GENERIC, 0); }
		public TerminalNode Surrogate_id_SYMB_43() { return getToken(stellaParser.Surrogate_id_SYMB_43, 0); }
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(stellaParser.Surrogate_id_SYMB_13, 0); }
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(stellaParser.Surrogate_id_SYMB_14, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(stellaParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode Surrogate_id_SYMB_56() { return getToken(stellaParser.Surrogate_id_SYMB_56, 0); }
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(stellaParser.Surrogate_id_SYMB_5, 0); }
		public List<TerminalNode> StellaIdent() { return getTokens(stellaParser.StellaIdent); }
		public TerminalNode StellaIdent(int i) {
			return getToken(stellaParser.StellaIdent, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(stellaParser.Surrogate_id_SYMB_8, 0); }
		public TerminalNode Surrogate_id_SYMB_59() { return getToken(stellaParser.Surrogate_id_SYMB_59, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ParamDeclContext> paramDecl() {
			return getRuleContexts(ParamDeclContext.class);
		}
		public ParamDeclContext paramDecl(int i) {
			return getRuleContext(ParamDeclContext.class,i);
		}
		public List<StellatypeContext> stellatype() {
			return getRuleContexts(StellatypeContext.class);
		}
		public StellatypeContext stellatype(int i) {
			return getRuleContext(StellatypeContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DeclFunGenericContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterDeclFunGeneric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitDeclFunGeneric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitDeclFunGeneric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_decl);
		int _la;
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new DeclFunContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Surrogate_id_SYMB_48) {
					{
					{
					setState(74);
					((DeclFunContext)_localctx).annotation = annotation();
					((DeclFunContext)_localctx).annotations.add(((DeclFunContext)_localctx).annotation);
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(80);
				match(Surrogate_id_SYMB_43);
				setState(81);
				((DeclFunContext)_localctx).name = match(StellaIdent);
				setState(82);
				match(Surrogate_id_SYMB_2);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==StellaIdent) {
					{
					setState(83);
					((DeclFunContext)_localctx).paramDecl = paramDecl();
					((DeclFunContext)_localctx).paramDecls.add(((DeclFunContext)_localctx).paramDecl);
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(84);
						match(Surrogate_id_SYMB_0);
						setState(85);
						((DeclFunContext)_localctx).paramDecl = paramDecl();
						((DeclFunContext)_localctx).paramDecls.add(((DeclFunContext)_localctx).paramDecl);
						}
						}
						setState(90);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(93);
				match(Surrogate_id_SYMB_3);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Surrogate_id_SYMB_8) {
					{
					setState(94);
					match(Surrogate_id_SYMB_8);
					setState(95);
					((DeclFunContext)_localctx).returnType = stellatype(0);
					}
				}

				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Surrogate_id_SYMB_59) {
					{
					setState(98);
					match(Surrogate_id_SYMB_59);
					setState(99);
					((DeclFunContext)_localctx).stellatype = stellatype(0);
					((DeclFunContext)_localctx).throwTypes.add(((DeclFunContext)_localctx).stellatype);
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(100);
						match(Surrogate_id_SYMB_0);
						setState(101);
						((DeclFunContext)_localctx).stellatype = stellatype(0);
						((DeclFunContext)_localctx).throwTypes.add(((DeclFunContext)_localctx).stellatype);
						}
						}
						setState(106);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(109);
				match(Surrogate_id_SYMB_4);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & 68728127521L) != 0)) {
					{
					{
					setState(110);
					((DeclFunContext)_localctx).decl = decl();
					((DeclFunContext)_localctx).localDecls.add(((DeclFunContext)_localctx).decl);
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(116);
				match(Surrogate_id_SYMB_56);
				setState(117);
				((DeclFunContext)_localctx).returnExpr = expr(0);
				setState(118);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 2:
				_localctx = new DeclFunGenericContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Surrogate_id_SYMB_48) {
					{
					{
					setState(120);
					((DeclFunGenericContext)_localctx).annotation = annotation();
					((DeclFunGenericContext)_localctx).annotations.add(((DeclFunGenericContext)_localctx).annotation);
					}
					}
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(126);
				match(GENERIC);
				setState(127);
				match(Surrogate_id_SYMB_43);
				setState(128);
				((DeclFunGenericContext)_localctx).name = match(StellaIdent);
				setState(129);
				match(Surrogate_id_SYMB_13);
				setState(130);
				((DeclFunGenericContext)_localctx).StellaIdent = match(StellaIdent);
				((DeclFunGenericContext)_localctx).generics.add(((DeclFunGenericContext)_localctx).StellaIdent);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Surrogate_id_SYMB_0) {
					{
					{
					setState(131);
					match(Surrogate_id_SYMB_0);
					setState(132);
					((DeclFunGenericContext)_localctx).StellaIdent = match(StellaIdent);
					((DeclFunGenericContext)_localctx).generics.add(((DeclFunGenericContext)_localctx).StellaIdent);
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(138);
				match(Surrogate_id_SYMB_14);
				setState(139);
				match(Surrogate_id_SYMB_2);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==StellaIdent) {
					{
					setState(140);
					((DeclFunGenericContext)_localctx).paramDecl = paramDecl();
					((DeclFunGenericContext)_localctx).paramDecls.add(((DeclFunGenericContext)_localctx).paramDecl);
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(141);
						match(Surrogate_id_SYMB_0);
						setState(142);
						((DeclFunGenericContext)_localctx).paramDecl = paramDecl();
						((DeclFunGenericContext)_localctx).paramDecls.add(((DeclFunGenericContext)_localctx).paramDecl);
						}
						}
						setState(147);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(150);
				match(Surrogate_id_SYMB_3);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Surrogate_id_SYMB_8) {
					{
					setState(151);
					match(Surrogate_id_SYMB_8);
					setState(152);
					((DeclFunGenericContext)_localctx).returnType = stellatype(0);
					}
				}

				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Surrogate_id_SYMB_59) {
					{
					setState(155);
					match(Surrogate_id_SYMB_59);
					setState(156);
					((DeclFunGenericContext)_localctx).stellatype = stellatype(0);
					((DeclFunGenericContext)_localctx).throwTypes.add(((DeclFunGenericContext)_localctx).stellatype);
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(157);
						match(Surrogate_id_SYMB_0);
						setState(158);
						((DeclFunGenericContext)_localctx).stellatype = stellatype(0);
						((DeclFunGenericContext)_localctx).throwTypes.add(((DeclFunGenericContext)_localctx).stellatype);
						}
						}
						setState(163);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(166);
				match(Surrogate_id_SYMB_4);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & 68728127521L) != 0)) {
					{
					{
					setState(167);
					((DeclFunGenericContext)_localctx).decl = decl();
					((DeclFunGenericContext)_localctx).localDecls.add(((DeclFunGenericContext)_localctx).decl);
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				match(Surrogate_id_SYMB_56);
				setState(174);
				((DeclFunGenericContext)_localctx).returnExpr = expr(0);
				setState(175);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 3:
				_localctx = new DeclTypeAliasContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				match(Surrogate_id_SYMB_61);
				setState(178);
				((DeclTypeAliasContext)_localctx).name = match(StellaIdent);
				setState(179);
				match(Surrogate_id_SYMB_6);
				setState(180);
				((DeclTypeAliasContext)_localctx).atype = stellatype(0);
				}
				break;
			case 4:
				_localctx = new DeclExceptionTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(181);
				match(EXCEPTION);
				setState(182);
				match(Surrogate_id_SYMB_61);
				setState(183);
				match(Surrogate_id_SYMB_6);
				setState(184);
				((DeclExceptionTypeContext)_localctx).exceptionType = stellatype(0);
				}
				break;
			case 5:
				_localctx = new DeclExceptionVariantContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(185);
				match(EXCEPTION);
				setState(186);
				match(VARIANT);
				setState(187);
				((DeclExceptionVariantContext)_localctx).name = match(StellaIdent);
				setState(188);
				match(Surrogate_id_SYMB_7);
				setState(189);
				((DeclExceptionVariantContext)_localctx).variantType = stellatype(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationContext extends ParserRuleContext {
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
	 
		public AnnotationContext() { }
		public void copyFrom(AnnotationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InlineAnnotationContext extends AnnotationContext {
		public TerminalNode Surrogate_id_SYMB_48() { return getToken(stellaParser.Surrogate_id_SYMB_48, 0); }
		public InlineAnnotationContext(AnnotationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterInlineAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitInlineAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitInlineAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_annotation);
		try {
			_localctx = new InlineAnnotationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(Surrogate_id_SYMB_48);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamDeclContext extends ParserRuleContext {
		public Token name;
		public StellatypeContext paramType;
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(stellaParser.Surrogate_id_SYMB_7, 0); }
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public ParamDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterParamDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitParamDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitParamDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamDeclContext paramDecl() throws RecognitionException {
		ParamDeclContext _localctx = new ParamDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_paramDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			((ParamDeclContext)_localctx).name = match(StellaIdent);
			setState(195);
			match(Surrogate_id_SYMB_7);
			setState(196);
			((ParamDeclContext)_localctx).paramType = stellatype(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FoldContext extends ExprContext {
		public StellatypeContext type_;
		public ExprContext expr_;
		public TerminalNode Surrogate_id_SYMB_44() { return getToken(stellaParser.Surrogate_id_SYMB_44, 0); }
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(stellaParser.Surrogate_id_SYMB_13, 0); }
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(stellaParser.Surrogate_id_SYMB_14, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FoldContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterFold(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitFold(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitFold(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_21() { return getToken(stellaParser.Surrogate_id_SYMB_21, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsZeroContext extends ExprContext {
		public ExprContext n;
		public TerminalNode Surrogate_id_SYMB_30() { return getToken(stellaParser.Surrogate_id_SYMB_30, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IsZeroContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterIsZero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitIsZero(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitIsZero(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ExprContext {
		public Token name;
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public VarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeAbstractionContext extends ExprContext {
		public Token StellaIdent;
		public List<Token> generics = new ArrayList<Token>();
		public ExprContext expr_;
		public TerminalNode GENERIC() { return getToken(stellaParser.GENERIC, 0); }
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(stellaParser.Surrogate_id_SYMB_13, 0); }
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(stellaParser.Surrogate_id_SYMB_14, 0); }
		public List<TerminalNode> StellaIdent() { return getTokens(stellaParser.StellaIdent); }
		public TerminalNode StellaIdent(int i) {
			return getToken(stellaParser.StellaIdent, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public TypeAbstractionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeAbstraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeAbstraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeAbstraction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivideContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_24() { return getToken(stellaParser.Surrogate_id_SYMB_24, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DivideContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessThanContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_15() { return getToken(stellaParser.Surrogate_id_SYMB_15, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LessThanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterLessThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitLessThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotRecordContext extends ExprContext {
		public ExprContext expr_;
		public Token label;
		public TerminalNode Surrogate_id_SYMB_25() { return getToken(stellaParser.Surrogate_id_SYMB_25, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public DotRecordContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterDotRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitDotRecord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitDotRecord(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterThanContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_17() { return getToken(stellaParser.Surrogate_id_SYMB_17, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GreaterThanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterGreaterThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitGreaterThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_19() { return getToken(stellaParser.Surrogate_id_SYMB_19, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqualContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ThrowContext extends ExprContext {
		public ExprContext expr_;
		public TerminalNode THROW() { return getToken(stellaParser.THROW, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ThrowContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterThrow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitThrow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitThrow(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplyContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_23() { return getToken(stellaParser.Surrogate_id_SYMB_23, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultiplyContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitMultiply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstMemoryContext extends ExprContext {
		public Token mem;
		public TerminalNode MemoryAddress() { return getToken(stellaParser.MemoryAddress, 0); }
		public ConstMemoryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterConstMemory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitConstMemory(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitConstMemory(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ExprContext {
		public ExprContext expr;
		public List<ExprContext> exprs = new ArrayList<ExprContext>();
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(stellaParser.Surrogate_id_SYMB_13, 0); }
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(stellaParser.Surrogate_id_SYMB_14, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public ListContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TryCatchContext extends ExprContext {
		public ExprContext tryExpr;
		public PatternContext pat;
		public ExprContext fallbackExpr;
		public TerminalNode TRY() { return getToken(stellaParser.TRY, 0); }
		public List<TerminalNode> Surrogate_id_SYMB_4() { return getTokens(stellaParser.Surrogate_id_SYMB_4); }
		public TerminalNode Surrogate_id_SYMB_4(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_4, i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_5() { return getTokens(stellaParser.Surrogate_id_SYMB_5); }
		public TerminalNode Surrogate_id_SYMB_5(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_5, i);
		}
		public TerminalNode CATCH() { return getToken(stellaParser.CATCH, 0); }
		public TerminalNode Surrogate_id_SYMB_9() { return getToken(stellaParser.Surrogate_id_SYMB_9, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TryCatchContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTryCatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTryCatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTryCatch(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TryCastAsContext extends ExprContext {
		public ExprContext tryExpr;
		public StellatypeContext type_;
		public PatternContext pattern_;
		public ExprContext expr_;
		public ExprContext fallbackExpr;
		public TerminalNode TRY() { return getToken(stellaParser.TRY, 0); }
		public List<TerminalNode> Surrogate_id_SYMB_4() { return getTokens(stellaParser.Surrogate_id_SYMB_4); }
		public TerminalNode Surrogate_id_SYMB_4(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_4, i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_5() { return getTokens(stellaParser.Surrogate_id_SYMB_5); }
		public TerminalNode Surrogate_id_SYMB_5(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_5, i);
		}
		public TerminalNode CAST() { return getToken(stellaParser.CAST, 0); }
		public TerminalNode Surrogate_id_SYMB_36() { return getToken(stellaParser.Surrogate_id_SYMB_36, 0); }
		public TerminalNode Surrogate_id_SYMB_9() { return getToken(stellaParser.Surrogate_id_SYMB_9, 0); }
		public TerminalNode Surrogate_id_SYMB_64() { return getToken(stellaParser.Surrogate_id_SYMB_64, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TryCastAsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTryCastAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTryCastAs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTryCastAs(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HeadContext extends ExprContext {
		public ExprContext list;
		public TerminalNode Surrogate_id_SYMB_26() { return getToken(stellaParser.Surrogate_id_SYMB_26, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public HeadContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitHead(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TerminatingSemicolonContext extends ExprContext {
		public ExprContext expr_;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(stellaParser.Surrogate_id_SYMB_1, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminatingSemicolonContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTerminatingSemicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTerminatingSemicolon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTerminatingSemicolon(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotEqualContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_20() { return getToken(stellaParser.Surrogate_id_SYMB_20, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public NotEqualContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterNotEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitNotEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitNotEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstUnitContext extends ExprContext {
		public TerminalNode Surrogate_id_SYMB_63() { return getToken(stellaParser.Surrogate_id_SYMB_63, 0); }
		public ConstUnitContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterConstUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitConstUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitConstUnit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SequenceContext extends ExprContext {
		public ExprContext expr1;
		public ExprContext expr2;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(stellaParser.Surrogate_id_SYMB_1, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SequenceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstFalseContext extends ExprContext {
		public TerminalNode Surrogate_id_SYMB_41() { return getToken(stellaParser.Surrogate_id_SYMB_41, 0); }
		public ConstFalseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterConstFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitConstFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitConstFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AbstractionContext extends ExprContext {
		public ParamDeclContext paramDecl;
		public List<ParamDeclContext> paramDecls = new ArrayList<ParamDeclContext>();
		public ExprContext returnExpr;
		public TerminalNode Surrogate_id_SYMB_43() { return getToken(stellaParser.Surrogate_id_SYMB_43, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(stellaParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode Surrogate_id_SYMB_56() { return getToken(stellaParser.Surrogate_id_SYMB_56, 0); }
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(stellaParser.Surrogate_id_SYMB_5, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<ParamDeclContext> paramDecl() {
			return getRuleContexts(ParamDeclContext.class);
		}
		public ParamDeclContext paramDecl(int i) {
			return getRuleContext(ParamDeclContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public AbstractionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterAbstraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitAbstraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitAbstraction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstIntContext extends ExprContext {
		public Token n;
		public TerminalNode INTEGER() { return getToken(stellaParser.INTEGER, 0); }
		public ConstIntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterConstInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitConstInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitConstInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariantContext extends ExprContext {
		public Token label;
		public ExprContext rhs;
		public TerminalNode Surrogate_id_SYMB_11() { return getToken(stellaParser.Surrogate_id_SYMB_11, 0); }
		public TerminalNode Surrogate_id_SYMB_12() { return getToken(stellaParser.Surrogate_id_SYMB_12, 0); }
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(stellaParser.Surrogate_id_SYMB_6, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VariantContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterVariant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitVariant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitVariant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstTrueContext extends ExprContext {
		public TerminalNode Surrogate_id_SYMB_60() { return getToken(stellaParser.Surrogate_id_SYMB_60, 0); }
		public ConstTrueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterConstTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitConstTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitConstTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubtractContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_22() { return getToken(stellaParser.Surrogate_id_SYMB_22, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SubtractContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterSubtract(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitSubtract(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitSubtract(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeCastContext extends ExprContext {
		public ExprContext expr_;
		public StellatypeContext type_;
		public TerminalNode CAST() { return getToken(stellaParser.CAST, 0); }
		public TerminalNode Surrogate_id_SYMB_36() { return getToken(stellaParser.Surrogate_id_SYMB_36, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public TypeCastContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeCast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeCast(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ExprContext {
		public ExprContext condition;
		public ExprContext thenExpr;
		public ExprContext elseExpr;
		public TerminalNode Surrogate_id_SYMB_45() { return getToken(stellaParser.Surrogate_id_SYMB_45, 0); }
		public TerminalNode Surrogate_id_SYMB_58() { return getToken(stellaParser.Surrogate_id_SYMB_58, 0); }
		public TerminalNode Surrogate_id_SYMB_39() { return getToken(stellaParser.Surrogate_id_SYMB_39, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ApplicationContext extends ExprContext {
		public ExprContext fun;
		public ExprContext expr;
		public List<ExprContext> args = new ArrayList<ExprContext>();
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public ApplicationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitApplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitApplication(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DerefContext extends ExprContext {
		public ExprContext expr_;
		public TerminalNode Surrogate_id_SYMB_23() { return getToken(stellaParser.Surrogate_id_SYMB_23, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DerefContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterDeref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitDeref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitDeref(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsEmptyContext extends ExprContext {
		public ExprContext list;
		public TerminalNode Surrogate_id_SYMB_27() { return getToken(stellaParser.Surrogate_id_SYMB_27, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IsEmptyContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterIsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitIsEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitIsEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PanicContext extends ExprContext {
		public TerminalNode PANIC() { return getToken(stellaParser.PANIC, 0); }
		public PanicContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPanic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPanic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPanic(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessThanOrEqualContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_16() { return getToken(stellaParser.Surrogate_id_SYMB_16, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LessThanOrEqualContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterLessThanOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitLessThanOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitLessThanOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SuccContext extends ExprContext {
		public ExprContext n;
		public TerminalNode Surrogate_id_SYMB_57() { return getToken(stellaParser.Surrogate_id_SYMB_57, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SuccContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterSucc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitSucc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitSucc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InlContext extends ExprContext {
		public ExprContext expr_;
		public TerminalNode Surrogate_id_SYMB_47() { return getToken(stellaParser.Surrogate_id_SYMB_47, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InlContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterInl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitInl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitInl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterThanOrEqualContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_18() { return getToken(stellaParser.Surrogate_id_SYMB_18, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GreaterThanOrEqualContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterGreaterThanOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitGreaterThanOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitGreaterThanOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InrContext extends ExprContext {
		public ExprContext expr_;
		public TerminalNode Surrogate_id_SYMB_49() { return getToken(stellaParser.Surrogate_id_SYMB_49, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterInr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitInr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitInr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchContext extends ExprContext {
		public ExprContext expr_;
		public MatchCaseContext matchCase;
		public List<MatchCaseContext> cases = new ArrayList<MatchCaseContext>();
		public TerminalNode Surrogate_id_SYMB_53() { return getToken(stellaParser.Surrogate_id_SYMB_53, 0); }
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(stellaParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(stellaParser.Surrogate_id_SYMB_5, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<MatchCaseContext> matchCase() {
			return getRuleContexts(MatchCaseContext.class);
		}
		public MatchCaseContext matchCase(int i) {
			return getRuleContext(MatchCaseContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_10() { return getTokens(stellaParser.Surrogate_id_SYMB_10); }
		public TerminalNode Surrogate_id_SYMB_10(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_10, i);
		}
		public MatchContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitMatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitMatch(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicNotContext extends ExprContext {
		public ExprContext expr_;
		public TerminalNode Surrogate_id_SYMB_54() { return getToken(stellaParser.Surrogate_id_SYMB_54, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LogicNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterLogicNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitLogicNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitLogicNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisedExprContext extends ExprContext {
		public ExprContext expr_;
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisedExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterParenthesisedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitParenthesisedExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitParenthesisedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TailContext extends ExprContext {
		public ExprContext list;
		public TerminalNode Surrogate_id_SYMB_28() { return getToken(stellaParser.Surrogate_id_SYMB_28, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TailContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTail(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RecordContext extends ExprContext {
		public BindingContext binding;
		public List<BindingContext> bindings = new ArrayList<BindingContext>();
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(stellaParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(stellaParser.Surrogate_id_SYMB_5, 0); }
		public List<BindingContext> binding() {
			return getRuleContexts(BindingContext.class);
		}
		public BindingContext binding(int i) {
			return getRuleContext(BindingContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public RecordContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitRecord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitRecord(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicAndContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_35() { return getToken(stellaParser.Surrogate_id_SYMB_35, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogicAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterLogicAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitLogicAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitLogicAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeApplicationContext extends ExprContext {
		public ExprContext fun;
		public StellatypeContext stellatype;
		public List<StellatypeContext> types = new ArrayList<StellatypeContext>();
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(stellaParser.Surrogate_id_SYMB_13, 0); }
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(stellaParser.Surrogate_id_SYMB_14, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StellatypeContext> stellatype() {
			return getRuleContexts(StellatypeContext.class);
		}
		public StellatypeContext stellatype(int i) {
			return getRuleContext(StellatypeContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public TypeApplicationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeApplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeApplication(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetRecContext extends ExprContext {
		public PatternBindingContext patternBinding;
		public List<PatternBindingContext> patternBindings = new ArrayList<PatternBindingContext>();
		public ExprContext body;
		public TerminalNode Surrogate_id_SYMB_52() { return getToken(stellaParser.Surrogate_id_SYMB_52, 0); }
		public TerminalNode Surrogate_id_SYMB_46() { return getToken(stellaParser.Surrogate_id_SYMB_46, 0); }
		public List<PatternBindingContext> patternBinding() {
			return getRuleContexts(PatternBindingContext.class);
		}
		public PatternBindingContext patternBinding(int i) {
			return getRuleContext(PatternBindingContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public LetRecContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterLetRec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitLetRec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitLetRec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicOrContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode Surrogate_id_SYMB_55() { return getToken(stellaParser.Surrogate_id_SYMB_55, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogicOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterLogicOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitLogicOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitLogicOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TryWithContext extends ExprContext {
		public ExprContext tryExpr;
		public ExprContext fallbackExpr;
		public TerminalNode TRY() { return getToken(stellaParser.TRY, 0); }
		public List<TerminalNode> Surrogate_id_SYMB_4() { return getTokens(stellaParser.Surrogate_id_SYMB_4); }
		public TerminalNode Surrogate_id_SYMB_4(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_4, i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_5() { return getTokens(stellaParser.Surrogate_id_SYMB_5); }
		public TerminalNode Surrogate_id_SYMB_5(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_5, i);
		}
		public TerminalNode Surrogate_id_SYMB_64() { return getToken(stellaParser.Surrogate_id_SYMB_64, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TryWithContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTryWith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTryWith(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTryWith(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PredContext extends ExprContext {
		public ExprContext n;
		public TerminalNode Surrogate_id_SYMB_29() { return getToken(stellaParser.Surrogate_id_SYMB_29, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PredContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPred(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPred(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeAscContext extends ExprContext {
		public ExprContext expr_;
		public StellatypeContext type_;
		public TerminalNode Surrogate_id_SYMB_36() { return getToken(stellaParser.Surrogate_id_SYMB_36, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public TypeAscContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeAsc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeAsc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeAsc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NatRecContext extends ExprContext {
		public ExprContext n;
		public ExprContext initial;
		public ExprContext step;
		public TerminalNode Surrogate_id_SYMB_31() { return getToken(stellaParser.Surrogate_id_SYMB_31, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public NatRecContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterNatRec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitNatRec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitNatRec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnfoldContext extends ExprContext {
		public StellatypeContext type_;
		public ExprContext expr_;
		public TerminalNode Surrogate_id_SYMB_62() { return getToken(stellaParser.Surrogate_id_SYMB_62, 0); }
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(stellaParser.Surrogate_id_SYMB_13, 0); }
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(stellaParser.Surrogate_id_SYMB_14, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnfoldContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterUnfold(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitUnfold(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitUnfold(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RefContext extends ExprContext {
		public ExprContext expr_;
		public TerminalNode REFERENCE() { return getToken(stellaParser.REFERENCE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RefContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitRef(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotTupleContext extends ExprContext {
		public ExprContext expr_;
		public Token index;
		public TerminalNode Surrogate_id_SYMB_25() { return getToken(stellaParser.Surrogate_id_SYMB_25, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(stellaParser.INTEGER, 0); }
		public DotTupleContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterDotTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitDotTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitDotTuple(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FixContext extends ExprContext {
		public ExprContext expr_;
		public TerminalNode Surrogate_id_SYMB_42() { return getToken(stellaParser.Surrogate_id_SYMB_42, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FixContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterFix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitFix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitFix(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends ExprContext {
		public PatternBindingContext patternBinding;
		public List<PatternBindingContext> patternBindings = new ArrayList<PatternBindingContext>();
		public ExprContext body;
		public TerminalNode Surrogate_id_SYMB_51() { return getToken(stellaParser.Surrogate_id_SYMB_51, 0); }
		public TerminalNode Surrogate_id_SYMB_46() { return getToken(stellaParser.Surrogate_id_SYMB_46, 0); }
		public List<PatternBindingContext> patternBinding() {
			return getRuleContexts(PatternBindingContext.class);
		}
		public PatternBindingContext patternBinding(int i) {
			return getRuleContext(PatternBindingContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ExprContext {
		public ExprContext lhs;
		public ExprContext rhs;
		public TerminalNode ASSIGN() { return getToken(stellaParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TupleContext extends ExprContext {
		public ExprContext expr;
		public List<ExprContext> exprs = new ArrayList<ExprContext>();
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(stellaParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(stellaParser.Surrogate_id_SYMB_5, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public TupleContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConsListContext extends ExprContext {
		public ExprContext head;
		public ExprContext tail;
		public TerminalNode Surrogate_id_SYMB_37() { return getToken(stellaParser.Surrogate_id_SYMB_37, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(stellaParser.Surrogate_id_SYMB_0, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ConsListContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterConsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitConsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitConsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				_localctx = new ConstTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(199);
				match(Surrogate_id_SYMB_60);
				}
				break;
			case 2:
				{
				_localctx = new ConstFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(Surrogate_id_SYMB_41);
				}
				break;
			case 3:
				{
				_localctx = new ConstUnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(Surrogate_id_SYMB_63);
				}
				break;
			case 4:
				{
				_localctx = new ConstIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				((ConstIntContext)_localctx).n = match(INTEGER);
				}
				break;
			case 5:
				{
				_localctx = new ConstMemoryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				((ConstMemoryContext)_localctx).mem = match(MemoryAddress);
				}
				break;
			case 6:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				((VarContext)_localctx).name = match(StellaIdent);
				}
				break;
			case 7:
				{
				_localctx = new PanicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				match(PANIC);
				}
				break;
			case 8:
				{
				_localctx = new ThrowContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				match(THROW);
				setState(207);
				match(Surrogate_id_SYMB_2);
				setState(208);
				((ThrowContext)_localctx).expr_ = expr(0);
				setState(209);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 9:
				{
				_localctx = new TryCatchContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				match(TRY);
				setState(212);
				match(Surrogate_id_SYMB_4);
				setState(213);
				((TryCatchContext)_localctx).tryExpr = expr(0);
				setState(214);
				match(Surrogate_id_SYMB_5);
				setState(215);
				match(CATCH);
				setState(216);
				match(Surrogate_id_SYMB_4);
				setState(217);
				((TryCatchContext)_localctx).pat = pattern(0);
				setState(218);
				match(Surrogate_id_SYMB_9);
				setState(219);
				((TryCatchContext)_localctx).fallbackExpr = expr(0);
				setState(220);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 10:
				{
				_localctx = new TryCastAsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				match(TRY);
				setState(223);
				match(Surrogate_id_SYMB_4);
				setState(224);
				((TryCastAsContext)_localctx).tryExpr = expr(0);
				setState(225);
				match(Surrogate_id_SYMB_5);
				setState(226);
				match(CAST);
				setState(227);
				match(Surrogate_id_SYMB_36);
				setState(228);
				((TryCastAsContext)_localctx).type_ = stellatype(0);
				setState(229);
				match(Surrogate_id_SYMB_4);
				setState(230);
				((TryCastAsContext)_localctx).pattern_ = pattern(0);
				setState(231);
				match(Surrogate_id_SYMB_9);
				setState(232);
				((TryCastAsContext)_localctx).expr_ = expr(0);
				setState(233);
				match(Surrogate_id_SYMB_5);
				setState(234);
				match(Surrogate_id_SYMB_64);
				setState(235);
				match(Surrogate_id_SYMB_4);
				setState(236);
				((TryCastAsContext)_localctx).fallbackExpr = expr(0);
				setState(237);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 11:
				{
				_localctx = new TryWithContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				match(TRY);
				setState(240);
				match(Surrogate_id_SYMB_4);
				setState(241);
				((TryWithContext)_localctx).tryExpr = expr(0);
				setState(242);
				match(Surrogate_id_SYMB_5);
				setState(243);
				match(Surrogate_id_SYMB_64);
				setState(244);
				match(Surrogate_id_SYMB_4);
				setState(245);
				((TryWithContext)_localctx).fallbackExpr = expr(0);
				setState(246);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 12:
				{
				_localctx = new InlContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(248);
				match(Surrogate_id_SYMB_47);
				setState(249);
				match(Surrogate_id_SYMB_2);
				setState(250);
				((InlContext)_localctx).expr_ = expr(0);
				setState(251);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 13:
				{
				_localctx = new InrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				match(Surrogate_id_SYMB_49);
				setState(254);
				match(Surrogate_id_SYMB_2);
				setState(255);
				((InrContext)_localctx).expr_ = expr(0);
				setState(256);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 14:
				{
				_localctx = new ConsListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				match(Surrogate_id_SYMB_37);
				setState(259);
				match(Surrogate_id_SYMB_2);
				setState(260);
				((ConsListContext)_localctx).head = expr(0);
				setState(261);
				match(Surrogate_id_SYMB_0);
				setState(262);
				((ConsListContext)_localctx).tail = expr(0);
				setState(263);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 15:
				{
				_localctx = new HeadContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				match(Surrogate_id_SYMB_26);
				setState(266);
				match(Surrogate_id_SYMB_2);
				setState(267);
				((HeadContext)_localctx).list = expr(0);
				setState(268);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 16:
				{
				_localctx = new IsEmptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				match(Surrogate_id_SYMB_27);
				setState(271);
				match(Surrogate_id_SYMB_2);
				setState(272);
				((IsEmptyContext)_localctx).list = expr(0);
				setState(273);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 17:
				{
				_localctx = new TailContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				match(Surrogate_id_SYMB_28);
				setState(276);
				match(Surrogate_id_SYMB_2);
				setState(277);
				((TailContext)_localctx).list = expr(0);
				setState(278);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 18:
				{
				_localctx = new SuccContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(280);
				match(Surrogate_id_SYMB_57);
				setState(281);
				match(Surrogate_id_SYMB_2);
				setState(282);
				((SuccContext)_localctx).n = expr(0);
				setState(283);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 19:
				{
				_localctx = new LogicNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				match(Surrogate_id_SYMB_54);
				setState(286);
				match(Surrogate_id_SYMB_2);
				setState(287);
				((LogicNotContext)_localctx).expr_ = expr(0);
				setState(288);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 20:
				{
				_localctx = new PredContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290);
				match(Surrogate_id_SYMB_29);
				setState(291);
				match(Surrogate_id_SYMB_2);
				setState(292);
				((PredContext)_localctx).n = expr(0);
				setState(293);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 21:
				{
				_localctx = new IsZeroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(295);
				match(Surrogate_id_SYMB_30);
				setState(296);
				match(Surrogate_id_SYMB_2);
				setState(297);
				((IsZeroContext)_localctx).n = expr(0);
				setState(298);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 22:
				{
				_localctx = new FixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(300);
				match(Surrogate_id_SYMB_42);
				setState(301);
				match(Surrogate_id_SYMB_2);
				setState(302);
				((FixContext)_localctx).expr_ = expr(0);
				setState(303);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 23:
				{
				_localctx = new NatRecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(305);
				match(Surrogate_id_SYMB_31);
				setState(306);
				match(Surrogate_id_SYMB_2);
				setState(307);
				((NatRecContext)_localctx).n = expr(0);
				setState(308);
				match(Surrogate_id_SYMB_0);
				setState(309);
				((NatRecContext)_localctx).initial = expr(0);
				setState(310);
				match(Surrogate_id_SYMB_0);
				setState(311);
				((NatRecContext)_localctx).step = expr(0);
				setState(312);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 24:
				{
				_localctx = new FoldContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(314);
				match(Surrogate_id_SYMB_44);
				setState(315);
				match(Surrogate_id_SYMB_13);
				setState(316);
				((FoldContext)_localctx).type_ = stellatype(0);
				setState(317);
				match(Surrogate_id_SYMB_14);
				setState(318);
				((FoldContext)_localctx).expr_ = expr(34);
				}
				break;
			case 25:
				{
				_localctx = new UnfoldContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(320);
				match(Surrogate_id_SYMB_62);
				setState(321);
				match(Surrogate_id_SYMB_13);
				setState(322);
				((UnfoldContext)_localctx).type_ = stellatype(0);
				setState(323);
				match(Surrogate_id_SYMB_14);
				setState(324);
				((UnfoldContext)_localctx).expr_ = expr(33);
				}
				break;
			case 26:
				{
				_localctx = new RefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(326);
				match(REFERENCE);
				setState(327);
				((RefContext)_localctx).expr_ = expr(27);
				}
				break;
			case 27:
				{
				_localctx = new DerefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(328);
				match(Surrogate_id_SYMB_23);
				setState(329);
				((DerefContext)_localctx).expr_ = expr(26);
				}
				break;
			case 28:
				{
				_localctx = new AbstractionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(330);
				match(Surrogate_id_SYMB_43);
				setState(331);
				match(Surrogate_id_SYMB_2);
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==StellaIdent) {
					{
					setState(332);
					((AbstractionContext)_localctx).paramDecl = paramDecl();
					((AbstractionContext)_localctx).paramDecls.add(((AbstractionContext)_localctx).paramDecl);
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(333);
						match(Surrogate_id_SYMB_0);
						setState(334);
						((AbstractionContext)_localctx).paramDecl = paramDecl();
						((AbstractionContext)_localctx).paramDecls.add(((AbstractionContext)_localctx).paramDecl);
						}
						}
						setState(339);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(342);
				match(Surrogate_id_SYMB_3);
				setState(343);
				match(Surrogate_id_SYMB_4);
				setState(344);
				match(Surrogate_id_SYMB_56);
				setState(345);
				((AbstractionContext)_localctx).returnExpr = expr(0);
				setState(346);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 29:
				{
				_localctx = new TupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(348);
				match(Surrogate_id_SYMB_4);
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6560200659402993624L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 13700865L) != 0)) {
					{
					setState(349);
					((TupleContext)_localctx).expr = expr(0);
					((TupleContext)_localctx).exprs.add(((TupleContext)_localctx).expr);
					setState(354);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(350);
						match(Surrogate_id_SYMB_0);
						setState(351);
						((TupleContext)_localctx).expr = expr(0);
						((TupleContext)_localctx).exprs.add(((TupleContext)_localctx).expr);
						}
						}
						setState(356);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(359);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 30:
				{
				_localctx = new RecordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(360);
				match(Surrogate_id_SYMB_4);
				setState(361);
				((RecordContext)_localctx).binding = binding();
				((RecordContext)_localctx).bindings.add(((RecordContext)_localctx).binding);
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Surrogate_id_SYMB_0) {
					{
					{
					setState(362);
					match(Surrogate_id_SYMB_0);
					setState(363);
					((RecordContext)_localctx).binding = binding();
					((RecordContext)_localctx).bindings.add(((RecordContext)_localctx).binding);
					}
					}
					setState(368);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(369);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 31:
				{
				_localctx = new VariantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(371);
				match(Surrogate_id_SYMB_11);
				setState(372);
				((VariantContext)_localctx).label = match(StellaIdent);
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Surrogate_id_SYMB_6) {
					{
					setState(373);
					match(Surrogate_id_SYMB_6);
					setState(374);
					((VariantContext)_localctx).rhs = expr(0);
					}
				}

				setState(377);
				match(Surrogate_id_SYMB_12);
				}
				break;
			case 32:
				{
				_localctx = new MatchContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(378);
				match(Surrogate_id_SYMB_53);
				setState(379);
				((MatchContext)_localctx).expr_ = expr(0);
				setState(380);
				match(Surrogate_id_SYMB_4);
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2595485433173397544L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 9437185L) != 0)) {
					{
					setState(381);
					((MatchContext)_localctx).matchCase = matchCase();
					((MatchContext)_localctx).cases.add(((MatchContext)_localctx).matchCase);
					setState(386);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_10) {
						{
						{
						setState(382);
						match(Surrogate_id_SYMB_10);
						setState(383);
						((MatchContext)_localctx).matchCase = matchCase();
						((MatchContext)_localctx).cases.add(((MatchContext)_localctx).matchCase);
						}
						}
						setState(388);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(391);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 33:
				{
				_localctx = new ListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(393);
				match(Surrogate_id_SYMB_13);
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6560200659402993624L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 13700865L) != 0)) {
					{
					setState(394);
					((ListContext)_localctx).expr = expr(0);
					((ListContext)_localctx).exprs.add(((ListContext)_localctx).expr);
					setState(399);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(395);
						match(Surrogate_id_SYMB_0);
						setState(396);
						((ListContext)_localctx).expr = expr(0);
						((ListContext)_localctx).exprs.add(((ListContext)_localctx).expr);
						}
						}
						setState(401);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(404);
				match(Surrogate_id_SYMB_14);
				}
				break;
			case 34:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(405);
				match(Surrogate_id_SYMB_45);
				setState(406);
				((IfContext)_localctx).condition = expr(0);
				setState(407);
				match(Surrogate_id_SYMB_58);
				setState(408);
				((IfContext)_localctx).thenExpr = expr(0);
				setState(409);
				match(Surrogate_id_SYMB_39);
				setState(410);
				((IfContext)_localctx).elseExpr = expr(7);
				}
				break;
			case 35:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(412);
				match(Surrogate_id_SYMB_51);
				setState(413);
				((LetContext)_localctx).patternBinding = patternBinding();
				((LetContext)_localctx).patternBindings.add(((LetContext)_localctx).patternBinding);
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Surrogate_id_SYMB_0) {
					{
					{
					setState(414);
					match(Surrogate_id_SYMB_0);
					setState(415);
					((LetContext)_localctx).patternBinding = patternBinding();
					((LetContext)_localctx).patternBindings.add(((LetContext)_localctx).patternBinding);
					}
					}
					setState(420);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(421);
				match(Surrogate_id_SYMB_46);
				setState(422);
				((LetContext)_localctx).body = expr(5);
				}
				break;
			case 36:
				{
				_localctx = new LetRecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(424);
				match(Surrogate_id_SYMB_52);
				setState(425);
				((LetRecContext)_localctx).patternBinding = patternBinding();
				((LetRecContext)_localctx).patternBindings.add(((LetRecContext)_localctx).patternBinding);
				setState(430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Surrogate_id_SYMB_0) {
					{
					{
					setState(426);
					match(Surrogate_id_SYMB_0);
					setState(427);
					((LetRecContext)_localctx).patternBinding = patternBinding();
					((LetRecContext)_localctx).patternBindings.add(((LetRecContext)_localctx).patternBinding);
					}
					}
					setState(432);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(433);
				match(Surrogate_id_SYMB_46);
				setState(434);
				((LetRecContext)_localctx).body = expr(4);
				}
				break;
			case 37:
				{
				_localctx = new TypeAbstractionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(436);
				match(GENERIC);
				setState(437);
				match(Surrogate_id_SYMB_13);
				setState(438);
				((TypeAbstractionContext)_localctx).StellaIdent = match(StellaIdent);
				((TypeAbstractionContext)_localctx).generics.add(((TypeAbstractionContext)_localctx).StellaIdent);
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Surrogate_id_SYMB_0) {
					{
					{
					setState(439);
					match(Surrogate_id_SYMB_0);
					setState(440);
					((TypeAbstractionContext)_localctx).StellaIdent = match(StellaIdent);
					((TypeAbstractionContext)_localctx).generics.add(((TypeAbstractionContext)_localctx).StellaIdent);
					}
					}
					setState(445);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(446);
				match(Surrogate_id_SYMB_14);
				setState(447);
				((TypeAbstractionContext)_localctx).expr_ = expr(3);
				}
				break;
			case 38:
				{
				_localctx = new ParenthesisedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(448);
				match(Surrogate_id_SYMB_2);
				setState(449);
				((ParenthesisedExprContext)_localctx).expr_ = expr(0);
				setState(450);
				match(Surrogate_id_SYMB_3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(538);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(536);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyContext(new ExprContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(454);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(455);
						match(Surrogate_id_SYMB_23);
						setState(456);
						((MultiplyContext)_localctx).right = expr(31);
						}
						break;
					case 2:
						{
						_localctx = new DivideContext(new ExprContext(_parentctx, _parentState));
						((DivideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(457);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(458);
						match(Surrogate_id_SYMB_24);
						setState(459);
						((DivideContext)_localctx).right = expr(30);
						}
						break;
					case 3:
						{
						_localctx = new LogicAndContext(new ExprContext(_parentctx, _parentState));
						((LogicAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(460);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(461);
						match(Surrogate_id_SYMB_35);
						setState(462);
						((LogicAndContext)_localctx).right = expr(29);
						}
						break;
					case 4:
						{
						_localctx = new AddContext(new ExprContext(_parentctx, _parentState));
						((AddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(463);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(464);
						match(Surrogate_id_SYMB_21);
						setState(465);
						((AddContext)_localctx).right = expr(26);
						}
						break;
					case 5:
						{
						_localctx = new SubtractContext(new ExprContext(_parentctx, _parentState));
						((SubtractContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(466);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(467);
						match(Surrogate_id_SYMB_22);
						setState(468);
						((SubtractContext)_localctx).right = expr(25);
						}
						break;
					case 6:
						{
						_localctx = new LogicOrContext(new ExprContext(_parentctx, _parentState));
						((LogicOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(469);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(470);
						match(Surrogate_id_SYMB_55);
						setState(471);
						((LogicOrContext)_localctx).right = expr(24);
						}
						break;
					case 7:
						{
						_localctx = new LessThanContext(new ExprContext(_parentctx, _parentState));
						((LessThanContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(472);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(473);
						match(Surrogate_id_SYMB_15);
						setState(474);
						((LessThanContext)_localctx).right = expr(15);
						}
						break;
					case 8:
						{
						_localctx = new LessThanOrEqualContext(new ExprContext(_parentctx, _parentState));
						((LessThanOrEqualContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(475);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(476);
						match(Surrogate_id_SYMB_16);
						setState(477);
						((LessThanOrEqualContext)_localctx).right = expr(14);
						}
						break;
					case 9:
						{
						_localctx = new GreaterThanContext(new ExprContext(_parentctx, _parentState));
						((GreaterThanContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(478);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(479);
						match(Surrogate_id_SYMB_17);
						setState(480);
						((GreaterThanContext)_localctx).right = expr(13);
						}
						break;
					case 10:
						{
						_localctx = new GreaterThanOrEqualContext(new ExprContext(_parentctx, _parentState));
						((GreaterThanOrEqualContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(481);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(482);
						match(Surrogate_id_SYMB_18);
						setState(483);
						((GreaterThanOrEqualContext)_localctx).right = expr(12);
						}
						break;
					case 11:
						{
						_localctx = new EqualContext(new ExprContext(_parentctx, _parentState));
						((EqualContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(484);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(485);
						match(Surrogate_id_SYMB_19);
						setState(486);
						((EqualContext)_localctx).right = expr(11);
						}
						break;
					case 12:
						{
						_localctx = new NotEqualContext(new ExprContext(_parentctx, _parentState));
						((NotEqualContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(487);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(488);
						match(Surrogate_id_SYMB_20);
						setState(489);
						((NotEqualContext)_localctx).right = expr(10);
						}
						break;
					case 13:
						{
						_localctx = new AssignContext(new ExprContext(_parentctx, _parentState));
						((AssignContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(490);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(491);
						match(ASSIGN);
						setState(492);
						((AssignContext)_localctx).rhs = expr(9);
						}
						break;
					case 14:
						{
						_localctx = new SequenceContext(new ExprContext(_parentctx, _parentState));
						((SequenceContext)_localctx).expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(493);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(494);
						match(Surrogate_id_SYMB_1);
						setState(495);
						((SequenceContext)_localctx).expr2 = expr(7);
						}
						break;
					case 15:
						{
						_localctx = new DotRecordContext(new ExprContext(_parentctx, _parentState));
						((DotRecordContext)_localctx).expr_ = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(496);
						if (!(precpred(_ctx, 59))) throw new FailedPredicateException(this, "precpred(_ctx, 59)");
						setState(497);
						match(Surrogate_id_SYMB_25);
						setState(498);
						((DotRecordContext)_localctx).label = match(StellaIdent);
						}
						break;
					case 16:
						{
						_localctx = new DotTupleContext(new ExprContext(_parentctx, _parentState));
						((DotTupleContext)_localctx).expr_ = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(499);
						if (!(precpred(_ctx, 58))) throw new FailedPredicateException(this, "precpred(_ctx, 58)");
						setState(500);
						match(Surrogate_id_SYMB_25);
						setState(501);
						((DotTupleContext)_localctx).index = match(INTEGER);
						}
						break;
					case 17:
						{
						_localctx = new ApplicationContext(new ExprContext(_parentctx, _parentState));
						((ApplicationContext)_localctx).fun = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(502);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(503);
						match(Surrogate_id_SYMB_2);
						setState(512);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6560200659402993624L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 13700865L) != 0)) {
							{
							setState(504);
							((ApplicationContext)_localctx).expr = expr(0);
							((ApplicationContext)_localctx).args.add(((ApplicationContext)_localctx).expr);
							setState(509);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==Surrogate_id_SYMB_0) {
								{
								{
								setState(505);
								match(Surrogate_id_SYMB_0);
								setState(506);
								((ApplicationContext)_localctx).expr = expr(0);
								((ApplicationContext)_localctx).args.add(((ApplicationContext)_localctx).expr);
								}
								}
								setState(511);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(514);
						match(Surrogate_id_SYMB_3);
						}
						break;
					case 18:
						{
						_localctx = new TypeApplicationContext(new ExprContext(_parentctx, _parentState));
						((TypeApplicationContext)_localctx).fun = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(515);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(516);
						match(Surrogate_id_SYMB_13);
						{
						setState(517);
						((TypeApplicationContext)_localctx).stellatype = stellatype(0);
						((TypeApplicationContext)_localctx).types.add(((TypeApplicationContext)_localctx).stellatype);
						setState(522);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Surrogate_id_SYMB_0) {
							{
							{
							setState(518);
							match(Surrogate_id_SYMB_0);
							setState(519);
							((TypeApplicationContext)_localctx).stellatype = stellatype(0);
							((TypeApplicationContext)_localctx).types.add(((TypeApplicationContext)_localctx).stellatype);
							}
							}
							setState(524);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						setState(525);
						match(Surrogate_id_SYMB_14);
						}
						break;
					case 19:
						{
						_localctx = new TypeAscContext(new ExprContext(_parentctx, _parentState));
						((TypeAscContext)_localctx).expr_ = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(527);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(528);
						match(Surrogate_id_SYMB_36);
						setState(529);
						((TypeAscContext)_localctx).type_ = stellatype(0);
						}
						break;
					case 20:
						{
						_localctx = new TypeCastContext(new ExprContext(_parentctx, _parentState));
						((TypeCastContext)_localctx).expr_ = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(530);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(531);
						match(CAST);
						setState(532);
						match(Surrogate_id_SYMB_36);
						setState(533);
						((TypeCastContext)_localctx).type_ = stellatype(0);
						}
						break;
					case 21:
						{
						_localctx = new TerminatingSemicolonContext(new ExprContext(_parentctx, _parentState));
						((TerminatingSemicolonContext)_localctx).expr_ = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(534);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(535);
						match(Surrogate_id_SYMB_1);
						}
						break;
					}
					} 
				}
				setState(540);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternBindingContext extends ParserRuleContext {
		public PatternContext pat;
		public ExprContext rhs;
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(stellaParser.Surrogate_id_SYMB_6, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PatternBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternBindingContext patternBinding() throws RecognitionException {
		PatternBindingContext _localctx = new PatternBindingContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_patternBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			((PatternBindingContext)_localctx).pat = pattern(0);
			setState(542);
			match(Surrogate_id_SYMB_6);
			setState(543);
			((PatternBindingContext)_localctx).rhs = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingContext extends ParserRuleContext {
		public Token name;
		public ExprContext rhs;
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(stellaParser.Surrogate_id_SYMB_6, 0); }
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_binding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			((BindingContext)_localctx).name = match(StellaIdent);
			setState(546);
			match(Surrogate_id_SYMB_6);
			setState(547);
			((BindingContext)_localctx).rhs = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchCaseContext extends ParserRuleContext {
		public PatternContext pattern_;
		public ExprContext expr_;
		public TerminalNode Surrogate_id_SYMB_9() { return getToken(stellaParser.Surrogate_id_SYMB_9, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MatchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterMatchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitMatchCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitMatchCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchCaseContext matchCase() throws RecognitionException {
		MatchCaseContext _localctx = new MatchCaseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_matchCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			((MatchCaseContext)_localctx).pattern_ = pattern(0);
			setState(550);
			match(Surrogate_id_SYMB_9);
			setState(551);
			((MatchCaseContext)_localctx).expr_ = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternContext extends ParserRuleContext {
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
	 
		public PatternContext() { }
		public void copyFrom(PatternContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternConsContext extends PatternContext {
		public PatternContext head;
		public PatternContext tail;
		public TerminalNode Surrogate_id_SYMB_37() { return getToken(stellaParser.Surrogate_id_SYMB_37, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(stellaParser.Surrogate_id_SYMB_0, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public PatternConsContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternCons(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternCons(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternCons(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternTupleContext extends PatternContext {
		public PatternContext pattern;
		public List<PatternContext> patterns = new ArrayList<PatternContext>();
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(stellaParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(stellaParser.Surrogate_id_SYMB_5, 0); }
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public PatternTupleContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternTuple(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternListContext extends PatternContext {
		public PatternContext pattern;
		public List<PatternContext> patterns = new ArrayList<PatternContext>();
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(stellaParser.Surrogate_id_SYMB_13, 0); }
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(stellaParser.Surrogate_id_SYMB_14, 0); }
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public PatternListContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternRecordContext extends PatternContext {
		public LabelledPatternContext labelledPattern;
		public List<LabelledPatternContext> patterns = new ArrayList<LabelledPatternContext>();
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(stellaParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(stellaParser.Surrogate_id_SYMB_5, 0); }
		public List<LabelledPatternContext> labelledPattern() {
			return getRuleContexts(LabelledPatternContext.class);
		}
		public LabelledPatternContext labelledPattern(int i) {
			return getRuleContext(LabelledPatternContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public PatternRecordContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternRecord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternRecord(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternVariantContext extends PatternContext {
		public Token label;
		public PatternContext pattern_;
		public TerminalNode Surrogate_id_SYMB_11() { return getToken(stellaParser.Surrogate_id_SYMB_11, 0); }
		public TerminalNode Surrogate_id_SYMB_12() { return getToken(stellaParser.Surrogate_id_SYMB_12, 0); }
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(stellaParser.Surrogate_id_SYMB_6, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public PatternVariantContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternVariant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternVariant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternVariant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternAscContext extends PatternContext {
		public PatternContext pattern_;
		public StellatypeContext type_;
		public TerminalNode Surrogate_id_SYMB_36() { return getToken(stellaParser.Surrogate_id_SYMB_36, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public PatternAscContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternAsc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternAsc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternAsc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternIntContext extends PatternContext {
		public Token n;
		public TerminalNode INTEGER() { return getToken(stellaParser.INTEGER, 0); }
		public PatternIntContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternInrContext extends PatternContext {
		public PatternContext pattern_;
		public TerminalNode Surrogate_id_SYMB_49() { return getToken(stellaParser.Surrogate_id_SYMB_49, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public PatternInrContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternInr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternInr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternInr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternTrueContext extends PatternContext {
		public TerminalNode Surrogate_id_SYMB_60() { return getToken(stellaParser.Surrogate_id_SYMB_60, 0); }
		public PatternTrueContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternInlContext extends PatternContext {
		public PatternContext pattern_;
		public TerminalNode Surrogate_id_SYMB_47() { return getToken(stellaParser.Surrogate_id_SYMB_47, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public PatternInlContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternInl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternInl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternInl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternVarContext extends PatternContext {
		public Token name;
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public PatternVarContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisedPatternContext extends PatternContext {
		public PatternContext pattern_;
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public ParenthesisedPatternContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterParenthesisedPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitParenthesisedPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitParenthesisedPattern(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternSuccContext extends PatternContext {
		public PatternContext pattern_;
		public TerminalNode Surrogate_id_SYMB_57() { return getToken(stellaParser.Surrogate_id_SYMB_57, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public PatternSuccContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternSucc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternSucc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternSucc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternFalseContext extends PatternContext {
		public TerminalNode Surrogate_id_SYMB_41() { return getToken(stellaParser.Surrogate_id_SYMB_41, 0); }
		public PatternFalseContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternUnitContext extends PatternContext {
		public TerminalNode Surrogate_id_SYMB_63() { return getToken(stellaParser.Surrogate_id_SYMB_63, 0); }
		public PatternUnitContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternUnit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PatternCastAsContext extends PatternContext {
		public PatternContext pattern_;
		public StellatypeContext type_;
		public TerminalNode CAST() { return getToken(stellaParser.CAST, 0); }
		public TerminalNode Surrogate_id_SYMB_36() { return getToken(stellaParser.Surrogate_id_SYMB_36, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public PatternCastAsContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterPatternCastAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitPatternCastAs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitPatternCastAs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		return pattern(0);
	}

	private PatternContext pattern(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PatternContext _localctx = new PatternContext(_ctx, _parentState);
		PatternContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_pattern, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				_localctx = new PatternVariantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(554);
				match(Surrogate_id_SYMB_11);
				setState(555);
				((PatternVariantContext)_localctx).label = match(StellaIdent);
				setState(558);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Surrogate_id_SYMB_6) {
					{
					setState(556);
					match(Surrogate_id_SYMB_6);
					setState(557);
					((PatternVariantContext)_localctx).pattern_ = pattern(0);
					}
				}

				setState(560);
				match(Surrogate_id_SYMB_12);
				}
				break;
			case 2:
				{
				_localctx = new PatternInlContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(561);
				match(Surrogate_id_SYMB_47);
				setState(562);
				match(Surrogate_id_SYMB_2);
				setState(563);
				((PatternInlContext)_localctx).pattern_ = pattern(0);
				setState(564);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 3:
				{
				_localctx = new PatternInrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(566);
				match(Surrogate_id_SYMB_49);
				setState(567);
				match(Surrogate_id_SYMB_2);
				setState(568);
				((PatternInrContext)_localctx).pattern_ = pattern(0);
				setState(569);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 4:
				{
				_localctx = new PatternTupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(571);
				match(Surrogate_id_SYMB_4);
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2595485433173397544L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 9437185L) != 0)) {
					{
					setState(572);
					((PatternTupleContext)_localctx).pattern = pattern(0);
					((PatternTupleContext)_localctx).patterns.add(((PatternTupleContext)_localctx).pattern);
					setState(577);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(573);
						match(Surrogate_id_SYMB_0);
						setState(574);
						((PatternTupleContext)_localctx).pattern = pattern(0);
						((PatternTupleContext)_localctx).patterns.add(((PatternTupleContext)_localctx).pattern);
						}
						}
						setState(579);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(582);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 5:
				{
				_localctx = new PatternRecordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(583);
				match(Surrogate_id_SYMB_4);
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==StellaIdent) {
					{
					setState(584);
					((PatternRecordContext)_localctx).labelledPattern = labelledPattern();
					((PatternRecordContext)_localctx).patterns.add(((PatternRecordContext)_localctx).labelledPattern);
					setState(589);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(585);
						match(Surrogate_id_SYMB_0);
						setState(586);
						((PatternRecordContext)_localctx).labelledPattern = labelledPattern();
						((PatternRecordContext)_localctx).patterns.add(((PatternRecordContext)_localctx).labelledPattern);
						}
						}
						setState(591);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(594);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 6:
				{
				_localctx = new PatternListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(595);
				match(Surrogate_id_SYMB_13);
				setState(604);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2595485433173397544L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 9437185L) != 0)) {
					{
					setState(596);
					((PatternListContext)_localctx).pattern = pattern(0);
					((PatternListContext)_localctx).patterns.add(((PatternListContext)_localctx).pattern);
					setState(601);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(597);
						match(Surrogate_id_SYMB_0);
						setState(598);
						((PatternListContext)_localctx).pattern = pattern(0);
						((PatternListContext)_localctx).patterns.add(((PatternListContext)_localctx).pattern);
						}
						}
						setState(603);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(606);
				match(Surrogate_id_SYMB_14);
				}
				break;
			case 7:
				{
				_localctx = new PatternConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(607);
				match(Surrogate_id_SYMB_37);
				setState(608);
				match(Surrogate_id_SYMB_2);
				setState(609);
				((PatternConsContext)_localctx).head = pattern(0);
				setState(610);
				match(Surrogate_id_SYMB_0);
				setState(611);
				((PatternConsContext)_localctx).tail = pattern(0);
				setState(612);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 8:
				{
				_localctx = new PatternFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(614);
				match(Surrogate_id_SYMB_41);
				}
				break;
			case 9:
				{
				_localctx = new PatternTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(615);
				match(Surrogate_id_SYMB_60);
				}
				break;
			case 10:
				{
				_localctx = new PatternUnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(616);
				match(Surrogate_id_SYMB_63);
				}
				break;
			case 11:
				{
				_localctx = new PatternIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(617);
				((PatternIntContext)_localctx).n = match(INTEGER);
				}
				break;
			case 12:
				{
				_localctx = new PatternSuccContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(618);
				match(Surrogate_id_SYMB_57);
				setState(619);
				match(Surrogate_id_SYMB_2);
				setState(620);
				((PatternSuccContext)_localctx).pattern_ = pattern(0);
				setState(621);
				match(Surrogate_id_SYMB_3);
				}
				break;
			case 13:
				{
				_localctx = new PatternVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(623);
				((PatternVarContext)_localctx).name = match(StellaIdent);
				}
				break;
			case 14:
				{
				_localctx = new ParenthesisedPatternContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(624);
				match(Surrogate_id_SYMB_2);
				setState(625);
				((ParenthesisedPatternContext)_localctx).pattern_ = pattern(0);
				setState(626);
				match(Surrogate_id_SYMB_3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(639);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(637);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
					case 1:
						{
						_localctx = new PatternAscContext(new PatternContext(_parentctx, _parentState));
						((PatternAscContext)_localctx).pattern_ = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pattern);
						setState(630);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(631);
						match(Surrogate_id_SYMB_36);
						setState(632);
						((PatternAscContext)_localctx).type_ = stellatype(0);
						}
						break;
					case 2:
						{
						_localctx = new PatternCastAsContext(new PatternContext(_parentctx, _parentState));
						((PatternCastAsContext)_localctx).pattern_ = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pattern);
						setState(633);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(634);
						match(CAST);
						setState(635);
						match(Surrogate_id_SYMB_36);
						setState(636);
						((PatternCastAsContext)_localctx).type_ = stellatype(0);
						}
						break;
					}
					} 
				}
				setState(641);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelledPatternContext extends ParserRuleContext {
		public Token label;
		public PatternContext pattern_;
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(stellaParser.Surrogate_id_SYMB_6, 0); }
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public LabelledPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelledPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterLabelledPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitLabelledPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitLabelledPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelledPatternContext labelledPattern() throws RecognitionException {
		LabelledPatternContext _localctx = new LabelledPatternContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_labelledPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
			((LabelledPatternContext)_localctx).label = match(StellaIdent);
			setState(643);
			match(Surrogate_id_SYMB_6);
			setState(644);
			((LabelledPatternContext)_localctx).pattern_ = pattern(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StellatypeContext extends ParserRuleContext {
		public StellatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stellatype; }
	 
		public StellatypeContext() { }
		public void copyFrom(StellatypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeTupleContext extends StellatypeContext {
		public StellatypeContext stellatype;
		public List<StellatypeContext> types = new ArrayList<StellatypeContext>();
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(stellaParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(stellaParser.Surrogate_id_SYMB_5, 0); }
		public List<StellatypeContext> stellatype() {
			return getRuleContexts(StellatypeContext.class);
		}
		public StellatypeContext stellatype(int i) {
			return getRuleContext(StellatypeContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public TypeTupleContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeTuple(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeTopContext extends StellatypeContext {
		public TerminalNode TOP_TYPE() { return getToken(stellaParser.TOP_TYPE, 0); }
		public TypeTopContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeTop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeTop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeTop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeBoolContext extends StellatypeContext {
		public TerminalNode Surrogate_id_SYMB_32() { return getToken(stellaParser.Surrogate_id_SYMB_32, 0); }
		public TypeBoolContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeRefContext extends StellatypeContext {
		public StellatypeContext type_;
		public TerminalNode REF_TYPE() { return getToken(stellaParser.REF_TYPE, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public TypeRefContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeRef(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeRecContext extends StellatypeContext {
		public Token var;
		public StellatypeContext type_;
		public TerminalNode Surrogate_id_SYMB_65() { return getToken(stellaParser.Surrogate_id_SYMB_65, 0); }
		public TerminalNode Surrogate_id_SYMB_25() { return getToken(stellaParser.Surrogate_id_SYMB_25, 0); }
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public TypeRecContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeRec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeRec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeRec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeAutoContext extends StellatypeContext {
		public TerminalNode AUTO_TYPE() { return getToken(stellaParser.AUTO_TYPE, 0); }
		public TypeAutoContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeAuto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeAuto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeAuto(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeSumContext extends StellatypeContext {
		public StellatypeContext left;
		public StellatypeContext right;
		public TerminalNode Surrogate_id_SYMB_21() { return getToken(stellaParser.Surrogate_id_SYMB_21, 0); }
		public List<StellatypeContext> stellatype() {
			return getRuleContexts(StellatypeContext.class);
		}
		public StellatypeContext stellatype(int i) {
			return getRuleContext(StellatypeContext.class,i);
		}
		public TypeSumContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeSum(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeVarContext extends StellatypeContext {
		public Token name;
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public TypeVarContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeVariantContext extends StellatypeContext {
		public VariantFieldTypeContext variantFieldType;
		public List<VariantFieldTypeContext> fieldTypes = new ArrayList<VariantFieldTypeContext>();
		public TerminalNode Surrogate_id_SYMB_11() { return getToken(stellaParser.Surrogate_id_SYMB_11, 0); }
		public TerminalNode Surrogate_id_SYMB_12() { return getToken(stellaParser.Surrogate_id_SYMB_12, 0); }
		public List<VariantFieldTypeContext> variantFieldType() {
			return getRuleContexts(VariantFieldTypeContext.class);
		}
		public VariantFieldTypeContext variantFieldType(int i) {
			return getRuleContext(VariantFieldTypeContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public TypeVariantContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeVariant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeVariant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeVariant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeUnitContext extends StellatypeContext {
		public TerminalNode Surrogate_id_SYMB_34() { return getToken(stellaParser.Surrogate_id_SYMB_34, 0); }
		public TypeUnitContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeUnit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeNatContext extends StellatypeContext {
		public TerminalNode Surrogate_id_SYMB_33() { return getToken(stellaParser.Surrogate_id_SYMB_33, 0); }
		public TypeNatContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeNat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeNat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeNat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeBottomContext extends StellatypeContext {
		public TerminalNode BOTTOM_TYPE() { return getToken(stellaParser.BOTTOM_TYPE, 0); }
		public TypeBottomContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeBottom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeBottom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeBottom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeParensContext extends StellatypeContext {
		public StellatypeContext type_;
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public TypeParensContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeParens(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeFunContext extends StellatypeContext {
		public StellatypeContext stellatype;
		public List<StellatypeContext> paramTypes = new ArrayList<StellatypeContext>();
		public StellatypeContext returnType;
		public TerminalNode Surrogate_id_SYMB_43() { return getToken(stellaParser.Surrogate_id_SYMB_43, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(stellaParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(stellaParser.Surrogate_id_SYMB_3, 0); }
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(stellaParser.Surrogate_id_SYMB_8, 0); }
		public List<StellatypeContext> stellatype() {
			return getRuleContexts(StellatypeContext.class);
		}
		public StellatypeContext stellatype(int i) {
			return getRuleContext(StellatypeContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public TypeFunContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeFun(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeForAllContext extends StellatypeContext {
		public Token StellaIdent;
		public List<Token> types = new ArrayList<Token>();
		public StellatypeContext type_;
		public TerminalNode FORALL() { return getToken(stellaParser.FORALL, 0); }
		public TerminalNode Surrogate_id_SYMB_25() { return getToken(stellaParser.Surrogate_id_SYMB_25, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public List<TerminalNode> StellaIdent() { return getTokens(stellaParser.StellaIdent); }
		public TerminalNode StellaIdent(int i) {
			return getToken(stellaParser.StellaIdent, i);
		}
		public TypeForAllContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeForAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeForAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeForAll(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeRecordContext extends StellatypeContext {
		public RecordFieldTypeContext recordFieldType;
		public List<RecordFieldTypeContext> fieldTypes = new ArrayList<RecordFieldTypeContext>();
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(stellaParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(stellaParser.Surrogate_id_SYMB_5, 0); }
		public List<RecordFieldTypeContext> recordFieldType() {
			return getRuleContexts(RecordFieldTypeContext.class);
		}
		public RecordFieldTypeContext recordFieldType(int i) {
			return getRuleContext(RecordFieldTypeContext.class,i);
		}
		public List<TerminalNode> Surrogate_id_SYMB_0() { return getTokens(stellaParser.Surrogate_id_SYMB_0); }
		public TerminalNode Surrogate_id_SYMB_0(int i) {
			return getToken(stellaParser.Surrogate_id_SYMB_0, i);
		}
		public TypeRecordContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeRecord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeRecord(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeListContext extends StellatypeContext {
		public StellatypeContext type_;
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(stellaParser.Surrogate_id_SYMB_13, 0); }
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(stellaParser.Surrogate_id_SYMB_14, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public TypeListContext(StellatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StellatypeContext stellatype() throws RecognitionException {
		return stellatype(0);
	}

	private StellatypeContext stellatype(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StellatypeContext _localctx = new StellatypeContext(_ctx, _parentState);
		StellatypeContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_stellatype, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(727);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				_localctx = new TypeBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(647);
				match(Surrogate_id_SYMB_32);
				}
				break;
			case 2:
				{
				_localctx = new TypeNatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(648);
				match(Surrogate_id_SYMB_33);
				}
				break;
			case 3:
				{
				_localctx = new TypeRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(649);
				match(REF_TYPE);
				setState(650);
				((TypeRefContext)_localctx).type_ = stellatype(15);
				}
				break;
			case 4:
				{
				_localctx = new TypeFunContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(651);
				match(Surrogate_id_SYMB_43);
				setState(652);
				match(Surrogate_id_SYMB_2);
				setState(661);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17652315607080L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 309281L) != 0)) {
					{
					setState(653);
					((TypeFunContext)_localctx).stellatype = stellatype(0);
					((TypeFunContext)_localctx).paramTypes.add(((TypeFunContext)_localctx).stellatype);
					setState(658);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(654);
						match(Surrogate_id_SYMB_0);
						setState(655);
						((TypeFunContext)_localctx).stellatype = stellatype(0);
						((TypeFunContext)_localctx).paramTypes.add(((TypeFunContext)_localctx).stellatype);
						}
						}
						setState(660);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(663);
				match(Surrogate_id_SYMB_3);
				setState(664);
				match(Surrogate_id_SYMB_8);
				setState(665);
				((TypeFunContext)_localctx).returnType = stellatype(13);
				}
				break;
			case 5:
				{
				_localctx = new TypeForAllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(666);
				match(FORALL);
				setState(670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==StellaIdent) {
					{
					{
					setState(667);
					((TypeForAllContext)_localctx).StellaIdent = match(StellaIdent);
					((TypeForAllContext)_localctx).types.add(((TypeForAllContext)_localctx).StellaIdent);
					}
					}
					setState(672);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(673);
				match(Surrogate_id_SYMB_25);
				setState(674);
				((TypeForAllContext)_localctx).type_ = stellatype(12);
				}
				break;
			case 6:
				{
				_localctx = new TypeRecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(675);
				match(Surrogate_id_SYMB_65);
				setState(676);
				((TypeRecContext)_localctx).var = match(StellaIdent);
				setState(677);
				match(Surrogate_id_SYMB_25);
				setState(678);
				((TypeRecContext)_localctx).type_ = stellatype(11);
				}
				break;
			case 7:
				{
				_localctx = new TypeTupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(679);
				match(Surrogate_id_SYMB_4);
				setState(688);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17652315607080L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 309281L) != 0)) {
					{
					setState(680);
					((TypeTupleContext)_localctx).stellatype = stellatype(0);
					((TypeTupleContext)_localctx).types.add(((TypeTupleContext)_localctx).stellatype);
					setState(685);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(681);
						match(Surrogate_id_SYMB_0);
						setState(682);
						((TypeTupleContext)_localctx).stellatype = stellatype(0);
						((TypeTupleContext)_localctx).types.add(((TypeTupleContext)_localctx).stellatype);
						}
						}
						setState(687);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(690);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 8:
				{
				_localctx = new TypeRecordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(691);
				match(Surrogate_id_SYMB_4);
				setState(692);
				((TypeRecordContext)_localctx).recordFieldType = recordFieldType();
				((TypeRecordContext)_localctx).fieldTypes.add(((TypeRecordContext)_localctx).recordFieldType);
				setState(697);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Surrogate_id_SYMB_0) {
					{
					{
					setState(693);
					match(Surrogate_id_SYMB_0);
					setState(694);
					((TypeRecordContext)_localctx).recordFieldType = recordFieldType();
					((TypeRecordContext)_localctx).fieldTypes.add(((TypeRecordContext)_localctx).recordFieldType);
					}
					}
					setState(699);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(700);
				match(Surrogate_id_SYMB_5);
				}
				break;
			case 9:
				{
				_localctx = new TypeVariantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(702);
				match(Surrogate_id_SYMB_11);
				setState(711);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==StellaIdent) {
					{
					setState(703);
					((TypeVariantContext)_localctx).variantFieldType = variantFieldType();
					((TypeVariantContext)_localctx).fieldTypes.add(((TypeVariantContext)_localctx).variantFieldType);
					setState(708);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Surrogate_id_SYMB_0) {
						{
						{
						setState(704);
						match(Surrogate_id_SYMB_0);
						setState(705);
						((TypeVariantContext)_localctx).variantFieldType = variantFieldType();
						((TypeVariantContext)_localctx).fieldTypes.add(((TypeVariantContext)_localctx).variantFieldType);
						}
						}
						setState(710);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(713);
				match(Surrogate_id_SYMB_12);
				}
				break;
			case 10:
				{
				_localctx = new TypeListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(714);
				match(Surrogate_id_SYMB_13);
				setState(715);
				((TypeListContext)_localctx).type_ = stellatype(0);
				setState(716);
				match(Surrogate_id_SYMB_14);
				}
				break;
			case 11:
				{
				_localctx = new TypeUnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(718);
				match(Surrogate_id_SYMB_34);
				}
				break;
			case 12:
				{
				_localctx = new TypeTopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(719);
				match(TOP_TYPE);
				}
				break;
			case 13:
				{
				_localctx = new TypeBottomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(720);
				match(BOTTOM_TYPE);
				}
				break;
			case 14:
				{
				_localctx = new TypeAutoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(721);
				match(AUTO_TYPE);
				}
				break;
			case 15:
				{
				_localctx = new TypeVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(722);
				((TypeVarContext)_localctx).name = match(StellaIdent);
				}
				break;
			case 16:
				{
				_localctx = new TypeParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(723);
				match(Surrogate_id_SYMB_2);
				setState(724);
				((TypeParensContext)_localctx).type_ = stellatype(0);
				setState(725);
				match(Surrogate_id_SYMB_3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(734);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeSumContext(new StellatypeContext(_parentctx, _parentState));
					((TypeSumContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_stellatype);
					setState(729);
					if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
					setState(730);
					match(Surrogate_id_SYMB_21);
					setState(731);
					((TypeSumContext)_localctx).right = stellatype(15);
					}
					} 
				}
				setState(736);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecordFieldTypeContext extends ParserRuleContext {
		public Token label;
		public StellatypeContext type_;
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(stellaParser.Surrogate_id_SYMB_7, 0); }
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public RecordFieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordFieldType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterRecordFieldType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitRecordFieldType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitRecordFieldType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordFieldTypeContext recordFieldType() throws RecognitionException {
		RecordFieldTypeContext _localctx = new RecordFieldTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_recordFieldType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(737);
			((RecordFieldTypeContext)_localctx).label = match(StellaIdent);
			setState(738);
			match(Surrogate_id_SYMB_7);
			setState(739);
			((RecordFieldTypeContext)_localctx).type_ = stellatype(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariantFieldTypeContext extends ParserRuleContext {
		public Token label;
		public StellatypeContext type_;
		public TerminalNode StellaIdent() { return getToken(stellaParser.StellaIdent, 0); }
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(stellaParser.Surrogate_id_SYMB_7, 0); }
		public StellatypeContext stellatype() {
			return getRuleContext(StellatypeContext.class,0);
		}
		public VariantFieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variantFieldType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).enterVariantFieldType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof stellaParserListener ) ((stellaParserListener)listener).exitVariantFieldType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof stellaParserVisitor ) return ((stellaParserVisitor<? extends T>)visitor).visitVariantFieldType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariantFieldTypeContext variantFieldType() throws RecognitionException {
		VariantFieldTypeContext _localctx = new VariantFieldTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variantFieldType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(741);
			((VariantFieldTypeContext)_localctx).label = match(StellaIdent);
			setState(744);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Surrogate_id_SYMB_7) {
				{
				setState(742);
				match(Surrogate_id_SYMB_7);
				setState(743);
				((VariantFieldTypeContext)_localctx).type_ = stellatype(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 13:
			return pattern_sempred((PatternContext)_localctx, predIndex);
		case 15:
			return stellatype_sempred((StellatypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 30);
		case 1:
			return precpred(_ctx, 29);
		case 2:
			return precpred(_ctx, 28);
		case 3:
			return precpred(_ctx, 25);
		case 4:
			return precpred(_ctx, 24);
		case 5:
			return precpred(_ctx, 23);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 11);
		case 10:
			return precpred(_ctx, 10);
		case 11:
			return precpred(_ctx, 9);
		case 12:
			return precpred(_ctx, 8);
		case 13:
			return precpred(_ctx, 6);
		case 14:
			return precpred(_ctx, 59);
		case 15:
			return precpred(_ctx, 58);
		case 16:
			return precpred(_ctx, 32);
		case 17:
			return precpred(_ctx, 31);
		case 18:
			return precpred(_ctx, 22);
		case 19:
			return precpred(_ctx, 21);
		case 20:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean pattern_sempred(PatternContext _localctx, int predIndex) {
		switch (predIndex) {
		case 21:
			return precpred(_ctx, 3);
		case 22:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean stellatype_sempred(StellatypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 23:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001Y\u02eb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u00030\b\u0003\n\u0003\f\u0003"+
		"3\t\u0003\u0001\u0003\u0005\u00036\b\u0003\n\u0003\f\u00039\t\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005D\b\u0005\n\u0005\f\u0005G\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0005\u0006L\b\u0006\n\u0006"+
		"\f\u0006O\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006W\b\u0006\n\u0006\f\u0006Z\t\u0006\u0003"+
		"\u0006\\\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006a\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006g\b\u0006"+
		"\n\u0006\f\u0006j\t\u0006\u0003\u0006l\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006p\b\u0006\n\u0006\f\u0006s\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006z\b\u0006\n\u0006\f\u0006"+
		"}\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006\u0086\b\u0006\n\u0006\f\u0006\u0089"+
		"\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u0090\b\u0006\n\u0006\f\u0006\u0093\t\u0006\u0003\u0006\u0095\b"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u009a\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00a0\b\u0006\n"+
		"\u0006\f\u0006\u00a3\t\u0006\u0003\u0006\u00a5\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u00a9\b\u0006\n\u0006\f\u0006\u00ac\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00bf\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u0150\b\t\n\t\f\t\u0153\t\t\u0003\t\u0155\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u0161\b\t\n\t\f\t\u0164\t\t\u0003\t\u0166\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u016d\b\t\n\t\f\t\u0170\t\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0178\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0181\b\t\n\t\f\t\u0184\t\t"+
		"\u0003\t\u0186\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u018e\b\t\n\t\f\t\u0191\t\t\u0003\t\u0193\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u01a1\b\t\n\t\f\t\u01a4\t\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0005\t\u01ad\b\t\n\t\f\t\u01b0\t\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u01ba\b\t\n"+
		"\t\f\t\u01bd\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u01c5\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u01fc\b\t\n\t\f\t\u01ff\t\t\u0003\t\u0201\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0209\b\t\n\t\f\t\u020c\t\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u0219\b\t\n\t\f\t\u021c\t\t\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u022f\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0240"+
		"\b\r\n\r\f\r\u0243\t\r\u0003\r\u0245\b\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u024c\b\r\n\r\f\r\u024f\t\r\u0003\r\u0251\b\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0258\b\r\n\r\f\r\u025b\t\r"+
		"\u0003\r\u025d\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0275\b\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u027e\b\r\n"+
		"\r\f\r\u0281\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0291\b\u000f\n"+
		"\u000f\f\u000f\u0294\t\u000f\u0003\u000f\u0296\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u029d\b\u000f\n"+
		"\u000f\f\u000f\u02a0\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u02ac\b\u000f\n\u000f\f\u000f\u02af\t\u000f\u0003\u000f"+
		"\u02b1\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u02b8\b\u000f\n\u000f\f\u000f\u02bb\t\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u02c3"+
		"\b\u000f\n\u000f\f\u000f\u02c6\t\u000f\u0003\u000f\u02c8\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u02d8\b\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u02dd\b\u000f\n\u000f\f\u000f\u02e0\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u02e9\b\u0011\u0001\u0011\u0000\u0003\u0012\u001a\u001e\u0012"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"\u0000\u0000\u0367\u0000$\u0001\u0000\u0000\u0000\u0002"+
		"\'\u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000\u0006-\u0001"+
		"\u0000\u0000\u0000\b:\u0001\u0000\u0000\u0000\n>\u0001\u0000\u0000\u0000"+
		"\f\u00be\u0001\u0000\u0000\u0000\u000e\u00c0\u0001\u0000\u0000\u0000\u0010"+
		"\u00c2\u0001\u0000\u0000\u0000\u0012\u01c4\u0001\u0000\u0000\u0000\u0014"+
		"\u021d\u0001\u0000\u0000\u0000\u0016\u0221\u0001\u0000\u0000\u0000\u0018"+
		"\u0225\u0001\u0000\u0000\u0000\u001a\u0274\u0001\u0000\u0000\u0000\u001c"+
		"\u0282\u0001\u0000\u0000\u0000\u001e\u02d7\u0001\u0000\u0000\u0000 \u02e1"+
		"\u0001\u0000\u0000\u0000\"\u02e5\u0001\u0000\u0000\u0000$%\u0003\u0006"+
		"\u0003\u0000%&\u0005\u0000\u0000\u0001&\u0001\u0001\u0000\u0000\u0000"+
		"\'(\u0003\u0012\t\u0000()\u0005\u0000\u0000\u0001)\u0003\u0001\u0000\u0000"+
		"\u0000*+\u0003\u001e\u000f\u0000+,\u0005\u0000\u0000\u0001,\u0005\u0001"+
		"\u0000\u0000\u0000-1\u0003\b\u0004\u0000.0\u0003\n\u0005\u0000/.\u0001"+
		"\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u0000"+
		"12\u0001\u0000\u0000\u000027\u0001\u0000\u0000\u000031\u0001\u0000\u0000"+
		"\u000046\u0003\f\u0006\u000054\u0001\u0000\u0000\u000069\u0001\u0000\u0000"+
		"\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008\u0007\u0001"+
		"\u0000\u0000\u000097\u0001\u0000\u0000\u0000:;\u00053\u0000\u0000;<\u0005"+
		"\'\u0000\u0000<=\u0005\u0002\u0000\u0000=\t\u0001\u0000\u0000\u0000>?"+
		"\u0005)\u0000\u0000?@\u0005A\u0000\u0000@E\u0005U\u0000\u0000AB\u0005"+
		"\u0001\u0000\u0000BD\u0005U\u0000\u0000CA\u0001\u0000\u0000\u0000DG\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000"+
		"FH\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HI\u0005\u0002\u0000"+
		"\u0000I\u000b\u0001\u0000\u0000\u0000JL\u0003\u000e\u0007\u0000KJ\u0001"+
		"\u0000\u0000\u0000LO\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000"+
		"\u0000PQ\u0005,\u0000\u0000QR\u0005T\u0000\u0000R[\u0005\u0003\u0000\u0000"+
		"SX\u0003\u0010\b\u0000TU\u0005\u0001\u0000\u0000UW\u0003\u0010\b\u0000"+
		"VT\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000[S\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]`\u0005\u0004\u0000\u0000^_\u0005\t\u0000\u0000_a\u0003"+
		"\u001e\u000f\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000"+
		"ak\u0001\u0000\u0000\u0000bc\u0005<\u0000\u0000ch\u0003\u001e\u000f\u0000"+
		"de\u0005\u0001\u0000\u0000eg\u0003\u001e\u000f\u0000fd\u0001\u0000\u0000"+
		"\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kb\u0001"+
		"\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"mq\u0005\u0005\u0000\u0000np\u0003\f\u0006\u0000on\u0001\u0000\u0000\u0000"+
		"ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000rt\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u00059\u0000"+
		"\u0000uv\u0003\u0012\t\u0000vw\u0005\u0006\u0000\u0000w\u00bf\u0001\u0000"+
		"\u0000\u0000xz\u0003\u000e\u0007\u0000yx\u0001\u0000\u0000\u0000z}\u0001"+
		"\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000"+
		"|~\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u007f\u0005P\u0000"+
		"\u0000\u007f\u0080\u0005,\u0000\u0000\u0080\u0081\u0005T\u0000\u0000\u0081"+
		"\u0082\u0005\u000e\u0000\u0000\u0082\u0087\u0005T\u0000\u0000\u0083\u0084"+
		"\u0005\u0001\u0000\u0000\u0084\u0086\u0005T\u0000\u0000\u0085\u0083\u0001"+
		"\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008a\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"\u000f\u0000\u0000\u008b\u0094\u0005\u0003\u0000\u0000\u008c\u0091\u0003"+
		"\u0010\b\u0000\u008d\u008e\u0005\u0001\u0000\u0000\u008e\u0090\u0003\u0010"+
		"\b\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0094\u008c\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0099\u0005\u0004\u0000"+
		"\u0000\u0097\u0098\u0005\t\u0000\u0000\u0098\u009a\u0003\u001e\u000f\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a\u00a4\u0001\u0000\u0000\u0000\u009b\u009c\u0005<\u0000\u0000\u009c"+
		"\u00a1\u0003\u001e\u000f\u0000\u009d\u009e\u0005\u0001\u0000\u0000\u009e"+
		"\u00a0\u0003\u001e\u000f\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a4\u009b\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6"+
		"\u00aa\u0005\u0005\u0000\u0000\u00a7\u00a9\u0003\f\u0006\u0000\u00a8\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad"+
		"\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u00059\u0000\u0000\u00ae\u00af\u0003\u0012\t\u0000\u00af\u00b0\u0005"+
		"\u0006\u0000\u0000\u00b0\u00bf\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005"+
		">\u0000\u0000\u00b2\u00b3\u0005T\u0000\u0000\u00b3\u00b4\u0005\u0007\u0000"+
		"\u0000\u00b4\u00bf\u0003\u001e\u000f\u0000\u00b5\u00b6\u0005C\u0000\u0000"+
		"\u00b6\u00b7\u0005>\u0000\u0000\u00b7\u00b8\u0005\u0007\u0000\u0000\u00b8"+
		"\u00bf\u0003\u001e\u000f\u0000\u00b9\u00ba\u0005C\u0000\u0000\u00ba\u00bb"+
		"\u0005D\u0000\u0000\u00bb\u00bc\u0005T\u0000\u0000\u00bc\u00bd\u0005\b"+
		"\u0000\u0000\u00bd\u00bf\u0003\u001e\u000f\u0000\u00beM\u0001\u0000\u0000"+
		"\u0000\u00be{\u0001\u0000\u0000\u0000\u00be\u00b1\u0001\u0000\u0000\u0000"+
		"\u00be\u00b5\u0001\u0000\u0000\u0000\u00be\u00b9\u0001\u0000\u0000\u0000"+
		"\u00bf\r\u0001\u0000\u0000\u0000\u00c0\u00c1\u00051\u0000\u0000\u00c1"+
		"\u000f\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005T\u0000\u0000\u00c3\u00c4"+
		"\u0005\b\u0000\u0000\u00c4\u00c5\u0003\u001e\u000f\u0000\u00c5\u0011\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0006\t\uffff\uffff\u0000\u00c7\u01c5\u0005"+
		"=\u0000\u0000\u00c8\u01c5\u0005*\u0000\u0000\u00c9\u01c5\u0005@\u0000"+
		"\u0000\u00ca\u01c5\u0005W\u0000\u0000\u00cb\u01c5\u0005V\u0000\u0000\u00cc"+
		"\u01c5\u0005T\u0000\u0000\u00cd\u01c5\u0005I\u0000\u0000\u00ce\u00cf\u0005"+
		"J\u0000\u0000\u00cf\u00d0\u0005\u0003\u0000\u0000\u00d0\u00d1\u0003\u0012"+
		"\t\u0000\u00d1\u00d2\u0005\u0004\u0000\u0000\u00d2\u01c5\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0005K\u0000\u0000\u00d4\u00d5\u0005\u0005\u0000\u0000"+
		"\u00d5\u00d6\u0003\u0012\t\u0000\u00d6\u00d7\u0005\u0006\u0000\u0000\u00d7"+
		"\u00d8\u0005L\u0000\u0000\u00d8\u00d9\u0005\u0005\u0000\u0000\u00d9\u00da"+
		"\u0003\u001a\r\u0000\u00da\u00db\u0005\n\u0000\u0000\u00db\u00dc\u0003"+
		"\u0012\t\u0000\u00dc\u00dd\u0005\u0006\u0000\u0000\u00dd\u01c5\u0001\u0000"+
		"\u0000\u0000\u00de\u00df\u0005K\u0000\u0000\u00df\u00e0\u0005\u0005\u0000"+
		"\u0000\u00e0\u00e1\u0003\u0012\t\u0000\u00e1\u00e2\u0005\u0006\u0000\u0000"+
		"\u00e2\u00e3\u0005E\u0000\u0000\u00e3\u00e4\u0005%\u0000\u0000\u00e4\u00e5"+
		"\u0003\u001e\u000f\u0000\u00e5\u00e6\u0005\u0005\u0000\u0000\u00e6\u00e7"+
		"\u0003\u001a\r\u0000\u00e7\u00e8\u0005\n\u0000\u0000\u00e8\u00e9\u0003"+
		"\u0012\t\u0000\u00e9\u00ea\u0005\u0006\u0000\u0000\u00ea\u00eb\u0005A"+
		"\u0000\u0000\u00eb\u00ec\u0005\u0005\u0000\u0000\u00ec\u00ed\u0003\u0012"+
		"\t\u0000\u00ed\u00ee\u0005\u0006\u0000\u0000\u00ee\u01c5\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0005K\u0000\u0000\u00f0\u00f1\u0005\u0005\u0000\u0000"+
		"\u00f1\u00f2\u0003\u0012\t\u0000\u00f2\u00f3\u0005\u0006\u0000\u0000\u00f3"+
		"\u00f4\u0005A\u0000\u0000\u00f4\u00f5\u0005\u0005\u0000\u0000\u00f5\u00f6"+
		"\u0003\u0012\t\u0000\u00f6\u00f7\u0005\u0006\u0000\u0000\u00f7\u01c5\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u00050\u0000\u0000\u00f9\u00fa\u0005\u0003"+
		"\u0000\u0000\u00fa\u00fb\u0003\u0012\t\u0000\u00fb\u00fc\u0005\u0004\u0000"+
		"\u0000\u00fc\u01c5\u0001\u0000\u0000\u0000\u00fd\u00fe\u00052\u0000\u0000"+
		"\u00fe\u00ff\u0005\u0003\u0000\u0000\u00ff\u0100\u0003\u0012\t\u0000\u0100"+
		"\u0101\u0005\u0004\u0000\u0000\u0101\u01c5\u0001\u0000\u0000\u0000\u0102"+
		"\u0103\u0005&\u0000\u0000\u0103\u0104\u0005\u0003\u0000\u0000\u0104\u0105"+
		"\u0003\u0012\t\u0000\u0105\u0106\u0005\u0001\u0000\u0000\u0106\u0107\u0003"+
		"\u0012\t\u0000\u0107\u0108\u0005\u0004\u0000\u0000\u0108\u01c5\u0001\u0000"+
		"\u0000\u0000\u0109\u010a\u0005\u001b\u0000\u0000\u010a\u010b\u0005\u0003"+
		"\u0000\u0000\u010b\u010c\u0003\u0012\t\u0000\u010c\u010d\u0005\u0004\u0000"+
		"\u0000\u010d\u01c5\u0001\u0000\u0000\u0000\u010e\u010f\u0005\u001c\u0000"+
		"\u0000\u010f\u0110\u0005\u0003\u0000\u0000\u0110\u0111\u0003\u0012\t\u0000"+
		"\u0111\u0112\u0005\u0004\u0000\u0000\u0112\u01c5\u0001\u0000\u0000\u0000"+
		"\u0113\u0114\u0005\u001d\u0000\u0000\u0114\u0115\u0005\u0003\u0000\u0000"+
		"\u0115\u0116\u0003\u0012\t\u0000\u0116\u0117\u0005\u0004\u0000\u0000\u0117"+
		"\u01c5\u0001\u0000\u0000\u0000\u0118\u0119\u0005:\u0000\u0000\u0119\u011a"+
		"\u0005\u0003\u0000\u0000\u011a\u011b\u0003\u0012\t\u0000\u011b\u011c\u0005"+
		"\u0004\u0000\u0000\u011c\u01c5\u0001\u0000\u0000\u0000\u011d\u011e\u0005"+
		"7\u0000\u0000\u011e\u011f\u0005\u0003\u0000\u0000\u011f\u0120\u0003\u0012"+
		"\t\u0000\u0120\u0121\u0005\u0004\u0000\u0000\u0121\u01c5\u0001\u0000\u0000"+
		"\u0000\u0122\u0123\u0005\u001e\u0000\u0000\u0123\u0124\u0005\u0003\u0000"+
		"\u0000\u0124\u0125\u0003\u0012\t\u0000\u0125\u0126\u0005\u0004\u0000\u0000"+
		"\u0126\u01c5\u0001\u0000\u0000\u0000\u0127\u0128\u0005\u001f\u0000\u0000"+
		"\u0128\u0129\u0005\u0003\u0000\u0000\u0129\u012a\u0003\u0012\t\u0000\u012a"+
		"\u012b\u0005\u0004\u0000\u0000\u012b\u01c5\u0001\u0000\u0000\u0000\u012c"+
		"\u012d\u0005+\u0000\u0000\u012d\u012e\u0005\u0003\u0000\u0000\u012e\u012f"+
		"\u0003\u0012\t\u0000\u012f\u0130\u0005\u0004\u0000\u0000\u0130\u01c5\u0001"+
		"\u0000\u0000\u0000\u0131\u0132\u0005 \u0000\u0000\u0132\u0133\u0005\u0003"+
		"\u0000\u0000\u0133\u0134\u0003\u0012\t\u0000\u0134\u0135\u0005\u0001\u0000"+
		"\u0000\u0135\u0136\u0003\u0012\t\u0000\u0136\u0137\u0005\u0001\u0000\u0000"+
		"\u0137\u0138\u0003\u0012\t\u0000\u0138\u0139\u0005\u0004\u0000\u0000\u0139"+
		"\u01c5\u0001\u0000\u0000\u0000\u013a\u013b\u0005-\u0000\u0000\u013b\u013c"+
		"\u0005\u000e\u0000\u0000\u013c\u013d\u0003\u001e\u000f\u0000\u013d\u013e"+
		"\u0005\u000f\u0000\u0000\u013e\u013f\u0003\u0012\t\"\u013f\u01c5\u0001"+
		"\u0000\u0000\u0000\u0140\u0141\u0005?\u0000\u0000\u0141\u0142\u0005\u000e"+
		"\u0000\u0000\u0142\u0143\u0003\u001e\u000f\u0000\u0143\u0144\u0005\u000f"+
		"\u0000\u0000\u0144\u0145\u0003\u0012\t!\u0145\u01c5\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0005H\u0000\u0000\u0147\u01c5\u0003\u0012\t\u001b"+
		"\u0148\u0149\u0005\u0018\u0000\u0000\u0149\u01c5\u0003\u0012\t\u001a\u014a"+
		"\u014b\u0005,\u0000\u0000\u014b\u0154\u0005\u0003\u0000\u0000\u014c\u0151"+
		"\u0003\u0010\b\u0000\u014d\u014e\u0005\u0001\u0000\u0000\u014e\u0150\u0003"+
		"\u0010\b\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u0150\u0153\u0001\u0000"+
		"\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000"+
		"\u0000\u0000\u0152\u0155\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000"+
		"\u0000\u0000\u0154\u014c\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000"+
		"\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0156\u0157\u0005\u0004"+
		"\u0000\u0000\u0157\u0158\u0005\u0005\u0000\u0000\u0158\u0159\u00059\u0000"+
		"\u0000\u0159\u015a\u0003\u0012\t\u0000\u015a\u015b\u0005\u0006\u0000\u0000"+
		"\u015b\u01c5\u0001\u0000\u0000\u0000\u015c\u0165\u0005\u0005\u0000\u0000"+
		"\u015d\u0162\u0003\u0012\t\u0000\u015e\u015f\u0005\u0001\u0000\u0000\u015f"+
		"\u0161\u0003\u0012\t\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161\u0164"+
		"\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163"+
		"\u0001\u0000\u0000\u0000\u0163\u0166\u0001\u0000\u0000\u0000\u0164\u0162"+
		"\u0001\u0000\u0000\u0000\u0165\u015d\u0001\u0000\u0000\u0000\u0165\u0166"+
		"\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u01c5"+
		"\u0005\u0006\u0000\u0000\u0168\u0169\u0005\u0005\u0000\u0000\u0169\u016e"+
		"\u0003\u0016\u000b\u0000\u016a\u016b\u0005\u0001\u0000\u0000\u016b\u016d"+
		"\u0003\u0016\u000b\u0000\u016c\u016a\u0001\u0000\u0000\u0000\u016d\u0170"+
		"\u0001\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f"+
		"\u0001\u0000\u0000\u0000\u016f\u0171\u0001\u0000\u0000\u0000\u0170\u016e"+
		"\u0001\u0000\u0000\u0000\u0171\u0172\u0005\u0006\u0000\u0000\u0172\u01c5"+
		"\u0001\u0000\u0000\u0000\u0173\u0174\u0005\f\u0000\u0000\u0174\u0177\u0005"+
		"T\u0000\u0000\u0175\u0176\u0005\u0007\u0000\u0000\u0176\u0178\u0003\u0012"+
		"\t\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000"+
		"\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179\u01c5\u0005\r\u0000\u0000"+
		"\u017a\u017b\u00056\u0000\u0000\u017b\u017c\u0003\u0012\t\u0000\u017c"+
		"\u0185\u0005\u0005\u0000\u0000\u017d\u0182\u0003\u0018\f\u0000\u017e\u017f"+
		"\u0005\u000b\u0000\u0000\u017f\u0181\u0003\u0018\f\u0000\u0180\u017e\u0001"+
		"\u0000\u0000\u0000\u0181\u0184\u0001\u0000\u0000\u0000\u0182\u0180\u0001"+
		"\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0186\u0001"+
		"\u0000\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0185\u017d\u0001"+
		"\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186\u0187\u0001"+
		"\u0000\u0000\u0000\u0187\u0188\u0005\u0006\u0000\u0000\u0188\u01c5\u0001"+
		"\u0000\u0000\u0000\u0189\u0192\u0005\u000e\u0000\u0000\u018a\u018f\u0003"+
		"\u0012\t\u0000\u018b\u018c\u0005\u0001\u0000\u0000\u018c\u018e\u0003\u0012"+
		"\t\u0000\u018d\u018b\u0001\u0000\u0000\u0000\u018e\u0191\u0001\u0000\u0000"+
		"\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000"+
		"\u0000\u0190\u0193\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000\u0000"+
		"\u0000\u0192\u018a\u0001\u0000\u0000\u0000\u0192\u0193\u0001\u0000\u0000"+
		"\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194\u01c5\u0005\u000f\u0000"+
		"\u0000\u0195\u0196\u0005.\u0000\u0000\u0196\u0197\u0003\u0012\t\u0000"+
		"\u0197\u0198\u0005;\u0000\u0000\u0198\u0199\u0003\u0012\t\u0000\u0199"+
		"\u019a\u0005(\u0000\u0000\u019a\u019b\u0003\u0012\t\u0007\u019b\u01c5"+
		"\u0001\u0000\u0000\u0000\u019c\u019d\u00054\u0000\u0000\u019d\u01a2\u0003"+
		"\u0014\n\u0000\u019e\u019f\u0005\u0001\u0000\u0000\u019f\u01a1\u0003\u0014"+
		"\n\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a1\u01a4\u0001\u0000\u0000"+
		"\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a5\u0001\u0000\u0000\u0000\u01a4\u01a2\u0001\u0000\u0000"+
		"\u0000\u01a5\u01a6\u0005/\u0000\u0000\u01a6\u01a7\u0003\u0012\t\u0005"+
		"\u01a7\u01c5\u0001\u0000\u0000\u0000\u01a8\u01a9\u00055\u0000\u0000\u01a9"+
		"\u01ae\u0003\u0014\n\u0000\u01aa\u01ab\u0005\u0001\u0000\u0000\u01ab\u01ad"+
		"\u0003\u0014\n\u0000\u01ac\u01aa\u0001\u0000\u0000\u0000\u01ad\u01b0\u0001"+
		"\u0000\u0000\u0000\u01ae\u01ac\u0001\u0000\u0000\u0000\u01ae\u01af\u0001"+
		"\u0000\u0000\u0000\u01af\u01b1\u0001\u0000\u0000\u0000\u01b0\u01ae\u0001"+
		"\u0000\u0000\u0000\u01b1\u01b2\u0005/\u0000\u0000\u01b2\u01b3\u0003\u0012"+
		"\t\u0004\u01b3\u01c5\u0001\u0000\u0000\u0000\u01b4\u01b5\u0005P\u0000"+
		"\u0000\u01b5\u01b6\u0005\u000e\u0000\u0000\u01b6\u01bb\u0005T\u0000\u0000"+
		"\u01b7\u01b8\u0005\u0001\u0000\u0000\u01b8\u01ba\u0005T\u0000\u0000\u01b9"+
		"\u01b7\u0001\u0000\u0000\u0000\u01ba\u01bd\u0001\u0000\u0000\u0000\u01bb"+
		"\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc"+
		"\u01be\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01be"+
		"\u01bf\u0005\u000f\u0000\u0000\u01bf\u01c5\u0003\u0012\t\u0003\u01c0\u01c1"+
		"\u0005\u0003\u0000\u0000\u01c1\u01c2\u0003\u0012\t\u0000\u01c2\u01c3\u0005"+
		"\u0004\u0000\u0000\u01c3\u01c5\u0001\u0000\u0000\u0000\u01c4\u00c6\u0001"+
		"\u0000\u0000\u0000\u01c4\u00c8\u0001\u0000\u0000\u0000\u01c4\u00c9\u0001"+
		"\u0000\u0000\u0000\u01c4\u00ca\u0001\u0000\u0000\u0000\u01c4\u00cb\u0001"+
		"\u0000\u0000\u0000\u01c4\u00cc\u0001\u0000\u0000\u0000\u01c4\u00cd\u0001"+
		"\u0000\u0000\u0000\u01c4\u00ce\u0001\u0000\u0000\u0000\u01c4\u00d3\u0001"+
		"\u0000\u0000\u0000\u01c4\u00de\u0001\u0000\u0000\u0000\u01c4\u00ef\u0001"+
		"\u0000\u0000\u0000\u01c4\u00f8\u0001\u0000\u0000\u0000\u01c4\u00fd\u0001"+
		"\u0000\u0000\u0000\u01c4\u0102\u0001\u0000\u0000\u0000\u01c4\u0109\u0001"+
		"\u0000\u0000\u0000\u01c4\u010e\u0001\u0000\u0000\u0000\u01c4\u0113\u0001"+
		"\u0000\u0000\u0000\u01c4\u0118\u0001\u0000\u0000\u0000\u01c4\u011d\u0001"+
		"\u0000\u0000\u0000\u01c4\u0122\u0001\u0000\u0000\u0000\u01c4\u0127\u0001"+
		"\u0000\u0000\u0000\u01c4\u012c\u0001\u0000\u0000\u0000\u01c4\u0131\u0001"+
		"\u0000\u0000\u0000\u01c4\u013a\u0001\u0000\u0000\u0000\u01c4\u0140\u0001"+
		"\u0000\u0000\u0000\u01c4\u0146\u0001\u0000\u0000\u0000\u01c4\u0148\u0001"+
		"\u0000\u0000\u0000\u01c4\u014a\u0001\u0000\u0000\u0000\u01c4\u015c\u0001"+
		"\u0000\u0000\u0000\u01c4\u0168\u0001\u0000\u0000\u0000\u01c4\u0173\u0001"+
		"\u0000\u0000\u0000\u01c4\u017a\u0001\u0000\u0000\u0000\u01c4\u0189\u0001"+
		"\u0000\u0000\u0000\u01c4\u0195\u0001\u0000\u0000\u0000\u01c4\u019c\u0001"+
		"\u0000\u0000\u0000\u01c4\u01a8\u0001\u0000\u0000\u0000\u01c4\u01b4\u0001"+
		"\u0000\u0000\u0000\u01c4\u01c0\u0001\u0000\u0000\u0000\u01c5\u021a\u0001"+
		"\u0000\u0000\u0000\u01c6\u01c7\n\u001e\u0000\u0000\u01c7\u01c8\u0005\u0018"+
		"\u0000\u0000\u01c8\u0219\u0003\u0012\t\u001f\u01c9\u01ca\n\u001d\u0000"+
		"\u0000\u01ca\u01cb\u0005\u0019\u0000\u0000\u01cb\u0219\u0003\u0012\t\u001e"+
		"\u01cc\u01cd\n\u001c\u0000\u0000\u01cd\u01ce\u0005$\u0000\u0000\u01ce"+
		"\u0219\u0003\u0012\t\u001d\u01cf\u01d0\n\u0019\u0000\u0000\u01d0\u01d1"+
		"\u0005\u0016\u0000\u0000\u01d1\u0219\u0003\u0012\t\u001a\u01d2\u01d3\n"+
		"\u0018\u0000\u0000\u01d3\u01d4\u0005\u0017\u0000\u0000\u01d4\u0219\u0003"+
		"\u0012\t\u0019\u01d5\u01d6\n\u0017\u0000\u0000\u01d6\u01d7\u00058\u0000"+
		"\u0000\u01d7\u0219\u0003\u0012\t\u0018\u01d8\u01d9\n\u000e\u0000\u0000"+
		"\u01d9\u01da\u0005\u0010\u0000\u0000\u01da\u0219\u0003\u0012\t\u000f\u01db"+
		"\u01dc\n\r\u0000\u0000\u01dc\u01dd\u0005\u0011\u0000\u0000\u01dd\u0219"+
		"\u0003\u0012\t\u000e\u01de\u01df\n\f\u0000\u0000\u01df\u01e0\u0005\u0012"+
		"\u0000\u0000\u01e0\u0219\u0003\u0012\t\r\u01e1\u01e2\n\u000b\u0000\u0000"+
		"\u01e2\u01e3\u0005\u0013\u0000\u0000\u01e3\u0219\u0003\u0012\t\f\u01e4"+
		"\u01e5\n\n\u0000\u0000\u01e5\u01e6\u0005\u0014\u0000\u0000\u01e6\u0219"+
		"\u0003\u0012\t\u000b\u01e7\u01e8\n\t\u0000\u0000\u01e8\u01e9\u0005\u0015"+
		"\u0000\u0000\u01e9\u0219\u0003\u0012\t\n\u01ea\u01eb\n\b\u0000\u0000\u01eb"+
		"\u01ec\u0005F\u0000\u0000\u01ec\u0219\u0003\u0012\t\t\u01ed\u01ee\n\u0006"+
		"\u0000\u0000\u01ee\u01ef\u0005\u0002\u0000\u0000\u01ef\u0219\u0003\u0012"+
		"\t\u0007\u01f0\u01f1\n;\u0000\u0000\u01f1\u01f2\u0005\u001a\u0000\u0000"+
		"\u01f2\u0219\u0005T\u0000\u0000\u01f3\u01f4\n:\u0000\u0000\u01f4\u01f5"+
		"\u0005\u001a\u0000\u0000\u01f5\u0219\u0005W\u0000\u0000\u01f6\u01f7\n"+
		" \u0000\u0000\u01f7\u0200\u0005\u0003\u0000\u0000\u01f8\u01fd\u0003\u0012"+
		"\t\u0000\u01f9\u01fa\u0005\u0001\u0000\u0000\u01fa\u01fc\u0003\u0012\t"+
		"\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fc\u01ff\u0001\u0000\u0000"+
		"\u0000\u01fd\u01fb\u0001\u0000\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000"+
		"\u0000\u01fe\u0201\u0001\u0000\u0000\u0000\u01ff\u01fd\u0001\u0000\u0000"+
		"\u0000\u0200\u01f8\u0001\u0000\u0000\u0000\u0200\u0201\u0001\u0000\u0000"+
		"\u0000\u0201\u0202\u0001\u0000\u0000\u0000\u0202\u0219\u0005\u0004\u0000"+
		"\u0000\u0203\u0204\n\u001f\u0000\u0000\u0204\u0205\u0005\u000e\u0000\u0000"+
		"\u0205\u020a\u0003\u001e\u000f\u0000\u0206\u0207\u0005\u0001\u0000\u0000"+
		"\u0207\u0209\u0003\u001e\u000f\u0000\u0208\u0206\u0001\u0000\u0000\u0000"+
		"\u0209\u020c\u0001\u0000\u0000\u0000\u020a\u0208\u0001\u0000\u0000\u0000"+
		"\u020a\u020b\u0001\u0000\u0000\u0000\u020b\u020d\u0001\u0000\u0000\u0000"+
		"\u020c\u020a\u0001\u0000\u0000\u0000\u020d\u020e\u0005\u000f\u0000\u0000"+
		"\u020e\u0219\u0001\u0000\u0000\u0000\u020f\u0210\n\u0016\u0000\u0000\u0210"+
		"\u0211\u0005%\u0000\u0000\u0211\u0219\u0003\u001e\u000f\u0000\u0212\u0213"+
		"\n\u0015\u0000\u0000\u0213\u0214\u0005E\u0000\u0000\u0214\u0215\u0005"+
		"%\u0000\u0000\u0215\u0219\u0003\u001e\u000f\u0000\u0216\u0217\n\u0001"+
		"\u0000\u0000\u0217\u0219\u0005\u0002\u0000\u0000\u0218\u01c6\u0001\u0000"+
		"\u0000\u0000\u0218\u01c9\u0001\u0000\u0000\u0000\u0218\u01cc\u0001\u0000"+
		"\u0000\u0000\u0218\u01cf\u0001\u0000\u0000\u0000\u0218\u01d2\u0001\u0000"+
		"\u0000\u0000\u0218\u01d5\u0001\u0000\u0000\u0000\u0218\u01d8\u0001\u0000"+
		"\u0000\u0000\u0218\u01db\u0001\u0000\u0000\u0000\u0218\u01de\u0001\u0000"+
		"\u0000\u0000\u0218\u01e1\u0001\u0000\u0000\u0000\u0218\u01e4\u0001\u0000"+
		"\u0000\u0000\u0218\u01e7\u0001\u0000\u0000\u0000\u0218\u01ea\u0001\u0000"+
		"\u0000\u0000\u0218\u01ed\u0001\u0000\u0000\u0000\u0218\u01f0\u0001\u0000"+
		"\u0000\u0000\u0218\u01f3\u0001\u0000\u0000\u0000\u0218\u01f6\u0001\u0000"+
		"\u0000\u0000\u0218\u0203\u0001\u0000\u0000\u0000\u0218\u020f\u0001\u0000"+
		"\u0000\u0000\u0218\u0212\u0001\u0000\u0000\u0000\u0218\u0216\u0001\u0000"+
		"\u0000\u0000\u0219\u021c\u0001\u0000\u0000\u0000\u021a\u0218\u0001\u0000"+
		"\u0000\u0000\u021a\u021b\u0001\u0000\u0000\u0000\u021b\u0013\u0001\u0000"+
		"\u0000\u0000\u021c\u021a\u0001\u0000\u0000\u0000\u021d\u021e\u0003\u001a"+
		"\r\u0000\u021e\u021f\u0005\u0007\u0000\u0000\u021f\u0220\u0003\u0012\t"+
		"\u0000\u0220\u0015\u0001\u0000\u0000\u0000\u0221\u0222\u0005T\u0000\u0000"+
		"\u0222\u0223\u0005\u0007\u0000\u0000\u0223\u0224\u0003\u0012\t\u0000\u0224"+
		"\u0017\u0001\u0000\u0000\u0000\u0225\u0226\u0003\u001a\r\u0000\u0226\u0227"+
		"\u0005\n\u0000\u0000\u0227\u0228\u0003\u0012\t\u0000\u0228\u0019\u0001"+
		"\u0000\u0000\u0000\u0229\u022a\u0006\r\uffff\uffff\u0000\u022a\u022b\u0005"+
		"\f\u0000\u0000\u022b\u022e\u0005T\u0000\u0000\u022c\u022d\u0005\u0007"+
		"\u0000\u0000\u022d\u022f\u0003\u001a\r\u0000\u022e\u022c\u0001\u0000\u0000"+
		"\u0000\u022e\u022f\u0001\u0000\u0000\u0000\u022f\u0230\u0001\u0000\u0000"+
		"\u0000\u0230\u0275\u0005\r\u0000\u0000\u0231\u0232\u00050\u0000\u0000"+
		"\u0232\u0233\u0005\u0003\u0000\u0000\u0233\u0234\u0003\u001a\r\u0000\u0234"+
		"\u0235\u0005\u0004\u0000\u0000\u0235\u0275\u0001\u0000\u0000\u0000\u0236"+
		"\u0237\u00052\u0000\u0000\u0237\u0238\u0005\u0003\u0000\u0000\u0238\u0239"+
		"\u0003\u001a\r\u0000\u0239\u023a\u0005\u0004\u0000\u0000\u023a\u0275\u0001"+
		"\u0000\u0000\u0000\u023b\u0244\u0005\u0005\u0000\u0000\u023c\u0241\u0003"+
		"\u001a\r\u0000\u023d\u023e\u0005\u0001\u0000\u0000\u023e\u0240\u0003\u001a"+
		"\r\u0000\u023f\u023d\u0001\u0000\u0000\u0000\u0240\u0243\u0001\u0000\u0000"+
		"\u0000\u0241\u023f\u0001\u0000\u0000\u0000\u0241\u0242\u0001\u0000\u0000"+
		"\u0000\u0242\u0245\u0001\u0000\u0000\u0000\u0243\u0241\u0001\u0000\u0000"+
		"\u0000\u0244\u023c\u0001\u0000\u0000\u0000\u0244\u0245\u0001\u0000\u0000"+
		"\u0000\u0245\u0246\u0001\u0000\u0000\u0000\u0246\u0275\u0005\u0006\u0000"+
		"\u0000\u0247\u0250\u0005\u0005\u0000\u0000\u0248\u024d\u0003\u001c\u000e"+
		"\u0000\u0249\u024a\u0005\u0001\u0000\u0000\u024a\u024c\u0003\u001c\u000e"+
		"\u0000\u024b\u0249\u0001\u0000\u0000\u0000\u024c\u024f\u0001\u0000\u0000"+
		"\u0000\u024d\u024b\u0001\u0000\u0000\u0000\u024d\u024e\u0001\u0000\u0000"+
		"\u0000\u024e\u0251\u0001\u0000\u0000\u0000\u024f\u024d\u0001\u0000\u0000"+
		"\u0000\u0250\u0248\u0001\u0000\u0000\u0000\u0250\u0251\u0001\u0000\u0000"+
		"\u0000\u0251\u0252\u0001\u0000\u0000\u0000\u0252\u0275\u0005\u0006\u0000"+
		"\u0000\u0253\u025c\u0005\u000e\u0000\u0000\u0254\u0259\u0003\u001a\r\u0000"+
		"\u0255\u0256\u0005\u0001\u0000\u0000\u0256\u0258\u0003\u001a\r\u0000\u0257"+
		"\u0255\u0001\u0000\u0000\u0000\u0258\u025b\u0001\u0000\u0000\u0000\u0259"+
		"\u0257\u0001\u0000\u0000\u0000\u0259\u025a\u0001\u0000\u0000\u0000\u025a"+
		"\u025d\u0001\u0000\u0000\u0000\u025b\u0259\u0001\u0000\u0000\u0000\u025c"+
		"\u0254\u0001\u0000\u0000\u0000\u025c\u025d\u0001\u0000\u0000\u0000\u025d"+
		"\u025e\u0001\u0000\u0000\u0000\u025e\u0275\u0005\u000f\u0000\u0000\u025f"+
		"\u0260\u0005&\u0000\u0000\u0260\u0261\u0005\u0003\u0000\u0000\u0261\u0262"+
		"\u0003\u001a\r\u0000\u0262\u0263\u0005\u0001\u0000\u0000\u0263\u0264\u0003"+
		"\u001a\r\u0000\u0264\u0265\u0005\u0004\u0000\u0000\u0265\u0275\u0001\u0000"+
		"\u0000\u0000\u0266\u0275\u0005*\u0000\u0000\u0267\u0275\u0005=\u0000\u0000"+
		"\u0268\u0275\u0005@\u0000\u0000\u0269\u0275\u0005W\u0000\u0000\u026a\u026b"+
		"\u0005:\u0000\u0000\u026b\u026c\u0005\u0003\u0000\u0000\u026c\u026d\u0003"+
		"\u001a\r\u0000\u026d\u026e\u0005\u0004\u0000\u0000\u026e\u0275\u0001\u0000"+
		"\u0000\u0000\u026f\u0275\u0005T\u0000\u0000\u0270\u0271\u0005\u0003\u0000"+
		"\u0000\u0271\u0272\u0003\u001a\r\u0000\u0272\u0273\u0005\u0004\u0000\u0000"+
		"\u0273\u0275\u0001\u0000\u0000\u0000\u0274\u0229\u0001\u0000\u0000\u0000"+
		"\u0274\u0231\u0001\u0000\u0000\u0000\u0274\u0236\u0001\u0000\u0000\u0000"+
		"\u0274\u023b\u0001\u0000\u0000\u0000\u0274\u0247\u0001\u0000\u0000\u0000"+
		"\u0274\u0253\u0001\u0000\u0000\u0000\u0274\u025f\u0001\u0000\u0000\u0000"+
		"\u0274\u0266\u0001\u0000\u0000\u0000\u0274\u0267\u0001\u0000\u0000\u0000"+
		"\u0274\u0268\u0001\u0000\u0000\u0000\u0274\u0269\u0001\u0000\u0000\u0000"+
		"\u0274\u026a\u0001\u0000\u0000\u0000\u0274\u026f\u0001\u0000\u0000\u0000"+
		"\u0274\u0270\u0001\u0000\u0000\u0000\u0275\u027f\u0001\u0000\u0000\u0000"+
		"\u0276\u0277\n\u0003\u0000\u0000\u0277\u0278\u0005%\u0000\u0000\u0278"+
		"\u027e\u0003\u001e\u000f\u0000\u0279\u027a\n\u0002\u0000\u0000\u027a\u027b"+
		"\u0005E\u0000\u0000\u027b\u027c\u0005%\u0000\u0000\u027c\u027e\u0003\u001e"+
		"\u000f\u0000\u027d\u0276\u0001\u0000\u0000\u0000\u027d\u0279\u0001\u0000"+
		"\u0000\u0000\u027e\u0281\u0001\u0000\u0000\u0000\u027f\u027d\u0001\u0000"+
		"\u0000\u0000\u027f\u0280\u0001\u0000\u0000\u0000\u0280\u001b\u0001\u0000"+
		"\u0000\u0000\u0281\u027f\u0001\u0000\u0000\u0000\u0282\u0283\u0005T\u0000"+
		"\u0000\u0283\u0284\u0005\u0007\u0000\u0000\u0284\u0285\u0003\u001a\r\u0000"+
		"\u0285\u001d\u0001\u0000\u0000\u0000\u0286\u0287\u0006\u000f\uffff\uffff"+
		"\u0000\u0287\u02d8\u0005!\u0000\u0000\u0288\u02d8\u0005\"\u0000\u0000"+
		"\u0289\u028a\u0005G\u0000\u0000\u028a\u02d8\u0003\u001e\u000f\u000f\u028b"+
		"\u028c\u0005,\u0000\u0000\u028c\u0295\u0005\u0003\u0000\u0000\u028d\u0292"+
		"\u0003\u001e\u000f\u0000\u028e\u028f\u0005\u0001\u0000\u0000\u028f\u0291"+
		"\u0003\u001e\u000f\u0000\u0290\u028e\u0001\u0000\u0000\u0000\u0291\u0294"+
		"\u0001\u0000\u0000\u0000\u0292\u0290\u0001\u0000\u0000\u0000\u0292\u0293"+
		"\u0001\u0000\u0000\u0000\u0293\u0296\u0001\u0000\u0000\u0000\u0294\u0292"+
		"\u0001\u0000\u0000\u0000\u0295\u028d\u0001\u0000\u0000\u0000\u0295\u0296"+
		"\u0001\u0000\u0000\u0000\u0296\u0297\u0001\u0000\u0000\u0000\u0297\u0298"+
		"\u0005\u0004\u0000\u0000\u0298\u0299\u0005\t\u0000\u0000\u0299\u02d8\u0003"+
		"\u001e\u000f\r\u029a\u029e\u0005Q\u0000\u0000\u029b\u029d\u0005T\u0000"+
		"\u0000\u029c\u029b\u0001\u0000\u0000\u0000\u029d\u02a0\u0001\u0000\u0000"+
		"\u0000\u029e\u029c\u0001\u0000\u0000\u0000\u029e\u029f\u0001\u0000\u0000"+
		"\u0000\u029f\u02a1\u0001\u0000\u0000\u0000\u02a0\u029e\u0001\u0000\u0000"+
		"\u0000\u02a1\u02a2\u0005\u001a\u0000\u0000\u02a2\u02d8\u0003\u001e\u000f"+
		"\f\u02a3\u02a4\u0005B\u0000\u0000\u02a4\u02a5\u0005T\u0000\u0000\u02a5"+
		"\u02a6\u0005\u001a\u0000\u0000\u02a6\u02d8\u0003\u001e\u000f\u000b\u02a7"+
		"\u02b0\u0005\u0005\u0000\u0000\u02a8\u02ad\u0003\u001e\u000f\u0000\u02a9"+
		"\u02aa\u0005\u0001\u0000\u0000\u02aa\u02ac\u0003\u001e\u000f\u0000\u02ab"+
		"\u02a9\u0001\u0000\u0000\u0000\u02ac\u02af\u0001\u0000\u0000\u0000\u02ad"+
		"\u02ab\u0001\u0000\u0000\u0000\u02ad\u02ae\u0001\u0000\u0000\u0000\u02ae"+
		"\u02b1\u0001\u0000\u0000\u0000\u02af\u02ad\u0001\u0000\u0000\u0000\u02b0"+
		"\u02a8\u0001\u0000\u0000\u0000\u02b0\u02b1\u0001\u0000\u0000\u0000\u02b1"+
		"\u02b2\u0001\u0000\u0000\u0000\u02b2\u02d8\u0005\u0006\u0000\u0000\u02b3"+
		"\u02b4\u0005\u0005\u0000\u0000\u02b4\u02b9\u0003 \u0010\u0000\u02b5\u02b6"+
		"\u0005\u0001\u0000\u0000\u02b6\u02b8\u0003 \u0010\u0000\u02b7\u02b5\u0001"+
		"\u0000\u0000\u0000\u02b8\u02bb\u0001\u0000\u0000\u0000\u02b9\u02b7\u0001"+
		"\u0000\u0000\u0000\u02b9\u02ba\u0001\u0000\u0000\u0000\u02ba\u02bc\u0001"+
		"\u0000\u0000\u0000\u02bb\u02b9\u0001\u0000\u0000\u0000\u02bc\u02bd\u0005"+
		"\u0006\u0000\u0000\u02bd\u02d8\u0001\u0000\u0000\u0000\u02be\u02c7\u0005"+
		"\f\u0000\u0000\u02bf\u02c4\u0003\"\u0011\u0000\u02c0\u02c1\u0005\u0001"+
		"\u0000\u0000\u02c1\u02c3\u0003\"\u0011\u0000\u02c2\u02c0\u0001\u0000\u0000"+
		"\u0000\u02c3\u02c6\u0001\u0000\u0000\u0000\u02c4\u02c2\u0001\u0000\u0000"+
		"\u0000\u02c4\u02c5\u0001\u0000\u0000\u0000\u02c5\u02c8\u0001\u0000\u0000"+
		"\u0000\u02c6\u02c4\u0001\u0000\u0000\u0000\u02c7\u02bf\u0001\u0000\u0000"+
		"\u0000\u02c7\u02c8\u0001\u0000\u0000\u0000\u02c8\u02c9\u0001\u0000\u0000"+
		"\u0000\u02c9\u02d8\u0005\r\u0000\u0000\u02ca\u02cb\u0005\u000e\u0000\u0000"+
		"\u02cb\u02cc\u0003\u001e\u000f\u0000\u02cc\u02cd\u0005\u000f\u0000\u0000"+
		"\u02cd\u02d8\u0001\u0000\u0000\u0000\u02ce\u02d8\u0005#\u0000\u0000\u02cf"+
		"\u02d8\u0005M\u0000\u0000\u02d0\u02d8\u0005N\u0000\u0000\u02d1\u02d8\u0005"+
		"O\u0000\u0000\u02d2\u02d8\u0005T\u0000\u0000\u02d3\u02d4\u0005\u0003\u0000"+
		"\u0000\u02d4\u02d5\u0003\u001e\u000f\u0000\u02d5\u02d6\u0005\u0004\u0000"+
		"\u0000\u02d6\u02d8\u0001\u0000\u0000\u0000\u02d7\u0286\u0001\u0000\u0000"+
		"\u0000\u02d7\u0288\u0001\u0000\u0000\u0000\u02d7\u0289\u0001\u0000\u0000"+
		"\u0000\u02d7\u028b\u0001\u0000\u0000\u0000\u02d7\u029a\u0001\u0000\u0000"+
		"\u0000\u02d7\u02a3\u0001\u0000\u0000\u0000\u02d7\u02a7\u0001\u0000\u0000"+
		"\u0000\u02d7\u02b3\u0001\u0000\u0000\u0000\u02d7\u02be\u0001\u0000\u0000"+
		"\u0000\u02d7\u02ca\u0001\u0000\u0000\u0000\u02d7\u02ce\u0001\u0000\u0000"+
		"\u0000\u02d7\u02cf\u0001\u0000\u0000\u0000\u02d7\u02d0\u0001\u0000\u0000"+
		"\u0000\u02d7\u02d1\u0001\u0000\u0000\u0000\u02d7\u02d2\u0001\u0000\u0000"+
		"\u0000\u02d7\u02d3\u0001\u0000\u0000\u0000\u02d8\u02de\u0001\u0000\u0000"+
		"\u0000\u02d9\u02da\n\u000e\u0000\u0000\u02da\u02db\u0005\u0016\u0000\u0000"+
		"\u02db\u02dd\u0003\u001e\u000f\u000f\u02dc\u02d9\u0001\u0000\u0000\u0000"+
		"\u02dd\u02e0\u0001\u0000\u0000\u0000\u02de\u02dc\u0001\u0000\u0000\u0000"+
		"\u02de\u02df\u0001\u0000\u0000\u0000\u02df\u001f\u0001\u0000\u0000\u0000"+
		"\u02e0\u02de\u0001\u0000\u0000\u0000\u02e1\u02e2\u0005T\u0000\u0000\u02e2"+
		"\u02e3\u0005\b\u0000\u0000\u02e3\u02e4\u0003\u001e\u000f\u0000\u02e4!"+
		"\u0001\u0000\u0000\u0000\u02e5\u02e8\u0005T\u0000\u0000\u02e6\u02e7\u0005"+
		"\b\u0000\u0000\u02e7\u02e9\u0003\u001e\u000f\u0000\u02e8\u02e6\u0001\u0000"+
		"\u0000\u0000\u02e8\u02e9\u0001\u0000\u0000\u0000\u02e9#\u0001\u0000\u0000"+
		"\u0000;17EMX[`hkq{\u0087\u0091\u0094\u0099\u00a1\u00a4\u00aa\u00be\u0151"+
		"\u0154\u0162\u0165\u016e\u0177\u0182\u0185\u018f\u0192\u01a2\u01ae\u01bb"+
		"\u01c4\u01fd\u0200\u020a\u0218\u021a\u022e\u0241\u0244\u024d\u0250\u0259"+
		"\u025c\u0274\u027d\u027f\u0292\u0295\u029e\u02ad\u02b0\u02b9\u02c4\u02c7"+
		"\u02d7\u02de\u02e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}