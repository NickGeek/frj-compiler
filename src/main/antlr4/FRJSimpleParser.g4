parser grammar FRJSimpleParser;
@header {package antlrGenerated;}
options {
	tokenVocab = FRJLexer;
}

program : classDeclaration* main classDeclaration* EOF;

main : MAIN ASSIGN expr SEMI;

classDeclaration
	: CAP? CLASS Identifier implementsDeclaration? LBRACE fieldDeclaration* methodDeclaration* RBRACE
	| INTERFACE Identifier extendsDeclaration? LBRACE (methodHeader SEMI)* RBRACE
	;

implementsDeclaration : IMPLEMENTS Identifier (COMMA Identifier)*;
extendsDeclaration : EXTENDS Identifier (COMMA Identifier)*;

fieldDeclaration : typeName Identifier SEMI;

typeName
	: MDF? Identifier
	| liftedTypeName
	;

liftedTypeName
	: AT Identifier
	| AT liftedTypeName
	;

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
