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
		MDF=1, CAP=2, METHOD=3, HEAD=4, TAIL=5, MAIN=6, DeclarationName=7, ABSTRACT=8, 
		ASSERT=9, BOOLEAN=10, BREAK=11, BYTE=12, CASE=13, CATCH=14, CHAR=15, CLASS=16, 
		CONST=17, CONTINUE=18, DEFAULT=19, DO=20, DOUBLE=21, ELSE=22, ENUM=23, 
		EXTENDS=24, FINAL=25, FINALLY=26, FLOAT=27, FOR=28, IF=29, GOTO=30, IMPLEMENTS=31, 
		IMPORT=32, INSTANCEOF=33, INT=34, INTERFACE=35, LONG=36, NATIVE=37, NEW=38, 
		PACKAGE=39, PRIVATE=40, PROTECTED=41, PUBLIC=42, RETURN=43, SHORT=44, 
		STATIC=45, STRICTFP=46, SUPER=47, SWITCH=48, SYNCHRONIZED=49, THIS=50, 
		THROW=51, THROWS=52, TRANSIENT=53, TRY=54, VOID=55, VOLATILE=56, WHILE=57, 
		IntegerLiteral=58, FloatingPointLiteral=59, BooleanLiteral=60, CharacterLiteral=61, 
		StringLiteral=62, NullLiteral=63, LPAREN=64, RPAREN=65, LBRACE=66, RBRACE=67, 
		LBRACK=68, RBRACK=69, SEMI=70, COMMA=71, DOT=72, ASSIGN=73, GT=74, LT=75, 
		BANG=76, TILDE=77, QUESTION=78, COLON=79, EQUAL=80, LE=81, GE=82, NOTEQUAL=83, 
		AND=84, OR=85, INC=86, DEC=87, ADD=88, SUB=89, MUL=90, DIV=91, BITAND=92, 
		BITOR=93, CARET=94, MOD=95, ARROW=96, COLONCOLON=97, ADD_ASSIGN=98, SUB_ASSIGN=99, 
		MUL_ASSIGN=100, DIV_ASSIGN=101, AND_ASSIGN=102, OR_ASSIGN=103, XOR_ASSIGN=104, 
		MOD_ASSIGN=105, LSHIFT_ASSIGN=106, RSHIFT_ASSIGN=107, URSHIFT_ASSIGN=108, 
		Identifier=109, AT=110, ELLIPSIS=111, WS=112, COMMENT=113, LINE_COMMENT=114;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_classDeclaration = 2, RULE_implementsDeclaration = 3, 
		RULE_extendsDeclaration = 4, RULE_fieldDeclaration = 5, RULE_typeName = 6, 
		RULE_methodHeader = 7, RULE_methodDeclaration = 8, RULE_methodDeclarationArgument = 9, 
		RULE_expr = 10, RULE_instantiationExpr = 11, RULE_signalConstructionExpr = 12, 
		RULE_emptySignalExpr = 13, RULE_headExpr = 14, RULE_tailExpr = 15, RULE_letExpr = 16, 
		RULE_liftedCallExpr = 17, RULE_callExpr = 18, RULE_fieldAssignExpr = 19, 
		RULE_fieldAccessExpr = 20, RULE_argumentList = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "classDeclaration", "implementsDeclaration", "extendsDeclaration", 
			"fieldDeclaration", "typeName", "methodHeader", "methodDeclaration", 
			"methodDeclarationArgument", "expr", "instantiationExpr", "signalConstructionExpr", 
			"emptySignalExpr", "headExpr", "tailExpr", "letExpr", "liftedCallExpr", 
			"callExpr", "fieldAssignExpr", "fieldAccessExpr", "argumentList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'capability'", "'method'", "'head'", "'tail'", "'main'", 
			null, "'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", "'case'", 
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
			null, "MDF", "CAP", "METHOD", "HEAD", "TAIL", "MAIN", "DeclarationName", 
			"ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", 
			"CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", 
			"EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", 
			"IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", "NEW", 
			"PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", 
			"STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS", 
			"TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "IntegerLiteral", "FloatingPointLiteral", 
			"BooleanLiteral", "CharacterLiteral", "StringLiteral", "NullLiteral", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", 
			"DOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", 
			"LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", 
			"DIV", "BITAND", "BITOR", "CARET", "MOD", "ARROW", "COLONCOLON", "ADD_ASSIGN", 
			"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", 
			"XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "URSHIFT_ASSIGN", 
			"Identifier", "AT", "ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT"
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
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CAP) | (1L << CLASS) | (1L << INTERFACE))) != 0)) {
				{
				{
				setState(44);
				classDeclaration();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
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
			setState(52);
			match(MAIN);
			setState(53);
			match(ASSIGN);
			setState(54);
			expr(0);
			setState(55);
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
		public TerminalNode DeclarationName() { return getToken(FRJSimpleParser.DeclarationName, 0); }
		public TerminalNode LBRACE() { return getToken(FRJSimpleParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(FRJSimpleParser.RBRACE, 0); }
		public TerminalNode CAP() { return getToken(FRJSimpleParser.CAP, 0); }
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
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAP:
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CAP) {
					{
					setState(57);
					match(CAP);
					}
				}

				setState(60);
				match(CLASS);
				setState(61);
				match(DeclarationName);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IMPLEMENTS) {
					{
					{
					setState(62);
					implementsDeclaration();
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(68);
				match(LBRACE);
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(69);
						fieldDeclaration();
						}
						} 
					}
					setState(74);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MDF || _la==METHOD) {
					{
					{
					setState(75);
					methodDeclaration();
					}
					}
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(81);
				match(RBRACE);
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(INTERFACE);
				setState(83);
				match(DeclarationName);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTENDS) {
					{
					setState(84);
					extendsDeclaration();
					}
				}

				setState(87);
				match(LBRACE);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MDF || _la==METHOD) {
					{
					{
					setState(88);
					methodHeader();
					setState(89);
					match(SEMI);
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
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
		public List<TypeNameContext> typeName() {
			return getRuleContexts(TypeNameContext.class);
		}
		public TypeNameContext typeName(int i) {
			return getRuleContext(TypeNameContext.class,i);
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
			setState(99);
			match(IMPLEMENTS);
			setState(100);
			typeName();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(101);
				match(COMMA);
				setState(102);
				typeName();
				}
				}
				setState(107);
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
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(EXTENDS);
			setState(109);
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DeclarationName() { return getToken(FRJSimpleParser.DeclarationName, 0); }
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
			setState(111);
			typeName();
			setState(112);
			match(DeclarationName);
			setState(113);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MDF) {
				{
				setState(115);
				match(MDF);
				}
			}

			setState(118);
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

	public static class MethodHeaderContext extends ParserRuleContext {
		public TerminalNode METHOD() { return getToken(FRJSimpleParser.METHOD, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DeclarationName() { return getToken(FRJSimpleParser.DeclarationName, 0); }
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
		enterRule(_localctx, 14, RULE_methodHeader);
		int _la;
		try {
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
			match(METHOD);
			setState(124);
			typeName();
			setState(125);
			match(DeclarationName);
			setState(126);
			match(LPAREN);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MDF || _la==Identifier) {
				{
				setState(127);
				methodDeclarationArgument();
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(128);
					match(COMMA);
					setState(129);
					methodDeclarationArgument();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(137);
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
		enterRule(_localctx, 16, RULE_methodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			methodHeader();
			setState(140);
			match(ASSIGN);
			setState(141);
			expr(0);
			setState(142);
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
		enterRule(_localctx, 18, RULE_methodDeclarationArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			typeName();
			setState(145);
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
		public TerminalNode Identifier() { return getToken(FRJSimpleParser.Identifier, 0); }
		public TerminalNode IntegerLiteral() { return getToken(FRJSimpleParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(FRJSimpleParser.FloatingPointLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(FRJSimpleParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(FRJSimpleParser.BooleanLiteral, 0); }
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(148);
				instantiationExpr();
				}
				break;
			case 2:
				{
				setState(149);
				signalConstructionExpr();
				}
				break;
			case 3:
				{
				setState(150);
				emptySignalExpr();
				}
				break;
			case 4:
				{
				setState(151);
				headExpr();
				}
				break;
			case 5:
				{
				setState(152);
				tailExpr();
				}
				break;
			case 6:
				{
				setState(153);
				letExpr();
				}
				break;
			case 7:
				{
				setState(154);
				match(Identifier);
				}
				break;
			case 8:
				{
				setState(155);
				match(IntegerLiteral);
				}
				break;
			case 9:
				{
				setState(156);
				match(FloatingPointLiteral);
				}
				break;
			case 10:
				{
				setState(157);
				match(StringLiteral);
				}
				break;
			case 11:
				{
				setState(158);
				match(BooleanLiteral);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(161);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(162);
					match(DOT);
					setState(167);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						setState(163);
						liftedCallExpr();
						}
						break;
					case 2:
						{
						setState(164);
						callExpr();
						}
						break;
					case 3:
						{
						setState(165);
						fieldAccessExpr();
						}
						break;
					case 4:
						{
						setState(166);
						fieldAssignExpr();
						}
						break;
					}
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		enterRule(_localctx, 22, RULE_instantiationExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(NEW);
			setState(175);
			match(Identifier);
			setState(176);
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
		enterRule(_localctx, 24, RULE_signalConstructionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(AT);
			setState(179);
			match(LBRACK);
			setState(180);
			expr(0);
			setState(181);
			match(SEMI);
			setState(182);
			expr(0);
			setState(183);
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
		enterRule(_localctx, 26, RULE_emptySignalExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(AT);
			setState(186);
			match(LBRACK);
			setState(187);
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
		enterRule(_localctx, 28, RULE_headExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(HEAD);
			setState(190);
			match(LPAREN);
			setState(191);
			expr(0);
			setState(192);
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
		enterRule(_localctx, 30, RULE_tailExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(TAIL);
			setState(195);
			match(LPAREN);
			setState(196);
			expr(0);
			setState(197);
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
		enterRule(_localctx, 32, RULE_letExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			typeName();
			setState(200);
			match(Identifier);
			setState(201);
			match(ASSIGN);
			setState(202);
			expr(0);
			setState(203);
			match(COMMA);
			setState(204);
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
		enterRule(_localctx, 34, RULE_liftedCallExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(AT);
			setState(207);
			match(Identifier);
			setState(208);
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
		enterRule(_localctx, 36, RULE_callExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(Identifier);
			setState(211);
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
		enterRule(_localctx, 38, RULE_fieldAssignExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(Identifier);
			setState(214);
			match(ASSIGN);
			setState(215);
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
		enterRule(_localctx, 40, RULE_fieldAccessExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
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
		enterRule(_localctx, 42, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(LPAREN);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MDF) | (1L << HEAD) | (1L << TAIL) | (1L << NEW) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(220);
				expr(0);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(221);
					match(COMMA);
					setState(222);
					expr(0);
					}
					}
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(230);
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
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3t\u00eb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\7\2\60\n\2\f\2"+
		"\16\2\63\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\5\4=\n\4\3\4\3\4\3\4\7\4"+
		"B\n\4\f\4\16\4E\13\4\3\4\3\4\7\4I\n\4\f\4\16\4L\13\4\3\4\7\4O\n\4\f\4"+
		"\16\4R\13\4\3\4\3\4\3\4\3\4\5\4X\n\4\3\4\3\4\3\4\3\4\7\4^\n\4\f\4\16\4"+
		"a\13\4\3\4\5\4d\n\4\3\5\3\5\3\5\3\5\7\5j\n\5\f\5\16\5m\13\5\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\b\5\bw\n\b\3\b\3\b\3\t\5\t|\n\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\7\t\u0085\n\t\f\t\16\t\u0088\13\t\5\t\u008a\n\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u00a2\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00aa\n\f\7\f\u00ac"+
		"\n\f\f\f\16\f\u00af\13\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u00e2\n\27"+
		"\f\27\16\27\u00e5\13\27\5\27\u00e7\n\27\3\27\3\27\3\27\2\3\26\30\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\2\2\u00f1\2\61\3\2\2\2\4\66"+
		"\3\2\2\2\6c\3\2\2\2\be\3\2\2\2\nn\3\2\2\2\fq\3\2\2\2\16v\3\2\2\2\20{\3"+
		"\2\2\2\22\u008d\3\2\2\2\24\u0092\3\2\2\2\26\u00a1\3\2\2\2\30\u00b0\3\2"+
		"\2\2\32\u00b4\3\2\2\2\34\u00bb\3\2\2\2\36\u00bf\3\2\2\2 \u00c4\3\2\2\2"+
		"\"\u00c9\3\2\2\2$\u00d0\3\2\2\2&\u00d4\3\2\2\2(\u00d7\3\2\2\2*\u00db\3"+
		"\2\2\2,\u00dd\3\2\2\2.\60\5\6\4\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2"+
		"\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\5\4\3\2\65\3\3\2\2\2"+
		"\66\67\7\b\2\2\678\7K\2\289\5\26\f\29:\7H\2\2:\5\3\2\2\2;=\7\4\2\2<;\3"+
		"\2\2\2<=\3\2\2\2=>\3\2\2\2>?\7\22\2\2?C\7\t\2\2@B\5\b\5\2A@\3\2\2\2BE"+
		"\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FJ\7D\2\2GI\5\f\7\2HG"+
		"\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KP\3\2\2\2LJ\3\2\2\2MO\5\22\n\2"+
		"NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2Sd\7E\2\2"+
		"TU\7%\2\2UW\7\t\2\2VX\5\n\6\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2Y_\7D\2\2Z"+
		"[\5\20\t\2[\\\7H\2\2\\^\3\2\2\2]Z\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2"+
		"\2`b\3\2\2\2a_\3\2\2\2bd\7E\2\2c<\3\2\2\2cT\3\2\2\2d\7\3\2\2\2ef\7!\2"+
		"\2fk\5\16\b\2gh\7I\2\2hj\5\16\b\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2"+
		"\2\2l\t\3\2\2\2mk\3\2\2\2no\7\32\2\2op\5\16\b\2p\13\3\2\2\2qr\5\16\b\2"+
		"rs\7\t\2\2st\7H\2\2t\r\3\2\2\2uw\7\3\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2"+
		"xy\7o\2\2y\17\3\2\2\2z|\7\3\2\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\7\5\2"+
		"\2~\177\5\16\b\2\177\u0080\7\t\2\2\u0080\u0089\7B\2\2\u0081\u0086\5\24"+
		"\13\2\u0082\u0083\7I\2\2\u0083\u0085\5\24\13\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\7C\2\2\u008c\21\3\2\2\2\u008d\u008e\5\20\t"+
		"\2\u008e\u008f\7K\2\2\u008f\u0090\5\26\f\2\u0090\u0091\7H\2\2\u0091\23"+
		"\3\2\2\2\u0092\u0093\5\16\b\2\u0093\u0094\7o\2\2\u0094\25\3\2\2\2\u0095"+
		"\u0096\b\f\1\2\u0096\u00a2\5\30\r\2\u0097\u00a2\5\32\16\2\u0098\u00a2"+
		"\5\34\17\2\u0099\u00a2\5\36\20\2\u009a\u00a2\5 \21\2\u009b\u00a2\5\"\22"+
		"\2\u009c\u00a2\7o\2\2\u009d\u00a2\7<\2\2\u009e\u00a2\7=\2\2\u009f\u00a2"+
		"\7@\2\2\u00a0\u00a2\7>\2\2\u00a1\u0095\3\2\2\2\u00a1\u0097\3\2\2\2\u00a1"+
		"\u0098\3\2\2\2\u00a1\u0099\3\2\2\2\u00a1\u009a\3\2\2\2\u00a1\u009b\3\2"+
		"\2\2\u00a1\u009c\3\2\2\2\u00a1\u009d\3\2\2\2\u00a1\u009e\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00ad\3\2\2\2\u00a3\u00a4\f\b"+
		"\2\2\u00a4\u00a9\7J\2\2\u00a5\u00aa\5$\23\2\u00a6\u00aa\5&\24\2\u00a7"+
		"\u00aa\5*\26\2\u00a8\u00aa\5(\25\2\u00a9\u00a5\3\2\2\2\u00a9\u00a6\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab"+
		"\u00a3\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\27\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7(\2\2\u00b1\u00b2"+
		"\7o\2\2\u00b2\u00b3\5,\27\2\u00b3\31\3\2\2\2\u00b4\u00b5\7p\2\2\u00b5"+
		"\u00b6\7F\2\2\u00b6\u00b7\5\26\f\2\u00b7\u00b8\7H\2\2\u00b8\u00b9\5\26"+
		"\f\2\u00b9\u00ba\7G\2\2\u00ba\33\3\2\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd"+
		"\7F\2\2\u00bd\u00be\7G\2\2\u00be\35\3\2\2\2\u00bf\u00c0\7\6\2\2\u00c0"+
		"\u00c1\7B\2\2\u00c1\u00c2\5\26\f\2\u00c2\u00c3\7C\2\2\u00c3\37\3\2\2\2"+
		"\u00c4\u00c5\7\7\2\2\u00c5\u00c6\7B\2\2\u00c6\u00c7\5\26\f\2\u00c7\u00c8"+
		"\7C\2\2\u00c8!\3\2\2\2\u00c9\u00ca\5\16\b\2\u00ca\u00cb\7o\2\2\u00cb\u00cc"+
		"\7K\2\2\u00cc\u00cd\5\26\f\2\u00cd\u00ce\7I\2\2\u00ce\u00cf\5\26\f\2\u00cf"+
		"#\3\2\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7o\2\2\u00d2\u00d3\5,\27\2\u00d3"+
		"%\3\2\2\2\u00d4\u00d5\7o\2\2\u00d5\u00d6\5,\27\2\u00d6\'\3\2\2\2\u00d7"+
		"\u00d8\7o\2\2\u00d8\u00d9\7K\2\2\u00d9\u00da\5\26\f\2\u00da)\3\2\2\2\u00db"+
		"\u00dc\7o\2\2\u00dc+\3\2\2\2\u00dd\u00e6\7B\2\2\u00de\u00e3\5\26\f\2\u00df"+
		"\u00e0\7I\2\2\u00e0\u00e2\5\26\f\2\u00e1\u00df\3\2\2\2\u00e2\u00e5\3\2"+
		"\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e6\u00de\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00e9\7C\2\2\u00e9-\3\2\2\2\24\61<CJPW_ckv{\u0086\u0089\u00a1"+
		"\u00a9\u00ad\u00e3\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}