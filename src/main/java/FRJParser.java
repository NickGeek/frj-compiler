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
		RULE_methodDeclarationArgument = 11, RULE_expr = 12, RULE_argumentList = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "classDeclaration", "implementsDeclaration", "extendsDeclaration", 
			"genericDeclaration", "fieldDeclaration", "typeName", "typeNameGeneric", 
			"methodHeader", "methodDeclaration", "methodDeclarationArgument", "expr", 
			"argumentList"
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
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CAP) | (1L << CLASS) | (1L << INTERFACE))) != 0)) {
				{
				{
				setState(28);
				classDeclaration();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
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
			setState(36);
			match(MAIN);
			setState(37);
			match(ASSIGN);
			setState(38);
			expr(0);
			setState(39);
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
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAP:
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CAP) {
					{
					setState(41);
					match(CAP);
					}
				}

				setState(44);
				match(CLASS);
				setState(45);
				match(Identifier);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LT) {
					{
					{
					setState(46);
					match(LT);
					setState(47);
					genericDeclaration();
					setState(48);
					match(GT);
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IMPLEMENTS) {
					{
					{
					setState(55);
					implementsDeclaration();
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(61);
				match(LBRACE);
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(62);
						fieldDeclaration();
						}
						} 
					}
					setState(67);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MDF || _la==METHOD) {
					{
					{
					setState(68);
					methodDeclaration();
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(74);
				match(RBRACE);
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(INTERFACE);
				setState(76);
				match(Identifier);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LT) {
					{
					{
					setState(77);
					match(LT);
					setState(78);
					genericDeclaration();
					setState(79);
					match(GT);
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTENDS) {
					{
					setState(86);
					extendsDeclaration();
					}
				}

				setState(89);
				match(LBRACE);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MDF || _la==METHOD) {
					{
					{
					setState(90);
					methodHeader();
					setState(91);
					match(SEMI);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98);
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
			setState(101);
			match(IMPLEMENTS);
			setState(102);
			typeName();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(103);
				match(COMMA);
				setState(104);
				typeName();
				}
				}
				setState(109);
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
			setState(110);
			match(EXTENDS);
			setState(111);
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
			setState(113);
			match(Identifier);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(114);
				match(EXTENDS);
				setState(115);
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
			setState(118);
			typeName();
			setState(119);
			match(Identifier);
			setState(120);
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
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MDF) {
					{
					setState(122);
					match(MDF);
					}
				}

				setState(125);
				match(Identifier);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LT) {
					{
					{
					setState(126);
					typeNameGeneric();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
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
			setState(135);
			match(LT);
			setState(136);
			typeName();
			setState(137);
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
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MDF) {
				{
				setState(139);
				match(MDF);
				}
			}

			setState(142);
			match(METHOD);
			setState(143);
			typeName();
			setState(144);
			match(Identifier);
			setState(145);
			match(LPAREN);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MDF || _la==Identifier) {
				{
				{
				setState(146);
				methodDeclarationArgument();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
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
			setState(154);
			methodHeader();
			setState(155);
			match(ASSIGN);
			setState(156);
			expr(0);
			setState(157);
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
			setState(159);
			typeName();
			setState(160);
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
		public TerminalNode NEW() { return getToken(FRJParser.NEW, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TypeNameGenericContext typeNameGeneric() {
			return getRuleContext(TypeNameGenericContext.class,0);
		}
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
		public TerminalNode HEAD() { return getToken(FRJParser.HEAD, 0); }
		public TerminalNode LPAREN() { return getToken(FRJParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FRJParser.RPAREN, 0); }
		public TerminalNode TAIL() { return getToken(FRJParser.TAIL, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(FRJParser.ASSIGN, 0); }
		public TerminalNode DOT() { return getToken(FRJParser.DOT, 0); }
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(163);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(164);
				match(NEW);
				setState(165);
				match(Identifier);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(166);
					typeNameGeneric();
					}
				}

				setState(169);
				argumentList();
				}
				break;
			case 3:
				{
				setState(170);
				match(AT);
				setState(171);
				match(LBRACK);
				setState(172);
				expr(0);
				setState(173);
				match(SEMI);
				setState(174);
				expr(0);
				setState(175);
				match(RBRACK);
				}
				break;
			case 4:
				{
				setState(177);
				match(AT);
				setState(178);
				match(LBRACK);
				setState(179);
				match(RBRACK);
				}
				break;
			case 5:
				{
				setState(180);
				match(HEAD);
				setState(181);
				match(LPAREN);
				setState(182);
				expr(0);
				setState(183);
				match(RPAREN);
				}
				break;
			case 6:
				{
				setState(185);
				match(TAIL);
				setState(186);
				match(LPAREN);
				setState(187);
				expr(0);
				setState(188);
				match(RPAREN);
				}
				break;
			case 7:
				{
				setState(190);
				typeName();
				setState(191);
				match(Identifier);
				setState(192);
				match(ASSIGN);
				setState(193);
				expr(0);
				setState(194);
				match(SEMI);
				setState(195);
				expr(5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(216);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(199);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(200);
						match(DOT);
						setState(201);
						match(Identifier);
						setState(202);
						match(ASSIGN);
						setState(203);
						expr(3);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(204);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(205);
						match(DOT);
						setState(206);
						match(AT);
						setState(207);
						match(Identifier);
						setState(208);
						argumentList();
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(210);
						match(DOT);
						setState(211);
						match(Identifier);
						setState(212);
						argumentList();
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(213);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(214);
						match(DOT);
						setState(215);
						match(Identifier);
						}
						break;
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		enterRule(_localctx, 26, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(LPAREN);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MDF) | (1L << HEAD) | (1L << TAIL) | (1L << NEW))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(222);
				expr(0);
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(223);
					match(COMMA);
					setState(224);
					expr(0);
					}
					}
					setState(229);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(232);
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
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3s\u00ed\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\7\2 \n\2\f\2\16\2#\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\5\4-\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\65"+
		"\n\4\f\4\16\48\13\4\3\4\7\4;\n\4\f\4\16\4>\13\4\3\4\3\4\7\4B\n\4\f\4\16"+
		"\4E\13\4\3\4\7\4H\n\4\f\4\16\4K\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4T"+
		"\n\4\f\4\16\4W\13\4\3\4\5\4Z\n\4\3\4\3\4\3\4\3\4\7\4`\n\4\f\4\16\4c\13"+
		"\4\3\4\5\4f\n\4\3\5\3\5\3\5\3\5\7\5l\n\5\f\5\16\5o\13\5\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\5\7w\n\7\3\b\3\b\3\b\3\b\3\t\5\t~\n\t\3\t\3\t\7\t\u0082\n\t"+
		"\f\t\16\t\u0085\13\t\3\t\5\t\u0088\n\t\3\n\3\n\3\n\3\n\3\13\5\13\u008f"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\7\13\u0096\n\13\f\13\16\13\u0099\13\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u00aa\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00c8\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00db\n\16\f\16\16"+
		"\16\u00de\13\16\3\17\3\17\3\17\3\17\7\17\u00e4\n\17\f\17\16\17\u00e7\13"+
		"\17\5\17\u00e9\n\17\3\17\3\17\3\17\2\3\32\20\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\2\2\2\u00fc\2!\3\2\2\2\4&\3\2\2\2\6e\3\2\2\2\bg\3\2\2\2\np\3"+
		"\2\2\2\fs\3\2\2\2\16x\3\2\2\2\20\u0087\3\2\2\2\22\u0089\3\2\2\2\24\u008e"+
		"\3\2\2\2\26\u009c\3\2\2\2\30\u00a1\3\2\2\2\32\u00c7\3\2\2\2\34\u00df\3"+
		"\2\2\2\36 \5\6\4\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3"+
		"\2\2\2#!\3\2\2\2$%\5\4\3\2%\3\3\2\2\2&\'\7\b\2\2\'(\7J\2\2()\5\32\16\2"+
		")*\7G\2\2*\5\3\2\2\2+-\7\4\2\2,+\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7\21\2"+
		"\2/\66\7n\2\2\60\61\7L\2\2\61\62\5\f\7\2\62\63\7K\2\2\63\65\3\2\2\2\64"+
		"\60\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67<\3\2\2\28\66\3"+
		"\2\2\29;\5\b\5\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3"+
		"\2\2\2?C\7C\2\2@B\5\16\b\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DI\3"+
		"\2\2\2EC\3\2\2\2FH\5\26\f\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL"+
		"\3\2\2\2KI\3\2\2\2Lf\7D\2\2MN\7$\2\2NU\7n\2\2OP\7L\2\2PQ\5\f\7\2QR\7K"+
		"\2\2RT\3\2\2\2SO\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VY\3\2\2\2WU\3\2"+
		"\2\2XZ\5\n\6\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[a\7C\2\2\\]\5\24\13\2]^\7"+
		"G\2\2^`\3\2\2\2_\\\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3"+
		"\2\2\2df\7D\2\2e,\3\2\2\2eM\3\2\2\2f\7\3\2\2\2gh\7 \2\2hm\5\20\t\2ij\7"+
		"H\2\2jl\5\20\t\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\t\3\2\2\2om"+
		"\3\2\2\2pq\7\31\2\2qr\5\20\t\2r\13\3\2\2\2sv\7n\2\2tu\7\31\2\2uw\5\20"+
		"\t\2vt\3\2\2\2vw\3\2\2\2w\r\3\2\2\2xy\5\20\t\2yz\7n\2\2z{\7G\2\2{\17\3"+
		"\2\2\2|~\7\3\2\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0083\7n\2\2\u0080"+
		"\u0082\5\22\n\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3"+
		"\2\2\2\u0083\u0084\3\2\2\2\u0084\u0088\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0088\7n\2\2\u0087}\3\2\2\2\u0087\u0086\3\2\2\2\u0088\21\3\2\2\2\u0089"+
		"\u008a\7L\2\2\u008a\u008b\5\20\t\2\u008b\u008c\7K\2\2\u008c\23\3\2\2\2"+
		"\u008d\u008f\7\3\2\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\u0091\7\5\2\2\u0091\u0092\5\20\t\2\u0092\u0093\7n\2\2\u0093"+
		"\u0097\7A\2\2\u0094\u0096\5\30\r\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2"+
		"\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009b\7B\2\2\u009b\25\3\2\2\2\u009c\u009d\5\24\13"+
		"\2\u009d\u009e\7J\2\2\u009e\u009f\5\32\16\2\u009f\u00a0\7G\2\2\u00a0\27"+
		"\3\2\2\2\u00a1\u00a2\5\20\t\2\u00a2\u00a3\7n\2\2\u00a3\31\3\2\2\2\u00a4"+
		"\u00a5\b\16\1\2\u00a5\u00c8\7n\2\2\u00a6\u00a7\7\'\2\2\u00a7\u00a9\7n"+
		"\2\2\u00a8\u00aa\5\22\n\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00c8\5\34\17\2\u00ac\u00ad\7o\2\2\u00ad\u00ae\7"+
		"E\2\2\u00ae\u00af\5\32\16\2\u00af\u00b0\7G\2\2\u00b0\u00b1\5\32\16\2\u00b1"+
		"\u00b2\7F\2\2\u00b2\u00c8\3\2\2\2\u00b3\u00b4\7o\2\2\u00b4\u00b5\7E\2"+
		"\2\u00b5\u00c8\7F\2\2\u00b6\u00b7\7\6\2\2\u00b7\u00b8\7A\2\2\u00b8\u00b9"+
		"\5\32\16\2\u00b9\u00ba\7B\2\2\u00ba\u00c8\3\2\2\2\u00bb\u00bc\7\7\2\2"+
		"\u00bc\u00bd\7A\2\2\u00bd\u00be\5\32\16\2\u00be\u00bf\7B\2\2\u00bf\u00c8"+
		"\3\2\2\2\u00c0\u00c1\5\20\t\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7J\2\2\u00c3"+
		"\u00c4\5\32\16\2\u00c4\u00c5\7G\2\2\u00c5\u00c6\5\32\16\7\u00c6\u00c8"+
		"\3\2\2\2\u00c7\u00a4\3\2\2\2\u00c7\u00a6\3\2\2\2\u00c7\u00ac\3\2\2\2\u00c7"+
		"\u00b3\3\2\2\2\u00c7\u00b6\3\2\2\2\u00c7\u00bb\3\2\2\2\u00c7\u00c0\3\2"+
		"\2\2\u00c8\u00dc\3\2\2\2\u00c9\u00ca\f\4\2\2\u00ca\u00cb\7I\2\2\u00cb"+
		"\u00cc\7n\2\2\u00cc\u00cd\7J\2\2\u00cd\u00db\5\32\16\5\u00ce\u00cf\f\6"+
		"\2\2\u00cf\u00d0\7I\2\2\u00d0\u00d1\7o\2\2\u00d1\u00d2\7n\2\2\u00d2\u00db"+
		"\5\34\17\2\u00d3\u00d4\f\5\2\2\u00d4\u00d5\7I\2\2\u00d5\u00d6\7n\2\2\u00d6"+
		"\u00db\5\34\17\2\u00d7\u00d8\f\3\2\2\u00d8\u00d9\7I\2\2\u00d9\u00db\7"+
		"n\2\2\u00da\u00c9\3\2\2\2\u00da\u00ce\3\2\2\2\u00da\u00d3\3\2\2\2\u00da"+
		"\u00d7\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2"+
		"\2\2\u00dd\33\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e8\7A\2\2\u00e0\u00e5"+
		"\5\32\16\2\u00e1\u00e2\7H\2\2\u00e2\u00e4\5\32\16\2\u00e3\u00e1\3\2\2"+
		"\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e9"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e0\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea\u00eb\7B\2\2\u00eb\35\3\2\2\2\31!,\66<CIUYaemv}\u0083"+
		"\u0087\u008e\u0097\u00a9\u00c7\u00da\u00dc\u00e5\u00e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}