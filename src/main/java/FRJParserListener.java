// Generated from /home/nick/Programming/uni/COMP489/compiler/src/main/antlr4/FRJParser.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FRJParser}.
 */
public interface FRJParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FRJParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FRJParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FRJParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(FRJParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(FRJParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(FRJParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(FRJParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#implementsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImplementsDeclaration(FRJParser.ImplementsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#implementsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImplementsDeclaration(FRJParser.ImplementsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#extendsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExtendsDeclaration(FRJParser.ExtendsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#extendsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExtendsDeclaration(FRJParser.ExtendsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#genericDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericDeclaration(FRJParser.GenericDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#genericDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericDeclaration(FRJParser.GenericDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(FRJParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(FRJParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(FRJParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(FRJParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#typeNameGeneric}.
	 * @param ctx the parse tree
	 */
	void enterTypeNameGeneric(FRJParser.TypeNameGenericContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#typeNameGeneric}.
	 * @param ctx the parse tree
	 */
	void exitTypeNameGeneric(FRJParser.TypeNameGenericContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(FRJParser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(FRJParser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(FRJParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(FRJParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#methodDeclarationArgument}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarationArgument(FRJParser.MethodDeclarationArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#methodDeclarationArgument}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarationArgument(FRJParser.MethodDeclarationArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(FRJParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(FRJParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(FRJParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(FRJParser.ArgumentListContext ctx);
}