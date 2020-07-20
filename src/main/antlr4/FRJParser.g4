parser grammar FRJParser;

options {
	tokenVocab = FRJLexer;
}

program : classDeclaration* main;

main : MAIN ASSIGN expr SEMI;

classDeclaration
	: CAP? CLASS Identifier (LT genericDeclaration GT)* implementsDeclaration* LBRACE fieldDeclaration* methodDeclaration* RBRACE
	| INTERFACE Identifier (LT genericDeclaration GT)* extendsDeclaration? LBRACE (methodHeader SEMI)* RBRACE
	;

implementsDeclaration : IMPLEMENTS typeName (COMMA typeName)*;
extendsDeclaration : EXTENDS typeName;

genericDeclaration : Identifier (EXTENDS typeName)?;

//constructor : Identifier LPAREN (methodArgument)* RPAREN LBRACE ; // TODO: I don't think we need a constructor if it's the same every time

fieldDeclaration : typeName Identifier SEMI;

typeName
	: MDF? Identifier typeNameGeneric*
	| Identifier
	;

typeNameGeneric : LT typeName GT;

methodHeader : MDF? METHOD typeName Identifier LPAREN methodDeclarationArgument* RPAREN;

methodDeclaration : methodHeader ASSIGN expr SEMI;

methodDeclarationArgument : typeName Identifier;

expr
	: Identifier
	| NEW Identifier typeNameGeneric? argumentList // new
	| AT LBRACK expr SEMI expr RBRACK // signal constructor
	| AT LBRACK RBRACK // empty signal
	| HEAD LPAREN expr RPAREN // head
	| TAIL LPAREN expr RPAREN // tail
	| typeName Identifier ASSIGN expr SEMI expr
	| expr DOT AT Identifier argumentList // lifted method call
	| expr DOT Identifier argumentList // method call
	| expr DOT Identifier ASSIGN expr // field assign
	| expr DOT Identifier // field access
	;

argumentList : LPAREN (expr (COMMA expr)*)? RPAREN;
