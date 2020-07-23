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
	| instantiationExpr
	| signalConstructionExpr
	| emptySignalExpr
	| headExpr
	| tailExpr
	| letExpr
	| expr DOT (liftedCallExpr | callExpr | fieldAccessExpr | fieldAssignExpr)
	;

instantiationExpr : NEW Identifier typeNameGeneric? argumentList;
signalConstructionExpr : AT LBRACK expr SEMI expr RBRACK;
emptySignalExpr : AT LBRACK RBRACK;
headExpr : HEAD LPAREN expr RPAREN;
tailExpr : TAIL LPAREN expr RPAREN;
letExpr : typeName Identifier ASSIGN expr COMMA expr;
liftedCallExpr : expr DOT AT Identifier argumentList;
callExpr : expr DOT Identifier argumentList;
fieldAssignExpr : expr DOT Identifier ASSIGN expr;
fieldAccessExpr : expr DOT Identifier;

argumentList : LPAREN (expr (COMMA expr)*)? RPAREN;
