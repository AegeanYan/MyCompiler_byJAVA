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
		RULE_statement = 7, RULE_controlStmt = 8, RULE_forinit = 9, RULE_forstop = 10, 
		RULE_declarationStmt = 11, RULE_classDecl = 12, RULE_subClassDecl = 13, 
		RULE_expression = 14, RULE_varDef = 15, RULE_varDeclaration = 16, RULE_creator = 17, 
		RULE_returnType = 18, RULE_varType = 19, RULE_arrayType = 20, RULE_builtinType = 21, 
		RULE_constant = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "subProgram", "functionDef", "lambdaDef", "functionparameterDef", 
			"expressionList", "suite", "statement", "controlStmt", "forinit", "forstop", 
			"declarationStmt", "classDecl", "subClassDecl", "expression", "varDef", 
			"varDeclaration", "creator", "returnType", "varType", "arrayType", "builtinType", 
			"constant"
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
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << Void) | (1L << String) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				{
				setState(46);
				subProgram();
				}
				}
				setState(51);
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
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				declarationStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				functionDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
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
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(57);
				returnType();
				}
				break;
			}
			setState(60);
			match(Identifier);
			setState(61);
			match(LeftParen);
			setState(62);
			functionparameterDef();
			setState(63);
			match(RightParen);
			setState(64);
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
			setState(66);
			match(T__0);
			setState(67);
			match(LeftParen);
			setState(68);
			functionparameterDef();
			setState(69);
			match(RightParen);
			setState(70);
			match(T__1);
			setState(71);
			suite();
			setState(72);
			match(LeftParen);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
				{
				setState(73);
				expressionList();
				}
			}

			setState(76);
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
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(78);
				varType();
				setState(79);
				varDeclaration();
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(80);
					match(Comma);
					setState(81);
					varType();
					setState(82);
					varDeclaration();
					}
					}
					setState(88);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			expression(0);
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(92);
					match(Comma);
					setState(93);
					expression(0);
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
			setState(99);
			match(LeftBrace);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << If) | (1L << Return) | (1L << While) | (1L << For) | (1L << Break) | (1L << Continue) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Semi) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
				{
				{
				setState(100);
				statement();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
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
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public DeclarationStmtContext declarationStmt() {
			return getRuleContext(DeclarationStmtContext.class,0);
		}
		public ControlStmtContext controlStmt() {
			return getRuleContext(ControlStmtContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
				setState(108);
				suite();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				declarationStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				controlStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				expression(0);
				setState(112);
				match(Semi);
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
		public StatementContext trueStmt;
		public StatementContext falseStmt;
		public TerminalNode If() { return getToken(Mx_liteParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(Mx_liteParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(Mx_liteParser.RightParen, 0); }
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
		public ForinitContext init;
		public ForstopContext cond;
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
		public ForinitContext forinit() {
			return getRuleContext(ForinitContext.class,0);
		}
		public ForstopContext forstop() {
			return getRuleContext(ForstopContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 16, RULE_controlStmt);
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(If);
				setState(118);
				match(LeftParen);
				setState(119);
				expression(0);
				setState(120);
				match(RightParen);
				setState(121);
				((IfStmtContext)_localctx).trueStmt = statement();
				setState(124);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(122);
					match(Else);
					setState(123);
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
				setState(126);
				match(Return);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
					{
					setState(127);
					expression(0);
					}
				}

				setState(130);
				match(Semi);
				}
				break;
			case For:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(For);
				setState(132);
				match(LeftParen);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
					{
					setState(133);
					((ForStmtContext)_localctx).init = forinit();
					}
				}

				setState(136);
				match(Semi);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
					{
					setState(137);
					((ForStmtContext)_localctx).cond = forstop();
					}
				}

				setState(140);
				match(Semi);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
					{
					setState(141);
					((ForStmtContext)_localctx).step = expression(0);
					}
				}

				setState(144);
				match(RightParen);
				setState(145);
				statement();
				}
				break;
			case While:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(146);
				match(While);
				setState(147);
				match(LeftParen);
				setState(148);
				expression(0);
				setState(149);
				match(RightParen);
				setState(150);
				statement();
				}
				break;
			case Continue:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				match(Continue);
				setState(153);
				match(Semi);
				}
				break;
			case Break:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(154);
				match(Break);
				setState(155);
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

	public static class ForinitContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public ForinitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forinit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterForinit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitForinit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitForinit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForinitContext forinit() throws RecognitionException {
		ForinitContext _localctx = new ForinitContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forinit);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				varDef();
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

	public static class ForstopContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForstopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).enterForstop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Mx_liteListener ) ((Mx_liteListener)listener).exitForstop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Mx_liteVisitor ) return ((Mx_liteVisitor<? extends T>)visitor).visitForstop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForstopContext forstop() throws RecognitionException {
		ForstopContext _localctx = new ForstopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forstop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			expression(0);
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
		enterRule(_localctx, 22, RULE_declarationStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			varDef();
			setState(165);
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
		enterRule(_localctx, 24, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(Class);
			setState(168);
			match(Identifier);
			setState(169);
			match(LeftBrace);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << Void) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				{
				setState(170);
				subClassDecl();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
			match(RightBrace);
			setState(177);
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
		enterRule(_localctx, 26, RULE_subClassDecl);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				functionDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
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
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(Mx_liteParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(Mx_liteParser.RightParen, 0); }
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
	public static class UnaryExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SelfPlus() { return getToken(Mx_liteParser.SelfPlus, 0); }
		public TerminalNode SelfMinus() { return getToken(Mx_liteParser.SelfMinus, 0); }
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(184);
				match(Identifier);
				}
				break;
			case 2:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				constant();
				}
				break;
			case 3:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(New);
				setState(187);
				creator();
				}
				break;
			case 4:
				{
				_localctx = new FuncCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(Identifier);
				setState(189);
				match(LeftParen);
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
					{
					setState(190);
					expressionList();
					}
				}

				setState(193);
				match(RightParen);
				}
				break;
			case 5:
				{
				_localctx = new LambDefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				lambdaDef();
				}
				break;
			case 6:
				{
				_localctx = new ThisExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(This);
				}
				break;
			case 7:
				{
				_localctx = new SubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(LeftParen);
				setState(197);
				expression(0);
				setState(198);
				match(RightParen);
				}
				break;
			case 8:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SelfPlus || _la==SelfMinus) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(201);
				expression(14);
				}
				break;
			case 9:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
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
				setState(203);
				expression(13);
				}
				break;
			case 10:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
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
				setState(205);
				expression(12);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(262);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(209);
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
						setState(210);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(211);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(212);
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
						setState(213);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(215);
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
						setState(216);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(217);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(218);
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
						setState(219);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(220);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(221);
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
						setState(222);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(224);
						((BinaryExprContext)_localctx).op = match(And);
						setState(225);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(227);
						((BinaryExprContext)_localctx).op = match(Caret);
						setState(228);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(229);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(230);
						((BinaryExprContext)_localctx).op = match(Or);
						setState(231);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(232);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(233);
						((BinaryExprContext)_localctx).op = match(AndAnd);
						setState(234);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(235);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(236);
						((BinaryExprContext)_localctx).op = match(OrOr);
						setState(237);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(238);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(239);
						match(Assign);
						setState(240);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new MemberAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(241);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(242);
						match(Dot);
						setState(243);
						match(Identifier);
						setState(245);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
						case 1:
							{
							setState(244);
							expressionList();
							}
							break;
						}
						}
						break;
					case 13:
						{
						_localctx = new MemberAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(248);
						match(Dot);
						setState(249);
						match(LeftParen);
						setState(250);
						match(Identifier);
						setState(252);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolconstant) | (1L << Nullconstant) | (1L << StringConstant) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
							{
							setState(251);
							expressionList();
							}
						}

						setState(254);
						match(RightParen);
						}
						break;
					case 14:
						{
						_localctx = new IndexExprContext(new ExpressionContext(_parentctx, _parentState));
						((IndexExprContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(255);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(256);
						match(LeftBracket);
						setState(257);
						((IndexExprContext)_localctx).index = expression(0);
						setState(258);
						match(RightBracket);
						}
						break;
					case 15:
						{
						_localctx = new UnaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(260);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(261);
						((UnaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SelfPlus || _la==SelfMinus) ) {
							((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
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
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		enterRule(_localctx, 30, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			varType();
			setState(268);
			varDeclaration();
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(269);
				match(Comma);
				setState(270);
				varDeclaration();
				}
				}
				setState(275);
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
		enterRule(_localctx, 32, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(Identifier);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(277);
				match(Assign);
				setState(278);
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
		enterRule(_localctx, 34, RULE_creator);
		try {
			int _alt;
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new WrongArrayCreator1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				builtinType();
				setState(284); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(282);
						match(LeftBracket);
						setState(283);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(286); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(288);
						match(LeftBracket);
						setState(289);
						expression(0);
						setState(290);
						match(RightBracket);
						}
						} 
					}
					setState(296);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				}
				break;
			case 2:
				_localctx = new WrongArrayCreator2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				builtinType();
				setState(302); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
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
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(304); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(308); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(306);
						match(LeftBracket);
						setState(307);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(310); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(316); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(312);
						match(LeftBracket);
						setState(313);
						expression(0);
						setState(314);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(318); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				_localctx = new NewArrayCreatorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				builtinType();
				setState(325); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(321);
						match(LeftBracket);
						setState(322);
						expression(0);
						setState(323);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(327); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(333);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(329);
						match(LeftBracket);
						setState(330);
						match(RightBracket);
						}
						} 
					}
					setState(335);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				}
				break;
			case 4:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(336);
				builtinType();
				setState(337);
				match(LeftParen);
				setState(338);
				match(RightParen);
				}
				break;
			case 5:
				_localctx = new NewNArrayContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(340);
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
		enterRule(_localctx, 36, RULE_returnType);
		try {
			setState(345);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				match(Void);
				}
				break;
			case Int:
			case Bool:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(344);
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
		enterRule(_localctx, 38, RULE_varType);
		try {
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				arrayType(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_arrayType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(352);
			builtinType();
			setState(353);
			match(LeftBracket);
			setState(354);
			match(RightBracket);
			}
			_ctx.stop = _input.LT(-1);
			setState(361);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arrayType);
					setState(356);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(357);
					match(LeftBracket);
					setState(358);
					match(RightBracket);
					}
					} 
				}
				setState(363);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		enterRule(_localctx, 42, RULE_builtinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
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
		enterRule(_localctx, 44, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
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
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 20:
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
			return precpred(_ctx, 15);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u0173\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\3\3\3\3\3\5\3:\n\3\3\4\5\4=\n\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5M\n\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\5\6\\\n\6\3\7\3\7\3\7\7\7a\n\7"+
		"\f\7\16\7d\13\7\3\b\3\b\7\bh\n\b\f\b\16\bk\13\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\tv\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\177\n\n\3\n\3"+
		"\n\5\n\u0083\n\n\3\n\3\n\3\n\3\n\5\n\u0089\n\n\3\n\3\n\5\n\u008d\n\n\3"+
		"\n\3\n\5\n\u0091\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\n\u009f\n\n\3\13\3\13\5\13\u00a3\n\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\7\16\u00ae\n\16\f\16\16\16\u00b1\13\16\3\16\3\16\3\16\3\17\3"+
		"\17\5\17\u00b8\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c2"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00d1\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00f8"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\5\20\u00ff\n\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u0109\n\20\f\20\16\20\u010c\13\20\3\21\3\21\3\21"+
		"\3\21\7\21\u0112\n\21\f\21\16\21\u0115\13\21\3\22\3\22\3\22\5\22\u011a"+
		"\n\22\3\23\3\23\3\23\6\23\u011f\n\23\r\23\16\23\u0120\3\23\3\23\3\23\3"+
		"\23\7\23\u0127\n\23\f\23\16\23\u012a\13\23\3\23\3\23\3\23\3\23\3\23\6"+
		"\23\u0131\n\23\r\23\16\23\u0132\3\23\3\23\6\23\u0137\n\23\r\23\16\23\u0138"+
		"\3\23\3\23\3\23\3\23\6\23\u013f\n\23\r\23\16\23\u0140\3\23\3\23\3\23\3"+
		"\23\3\23\6\23\u0148\n\23\r\23\16\23\u0149\3\23\3\23\7\23\u014e\n\23\f"+
		"\23\16\23\u0151\13\23\3\23\3\23\3\23\3\23\3\23\5\23\u0158\n\23\3\24\3"+
		"\24\5\24\u015c\n\24\3\25\3\25\5\25\u0160\n\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\7\26\u016a\n\26\f\26\16\26\u016d\13\26\3\27\3\27\3\30"+
		"\3\30\3\30\2\4\36*\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\2\13\4\2\'\'))\4\2&&((\3\2\62\63\3\2*,\3\2$%\3\2 #\3\29:\5\2\b\t\16\16"+
		"==\4\2\5\7>>\2\u01a0\2\63\3\2\2\2\49\3\2\2\2\6<\3\2\2\2\bD\3\2\2\2\n["+
		"\3\2\2\2\f]\3\2\2\2\16e\3\2\2\2\20u\3\2\2\2\22\u009e\3\2\2\2\24\u00a2"+
		"\3\2\2\2\26\u00a4\3\2\2\2\30\u00a6\3\2\2\2\32\u00a9\3\2\2\2\34\u00b7\3"+
		"\2\2\2\36\u00d0\3\2\2\2 \u010d\3\2\2\2\"\u0116\3\2\2\2$\u0157\3\2\2\2"+
		"&\u015b\3\2\2\2(\u015f\3\2\2\2*\u0161\3\2\2\2,\u016e\3\2\2\2.\u0170\3"+
		"\2\2\2\60\62\5\4\3\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3"+
		"\2\2\2\64\3\3\2\2\2\65\63\3\2\2\2\66:\5\30\r\2\67:\5\6\4\28:\5\32\16\2"+
		"9\66\3\2\2\29\67\3\2\2\298\3\2\2\2:\5\3\2\2\2;=\5&\24\2<;\3\2\2\2<=\3"+
		"\2\2\2=>\3\2\2\2>?\7=\2\2?@\7\32\2\2@A\5\n\6\2AB\7\33\2\2BC\5\16\b\2C"+
		"\7\3\2\2\2DE\7\3\2\2EF\7\32\2\2FG\5\n\6\2GH\7\33\2\2HI\7\4\2\2IJ\5\16"+
		"\b\2JL\7\32\2\2KM\5\f\7\2LK\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\33\2\2O\t"+
		"\3\2\2\2PQ\5(\25\2QX\5\"\22\2RS\7\67\2\2ST\5(\25\2TU\5\"\22\2UW\3\2\2"+
		"\2VR\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2[P\3\2"+
		"\2\2[\\\3\2\2\2\\\13\3\2\2\2]b\5\36\20\2^_\7\67\2\2_a\5\36\20\2`^\3\2"+
		"\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\r\3\2\2\2db\3\2\2\2ei\7\36\2\2fh\5"+
		"\20\t\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2ki\3\2\2\2lm"+
		"\7\37\2\2m\17\3\2\2\2nv\5\16\b\2ov\5\30\r\2pv\5\22\n\2qr\5\36\20\2rs\7"+
		"\66\2\2sv\3\2\2\2tv\7\66\2\2un\3\2\2\2uo\3\2\2\2up\3\2\2\2uq\3\2\2\2u"+
		"t\3\2\2\2v\21\3\2\2\2wx\7\17\2\2xy\7\32\2\2yz\5\36\20\2z{\7\33\2\2{~\5"+
		"\20\t\2|}\7\20\2\2}\177\5\20\t\2~|\3\2\2\2~\177\3\2\2\2\177\u009f\3\2"+
		"\2\2\u0080\u0082\7\21\2\2\u0081\u0083\5\36\20\2\u0082\u0081\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u009f\7\66\2\2\u0085\u0086\7"+
		"\24\2\2\u0086\u0088\7\32\2\2\u0087\u0089\5\24\13\2\u0088\u0087\3\2\2\2"+
		"\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\7\66\2\2\u008b\u008d"+
		"\5\26\f\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2"+
		"\u008e\u0090\7\66\2\2\u008f\u0091\5\36\20\2\u0090\u008f\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7\33\2\2\u0093\u009f\5"+
		"\20\t\2\u0094\u0095\7\23\2\2\u0095\u0096\7\32\2\2\u0096\u0097\5\36\20"+
		"\2\u0097\u0098\7\33\2\2\u0098\u0099\5\20\t\2\u0099\u009f\3\2\2\2\u009a"+
		"\u009b\7\26\2\2\u009b\u009f\7\66\2\2\u009c\u009d\7\25\2\2\u009d\u009f"+
		"\7\66\2\2\u009ew\3\2\2\2\u009e\u0080\3\2\2\2\u009e\u0085\3\2\2\2\u009e"+
		"\u0094\3\2\2\2\u009e\u009a\3\2\2\2\u009e\u009c\3\2\2\2\u009f\23\3\2\2"+
		"\2\u00a0\u00a3\5\36\20\2\u00a1\u00a3\5 \21\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\25\3\2\2\2\u00a4\u00a5\5\36\20\2\u00a5\27\3\2\2\2"+
		"\u00a6\u00a7\5 \21\2\u00a7\u00a8\7\66\2\2\u00a8\31\3\2\2\2\u00a9\u00aa"+
		"\7\22\2\2\u00aa\u00ab\7=\2\2\u00ab\u00af\7\36\2\2\u00ac\u00ae\5\34\17"+
		"\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7\37\2\2"+
		"\u00b3\u00b4\7\66\2\2\u00b4\33\3\2\2\2\u00b5\u00b8\5\6\4\2\u00b6\u00b8"+
		"\5\30\r\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\35\3\2\2\2\u00b9"+
		"\u00ba\b\20\1\2\u00ba\u00d1\7=\2\2\u00bb\u00d1\5.\30\2\u00bc\u00bd\7\27"+
		"\2\2\u00bd\u00d1\5$\23\2\u00be\u00bf\7=\2\2\u00bf\u00c1\7\32\2\2\u00c0"+
		"\u00c2\5\f\7\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00d1\7\33\2\2\u00c4\u00d1\5\b\5\2\u00c5\u00d1\7\30\2\2\u00c6"+
		"\u00c7\7\32\2\2\u00c7\u00c8\5\36\20\2\u00c8\u00c9\7\33\2\2\u00c9\u00d1"+
		"\3\2\2\2\u00ca\u00cb\t\2\2\2\u00cb\u00d1\5\36\20\20\u00cc\u00cd\t\3\2"+
		"\2\u00cd\u00d1\5\36\20\17\u00ce\u00cf\t\4\2\2\u00cf\u00d1\5\36\20\16\u00d0"+
		"\u00b9\3\2\2\2\u00d0\u00bb\3\2\2\2\u00d0\u00bc\3\2\2\2\u00d0\u00be\3\2"+
		"\2\2\u00d0\u00c4\3\2\2\2\u00d0\u00c5\3\2\2\2\u00d0\u00c6\3\2\2\2\u00d0"+
		"\u00ca\3\2\2\2\u00d0\u00cc\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u010a\3\2"+
		"\2\2\u00d2\u00d3\f\r\2\2\u00d3\u00d4\t\5\2\2\u00d4\u0109\5\36\20\16\u00d5"+
		"\u00d6\f\f\2\2\u00d6\u00d7\t\3\2\2\u00d7\u0109\5\36\20\r\u00d8\u00d9\f"+
		"\13\2\2\u00d9\u00da\t\6\2\2\u00da\u0109\5\36\20\f\u00db\u00dc\f\n\2\2"+
		"\u00dc\u00dd\t\7\2\2\u00dd\u0109\5\36\20\13\u00de\u00df\f\t\2\2\u00df"+
		"\u00e0\t\b\2\2\u00e0\u0109\5\36\20\n\u00e1\u00e2\f\b\2\2\u00e2\u00e3\7"+
		"-\2\2\u00e3\u0109\5\36\20\t\u00e4\u00e5\f\7\2\2\u00e5\u00e6\7\61\2\2\u00e6"+
		"\u0109\5\36\20\b\u00e7\u00e8\f\6\2\2\u00e8\u00e9\7.\2\2\u00e9\u0109\5"+
		"\36\20\7\u00ea\u00eb\f\5\2\2\u00eb\u00ec\7/\2\2\u00ec\u0109\5\36\20\6"+
		"\u00ed\u00ee\f\4\2\2\u00ee\u00ef\7\60\2\2\u00ef\u0109\5\36\20\5\u00f0"+
		"\u00f1\f\3\2\2\u00f1\u00f2\78\2\2\u00f2\u0109\5\36\20\3\u00f3\u00f4\f"+
		"\24\2\2\u00f4\u00f5\7\31\2\2\u00f5\u00f7\7=\2\2\u00f6\u00f8\5\f\7\2\u00f7"+
		"\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u0109\3\2\2\2\u00f9\u00fa\f\23"+
		"\2\2\u00fa\u00fb\7\31\2\2\u00fb\u00fc\7\32\2\2\u00fc\u00fe\7=\2\2\u00fd"+
		"\u00ff\5\f\7\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0109\7\33\2\2\u0101\u0102\f\22\2\2\u0102\u0103\7\34\2\2\u0103"+
		"\u0104\5\36\20\2\u0104\u0105\7\35\2\2\u0105\u0109\3\2\2\2\u0106\u0107"+
		"\f\21\2\2\u0107\u0109\t\2\2\2\u0108\u00d2\3\2\2\2\u0108\u00d5\3\2\2\2"+
		"\u0108\u00d8\3\2\2\2\u0108\u00db\3\2\2\2\u0108\u00de\3\2\2\2\u0108\u00e1"+
		"\3\2\2\2\u0108\u00e4\3\2\2\2\u0108\u00e7\3\2\2\2\u0108\u00ea\3\2\2\2\u0108"+
		"\u00ed\3\2\2\2\u0108\u00f0\3\2\2\2\u0108\u00f3\3\2\2\2\u0108\u00f9\3\2"+
		"\2\2\u0108\u0101\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010c\3\2\2\2\u010a"+
		"\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\37\3\2\2\2\u010c\u010a\3\2\2"+
		"\2\u010d\u010e\5(\25\2\u010e\u0113\5\"\22\2\u010f\u0110\7\67\2\2\u0110"+
		"\u0112\5\"\22\2\u0111\u010f\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3"+
		"\2\2\2\u0113\u0114\3\2\2\2\u0114!\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0119"+
		"\7=\2\2\u0117\u0118\78\2\2\u0118\u011a\5\36\20\2\u0119\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a#\3\2\2\2\u011b\u011e\5,\27\2\u011c\u011d\7\34\2\2"+
		"\u011d\u011f\7\35\2\2\u011e\u011c\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0128\3\2\2\2\u0122\u0123\7\34\2\2"+
		"\u0123\u0124\5\36\20\2\u0124\u0125\7\35\2\2\u0125\u0127\3\2\2\2\u0126"+
		"\u0122\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2"+
		"\2\2\u0129\u0158\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u0130\5,\27\2\u012c"+
		"\u012d\7\34\2\2\u012d\u012e\5\36\20\2\u012e\u012f\7\35\2\2\u012f\u0131"+
		"\3\2\2\2\u0130\u012c\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0135\7\34\2\2\u0135\u0137\7"+
		"\35\2\2\u0136\u0134\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2\2\2\u0138"+
		"\u0139\3\2\2\2\u0139\u013e\3\2\2\2\u013a\u013b\7\34\2\2\u013b\u013c\5"+
		"\36\20\2\u013c\u013d\7\35\2\2\u013d\u013f\3\2\2\2\u013e\u013a\3\2\2\2"+
		"\u013f\u0140\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0158"+
		"\3\2\2\2\u0142\u0147\5,\27\2\u0143\u0144\7\34\2\2\u0144\u0145\5\36\20"+
		"\2\u0145\u0146\7\35\2\2\u0146\u0148\3\2\2\2\u0147\u0143\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014f\3\2"+
		"\2\2\u014b\u014c\7\34\2\2\u014c\u014e\7\35\2\2\u014d\u014b\3\2\2\2\u014e"+
		"\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0158\3\2"+
		"\2\2\u0151\u014f\3\2\2\2\u0152\u0153\5,\27\2\u0153\u0154\7\32\2\2\u0154"+
		"\u0155\7\33\2\2\u0155\u0158\3\2\2\2\u0156\u0158\5,\27\2\u0157\u011b\3"+
		"\2\2\2\u0157\u012b\3\2\2\2\u0157\u0142\3\2\2\2\u0157\u0152\3\2\2\2\u0157"+
		"\u0156\3\2\2\2\u0158%\3\2\2\2\u0159\u015c\7\n\2\2\u015a\u015c\5(\25\2"+
		"\u015b\u0159\3\2\2\2\u015b\u015a\3\2\2\2\u015c\'\3\2\2\2\u015d\u0160\5"+
		"*\26\2\u015e\u0160\5,\27\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2\2\2\u0160"+
		")\3\2\2\2\u0161\u0162\b\26\1\2\u0162\u0163\5,\27\2\u0163\u0164\7\34\2"+
		"\2\u0164\u0165\7\35\2\2\u0165\u016b\3\2\2\2\u0166\u0167\f\3\2\2\u0167"+
		"\u0168\7\34\2\2\u0168\u016a\7\35\2\2\u0169\u0166\3\2\2\2\u016a\u016d\3"+
		"\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c+\3\2\2\2\u016d\u016b"+
		"\3\2\2\2\u016e\u016f\t\t\2\2\u016f-\3\2\2\2\u0170\u0171\t\n\2\2\u0171"+
		"/\3\2\2\2\'\639<LX[biu~\u0082\u0088\u008c\u0090\u009e\u00a2\u00af\u00b7"+
		"\u00c1\u00d0\u00f7\u00fe\u0108\u010a\u0113\u0119\u0120\u0128\u0132\u0138"+
		"\u0140\u0149\u014f\u0157\u015b\u015f\u016b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}