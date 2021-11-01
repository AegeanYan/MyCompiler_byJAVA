// Generated from /Users/luohaotian/IdeaProjects/compiler/src/Mx_lite.g4 by ANTLR 4.9.1

package Parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Mx_liteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, Boolconstant=3, Nullconstant=4, StringConstant=5, Int=6, 
		Bool=7, Void=8, True=9, False=10, Null=11, String=12, If=13, Else=14, 
		Return=15, Class=16, While=17, For=18, Break=19, Continue=20, New=21, 
		This=22, Dot=23, LeftParen=24, RightParen=25, LeftBracket=26, RightBracket=27, 
		LeftBrace=28, RightBrace=29, Less=30, LessEqual=31, Greater=32, GreaterEqual=33, 
		LeftShift=34, RightShift=35, Plus=36, SelfPlus=37, Minus=38, SelfMinus=39, 
		Mul=40, Div=41, Mod=42, And=43, Or=44, AndAnd=45, OrOr=46, Caret=47, Not=48, 
		Tilde=49, Question=50, Colon=51, Semi=52, Comma=53, Assign=54, Equal=55, 
		NotEqual=56, BackSlash=57, DbQuotation=58, Identifier=59, DecimalInteger=60, 
		Whitespace=61, Newline=62, BlockComment=63, LineComment=64;
	public static final int
		RULE_program = 0, RULE_subProgram = 1, RULE_functionDef = 2, RULE_lambdaDef = 3, 
		RULE_functionparameterDef = 4, RULE_expressionList = 5, RULE_suite = 6, 
		RULE_statement = 7, RULE_suiteStmt = 8, RULE_expressionStmt = 9, RULE_controlStmt = 10, 
		RULE_primeStmt = 11, RULE_declarationStmt = 12, RULE_classDecl = 13, RULE_subClassDecl = 14, 
		RULE_expression = 15, RULE_varDef = 16, RULE_varDeclaration = 17, RULE_creator = 18, 
		RULE_returnType = 19, RULE_varType = 20, RULE_arrayType = 21, RULE_builtinType = 22, 
		RULE_constant = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "subProgram", "functionDef", "lambdaDef", "functionparameterDef", 
			"expressionList", "suite", "statement", "suiteStmt", "expressionStmt", 
			"controlStmt", "primeStmt", "declarationStmt", "classDecl", "subClassDecl", 
			"expression", "varDef", "varDeclaration", "creator", "returnType", "varType", 
			"arrayType", "builtinType", "constant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'[&]'", "'->'", null, null, null, "'int'", "'bool'", "'void'", 
			"'true'", "'false'", "'null'", "'string'", "'if'", "'else'", "'return'", 
			"'class'", "'while'", "'for'", "'break'", "'continue'", "'new'", "'this'", 
			"'.'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'<='", "'>'", 
			"'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", "'*'", "'/'", "'%'", 
			"'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", "'?'", "':'", "';'", 
			"','", "'='", "'=='", "'!='", "'\\\\'", "'\\\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "Boolconstant", "Nullconstant", "StringConstant", "Int", 
			"Bool", "Void", "True", "False", "Null", "String", "If", "Else", "Return", 
			"Class", "While", "For", "Break", "Continue", "New", "This", "Dot", "LeftParen", 
			"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
			"Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", "RightShift", 
			"Plus", "SelfPlus", "Minus", "SelfMinus", "Mul", "Div", "Mod", "And", 
			"Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
			"Semi", "Comma", "Assign", "Equal", "NotEqual", "BackSlash", "DbQuotation", 
			"Identifier", "DecimalInteger", "Whitespace", "Newline", "BlockComment", 
			"LineComment"
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
	public String getGrammarFileName() { return "Mx_lite.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Mx_liteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<SubProgramContext> subProgram() {
			return getRuleContexts(SubProgramContext.class);
		}
		public SubProgramContext subProgram(int i) {
			return getRuleContext(SubProgramContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << Void) | (1L << String) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				{
				setState(48);
				subProgram();
				}
				}
				setState(53);
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

	public static class SubProgramContext extends ParserRuleContext {
		public DeclarationStmtContext declarationStmt() {
			return getRuleContext(DeclarationStmtContext.class,0);
		}
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public SubProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterSubProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitSubProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitSubProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubProgramContext subProgram() throws RecognitionException {
		SubProgramContext _localctx = new SubProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_subProgram);
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				declarationStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				functionDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				classDecl();
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

	public static class FunctionDefContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Mx_liteParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(Mx_liteParser.LeftParen, 0); }
		public FunctionparameterDefContext functionparameterDef() {
			return getRuleContext(FunctionparameterDefContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(Mx_liteParser.RightParen, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitFunctionDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(59);
				returnType();
				}
				break;
			}
			setState(62);
			match(Identifier);
			setState(63);
			match(LeftParen);
			setState(64);
			functionparameterDef();
			setState(65);
			match(RightParen);
			setState(66);
			suite();
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

	public static class LambdaDefContext extends ParserRuleContext {
		public List<TerminalNode> LeftParen() { return getTokens(Mx_liteParser.LeftParen); }
		public TerminalNode LeftParen(int i) {
			return getToken(Mx_liteParser.LeftParen, i);
		}
		public FunctionparameterDefContext functionparameterDef() {
			return getRuleContext(FunctionparameterDefContext.class,0);
		}
		public List<TerminalNode> RightParen() { return getTokens(Mx_liteParser.RightParen); }
		public TerminalNode RightParen(int i) {
			return getToken(Mx_liteParser.RightParen, i);
		}
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public LambdaDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterLambdaDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitLambdaDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitLambdaDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaDefContext lambdaDef() throws RecognitionException {
		LambdaDefContext _localctx = new LambdaDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lambdaDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__0);
			setState(69);
			match(LeftParen);
			setState(70);
			functionparameterDef();
			setState(71);
			match(RightParen);
			setState(72);
			match(T__1);
			setState(73);
			suite();
			setState(74);
			match(LeftParen);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
				{
				setState(75);
				expressionList();
				}
			}

			setState(78);
			match(RightParen);
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

	public static class FunctionparameterDefContext extends ParserRuleContext {
		public List<VarTypeContext> varType() {
			return getRuleContexts(VarTypeContext.class);
		}
		public VarTypeContext varType(int i) {
			return getRuleContext(VarTypeContext.class,i);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Mx_liteParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Mx_liteParser.Comma, i);
		}
		public FunctionparameterDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionparameterDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterFunctionparameterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitFunctionparameterDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitFunctionparameterDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionparameterDefContext functionparameterDef() throws RecognitionException {
		FunctionparameterDefContext _localctx = new FunctionparameterDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionparameterDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(80);
				varType();
				setState(81);
				varDeclaration();
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(82);
					match(Comma);
					setState(83);
					varType();
					setState(84);
					varDeclaration();
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Mx_liteParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Mx_liteParser.Comma, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			expression(0);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(94);
				match(Comma);
				setState(95);
				expression(0);
				}
				}
				setState(100);
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

	public static class SuiteContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(Mx_liteParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(Mx_liteParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitSuite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(LeftBrace);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << If) | (1L << Return) | (1L << While) | (1L << For) | (1L << Break) | (1L << Continue) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Semi) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
				{
				{
				setState(102);
				statement();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			match(RightBrace);
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

	public static class StatementContext extends ParserRuleContext {
		public SuiteStmtContext suiteStmt() {
			return getRuleContext(SuiteStmtContext.class,0);
		}
		public PrimeStmtContext primeStmt() {
			return getRuleContext(PrimeStmtContext.class,0);
		}
		public ControlStmtContext controlStmt() {
			return getRuleContext(ControlStmtContext.class,0);
		}
		public ExpressionStmtContext expressionStmt() {
			return getRuleContext(ExpressionStmtContext.class,0);
		}
		public TerminalNode Semi() { return getToken(Mx_liteParser.Semi, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				suiteStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				primeStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				controlStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				expressionStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(114);
				match(Semi);
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

	public static class SuiteStmtContext extends ParserRuleContext {
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public SuiteStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suiteStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterSuiteStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitSuiteStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitSuiteStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteStmtContext suiteStmt() throws RecognitionException {
		SuiteStmtContext _localctx = new SuiteStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_suiteStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			suite();
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

	public static class ExpressionStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(Mx_liteParser.Semi, 0); }
		public ExpressionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterExpressionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitExpressionStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitExpressionStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStmtContext expressionStmt() throws RecognitionException {
		ExpressionStmtContext _localctx = new ExpressionStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			expression(0);
			setState(120);
			match(Semi);
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

	public static class ControlStmtContext extends ParserRuleContext {
		public ControlStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlStmt; }
	 
		public ControlStmtContext() { }
		public void copyFrom(ControlStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ContinueStmtContext extends ControlStmtContext {
		public TerminalNode Continue() { return getToken(Mx_liteParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(Mx_liteParser.Semi, 0); }
		public ContinueStmtContext(ControlStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterContinueStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitContinueStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitContinueStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStmtContext extends ControlStmtContext {
		public ExpressionContext cond;
		public StatementContext trueStmt;
		public StatementContext falseStmt;
		public TerminalNode If() { return getToken(Mx_liteParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(Mx_liteParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(Mx_liteParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(Mx_liteParser.Else, 0); }
		public IfStmtContext(ControlStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtContext extends ControlStmtContext {
		public TerminalNode While() { return getToken(Mx_liteParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(Mx_liteParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(Mx_liteParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(ControlStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStmtContext extends ControlStmtContext {
		public TerminalNode Break() { return getToken(Mx_liteParser.Break, 0); }
		public TerminalNode Semi() { return getToken(Mx_liteParser.Semi, 0); }
		public BreakStmtContext(ControlStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitBreakStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmtContext extends ControlStmtContext {
		public TerminalNode Return() { return getToken(Mx_liteParser.Return, 0); }
		public TerminalNode Semi() { return getToken(Mx_liteParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(ControlStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStmtContext extends ControlStmtContext {
		public ExpressionContext init;
		public ExpressionContext cond;
		public ExpressionContext step;
		public TerminalNode For() { return getToken(Mx_liteParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(Mx_liteParser.LeftParen, 0); }
		public List<TerminalNode> Semi() { return getTokens(Mx_liteParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(Mx_liteParser.Semi, i);
		}
		public TerminalNode RightParen() { return getToken(Mx_liteParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStmtContext(ControlStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlStmtContext controlStmt() throws RecognitionException {
		ControlStmtContext _localctx = new ControlStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_controlStmt);
		int _la;
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(If);
				setState(123);
				match(LeftParen);
				setState(124);
				((IfStmtContext)_localctx).cond = expression(0);
				setState(125);
				match(RightParen);
				setState(126);
				((IfStmtContext)_localctx).trueStmt = statement();
				setState(129);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(127);
					match(Else);
					setState(128);
					((IfStmtContext)_localctx).falseStmt = statement();
					}
					break;
				}
				}
				break;
			case Return:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(Return);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
					{
					setState(132);
					expression(0);
					}
				}

				setState(135);
				match(Semi);
				}
				break;
			case For:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(For);
				setState(137);
				match(LeftParen);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
					{
					setState(138);
					((ForStmtContext)_localctx).init = expression(0);
					}
				}

				setState(141);
				match(Semi);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
					{
					setState(142);
					((ForStmtContext)_localctx).cond = expression(0);
					}
				}

				setState(145);
				match(Semi);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
					{
					setState(146);
					((ForStmtContext)_localctx).step = expression(0);
					}
				}

				setState(149);
				match(RightParen);
				setState(150);
				statement();
				}
				break;
			case While:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				match(While);
				setState(152);
				match(LeftParen);
				setState(153);
				expression(0);
				setState(154);
				match(RightParen);
				setState(155);
				statement();
				}
				break;
			case Continue:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(157);
				match(Continue);
				setState(158);
				match(Semi);
				}
				break;
			case Break:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(159);
				match(Break);
				setState(160);
				match(Semi);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PrimeStmtContext extends ParserRuleContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public TerminalNode Semi() { return getToken(Mx_liteParser.Semi, 0); }
		public PrimeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterPrimeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitPrimeStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitPrimeStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimeStmtContext primeStmt() throws RecognitionException {
		PrimeStmtContext _localctx = new PrimeStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_primeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			varDef();
			setState(164);
			match(Semi);
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

	public static class DeclarationStmtContext extends ParserRuleContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public TerminalNode Semi() { return getToken(Mx_liteParser.Semi, 0); }
		public DeclarationStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterDeclarationStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitDeclarationStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitDeclarationStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationStmtContext declarationStmt() throws RecognitionException {
		DeclarationStmtContext _localctx = new DeclarationStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declarationStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			varDef();
			setState(167);
			match(Semi);
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

	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(Mx_liteParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(Mx_liteParser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(Mx_liteParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(Mx_liteParser.RightBrace, 0); }
		public TerminalNode Semi() { return getToken(Mx_liteParser.Semi, 0); }
		public List<SubClassDeclContext> subClassDecl() {
			return getRuleContexts(SubClassDeclContext.class);
		}
		public SubClassDeclContext subClassDecl(int i) {
			return getRuleContext(SubClassDeclContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(Class);
			setState(170);
			match(Identifier);
			setState(171);
			match(LeftBrace);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << Void) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				{
				setState(172);
				subClassDecl();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
			match(RightBrace);
			setState(179);
			match(Semi);
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

	public static class SubClassDeclContext extends ParserRuleContext {
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public DeclarationStmtContext declarationStmt() {
			return getRuleContext(DeclarationStmtContext.class,0);
		}
		public SubClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subClassDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterSubClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitSubClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitSubClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubClassDeclContext subClassDecl() throws RecognitionException {
		SubClassDeclContext _localctx = new SubClassDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_subClassDecl);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				functionDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				declarationStmt();
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstExprContext extends ExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterConstExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitConstExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitConstExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(Mx_liteParser.Identifier, 0); }
		public IdExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubExprContext extends ExpressionContext {
		public TerminalNode LeftParen() { return getToken(Mx_liteParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(Mx_liteParser.RightParen, 0); }
		public SubExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Mul() { return getToken(Mx_liteParser.Mul, 0); }
		public TerminalNode Div() { return getToken(Mx_liteParser.Div, 0); }
		public TerminalNode Mod() { return getToken(Mx_liteParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(Mx_liteParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(Mx_liteParser.Minus, 0); }
		public TerminalNode LeftShift() { return getToken(Mx_liteParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(Mx_liteParser.RightShift, 0); }
		public TerminalNode Less() { return getToken(Mx_liteParser.Less, 0); }
		public TerminalNode LessEqual() { return getToken(Mx_liteParser.LessEqual, 0); }
		public TerminalNode Greater() { return getToken(Mx_liteParser.Greater, 0); }
		public TerminalNode GreaterEqual() { return getToken(Mx_liteParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(Mx_liteParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(Mx_liteParser.NotEqual, 0); }
		public TerminalNode And() { return getToken(Mx_liteParser.And, 0); }
		public TerminalNode Caret() { return getToken(Mx_liteParser.Caret, 0); }
		public TerminalNode Or() { return getToken(Mx_liteParser.Or, 0); }
		public TerminalNode AndAnd() { return getToken(Mx_liteParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(Mx_liteParser.OrOr, 0); }
		public TerminalNode Assign() { return getToken(Mx_liteParser.Assign, 0); }
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Plus() { return getToken(Mx_liteParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(Mx_liteParser.Minus, 0); }
		public TerminalNode Not() { return getToken(Mx_liteParser.Not, 0); }
		public TerminalNode Tilde() { return getToken(Mx_liteParser.Tilde, 0); }
		public UnaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexExprContext extends ExpressionContext {
		public ExpressionContext array;
		public ExpressionContext index;
		public TerminalNode LeftBracket() { return getToken(Mx_liteParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(Mx_liteParser.RightBracket, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IndexExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterIndexExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitIndexExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitIndexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SelfPlus() { return getToken(Mx_liteParser.SelfPlus, 0); }
		public TerminalNode SelfMinus() { return getToken(Mx_liteParser.SelfMinus, 0); }
		public PrefixExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitPrefixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SelfPlus() { return getToken(Mx_liteParser.SelfPlus, 0); }
		public TerminalNode SelfMinus() { return getToken(Mx_liteParser.SelfMinus, 0); }
		public SuffixExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterSuffixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitSuffixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitSuffixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExprContext extends ExpressionContext {
		public TerminalNode New() { return getToken(Mx_liteParser.New, 0); }
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public NewExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberAccessExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Dot() { return getToken(Mx_liteParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(Mx_liteParser.Identifier, 0); }
		public List<TerminalNode> LeftParen() { return getTokens(Mx_liteParser.LeftParen); }
		public TerminalNode LeftParen(int i) {
			return getToken(Mx_liteParser.LeftParen, i);
		}
		public List<TerminalNode> RightParen() { return getTokens(Mx_liteParser.RightParen); }
		public TerminalNode RightParen(int i) {
			return getToken(Mx_liteParser.RightParen, i);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public MemberAccessExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterMemberAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitMemberAccessExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitMemberAccessExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisExprContext extends ExpressionContext {
		public TerminalNode This() { return getToken(Mx_liteParser.This, 0); }
		public ThisExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterThisExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitThisExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitThisExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallExprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(Mx_liteParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(Mx_liteParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(Mx_liteParser.RightParen, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FuncCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterFuncCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitFuncCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitFuncCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambDefExprContext extends ExpressionContext {
		public LambdaDefContext lambdaDef() {
			return getRuleContext(LambdaDefContext.class,0);
		}
		public LambDefExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterLambDefExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitLambDefExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitLambDefExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(186);
				match(Identifier);
				}
				break;
			case 2:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				constant();
				}
				break;
			case 3:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(New);
				setState(189);
				creator();
				}
				break;
			case 4:
				{
				_localctx = new FuncCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(Identifier);
				setState(191);
				match(LeftParen);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
					{
					setState(192);
					expressionList();
					}
				}

				setState(195);
				match(RightParen);
				}
				break;
			case 5:
				{
				_localctx = new LambDefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				lambdaDef();
				}
				break;
			case 6:
				{
				_localctx = new ThisExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(This);
				}
				break;
			case 7:
				{
				_localctx = new SubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(LeftParen);
				setState(199);
				expression(0);
				setState(200);
				match(RightParen);
				}
				break;
			case 8:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SelfPlus || _la==SelfMinus) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(203);
				expression(15);
				}
				break;
			case 9:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(205);
				expression(13);
				}
				break;
			case 10:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Not || _la==Tilde) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(207);
				expression(12);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(272);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(210);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(211);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(212);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(214);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(215);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(217);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LeftShift || _la==RightShift) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(218);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(220);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Less) | (1L << LessEqual) | (1L << Greater) | (1L << GreaterEqual))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(223);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(224);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(226);
						((BinaryExprContext)_localctx).op = match(And);
						setState(227);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(229);
						((BinaryExprContext)_localctx).op = match(Caret);
						setState(230);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(232);
						((BinaryExprContext)_localctx).op = match(Or);
						setState(233);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(234);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(235);
						((BinaryExprContext)_localctx).op = match(AndAnd);
						setState(236);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(237);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(238);
						((BinaryExprContext)_localctx).op = match(OrOr);
						setState(239);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(240);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(241);
						((BinaryExprContext)_localctx).op = match(Assign);
						setState(242);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new MemberAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(243);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(244);
						match(Dot);
						setState(245);
						match(Identifier);
						setState(251);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
						case 1:
							{
							setState(246);
							match(LeftParen);
							setState(248);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
								{
								setState(247);
								expressionList();
								}
							}

							setState(250);
							match(RightParen);
							}
							break;
						}
						}
						break;
					case 13:
						{
						_localctx = new MemberAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(253);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(254);
						match(Dot);
						setState(255);
						match(LeftParen);
						setState(256);
						match(Identifier);
						setState(262);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LeftParen) {
							{
							setState(257);
							match(LeftParen);
							setState(259);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
								{
								setState(258);
								expressionList();
								}
							}

							setState(261);
							match(RightParen);
							}
						}

						setState(264);
						match(RightParen);
						}
						break;
					case 14:
						{
						_localctx = new IndexExprContext(new ExpressionContext(_parentctx, _parentState));
						((IndexExprContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(265);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(266);
						match(LeftBracket);
						setState(267);
						((IndexExprContext)_localctx).index = expression(0);
						setState(268);
						match(RightBracket);
						}
						break;
					case 15:
						{
						_localctx = new SuffixExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(270);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(271);
						((SuffixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SelfPlus || _la==SelfMinus) ) {
							((SuffixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public static class VarDefContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Mx_liteParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Mx_liteParser.Comma, i);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			varType();
			setState(278);
			varDeclaration();
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(279);
				match(Comma);
				setState(280);
				varDeclaration();
				}
				}
				setState(285);
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

	public static class VarDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Mx_liteParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(Mx_liteParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(Identifier);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(287);
				match(Assign);
				setState(288);
				expression(0);
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

	public static class CreatorContext extends ParserRuleContext {
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
	 
		public CreatorContext() { }
		public void copyFrom(CreatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewNArrayContext extends CreatorContext {
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public NewNArrayContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterNewNArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitNewNArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitNewNArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WrongArrayCreator2Context extends CreatorContext {
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(Mx_liteParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(Mx_liteParser.LeftBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(Mx_liteParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(Mx_liteParser.RightBracket, i);
		}
		public WrongArrayCreator2Context(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterWrongArrayCreator2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitWrongArrayCreator2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitWrongArrayCreator2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WrongArrayCreator1Context extends CreatorContext {
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(Mx_liteParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(Mx_liteParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(Mx_liteParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(Mx_liteParser.RightBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public WrongArrayCreator1Context(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterWrongArrayCreator1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitWrongArrayCreator1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitWrongArrayCreator1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewClassContext extends CreatorContext {
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(Mx_liteParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(Mx_liteParser.RightParen, 0); }
		public NewClassContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterNewClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitNewClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitNewClass(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewArrayCreatorContext extends CreatorContext {
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(Mx_liteParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(Mx_liteParser.LeftBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(Mx_liteParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(Mx_liteParser.RightBracket, i);
		}
		public NewArrayCreatorContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterNewArrayCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitNewArrayCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitNewArrayCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_creator);
		try {
			int _alt;
			setState(380);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				_localctx = new WrongArrayCreator1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				builtinType();
				setState(294); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(292);
						match(LeftBracket);
						setState(293);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(296); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(298);
						match(LeftBracket);
						setState(299);
						expression(0);
						setState(300);
						match(RightBracket);
						}
						} 
					}
					setState(306);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				}
				}
				break;
			case 2:
				_localctx = new WrongArrayCreator2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				builtinType();
				setState(312); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(308);
						match(LeftBracket);
						setState(309);
						expression(0);
						setState(310);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(314); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(318); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(316);
						match(LeftBracket);
						setState(317);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(320); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(326); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(322);
						match(LeftBracket);
						setState(323);
						expression(0);
						setState(324);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(328); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				_localctx = new WrongArrayCreator2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
				builtinType();
				setState(335); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(331);
						match(LeftBracket);
						setState(332);
						expression(0);
						setState(333);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(337); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(341); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(339);
						match(LeftBracket);
						setState(340);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(343); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(349); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(345);
						match(LeftBracket);
						setState(346);
						expression(0);
						setState(347);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(351); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(355); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(353);
						match(LeftBracket);
						setState(354);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(357); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				_localctx = new NewArrayCreatorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(359);
				builtinType();
				setState(364); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(360);
						match(LeftBracket);
						setState(361);
						expression(0);
						setState(362);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(366); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(372);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(368);
						match(LeftBracket);
						setState(369);
						match(RightBracket);
						}
						} 
					}
					setState(374);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				}
				}
				break;
			case 5:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(375);
				builtinType();
				setState(376);
				match(LeftParen);
				setState(377);
				match(RightParen);
				}
				break;
			case 6:
				_localctx = new NewNArrayContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(379);
				builtinType();
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

	public static class ReturnTypeContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(Mx_liteParser.Void, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnType);
		try {
			setState(384);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				match(Void);
				}
				break;
			case Int:
			case Bool:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				varType();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class VarTypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitVarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_varType);
		try {
			setState(388);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				arrayType(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				builtinType();
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

	public static class ArrayTypeContext extends ParserRuleContext {
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(Mx_liteParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(Mx_liteParser.RightBracket, 0); }
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		return arrayType(0);
	}

	private ArrayTypeContext arrayType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, _parentState);
		ArrayTypeContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_arrayType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(391);
			builtinType();
			setState(392);
			match(LeftBracket);
			setState(393);
			match(RightBracket);
			}
			_ctx.stop = _input.LT(-1);
			setState(400);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arrayType);
					setState(395);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(396);
					match(LeftBracket);
					setState(397);
					match(RightBracket);
					}
					} 
				}
				setState(402);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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

	public static class BuiltinTypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(Mx_liteParser.Int, 0); }
		public TerminalNode Bool() { return getToken(Mx_liteParser.Bool, 0); }
		public TerminalNode String() { return getToken(Mx_liteParser.String, 0); }
		public TerminalNode Identifier() { return getToken(Mx_liteParser.Identifier, 0); }
		public BuiltinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterBuiltinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitBuiltinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitBuiltinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltinTypeContext builtinType() throws RecognitionException {
		BuiltinTypeContext _localctx = new BuiltinTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_builtinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode DecimalInteger() { return getToken(Mx_liteParser.DecimalInteger, 0); }
		public TerminalNode StringConstant() { return getToken(Mx_liteParser.StringConstant, 0); }
		public TerminalNode Boolconstant() { return getToken(Mx_liteParser.Boolconstant, 0); }
		public TerminalNode Nullconstant() { return getToken(Mx_liteParser.Nullconstant, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << DecimalInteger))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		case 15:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 21:
			return arrayType_sempred((ArrayTypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 18);
		case 12:
			return precpred(_ctx, 17);
		case 13:
			return precpred(_ctx, 16);
		case 14:
			return precpred(_ctx, 14);
		}
		return true;
	}
	private boolean arrayType_sempred(ArrayTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u019a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\3\3\3\3\3\5\3<\n\3\3\4\5\4?\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5O\n\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\7\6Y\n\6\f\6\16\6\\\13\6\5\6^\n\6\3\7\3\7\3\7"+
		"\7\7c\n\7\f\7\16\7f\13\7\3\b\3\b\7\bj\n\b\f\b\16\bm\13\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\5\tv\n\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u0084\n\f\3\f\3\f\5\f\u0088\n\f\3\f\3\f\3\f\3\f\5\f\u008e\n\f"+
		"\3\f\3\f\5\f\u0092\n\f\3\f\3\f\5\f\u0096\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a4\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\7\17\u00b0\n\17\f\17\16\17\u00b3\13\17\3\17\3\17\3\17\3"+
		"\20\3\20\5\20\u00ba\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00c4\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u00d3\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00fb\n\21\3\21\5\21\u00fe\n\21\3\21\3\21\3\21\3\21\3\21\3\21\5"+
		"\21\u0106\n\21\3\21\5\21\u0109\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\7\21\u0113\n\21\f\21\16\21\u0116\13\21\3\22\3\22\3\22\3\22\7\22"+
		"\u011c\n\22\f\22\16\22\u011f\13\22\3\23\3\23\3\23\5\23\u0124\n\23\3\24"+
		"\3\24\3\24\6\24\u0129\n\24\r\24\16\24\u012a\3\24\3\24\3\24\3\24\7\24\u0131"+
		"\n\24\f\24\16\24\u0134\13\24\3\24\3\24\3\24\3\24\3\24\6\24\u013b\n\24"+
		"\r\24\16\24\u013c\3\24\3\24\6\24\u0141\n\24\r\24\16\24\u0142\3\24\3\24"+
		"\3\24\3\24\6\24\u0149\n\24\r\24\16\24\u014a\3\24\3\24\3\24\3\24\3\24\6"+
		"\24\u0152\n\24\r\24\16\24\u0153\3\24\3\24\6\24\u0158\n\24\r\24\16\24\u0159"+
		"\3\24\3\24\3\24\3\24\6\24\u0160\n\24\r\24\16\24\u0161\3\24\3\24\6\24\u0166"+
		"\n\24\r\24\16\24\u0167\3\24\3\24\3\24\3\24\3\24\6\24\u016f\n\24\r\24\16"+
		"\24\u0170\3\24\3\24\7\24\u0175\n\24\f\24\16\24\u0178\13\24\3\24\3\24\3"+
		"\24\3\24\3\24\5\24\u017f\n\24\3\25\3\25\5\25\u0183\n\25\3\26\3\26\5\26"+
		"\u0187\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0191\n\27\f"+
		"\27\16\27\u0194\13\27\3\30\3\30\3\31\3\31\3\31\2\4 ,\32\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\13\4\2\'\'))\4\2&&((\3\2\62\63"+
		"\3\2*,\3\2$%\3\2 #\3\29:\5\2\b\t\16\16==\4\2\5\7>>\2\u01cc\2\65\3\2\2"+
		"\2\4;\3\2\2\2\6>\3\2\2\2\bF\3\2\2\2\n]\3\2\2\2\f_\3\2\2\2\16g\3\2\2\2"+
		"\20u\3\2\2\2\22w\3\2\2\2\24y\3\2\2\2\26\u00a3\3\2\2\2\30\u00a5\3\2\2\2"+
		"\32\u00a8\3\2\2\2\34\u00ab\3\2\2\2\36\u00b9\3\2\2\2 \u00d2\3\2\2\2\"\u0117"+
		"\3\2\2\2$\u0120\3\2\2\2&\u017e\3\2\2\2(\u0182\3\2\2\2*\u0186\3\2\2\2,"+
		"\u0188\3\2\2\2.\u0195\3\2\2\2\60\u0197\3\2\2\2\62\64\5\4\3\2\63\62\3\2"+
		"\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\3\3\2\2\2\67\65\3\2"+
		"\2\28<\5\32\16\29<\5\6\4\2:<\5\34\17\2;8\3\2\2\2;9\3\2\2\2;:\3\2\2\2<"+
		"\5\3\2\2\2=?\5(\25\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\7=\2\2AB\7\32\2\2"+
		"BC\5\n\6\2CD\7\33\2\2DE\5\16\b\2E\7\3\2\2\2FG\7\3\2\2GH\7\32\2\2HI\5\n"+
		"\6\2IJ\7\33\2\2JK\7\4\2\2KL\5\16\b\2LN\7\32\2\2MO\5\f\7\2NM\3\2\2\2NO"+
		"\3\2\2\2OP\3\2\2\2PQ\7\33\2\2Q\t\3\2\2\2RS\5*\26\2SZ\5$\23\2TU\7\67\2"+
		"\2UV\5*\26\2VW\5$\23\2WY\3\2\2\2XT\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2"+
		"\2\2[^\3\2\2\2\\Z\3\2\2\2]R\3\2\2\2]^\3\2\2\2^\13\3\2\2\2_d\5 \21\2`a"+
		"\7\67\2\2ac\5 \21\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\r\3\2\2\2"+
		"fd\3\2\2\2gk\7\36\2\2hj\5\20\t\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2"+
		"\2ln\3\2\2\2mk\3\2\2\2no\7\37\2\2o\17\3\2\2\2pv\5\22\n\2qv\5\30\r\2rv"+
		"\5\26\f\2sv\5\24\13\2tv\7\66\2\2up\3\2\2\2uq\3\2\2\2ur\3\2\2\2us\3\2\2"+
		"\2ut\3\2\2\2v\21\3\2\2\2wx\5\16\b\2x\23\3\2\2\2yz\5 \21\2z{\7\66\2\2{"+
		"\25\3\2\2\2|}\7\17\2\2}~\7\32\2\2~\177\5 \21\2\177\u0080\7\33\2\2\u0080"+
		"\u0083\5\20\t\2\u0081\u0082\7\20\2\2\u0082\u0084\5\20\t\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u00a4\3\2\2\2\u0085\u0087\7\21\2\2"+
		"\u0086\u0088\5 \21\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\u00a4\7\66\2\2\u008a\u008b\7\24\2\2\u008b\u008d\7\32\2"+
		"\2\u008c\u008e\5 \21\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0091\7\66\2\2\u0090\u0092\5 \21\2\u0091\u0090\3\2\2\2"+
		"\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\7\66\2\2\u0094\u0096"+
		"\5 \21\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\7\33\2\2\u0098\u00a4\5\20\t\2\u0099\u009a\7\23\2\2\u009a\u009b"+
		"\7\32\2\2\u009b\u009c\5 \21\2\u009c\u009d\7\33\2\2\u009d\u009e\5\20\t"+
		"\2\u009e\u00a4\3\2\2\2\u009f\u00a0\7\26\2\2\u00a0\u00a4\7\66\2\2\u00a1"+
		"\u00a2\7\25\2\2\u00a2\u00a4\7\66\2\2\u00a3|\3\2\2\2\u00a3\u0085\3\2\2"+
		"\2\u00a3\u008a\3\2\2\2\u00a3\u0099\3\2\2\2\u00a3\u009f\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a4\27\3\2\2\2\u00a5\u00a6\5\"\22\2\u00a6\u00a7\7\66\2\2\u00a7"+
		"\31\3\2\2\2\u00a8\u00a9\5\"\22\2\u00a9\u00aa\7\66\2\2\u00aa\33\3\2\2\2"+
		"\u00ab\u00ac\7\22\2\2\u00ac\u00ad\7=\2\2\u00ad\u00b1\7\36\2\2\u00ae\u00b0"+
		"\5\36\20\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2"+
		"\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5"+
		"\7\37\2\2\u00b5\u00b6\7\66\2\2\u00b6\35\3\2\2\2\u00b7\u00ba\5\6\4\2\u00b8"+
		"\u00ba\5\32\16\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\37\3\2"+
		"\2\2\u00bb\u00bc\b\21\1\2\u00bc\u00d3\7=\2\2\u00bd\u00d3\5\60\31\2\u00be"+
		"\u00bf\7\27\2\2\u00bf\u00d3\5&\24\2\u00c0\u00c1\7=\2\2\u00c1\u00c3\7\32"+
		"\2\2\u00c2\u00c4\5\f\7\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00d3\7\33\2\2\u00c6\u00d3\5\b\5\2\u00c7\u00d3\7"+
		"\30\2\2\u00c8\u00c9\7\32\2\2\u00c9\u00ca\5 \21\2\u00ca\u00cb\7\33\2\2"+
		"\u00cb\u00d3\3\2\2\2\u00cc\u00cd\t\2\2\2\u00cd\u00d3\5 \21\21\u00ce\u00cf"+
		"\t\3\2\2\u00cf\u00d3\5 \21\17\u00d0\u00d1\t\4\2\2\u00d1\u00d3\5 \21\16"+
		"\u00d2\u00bb\3\2\2\2\u00d2\u00bd\3\2\2\2\u00d2\u00be\3\2\2\2\u00d2\u00c0"+
		"\3\2\2\2\u00d2\u00c6\3\2\2\2\u00d2\u00c7\3\2\2\2\u00d2\u00c8\3\2\2\2\u00d2"+
		"\u00cc\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u0114\3\2"+
		"\2\2\u00d4\u00d5\f\r\2\2\u00d5\u00d6\t\5\2\2\u00d6\u0113\5 \21\16\u00d7"+
		"\u00d8\f\f\2\2\u00d8\u00d9\t\3\2\2\u00d9\u0113\5 \21\r\u00da\u00db\f\13"+
		"\2\2\u00db\u00dc\t\6\2\2\u00dc\u0113\5 \21\f\u00dd\u00de\f\n\2\2\u00de"+
		"\u00df\t\7\2\2\u00df\u0113\5 \21\13\u00e0\u00e1\f\t\2\2\u00e1\u00e2\t"+
		"\b\2\2\u00e2\u0113\5 \21\n\u00e3\u00e4\f\b\2\2\u00e4\u00e5\7-\2\2\u00e5"+
		"\u0113\5 \21\t\u00e6\u00e7\f\7\2\2\u00e7\u00e8\7\61\2\2\u00e8\u0113\5"+
		" \21\b\u00e9\u00ea\f\6\2\2\u00ea\u00eb\7.\2\2\u00eb\u0113\5 \21\7\u00ec"+
		"\u00ed\f\5\2\2\u00ed\u00ee\7/\2\2\u00ee\u0113\5 \21\6\u00ef\u00f0\f\4"+
		"\2\2\u00f0\u00f1\7\60\2\2\u00f1\u0113\5 \21\5\u00f2\u00f3\f\3\2\2\u00f3"+
		"\u00f4\78\2\2\u00f4\u0113\5 \21\3\u00f5\u00f6\f\24\2\2\u00f6\u00f7\7\31"+
		"\2\2\u00f7\u00fd\7=\2\2\u00f8\u00fa\7\32\2\2\u00f9\u00fb\5\f\7\2\u00fa"+
		"\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\7\33"+
		"\2\2\u00fd\u00f8\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0113\3\2\2\2\u00ff"+
		"\u0100\f\23\2\2\u0100\u0101\7\31\2\2\u0101\u0102\7\32\2\2\u0102\u0108"+
		"\7=\2\2\u0103\u0105\7\32\2\2\u0104\u0106\5\f\7\2\u0105\u0104\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\7\33\2\2\u0108\u0103\3"+
		"\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0113\7\33\2\2\u010b"+
		"\u010c\f\22\2\2\u010c\u010d\7\34\2\2\u010d\u010e\5 \21\2\u010e\u010f\7"+
		"\35\2\2\u010f\u0113\3\2\2\2\u0110\u0111\f\20\2\2\u0111\u0113\t\2\2\2\u0112"+
		"\u00d4\3\2\2\2\u0112\u00d7\3\2\2\2\u0112\u00da\3\2\2\2\u0112\u00dd\3\2"+
		"\2\2\u0112\u00e0\3\2\2\2\u0112\u00e3\3\2\2\2\u0112\u00e6\3\2\2\2\u0112"+
		"\u00e9\3\2\2\2\u0112\u00ec\3\2\2\2\u0112\u00ef\3\2\2\2\u0112\u00f2\3\2"+
		"\2\2\u0112\u00f5\3\2\2\2\u0112\u00ff\3\2\2\2\u0112\u010b\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115!\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0118\5*\26\2\u0118\u011d"+
		"\5$\23\2\u0119\u011a\7\67\2\2\u011a\u011c\5$\23\2\u011b\u0119\3\2\2\2"+
		"\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e#\3"+
		"\2\2\2\u011f\u011d\3\2\2\2\u0120\u0123\7=\2\2\u0121\u0122\78\2\2\u0122"+
		"\u0124\5 \21\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124%\3\2\2\2"+
		"\u0125\u0128\5.\30\2\u0126\u0127\7\34\2\2\u0127\u0129\7\35\2\2\u0128\u0126"+
		"\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u0132\3\2\2\2\u012c\u012d\7\34\2\2\u012d\u012e\5 \21\2\u012e\u012f\7"+
		"\35\2\2\u012f\u0131\3\2\2\2\u0130\u012c\3\2\2\2\u0131\u0134\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u017f\3\2\2\2\u0134\u0132\3\2"+
		"\2\2\u0135\u013a\5.\30\2\u0136\u0137\7\34\2\2\u0137\u0138\5 \21\2\u0138"+
		"\u0139\7\35\2\2\u0139\u013b\3\2\2\2\u013a\u0136\3\2\2\2\u013b\u013c\3"+
		"\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u013f\7\34\2\2\u013f\u0141\7\35\2\2\u0140\u013e\3\2\2\2\u0141\u0142\3"+
		"\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0148\3\2\2\2\u0144"+
		"\u0145\7\34\2\2\u0145\u0146\5 \21\2\u0146\u0147\7\35\2\2\u0147\u0149\3"+
		"\2\2\2\u0148\u0144\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u0148\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\u017f\3\2\2\2\u014c\u0151\5.\30\2\u014d\u014e\7\34"+
		"\2\2\u014e\u014f\5 \21\2\u014f\u0150\7\35\2\2\u0150\u0152\3\2\2\2\u0151"+
		"\u014d\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2"+
		"\2\2\u0154\u0157\3\2\2\2\u0155\u0156\7\34\2\2\u0156\u0158\7\35\2\2\u0157"+
		"\u0155\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2"+
		"\2\2\u015a\u015f\3\2\2\2\u015b\u015c\7\34\2\2\u015c\u015d\5 \21\2\u015d"+
		"\u015e\7\35\2\2\u015e\u0160\3\2\2\2\u015f\u015b\3\2\2\2\u0160\u0161\3"+
		"\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0165\3\2\2\2\u0163"+
		"\u0164\7\34\2\2\u0164\u0166\7\35\2\2\u0165\u0163\3\2\2\2\u0166\u0167\3"+
		"\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u017f\3\2\2\2\u0169"+
		"\u016e\5.\30\2\u016a\u016b\7\34\2\2\u016b\u016c\5 \21\2\u016c\u016d\7"+
		"\35\2\2\u016d\u016f\3\2\2\2\u016e\u016a\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0176\3\2\2\2\u0172\u0173\7\34"+
		"\2\2\u0173\u0175\7\35\2\2\u0174\u0172\3\2\2\2\u0175\u0178\3\2\2\2\u0176"+
		"\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u017f\3\2\2\2\u0178\u0176\3\2"+
		"\2\2\u0179\u017a\5.\30\2\u017a\u017b\7\32\2\2\u017b\u017c\7\33\2\2\u017c"+
		"\u017f\3\2\2\2\u017d\u017f\5.\30\2\u017e\u0125\3\2\2\2\u017e\u0135\3\2"+
		"\2\2\u017e\u014c\3\2\2\2\u017e\u0169\3\2\2\2\u017e\u0179\3\2\2\2\u017e"+
		"\u017d\3\2\2\2\u017f\'\3\2\2\2\u0180\u0183\7\n\2\2\u0181\u0183\5*\26\2"+
		"\u0182\u0180\3\2\2\2\u0182\u0181\3\2\2\2\u0183)\3\2\2\2\u0184\u0187\5"+
		",\27\2\u0185\u0187\5.\30\2\u0186\u0184\3\2\2\2\u0186\u0185\3\2\2\2\u0187"+
		"+\3\2\2\2\u0188\u0189\b\27\1\2\u0189\u018a\5.\30\2\u018a\u018b\7\34\2"+
		"\2\u018b\u018c\7\35\2\2\u018c\u0192\3\2\2\2\u018d\u018e\f\3\2\2\u018e"+
		"\u018f\7\34\2\2\u018f\u0191\7\35\2\2\u0190\u018d\3\2\2\2\u0191\u0194\3"+
		"\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193-\3\2\2\2\u0194\u0192"+
		"\3\2\2\2\u0195\u0196\t\t\2\2\u0196/\3\2\2\2\u0197\u0198\t\n\2\2\u0198"+
		"\61\3\2\2\2,\65;>NZ]dku\u0083\u0087\u008d\u0091\u0095\u00a3\u00b1\u00b9"+
		"\u00c3\u00d2\u00fa\u00fd\u0105\u0108\u0112\u0114\u011d\u0123\u012a\u0132"+
		"\u013c\u0142\u014a\u0153\u0159\u0161\u0167\u0170\u0176\u017e\u0182\u0186"+
		"\u0192";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}