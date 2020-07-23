// Generated from /home/nick/Programming/uni/COMP489/compiler/src/main/antlr4/FRJParser.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FRJParser extends Parser {
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
		RULE_extendsDeclaration = 4, RULE_genericDeclaration = 5, RULE_fieldDeclaration = 6, 
		RULE_typeName = 7, RULE_typeNameGeneric = 8, RULE_methodHeader = 9, RULE_methodDeclaration = 10, 
		RULE_methodDeclarationArgument = 11, RULE_expr = 12, RULE_instantiationExpr = 13, 
		RULE_signalConstructionExpr = 14, RULE_emptySignalExpr = 15, RULE_headExpr = 16, 
		RULE_tailExpr = 17, RULE_letExpr = 18, RULE_liftedCallExpr = 19, RULE_callExpr = 20, 
		RULE_fieldAssignExpr = 21, RULE_fieldAccessExpr = 22, RULE_argumentList = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "classDeclaration", "implementsDeclaration", "extendsDeclaration", 
			"genericDeclaration", "fieldDeclaration", "typeName", "typeNameGeneric", 
			"methodHeader", "methodDeclaration", "methodDeclarationArgument", "expr", 
			"instantiationExpr", "signalConstructionExpr", "emptySignalExpr", "headExpr", 
			"tailExpr", "letExpr", "liftedCallExpr", "callExpr", "fieldAssignExpr", 
			"fieldAccessExpr", "argumentList"
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
	public String getGrammarFileName() { return "FRJParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FRJParser(TokenStream input) {
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
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitProgram(this);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CAP) | (1L << CLASS) | (1L << INTERFACE))) != 0)) {
				{
				{
				setState(48);
				classDeclaration();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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
		public TerminalNode MAIN() { return getToken(FRJParser.MAIN, 0); }
		public TerminalNode ASSIGN() { return getToken(FRJParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FRJParser.SEMI, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(MAIN);
			setState(57);
			match(ASSIGN);
			setState(58);
			expr(0);
			setState(59);
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
		public TerminalNode CLASS() { return getToken(FRJParser.CLASS, 0); }
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public TerminalNode LBRACE() { return getToken(FRJParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(FRJParser.RBRACE, 0); }
		public TerminalNode CAP() { return getToken(FRJParser.CAP, 0); }
		public List<TerminalNode> LT() { return getTokens(FRJParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(FRJParser.LT, i);
		}
		public List<GenericDeclarationContext> genericDeclaration() {
			return getRuleContexts(GenericDeclarationContext.class);
		}
		public GenericDeclarationContext genericDeclaration(int i) {
			return getRuleContext(GenericDeclarationContext.class,i);
		}
		public List<TerminalNode> GT() { return getTokens(FRJParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(FRJParser.GT, i);
		}
		public List<ImplementsDeclarationContext> implementsDeclaration() {
			return getRuleContexts(ImplementsDeclarationContext.class);
		}
		public ImplementsDeclarationContext implementsDeclaration(int i) {
			return getRuleContext(ImplementsDeclarationContext.class,i);
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
		public TerminalNode INTERFACE() { return getToken(FRJParser.INTERFACE, 0); }
		public ExtendsDeclarationContext extendsDeclaration() {
			return getRuleContext(ExtendsDeclarationContext.class,0);
		}
		public List<MethodHeaderContext> methodHeader() {
			return getRuleContexts(MethodHeaderContext.class);
		}
		public MethodHeaderContext methodHeader(int i) {
			return getRuleContext(MethodHeaderContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(FRJParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(FRJParser.SEMI, i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		int _la;
		try {
			int _alt;
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAP:
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CAP) {
					{
					setState(61);
					match(CAP);
					}
				}

				setState(64);
				match(CLASS);
				setState(65);
				match(Identifier);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LT) {
					{
					{
					setState(66);
					match(LT);
					setState(67);
					genericDeclaration();
					setState(68);
					match(GT);
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IMPLEMENTS) {
					{
					{
					setState(75);
					implementsDeclaration();
					}
					}
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(81);
				match(LBRACE);
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(82);
						fieldDeclaration();
						}
						} 
					}
					setState(87);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MDF || _la==METHOD) {
					{
					{
					setState(88);
					methodDeclaration();
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(94);
				match(RBRACE);
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(INTERFACE);
				setState(96);
				match(Identifier);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LT) {
					{
					{
					setState(97);
					match(LT);
					setState(98);
					genericDeclaration();
					setState(99);
					match(GT);
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTENDS) {
					{
					setState(106);
					extendsDeclaration();
					}
				}

				setState(109);
				match(LBRACE);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MDF || _la==METHOD) {
					{
					{
					setState(110);
					methodHeader();
					setState(111);
					match(SEMI);
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118);
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
		public TerminalNode IMPLEMENTS() { return getToken(FRJParser.IMPLEMENTS, 0); }
		public List<TypeNameContext> typeName() {
			return getRuleContexts(TypeNameContext.class);
		}
		public TypeNameContext typeName(int i) {
			return getRuleContext(TypeNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FRJParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FRJParser.COMMA, i);
		}
		public ImplementsDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implementsDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterImplementsDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitImplementsDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitImplementsDeclaration(this);
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
			setState(121);
			match(IMPLEMENTS);
			setState(122);
			typeName();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(123);
				match(COMMA);
				setState(124);
				typeName();
				}
				}
				setState(129);
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
		public TerminalNode EXTENDS() { return getToken(FRJParser.EXTENDS, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ExtendsDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendsDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterExtendsDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitExtendsDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitExtendsDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtendsDeclarationContext extendsDeclaration() throws RecognitionException {
		ExtendsDeclarationContext _localctx = new ExtendsDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_extendsDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(EXTENDS);
			setState(131);
			typeName();
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

	public static class GenericDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public TerminalNode EXTENDS() { return getToken(FRJParser.EXTENDS, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public GenericDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterGenericDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitGenericDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitGenericDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericDeclarationContext genericDeclaration() throws RecognitionException {
		GenericDeclarationContext _localctx = new GenericDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_genericDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(Identifier);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(134);
				match(EXTENDS);
				setState(135);
				typeName();
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public TerminalNode SEMI() { return getToken(FRJParser.SEMI, 0); }
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			typeName();
			setState(139);
			match(Identifier);
			setState(140);
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
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public TerminalNode MDF() { return getToken(FRJParser.MDF, 0); }
		public List<TypeNameGenericContext> typeNameGeneric() {
			return getRuleContexts(TypeNameGenericContext.class);
		}
		public TypeNameGenericContext typeNameGeneric(int i) {
			return getRuleContext(TypeNameGenericContext.class,i);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_typeName);
		int _la;
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MDF) {
					{
					setState(142);
					match(MDF);
					}
				}

				setState(145);
				match(Identifier);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LT) {
					{
					{
					setState(146);
					typeNameGeneric();
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(Identifier);
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

	public static class TypeNameGenericContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(FRJParser.LT, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode GT() { return getToken(FRJParser.GT, 0); }
		public TypeNameGenericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeNameGeneric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterTypeNameGeneric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitTypeNameGeneric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitTypeNameGeneric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameGenericContext typeNameGeneric() throws RecognitionException {
		TypeNameGenericContext _localctx = new TypeNameGenericContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeNameGeneric);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(LT);
			setState(156);
			typeName();
			setState(157);
			match(GT);
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
		public TerminalNode METHOD() { return getToken(FRJParser.METHOD, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(FRJParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FRJParser.RPAREN, 0); }
		public TerminalNode MDF() { return getToken(FRJParser.MDF, 0); }
		public List<MethodDeclarationArgumentContext> methodDeclarationArgument() {
			return getRuleContexts(MethodDeclarationArgumentContext.class);
		}
		public MethodDeclarationArgumentContext methodDeclarationArgument(int i) {
			return getRuleContext(MethodDeclarationArgumentContext.class,i);
		}
		public MethodHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterMethodHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitMethodHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitMethodHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodHeaderContext methodHeader() throws RecognitionException {
		MethodHeaderContext _localctx = new MethodHeaderContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MDF) {
				{
				setState(159);
				match(MDF);
				}
			}

			setState(162);
			match(METHOD);
			setState(163);
			typeName();
			setState(164);
			match(Identifier);
			setState(165);
			match(LPAREN);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MDF || _la==Identifier) {
				{
				{
				setState(166);
				methodDeclarationArgument();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
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
		public TerminalNode ASSIGN() { return getToken(FRJParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FRJParser.SEMI, 0); }
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_methodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			methodHeader();
			setState(175);
			match(ASSIGN);
			setState(176);
			expr(0);
			setState(177);
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
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public MethodDeclarationArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarationArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterMethodDeclarationArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitMethodDeclarationArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitMethodDeclarationArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationArgumentContext methodDeclarationArgument() throws RecognitionException {
		MethodDeclarationArgumentContext _localctx = new MethodDeclarationArgumentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_methodDeclarationArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			typeName();
			setState(180);
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
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FRJParser.DOT, 0); }
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
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitExpr(this);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(183);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(184);
				instantiationExpr();
				}
				break;
			case 3:
				{
				setState(185);
				signalConstructionExpr();
				}
				break;
			case 4:
				{
				setState(186);
				emptySignalExpr();
				}
				break;
			case 5:
				{
				setState(187);
				headExpr();
				}
				break;
			case 6:
				{
				setState(188);
				tailExpr();
				}
				break;
			case 7:
				{
				setState(189);
				letExpr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(192);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(193);
					match(DOT);
					setState(198);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						setState(194);
						liftedCallExpr();
						}
						break;
					case 2:
						{
						setState(195);
						callExpr();
						}
						break;
					case 3:
						{
						setState(196);
						fieldAccessExpr();
						}
						break;
					case 4:
						{
						setState(197);
						fieldAssignExpr();
						}
						break;
					}
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		public TerminalNode NEW() { return getToken(FRJParser.NEW, 0); }
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TypeNameGenericContext typeNameGeneric() {
			return getRuleContext(TypeNameGenericContext.class,0);
		}
		public InstantiationExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantiationExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterInstantiationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitInstantiationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitInstantiationExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstantiationExprContext instantiationExpr() throws RecognitionException {
		InstantiationExprContext _localctx = new InstantiationExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_instantiationExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(NEW);
			setState(206);
			match(Identifier);
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(207);
				typeNameGeneric();
				}
			}

			setState(210);
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
		public TerminalNode AT() { return getToken(FRJParser.AT, 0); }
		public TerminalNode LBRACK() { return getToken(FRJParser.LBRACK, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(FRJParser.SEMI, 0); }
		public TerminalNode RBRACK() { return getToken(FRJParser.RBRACK, 0); }
		public SignalConstructionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signalConstructionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterSignalConstructionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitSignalConstructionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitSignalConstructionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignalConstructionExprContext signalConstructionExpr() throws RecognitionException {
		SignalConstructionExprContext _localctx = new SignalConstructionExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_signalConstructionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(AT);
			setState(213);
			match(LBRACK);
			setState(214);
			expr(0);
			setState(215);
			match(SEMI);
			setState(216);
			expr(0);
			setState(217);
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
		public TerminalNode AT() { return getToken(FRJParser.AT, 0); }
		public TerminalNode LBRACK() { return getToken(FRJParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(FRJParser.RBRACK, 0); }
		public EmptySignalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptySignalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterEmptySignalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitEmptySignalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitEmptySignalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptySignalExprContext emptySignalExpr() throws RecognitionException {
		EmptySignalExprContext _localctx = new EmptySignalExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_emptySignalExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(AT);
			setState(220);
			match(LBRACK);
			setState(221);
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
		public TerminalNode HEAD() { return getToken(FRJParser.HEAD, 0); }
		public TerminalNode LPAREN() { return getToken(FRJParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FRJParser.RPAREN, 0); }
		public HeadExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterHeadExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitHeadExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitHeadExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadExprContext headExpr() throws RecognitionException {
		HeadExprContext _localctx = new HeadExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_headExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(HEAD);
			setState(224);
			match(LPAREN);
			setState(225);
			expr(0);
			setState(226);
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
		public TerminalNode TAIL() { return getToken(FRJParser.TAIL, 0); }
		public TerminalNode LPAREN() { return getToken(FRJParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FRJParser.RPAREN, 0); }
		public TailExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tailExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterTailExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitTailExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitTailExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TailExprContext tailExpr() throws RecognitionException {
		TailExprContext _localctx = new TailExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_tailExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(TAIL);
			setState(229);
			match(LPAREN);
			setState(230);
			expr(0);
			setState(231);
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
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(FRJParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(FRJParser.COMMA, 0); }
		public LetExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterLetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitLetExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitLetExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetExprContext letExpr() throws RecognitionException {
		LetExprContext _localctx = new LetExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_letExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			typeName();
			setState(234);
			match(Identifier);
			setState(235);
			match(ASSIGN);
			setState(236);
			expr(0);
			setState(237);
			match(COMMA);
			setState(238);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FRJParser.DOT, 0); }
		public TerminalNode AT() { return getToken(FRJParser.AT, 0); }
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public LiftedCallExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_liftedCallExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterLiftedCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitLiftedCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitLiftedCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiftedCallExprContext liftedCallExpr() throws RecognitionException {
		LiftedCallExprContext _localctx = new LiftedCallExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_liftedCallExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			expr(0);
			setState(241);
			match(DOT);
			setState(242);
			match(AT);
			setState(243);
			match(Identifier);
			setState(244);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FRJParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public CallExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallExprContext callExpr() throws RecognitionException {
		CallExprContext _localctx = new CallExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_callExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			expr(0);
			setState(247);
			match(DOT);
			setState(248);
			match(Identifier);
			setState(249);
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DOT() { return getToken(FRJParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(FRJParser.ASSIGN, 0); }
		public FieldAssignExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAssignExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterFieldAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitFieldAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitFieldAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAssignExprContext fieldAssignExpr() throws RecognitionException {
		FieldAssignExprContext _localctx = new FieldAssignExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_fieldAssignExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			expr(0);
			setState(252);
			match(DOT);
			setState(253);
			match(Identifier);
			setState(254);
			match(ASSIGN);
			setState(255);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FRJParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(FRJParser.Identifier, 0); }
		public FieldAccessExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccessExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterFieldAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitFieldAccessExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitFieldAccessExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccessExprContext fieldAccessExpr() throws RecognitionException {
		FieldAccessExprContext _localctx = new FieldAccessExprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_fieldAccessExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			expr(0);
			setState(258);
			match(DOT);
			setState(259);
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
		public TerminalNode LPAREN() { return getToken(FRJParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FRJParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FRJParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FRJParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRJParserListener ) ((FRJParserListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FRJParserVisitor ) return ((FRJParserVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(LPAREN);
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MDF) | (1L << HEAD) | (1L << TAIL) | (1L << NEW))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(262);
				expr(0);
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(263);
					match(COMMA);
					setState(264);
					expr(0);
					}
					}
					setState(269);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(272);
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
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3s\u0115\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\5\4A"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4I\n\4\f\4\16\4L\13\4\3\4\7\4O\n\4\f\4"+
		"\16\4R\13\4\3\4\3\4\7\4V\n\4\f\4\16\4Y\13\4\3\4\7\4\\\n\4\f\4\16\4_\13"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4h\n\4\f\4\16\4k\13\4\3\4\5\4n\n\4\3"+
		"\4\3\4\3\4\3\4\7\4t\n\4\f\4\16\4w\13\4\3\4\5\4z\n\4\3\5\3\5\3\5\3\5\7"+
		"\5\u0080\n\5\f\5\16\5\u0083\13\5\3\6\3\6\3\6\3\7\3\7\3\7\5\7\u008b\n\7"+
		"\3\b\3\b\3\b\3\b\3\t\5\t\u0092\n\t\3\t\3\t\7\t\u0096\n\t\f\t\16\t\u0099"+
		"\13\t\3\t\5\t\u009c\n\t\3\n\3\n\3\n\3\n\3\13\5\13\u00a3\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u00aa\n\13\f\13\16\13\u00ad\13\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00c1\n\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c9\n\16\7\16\u00cb\n"+
		"\16\f\16\16\16\u00ce\13\16\3\17\3\17\3\17\5\17\u00d3\n\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u010c\n\31"+
		"\f\31\16\31\u010f\13\31\5\31\u0111\n\31\3\31\3\31\3\31\2\3\32\32\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\2\2\u011a\2\65\3\2\2\2"+
		"\4:\3\2\2\2\6y\3\2\2\2\b{\3\2\2\2\n\u0084\3\2\2\2\f\u0087\3\2\2\2\16\u008c"+
		"\3\2\2\2\20\u009b\3\2\2\2\22\u009d\3\2\2\2\24\u00a2\3\2\2\2\26\u00b0\3"+
		"\2\2\2\30\u00b5\3\2\2\2\32\u00c0\3\2\2\2\34\u00cf\3\2\2\2\36\u00d6\3\2"+
		"\2\2 \u00dd\3\2\2\2\"\u00e1\3\2\2\2$\u00e6\3\2\2\2&\u00eb\3\2\2\2(\u00f2"+
		"\3\2\2\2*\u00f8\3\2\2\2,\u00fd\3\2\2\2.\u0103\3\2\2\2\60\u0107\3\2\2\2"+
		"\62\64\5\6\4\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2"+
		"\668\3\2\2\2\67\65\3\2\2\289\5\4\3\29\3\3\2\2\2:;\7\b\2\2;<\7J\2\2<=\5"+
		"\32\16\2=>\7G\2\2>\5\3\2\2\2?A\7\4\2\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2B"+
		"C\7\21\2\2CJ\7n\2\2DE\7L\2\2EF\5\f\7\2FG\7K\2\2GI\3\2\2\2HD\3\2\2\2IL"+
		"\3\2\2\2JH\3\2\2\2JK\3\2\2\2KP\3\2\2\2LJ\3\2\2\2MO\5\b\5\2NM\3\2\2\2O"+
		"R\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2SW\7C\2\2TV\5\16\b\2"+
		"UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X]\3\2\2\2YW\3\2\2\2Z\\\5\26\f"+
		"\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`z\7D\2"+
		"\2ab\7$\2\2bi\7n\2\2cd\7L\2\2de\5\f\7\2ef\7K\2\2fh\3\2\2\2gc\3\2\2\2h"+
		"k\3\2\2\2ig\3\2\2\2ij\3\2\2\2jm\3\2\2\2ki\3\2\2\2ln\5\n\6\2ml\3\2\2\2"+
		"mn\3\2\2\2no\3\2\2\2ou\7C\2\2pq\5\24\13\2qr\7G\2\2rt\3\2\2\2sp\3\2\2\2"+
		"tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xz\7D\2\2y@\3\2\2\2"+
		"ya\3\2\2\2z\7\3\2\2\2{|\7 \2\2|\u0081\5\20\t\2}~\7H\2\2~\u0080\5\20\t"+
		"\2\177}\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2"+
		"\2\2\u0082\t\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7\31\2\2\u0085\u0086"+
		"\5\20\t\2\u0086\13\3\2\2\2\u0087\u008a\7n\2\2\u0088\u0089\7\31\2\2\u0089"+
		"\u008b\5\20\t\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\r\3\2\2"+
		"\2\u008c\u008d\5\20\t\2\u008d\u008e\7n\2\2\u008e\u008f\7G\2\2\u008f\17"+
		"\3\2\2\2\u0090\u0092\7\3\2\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0097\7n\2\2\u0094\u0096\5\22\n\2\u0095\u0094\3\2"+
		"\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u009c\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009c\7n\2\2\u009b\u0091\3\2"+
		"\2\2\u009b\u009a\3\2\2\2\u009c\21\3\2\2\2\u009d\u009e\7L\2\2\u009e\u009f"+
		"\5\20\t\2\u009f\u00a0\7K\2\2\u00a0\23\3\2\2\2\u00a1\u00a3\7\3\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7\5"+
		"\2\2\u00a5\u00a6\5\20\t\2\u00a6\u00a7\7n\2\2\u00a7\u00ab\7A\2\2\u00a8"+
		"\u00aa\5\30\r\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3"+
		"\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae"+
		"\u00af\7B\2\2\u00af\25\3\2\2\2\u00b0\u00b1\5\24\13\2\u00b1\u00b2\7J\2"+
		"\2\u00b2\u00b3\5\32\16\2\u00b3\u00b4\7G\2\2\u00b4\27\3\2\2\2\u00b5\u00b6"+
		"\5\20\t\2\u00b6\u00b7\7n\2\2\u00b7\31\3\2\2\2\u00b8\u00b9\b\16\1\2\u00b9"+
		"\u00c1\7n\2\2\u00ba\u00c1\5\34\17\2\u00bb\u00c1\5\36\20\2\u00bc\u00c1"+
		"\5 \21\2\u00bd\u00c1\5\"\22\2\u00be\u00c1\5$\23\2\u00bf\u00c1\5&\24\2"+
		"\u00c0\u00b8\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c0\u00bb\3\2\2\2\u00c0\u00bc"+
		"\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1"+
		"\u00cc\3\2\2\2\u00c2\u00c3\f\3\2\2\u00c3\u00c8\7I\2\2\u00c4\u00c9\5(\25"+
		"\2\u00c5\u00c9\5*\26\2\u00c6\u00c9\5.\30\2\u00c7\u00c9\5,\27\2\u00c8\u00c4"+
		"\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9"+
		"\u00cb\3\2\2\2\u00ca\u00c2\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cd\33\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0"+
		"\7\'\2\2\u00d0\u00d2\7n\2\2\u00d1\u00d3\5\22\n\2\u00d2\u00d1\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\5\60\31\2\u00d5\35\3\2"+
		"\2\2\u00d6\u00d7\7o\2\2\u00d7\u00d8\7E\2\2\u00d8\u00d9\5\32\16\2\u00d9"+
		"\u00da\7G\2\2\u00da\u00db\5\32\16\2\u00db\u00dc\7F\2\2\u00dc\37\3\2\2"+
		"\2\u00dd\u00de\7o\2\2\u00de\u00df\7E\2\2\u00df\u00e0\7F\2\2\u00e0!\3\2"+
		"\2\2\u00e1\u00e2\7\6\2\2\u00e2\u00e3\7A\2\2\u00e3\u00e4\5\32\16\2\u00e4"+
		"\u00e5\7B\2\2\u00e5#\3\2\2\2\u00e6\u00e7\7\7\2\2\u00e7\u00e8\7A\2\2\u00e8"+
		"\u00e9\5\32\16\2\u00e9\u00ea\7B\2\2\u00ea%\3\2\2\2\u00eb\u00ec\5\20\t"+
		"\2\u00ec\u00ed\7n\2\2\u00ed\u00ee\7J\2\2\u00ee\u00ef\5\32\16\2\u00ef\u00f0"+
		"\7H\2\2\u00f0\u00f1\5\32\16\2\u00f1\'\3\2\2\2\u00f2\u00f3\5\32\16\2\u00f3"+
		"\u00f4\7I\2\2\u00f4\u00f5\7o\2\2\u00f5\u00f6\7n\2\2\u00f6\u00f7\5\60\31"+
		"\2\u00f7)\3\2\2\2\u00f8\u00f9\5\32\16\2\u00f9\u00fa\7I\2\2\u00fa\u00fb"+
		"\7n\2\2\u00fb\u00fc\5\60\31\2\u00fc+\3\2\2\2\u00fd\u00fe\5\32\16\2\u00fe"+
		"\u00ff\7I\2\2\u00ff\u0100\7n\2\2\u0100\u0101\7J\2\2\u0101\u0102\5\32\16"+
		"\2\u0102-\3\2\2\2\u0103\u0104\5\32\16\2\u0104\u0105\7I\2\2\u0105\u0106"+
		"\7n\2\2\u0106/\3\2\2\2\u0107\u0110\7A\2\2\u0108\u010d\5\32\16\2\u0109"+
		"\u010a\7H\2\2\u010a\u010c\5\32\16\2\u010b\u0109\3\2\2\2\u010c\u010f\3"+
		"\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0111\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0108\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2"+
		"\2\2\u0112\u0113\7B\2\2\u0113\61\3\2\2\2\31\65@JPW]imuy\u0081\u008a\u0091"+
		"\u0097\u009b\u00a2\u00ab\u00c0\u00c8\u00cc\u00d2\u010d\u0110";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}