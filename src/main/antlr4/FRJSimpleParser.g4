parser grammar FRJSimpleParser;
@header {package antlrGenerated;}
options {
	tokenVocab = FRJLexer;
}

program : classDeclaration* main;

main : MAIN ASSIGN expr SEMI;

classDeclaration
	: CAP? CLASS Identifier implementsDeclaration? LBRACE fieldDeclaration* methodDeclaration* RBRACE
	| INTERFACE Identifier extendsDeclaration? LBRACE (methodHeader SEMI)* RBRACE
	;

implementsDeclaration : IMPLEMENTS Identifier (COMMA Identifier)*;
extendsDeclaration : EXTENDS Identifier (COMMA Identifier)*;

//constructor : Identifier LPAREN (methodArgument)* RPAREN LBRACE ; // TODO: I don't think we need a constructor if it's the same every time

fieldDeclaration : typeName Identifier SEMI;

typeName : MDF? Identifier;

methodHeader : MDF? METHOD typeName Identifier LPAREN (methodDeclarationArgument (COMMA methodDeclarationArgument)*)? RPAREN;

methodDeclaration : methodHeader ASSIGN expr SEMI;

methodDeclarationArgument : typeName Identifier;

expr
	: instantiationExpr
	| signalConstructionExpr
	| emptySignalExpr
	| headExpr
	| tailExpr
	| letExpr
	| expr DOT (liftedCallExpr | callExpr | fieldAccessExpr | fieldAssignExpr)
	| THIS
	| IntegerLiteral
	| FloatingPointLiteral
	| StringLiteral
	| BooleanLiteral
	| Identifier
	;

instantiationExpr : NEW Identifier argumentList;
signalConstructionExpr : AT LBRACK expr SEMI expr RBRACK;
emptySignalExpr : AT LBRACK RBRACK;
headExpr : HEAD LPAREN expr RPAREN;
tailExpr : TAIL LPAREN expr RPAREN;
letExpr : typeName Identifier ASSIGN expr COMMA expr;
liftedCallExpr : AT Identifier argumentList;
callExpr : Identifier argumentList;
fieldAssignExpr : Identifier ASSIGN expr;
fieldAccessExpr : Identifier;

argumentList : LPAREN (expr (COMMA expr)*)? RPAREN;
