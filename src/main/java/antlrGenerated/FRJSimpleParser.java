// Generated from /home/nick/Programming/uni/COMP489/compiler/src/main/antlr4/FRJSimpleParser.g4 by ANTLR 4.8
package antlrGenerated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FRJSimpleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MDF=1, CAP=2, METHOD=3, HEAD=4, TAIL=5, MAIN=6, ABSTRACT=7, ASSERT=8, 
		BOOLEAN=9, BREAK=10, BYTE=11, CASE=12, CATCH=13, CHAR=14, CLASS=15, CONST=16, 
		CONTINUE=17, DEFAULT=18, DO=19, DOUBLE=20, ELSE=21, ENUM=22, EXTENDS=23, 
		FINAL=24, FINALLY=25, FLOAT=26, FOR=27, IF=28, GOTO=29, IMPLEMENTS=30, 
		IMPORT=31, INSTANCEOF=32, INT=33, INTERFACE=34, LONG=35, NATIVE=36, NEW=37, 
		PACKAGE=38, PRIVATE=39, PROTECTED=40, PUBLIC=41, RETURN=42, SHORT=43, 
		STATIC=44, STRICTFP=45, SUPER=46, SWITCH=47, SYNCHRONIZED=48, THIS=49, 
		THROW=50, THROWS=51, TRANSIENT=52, TRY=53, VOID=54, VOLATILE=55, WHILE=56, 
		IntegerLiteral=57, FloatingPointLiteral=58, BooleanLiteral=59, CharacterLiteral=60, 
		StringLiteral=61, NullLiteral=62, LPAREN=63, RPAREN=64, LBRACE=65, RBRACE=66, 
		LBRACK=67, RBRACK=68, SEMI=69, COMMA=70, DOT=71, ASSIGN=72, GT=73, LT=74, 
		BANG=75, TILDE=76, QUESTION=77, COLON=78, EQUAL=79, LE=80, GE=81, NOTEQUAL=82, 
		AND=83, OR=84, INC=85, DEC=86, ADD=87, SUB=88, MUL=89, DIV=90, BITAND=91, 
		BITOR=92, CARET=93, MOD=94, ARROW=95, COLONCOLON=96, ADD_ASSIGN=97, SUB_ASSIGN=98, 
		MUL_ASSIGN=99, DIV_ASSIGN=100, AND_ASSIGN=101, OR_ASSIGN=102, XOR_ASSIGN=103, 
		MOD_ASSIGN=104, LSHIFT_ASSIGN=105, RSHIFT_ASSIGN=106, URSHIFT_ASSIGN=107, 
		Identifier=108, AT=109, ELLIPSIS=110, WS=111, COMMENT=112, LINE_COMMENT=113;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_classDeclaration = 2, RULE_implementsDeclaration = 3, 
		RULE_extendsDeclaration = 4, RULE_fieldDeclaration = 5, RULE_typeName = 6, 
		RULE_liftedTypeName = 7, RULE_methodHeader = 8, RULE_methodDeclaration = 9, 
		RULE_methodDeclarationArgument = 10, RULE_expr = 11, RULE_instantiationExpr = 12, 
		RULE_signalConstructionExpr = 13, RULE_emptySignalExpr = 14, RULE_headExpr = 15, 
		RULE_tailExpr = 16, RULE_letExpr = 17, RULE_liftedCallExpr = 18, RULE_callExpr = 19, 
		RULE_fieldAssignExpr = 20, RULE_fieldAccessExpr = 21, RULE_argumentList = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "classDeclaration", "implementsDeclaration", "extendsDeclaration", 
			"fieldDeclaration", "typeName", "liftedTypeName", "methodHeader", "methodDeclaration", 
			"methodDeclarationArgument", "expr", "instantiationExpr", "signalConstructionExpr", 
			"emptySignalExpr", "headExpr", "tailExpr", "letExpr", "liftedCallExpr", 
			"callExpr", "fieldAssignExpr", "fieldAccessExpr", "argumentList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'capability'", "'method'", "'head'", "'tail'", "'main'", 
			"'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", "'case'", 
			"'catch'", "'char'", "'class'", "'const'", "'continue'", "'default'", 
			"'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", "'finally'", 
			"'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", "'instanceof'", 
			"'int'", "'interface'", "'long'", "'native'", "'new'", "'package'", "'private'", 
			"'protected'", "'public'", "'return'", "'short'", "'static'", "'strictfp'", 
			"'super'", "'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", 
			"'transient'", "'try'", "'void'", "'volatile'", "'while'", null, null, 
			null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", 
			"'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", 
			"'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'->'", "'::'", "'+='", 
			"'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", 
			"'>>>='", null, "'@'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MDF", "CAP", "METHOD", "HEAD", "TAIL", "MAIN", "ABSTRACT", "ASSERT", 
			"BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONST", 
			"CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", "EXTENDS", "FINAL", 
			"FINALLY", "FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", "IMPORT", "INSTANCEOF", 
			"INT", "INTERFACE", "LONG", "NATIVE", "NEW", "PACKAGE", "PRIVATE", "PROTECTED", 
			"PUBLIC", "RETURN", "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", 
			"SYNCHRONIZED", "THIS", "THROW", "THROWS", "TRANSIENT", "TRY", "VOID", 
			"VOLATILE", "WHILE", "IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", 
			"CharacterLiteral", "StringLiteral", "NullLiteral", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", 
			"GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", 
			"NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", 
			"BITOR", "CARET", "MOD", "ARROW", "COLONCOLON", "ADD_ASSIGN", "SUB_ASSIGN", 
			"MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", 
			"MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "Identifier", 
			"AT", "ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "FRJSimpleParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FRJSimpleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitProgram(this);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CAP) | (1L << CLASS) | (1L << INTERFACE))) != 0)) {
				{
				{
				setState(46);
				classDeclaration();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			main();
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

	public static class MainContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(FRJSimpleParser.MAIN, 0); }
		public TerminalNode ASSIGN() { return getToken(FRJSimpleParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FRJSimpleParser.SEMI, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(MAIN);
			setState(55);
			match(ASSIGN);
			setState(56);
			expr(0);
			setState(57);
			match(SEMI);
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(FRJSimpleParser.CLASS, 0); }
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public TerminalNode LBRACE() { return getToken(FRJSimpleParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(FRJSimpleParser.RBRACE, 0); }
		public TerminalNode CAP() { return getToken(FRJSimpleParser.CAP, 0); }
		public ImplementsDeclarationContext implementsDeclaration() {
			return getRuleContext(ImplementsDeclarationContext.class,0);
		}
		public List<FieldDeclarationContext> fieldDeclaration() {
			return getRuleContexts(FieldDeclarationContext.class);
		}
		public FieldDeclarationContext fieldDeclaration(int i) {
			return getRuleContext(FieldDeclarationContext.class,i);
		}
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public TerminalNode INTERFACE() { return getToken(FRJSimpleParser.INTERFACE, 0); }
		public ExtendsDeclarationContext extendsDeclaration() {
			return getRuleContext(ExtendsDeclarationContext.class,0);
		}
		public List<MethodHeaderContext> methodHeader() {
			return getRuleContexts(MethodHeaderContext.class);
		}
		public MethodHeaderContext methodHeader(int i) {
			return getRuleContext(MethodHeaderContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(FRJSimpleParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(FRJSimpleParser.SEMI, i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		int _la;
		try {
			int _alt;
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAP:
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CAP) {
					{
					setState(59);
					match(CAP);
					}
				}

				setState(62);
				match(CLASS);
				setState(63);
				match(Identifier);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IMPLEMENTS) {
					{
					setState(64);
					implementsDeclaration();
					}
				}

				setState(67);
				match(LBRACE);
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(68);
						fieldDeclaration();
						}
						} 
					}
					setState(73);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MDF || _la==METHOD) {
					{
					{
					setState(74);
					methodDeclaration();
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(80);
				match(RBRACE);
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(INTERFACE);
				setState(82);
				match(Identifier);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTENDS) {
					{
					setState(83);
					extendsDeclaration();
					}
				}

				setState(86);
				match(LBRACE);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MDF || _la==METHOD) {
					{
					{
					setState(87);
					methodHeader();
					setState(88);
					match(SEMI);
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95);
				match(RBRACE);
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

	public static class ImplementsDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPLEMENTS() { return getToken(FRJSimpleParser.IMPLEMENTS, 0); }
		public List<TerminalNode> Identifier() { return getTokens(FRJSimpleParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(FRJSimpleParser.Identifier, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FRJSimpleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FRJSimpleParser.COMMA, i);
		}
		public ImplementsDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implementsDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterImplementsDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitImplementsDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitImplementsDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplementsDeclarationContext implementsDeclaration() throws RecognitionException {
		ImplementsDeclarationContext _localctx = new ImplementsDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_implementsDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(IMPLEMENTS);
			setState(99);
			match(Identifier);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(100);
				match(COMMA);
				setState(101);
				match(Identifier);
				}
				}
				setState(106);
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

	public static class ExtendsDeclarationContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(FRJSimpleParser.EXTENDS, 0); }
		public List<TerminalNode> Identifier() { return getTokens(FRJSimpleParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(FRJSimpleParser.Identifier, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FRJSimpleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FRJSimpleParser.COMMA, i);
		}
		public ExtendsDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendsDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterExtendsDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitExtendsDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitExtendsDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtendsDeclarationContext extendsDeclaration() throws RecognitionException {
		ExtendsDeclarationContext _localctx = new ExtendsDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_extendsDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(EXTENDS);
			setState(108);
			match(Identifier);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(109);
				match(COMMA);
				setState(110);
				match(Identifier);
				}
				}
				setState(115);
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public TerminalNode SEMI() { return getToken(FRJSimpleParser.SEMI, 0); }
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			typeName();
			setState(117);
			match(Identifier);
			setState(118);
			match(SEMI);
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

	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public TerminalNode MDF() { return getToken(FRJSimpleParser.MDF, 0); }
		public LiftedTypeNameContext liftedTypeName() {
			return getRuleContext(LiftedTypeNameContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typeName);
		int _la;
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MDF:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MDF) {
					{
					setState(120);
					match(MDF);
					}
				}

				setState(123);
				match(Identifier);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				liftedTypeName();
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

	public static class LiftedTypeNameContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(FRJSimpleParser.AT, 0); }
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public LiftedTypeNameContext liftedTypeName() {
			return getRuleContext(LiftedTypeNameContext.class,0);
		}
		public LiftedTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_liftedTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterLiftedTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitLiftedTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitLiftedTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiftedTypeNameContext liftedTypeName() throws RecognitionException {
		LiftedTypeNameContext _localctx = new LiftedTypeNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_liftedTypeName);
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(AT);
				setState(128);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(AT);
				setState(130);
				liftedTypeName();
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

	public static class MethodHeaderContext extends ParserRuleContext {
		public TerminalNode METHOD() { return getToken(FRJSimpleParser.METHOD, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(FRJSimpleParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FRJSimpleParser.RPAREN, 0); }
		public TerminalNode MDF() { return getToken(FRJSimpleParser.MDF, 0); }
		public List<MethodDeclarationArgumentContext> methodDeclarationArgument() {
			return getRuleContexts(MethodDeclarationArgumentContext.class);
		}
		public MethodDeclarationArgumentContext methodDeclarationArgument(int i) {
			return getRuleContext(MethodDeclarationArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FRJSimpleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FRJSimpleParser.COMMA, i);
		}
		public MethodHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterMethodHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitMethodHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitMethodHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodHeaderContext methodHeader() throws RecognitionException {
		MethodHeaderContext _localctx = new MethodHeaderContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MDF) {
				{
				setState(133);
				match(MDF);
				}
			}

			setState(136);
			match(METHOD);
			setState(137);
			typeName();
			setState(138);
			match(Identifier);
			setState(139);
			match(LPAREN);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MDF || _la==Identifier || _la==AT) {
				{
				setState(140);
				methodDeclarationArgument();
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(141);
					match(COMMA);
					setState(142);
					methodDeclarationArgument();
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(150);
			match(RPAREN);
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(FRJSimpleParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FRJSimpleParser.SEMI, 0); }
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			methodHeader();
			setState(153);
			match(ASSIGN);
			setState(154);
			expr(0);
			setState(155);
			match(SEMI);
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

	public static class MethodDeclarationArgumentContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public MethodDeclarationArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarationArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterMethodDeclarationArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitMethodDeclarationArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitMethodDeclarationArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationArgumentContext methodDeclarationArgument() throws RecognitionException {
		MethodDeclarationArgumentContext _localctx = new MethodDeclarationArgumentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_methodDeclarationArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			typeName();
			setState(158);
			match(Identifier);
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

	public static class ExprContext extends ParserRuleContext {
		public InstantiationExprContext instantiationExpr() {
			return getRuleContext(InstantiationExprContext.class,0);
		}
		public SignalConstructionExprContext signalConstructionExpr() {
			return getRuleContext(SignalConstructionExprContext.class,0);
		}
		public EmptySignalExprContext emptySignalExpr() {
			return getRuleContext(EmptySignalExprContext.class,0);
		}
		public HeadExprContext headExpr() {
			return getRuleContext(HeadExprContext.class,0);
		}
		public TailExprContext tailExpr() {
			return getRuleContext(TailExprContext.class,0);
		}
		public LetExprContext letExpr() {
			return getRuleContext(LetExprContext.class,0);
		}
		public TerminalNode THIS() { return getToken(FRJSimpleParser.THIS, 0); }
		public TerminalNode IntegerLiteral() { return getToken(FRJSimpleParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(FRJSimpleParser.FloatingPointLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(FRJSimpleParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(FRJSimpleParser.BooleanLiteral, 0); }
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FRJSimpleParser.DOT, 0); }
		public LiftedCallExprContext liftedCallExpr() {
			return getRuleContext(LiftedCallExprContext.class,0);
		}
		public CallExprContext callExpr() {
			return getRuleContext(CallExprContext.class,0);
		}
		public FieldAccessExprContext fieldAccessExpr() {
			return getRuleContext(FieldAccessExprContext.class,0);
		}
		public FieldAssignExprContext fieldAssignExpr() {
			return getRuleContext(FieldAssignExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitExpr(this);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(161);
				instantiationExpr();
				}
				break;
			case 2:
				{
				setState(162);
				signalConstructionExpr();
				}
				break;
			case 3:
				{
				setState(163);
				emptySignalExpr();
				}
				break;
			case 4:
				{
				setState(164);
				headExpr();
				}
				break;
			case 5:
				{
				setState(165);
				tailExpr();
				}
				break;
			case 6:
				{
				setState(166);
				letExpr();
				}
				break;
			case 7:
				{
				setState(167);
				match(THIS);
				}
				break;
			case 8:
				{
				setState(168);
				match(IntegerLiteral);
				}
				break;
			case 9:
				{
				setState(169);
				match(FloatingPointLiteral);
				}
				break;
			case 10:
				{
				setState(170);
				match(StringLiteral);
				}
				break;
			case 11:
				{
				setState(171);
				match(BooleanLiteral);
				}
				break;
			case 12:
				{
				setState(172);
				match(Identifier);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(175);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(176);
					match(DOT);
					setState(181);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						setState(177);
						liftedCallExpr();
						}
						break;
					case 2:
						{
						setState(178);
						callExpr();
						}
						break;
					case 3:
						{
						setState(179);
						fieldAccessExpr();
						}
						break;
					case 4:
						{
						setState(180);
						fieldAssignExpr();
						}
						break;
					}
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class InstantiationExprContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(FRJSimpleParser.NEW, 0); }
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public InstantiationExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantiationExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterInstantiationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitInstantiationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitInstantiationExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstantiationExprContext instantiationExpr() throws RecognitionException {
		InstantiationExprContext _localctx = new InstantiationExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_instantiationExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(NEW);
			setState(189);
			match(Identifier);
			setState(190);
			argumentList();
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

	public static class SignalConstructionExprContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(FRJSimpleParser.AT, 0); }
		public TerminalNode LBRACK() { return getToken(FRJSimpleParser.LBRACK, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(FRJSimpleParser.SEMI, 0); }
		public TerminalNode RBRACK() { return getToken(FRJSimpleParser.RBRACK, 0); }
		public SignalConstructionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signalConstructionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterSignalConstructionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitSignalConstructionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitSignalConstructionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignalConstructionExprContext signalConstructionExpr() throws RecognitionException {
		SignalConstructionExprContext _localctx = new SignalConstructionExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_signalConstructionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(AT);
			setState(193);
			match(LBRACK);
			setState(194);
			expr(0);
			setState(195);
			match(SEMI);
			setState(196);
			expr(0);
			setState(197);
			match(RBRACK);
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

	public static class EmptySignalExprContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(FRJSimpleParser.AT, 0); }
		public TerminalNode LBRACK() { return getToken(FRJSimpleParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(FRJSimpleParser.RBRACK, 0); }
		public EmptySignalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptySignalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterEmptySignalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitEmptySignalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitEmptySignalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptySignalExprContext emptySignalExpr() throws RecognitionException {
		EmptySignalExprContext _localctx = new EmptySignalExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_emptySignalExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(AT);
			setState(200);
			match(LBRACK);
			setState(201);
			match(RBRACK);
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

	public static class HeadExprContext extends ParserRuleContext {
		public TerminalNode HEAD() { return getToken(FRJSimpleParser.HEAD, 0); }
		public TerminalNode LPAREN() { return getToken(FRJSimpleParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FRJSimpleParser.RPAREN, 0); }
		public HeadExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterHeadExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitHeadExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitHeadExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadExprContext headExpr() throws RecognitionException {
		HeadExprContext _localctx = new HeadExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_headExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(HEAD);
			setState(204);
			match(LPAREN);
			setState(205);
			expr(0);
			setState(206);
			match(RPAREN);
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

	public static class TailExprContext extends ParserRuleContext {
		public TerminalNode TAIL() { return getToken(FRJSimpleParser.TAIL, 0); }
		public TerminalNode LPAREN() { return getToken(FRJSimpleParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FRJSimpleParser.RPAREN, 0); }
		public TailExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tailExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterTailExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitTailExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitTailExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TailExprContext tailExpr() throws RecognitionException {
		TailExprContext _localctx = new TailExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_tailExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(TAIL);
			setState(209);
			match(LPAREN);
			setState(210);
			expr(0);
			setState(211);
			match(RPAREN);
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

	public static class LetExprContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(FRJSimpleParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(FRJSimpleParser.COMMA, 0); }
		public LetExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterLetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitLetExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitLetExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetExprContext letExpr() throws RecognitionException {
		LetExprContext _localctx = new LetExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_letExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			typeName();
			setState(214);
			match(Identifier);
			setState(215);
			match(ASSIGN);
			setState(216);
			expr(0);
			setState(217);
			match(COMMA);
			setState(218);
			expr(0);
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

	public static class LiftedCallExprContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(FRJSimpleParser.AT, 0); }
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public LiftedCallExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_liftedCallExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterLiftedCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitLiftedCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitLiftedCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiftedCallExprContext liftedCallExpr() throws RecognitionException {
		LiftedCallExprContext _localctx = new LiftedCallExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_liftedCallExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(AT);
			setState(221);
			match(Identifier);
			setState(222);
			argumentList();
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

	public static class CallExprContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public CallExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallExprContext callExpr() throws RecognitionException {
		CallExprContext _localctx = new CallExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_callExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(Identifier);
			setState(225);
			argumentList();
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

	public static class FieldAssignExprContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(FRJSimpleParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FieldAssignExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAssignExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterFieldAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitFieldAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitFieldAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAssignExprContext fieldAssignExpr() throws RecognitionException {
		FieldAssignExprContext _localctx = new FieldAssignExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_fieldAssignExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(Identifier);
			setState(228);
			match(ASSIGN);
			setState(229);
			expr(0);
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

	public static class FieldAccessExprContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public FieldAccessExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccessExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterFieldAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitFieldAccessExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitFieldAccessExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccessExprContext fieldAccessExpr() throws RecognitionException {
		FieldAccessExprContext _localctx = new FieldAccessExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_fieldAccessExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(Identifier);
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

	public static class ArgumentListContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(FRJSimpleParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FRJSimpleParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FRJSimpleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FRJSimpleParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJSimpleParserListener ) ((FRJSimpleParserListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJSimpleParserVisitor ) return ((FRJSimpleParserVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(LPAREN);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MDF) | (1L << HEAD) | (1L << TAIL) | (1L << NEW) | (1L << THIS) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(234);
				expr(0);
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(235);
					match(COMMA);
					setState(236);
					expr(0);
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(244);
			match(RPAREN);
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
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3s\u00f9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\5\4?\n\4\3\4\3\4"+
		"\3\4\5\4D\n\4\3\4\3\4\7\4H\n\4\f\4\16\4K\13\4\3\4\7\4N\n\4\f\4\16\4Q\13"+
		"\4\3\4\3\4\3\4\3\4\5\4W\n\4\3\4\3\4\3\4\3\4\7\4]\n\4\f\4\16\4`\13\4\3"+
		"\4\5\4c\n\4\3\5\3\5\3\5\3\5\7\5i\n\5\f\5\16\5l\13\5\3\6\3\6\3\6\3\6\7"+
		"\6r\n\6\f\6\16\6u\13\6\3\7\3\7\3\7\3\7\3\b\5\b|\n\b\3\b\3\b\5\b\u0080"+
		"\n\b\3\t\3\t\3\t\3\t\5\t\u0086\n\t\3\n\5\n\u0089\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\7\n\u0092\n\n\f\n\16\n\u0095\13\n\5\n\u0097\n\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00b0\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b8\n\r\7\r"+
		"\u00ba\n\r\f\r\16\r\u00bd\13\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\7\30"+
		"\u00f0\n\30\f\30\16\30\u00f3\13\30\5\30\u00f5\n\30\3\30\3\30\3\30\2\3"+
		"\30\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\2\2\u0102\2\63"+
		"\3\2\2\2\48\3\2\2\2\6b\3\2\2\2\bd\3\2\2\2\nm\3\2\2\2\fv\3\2\2\2\16\177"+
		"\3\2\2\2\20\u0085\3\2\2\2\22\u0088\3\2\2\2\24\u009a\3\2\2\2\26\u009f\3"+
		"\2\2\2\30\u00af\3\2\2\2\32\u00be\3\2\2\2\34\u00c2\3\2\2\2\36\u00c9\3\2"+
		"\2\2 \u00cd\3\2\2\2\"\u00d2\3\2\2\2$\u00d7\3\2\2\2&\u00de\3\2\2\2(\u00e2"+
		"\3\2\2\2*\u00e5\3\2\2\2,\u00e9\3\2\2\2.\u00eb\3\2\2\2\60\62\5\6\4\2\61"+
		"\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65"+
		"\63\3\2\2\2\66\67\5\4\3\2\67\3\3\2\2\289\7\b\2\29:\7J\2\2:;\5\30\r\2;"+
		"<\7G\2\2<\5\3\2\2\2=?\7\4\2\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\7\21\2\2"+
		"AC\7n\2\2BD\5\b\5\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EI\7C\2\2FH\5\f\7\2G"+
		"F\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JO\3\2\2\2KI\3\2\2\2LN\5\24\13"+
		"\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2Rc\7D\2"+
		"\2ST\7$\2\2TV\7n\2\2UW\5\n\6\2VU\3\2\2\2VW\3\2\2\2WX\3\2\2\2X^\7C\2\2"+
		"YZ\5\22\n\2Z[\7G\2\2[]\3\2\2\2\\Y\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2"+
		"\2_a\3\2\2\2`^\3\2\2\2ac\7D\2\2b>\3\2\2\2bS\3\2\2\2c\7\3\2\2\2de\7 \2"+
		"\2ej\7n\2\2fg\7H\2\2gi\7n\2\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2"+
		"k\t\3\2\2\2lj\3\2\2\2mn\7\31\2\2ns\7n\2\2op\7H\2\2pr\7n\2\2qo\3\2\2\2"+
		"ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\13\3\2\2\2us\3\2\2\2vw\5\16\b\2wx\7n\2"+
		"\2xy\7G\2\2y\r\3\2\2\2z|\7\3\2\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}\u0080"+
		"\7n\2\2~\u0080\5\20\t\2\177{\3\2\2\2\177~\3\2\2\2\u0080\17\3\2\2\2\u0081"+
		"\u0082\7o\2\2\u0082\u0086\7n\2\2\u0083\u0084\7o\2\2\u0084\u0086\5\20\t"+
		"\2\u0085\u0081\3\2\2\2\u0085\u0083\3\2\2\2\u0086\21\3\2\2\2\u0087\u0089"+
		"\7\3\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\7\5\2\2\u008b\u008c\5\16\b\2\u008c\u008d\7n\2\2\u008d\u0096\7A"+
		"\2\2\u008e\u0093\5\26\f\2\u008f\u0090\7H\2\2\u0090\u0092\5\26\f\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u008e\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7B\2\2\u0099\23\3\2\2\2"+
		"\u009a\u009b\5\22\n\2\u009b\u009c\7J\2\2\u009c\u009d\5\30\r\2\u009d\u009e"+
		"\7G\2\2\u009e\25\3\2\2\2\u009f\u00a0\5\16\b\2\u00a0\u00a1\7n\2\2\u00a1"+
		"\27\3\2\2\2\u00a2\u00a3\b\r\1\2\u00a3\u00b0\5\32\16\2\u00a4\u00b0\5\34"+
		"\17\2\u00a5\u00b0\5\36\20\2\u00a6\u00b0\5 \21\2\u00a7\u00b0\5\"\22\2\u00a8"+
		"\u00b0\5$\23\2\u00a9\u00b0\7\63\2\2\u00aa\u00b0\7;\2\2\u00ab\u00b0\7<"+
		"\2\2\u00ac\u00b0\7?\2\2\u00ad\u00b0\7=\2\2\u00ae\u00b0\7n\2\2\u00af\u00a2"+
		"\3\2\2\2\u00af\u00a4\3\2\2\2\u00af\u00a5\3\2\2\2\u00af\u00a6\3\2\2\2\u00af"+
		"\u00a7\3\2\2\2\u00af\u00a8\3\2\2\2\u00af\u00a9\3\2\2\2\u00af\u00aa\3\2"+
		"\2\2\u00af\u00ab\3\2\2\2\u00af\u00ac\3\2\2\2\u00af\u00ad\3\2\2\2\u00af"+
		"\u00ae\3\2\2\2\u00b0\u00bb\3\2\2\2\u00b1\u00b2\f\t\2\2\u00b2\u00b7\7I"+
		"\2\2\u00b3\u00b8\5&\24\2\u00b4\u00b8\5(\25\2\u00b5\u00b8\5,\27\2\u00b6"+
		"\u00b8\5*\26\2\u00b7\u00b3\3\2\2\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5\3\2"+
		"\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b1\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\31\3\2\2"+
		"\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7\'\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1"+
		"\5.\30\2\u00c1\33\3\2\2\2\u00c2\u00c3\7o\2\2\u00c3\u00c4\7E\2\2\u00c4"+
		"\u00c5\5\30\r\2\u00c5\u00c6\7G\2\2\u00c6\u00c7\5\30\r\2\u00c7\u00c8\7"+
		"F\2\2\u00c8\35\3\2\2\2\u00c9\u00ca\7o\2\2\u00ca\u00cb\7E\2\2\u00cb\u00cc"+
		"\7F\2\2\u00cc\37\3\2\2\2\u00cd\u00ce\7\6\2\2\u00ce\u00cf\7A\2\2\u00cf"+
		"\u00d0\5\30\r\2\u00d0\u00d1\7B\2\2\u00d1!\3\2\2\2\u00d2\u00d3\7\7\2\2"+
		"\u00d3\u00d4\7A\2\2\u00d4\u00d5\5\30\r\2\u00d5\u00d6\7B\2\2\u00d6#\3\2"+
		"\2\2\u00d7\u00d8\5\16\b\2\u00d8\u00d9\7n\2\2\u00d9\u00da\7J\2\2\u00da"+
		"\u00db\5\30\r\2\u00db\u00dc\7H\2\2\u00dc\u00dd\5\30\r\2\u00dd%\3\2\2\2"+
		"\u00de\u00df\7o\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1\5.\30\2\u00e1\'\3\2"+
		"\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4\5.\30\2\u00e4)\3\2\2\2\u00e5\u00e6"+
		"\7n\2\2\u00e6\u00e7\7J\2\2\u00e7\u00e8\5\30\r\2\u00e8+\3\2\2\2\u00e9\u00ea"+
		"\7n\2\2\u00ea-\3\2\2\2\u00eb\u00f4\7A\2\2\u00ec\u00f1\5\30\r\2\u00ed\u00ee"+
		"\7H\2\2\u00ee\u00f0\5\30\r\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2"+
		"\2\2\u00f4\u00ec\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\7B\2\2\u00f7/\3\2\2\2\27\63>CIOV^bjs{\177\u0085\u0088\u0093\u0096"+
		"\u00af\u00b7\u00bb\u00f1\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}