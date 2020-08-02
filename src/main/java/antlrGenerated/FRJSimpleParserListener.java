// Generated from /home/nick/Programming/uni/COMP489/compiler/src/main/antlr4/FRJSimpleParser.g4 by ANTLR 4.8
package antlrGenerated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FRJSimpleParser}.
 */
public interface FRJSimpleParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FRJSimpleParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FRJSimpleParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(FRJSimpleParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(FRJSimpleParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(FRJSimpleParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(FRJSimpleParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#implementsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImplementsDeclaration(FRJSimpleParser.ImplementsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#implementsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImplementsDeclaration(FRJSimpleParser.ImplementsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#extendsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExtendsDeclaration(FRJSimpleParser.ExtendsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#extendsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExtendsDeclaration(FRJSimpleParser.ExtendsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(FRJSimpleParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(FRJSimpleParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(FRJSimpleParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(FRJSimpleParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#liftedTypeName}.
	 * @param ctx the parse tree
	 */
	void enterLiftedTypeName(FRJSimpleParser.LiftedTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#liftedTypeName}.
	 * @param ctx the parse tree
	 */
	void exitLiftedTypeName(FRJSimpleParser.LiftedTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(FRJSimpleParser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(FRJSimpleParser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(FRJSimpleParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(FRJSimpleParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#methodDeclarationArgument}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarationArgument(FRJSimpleParser.MethodDeclarationArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#methodDeclarationArgument}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarationArgument(FRJSimpleParser.MethodDeclarationArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(FRJSimpleParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(FRJSimpleParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#instantiationExpr}.
	 * @param ctx the parse tree
	 */
	void enterInstantiationExpr(FRJSimpleParser.InstantiationExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#instantiationExpr}.
	 * @param ctx the parse tree
	 */
	void exitInstantiationExpr(FRJSimpleParser.InstantiationExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#signalConstructionExpr}.
	 * @param ctx the parse tree
	 */
	void enterSignalConstructionExpr(FRJSimpleParser.SignalConstructionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#signalConstructionExpr}.
	 * @param ctx the parse tree
	 */
	void exitSignalConstructionExpr(FRJSimpleParser.SignalConstructionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#emptySignalExpr}.
	 * @param ctx the parse tree
	 */
	void enterEmptySignalExpr(FRJSimpleParser.EmptySignalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#emptySignalExpr}.
	 * @param ctx the parse tree
	 */
	void exitEmptySignalExpr(FRJSimpleParser.EmptySignalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#headExpr}.
	 * @param ctx the parse tree
	 */
	void enterHeadExpr(FRJSimpleParser.HeadExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#headExpr}.
	 * @param ctx the parse tree
	 */
	void exitHeadExpr(FRJSimpleParser.HeadExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#tailExpr}.
	 * @param ctx the parse tree
	 */
	void enterTailExpr(FRJSimpleParser.TailExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#tailExpr}.
	 * @param ctx the parse tree
	 */
	void exitTailExpr(FRJSimpleParser.TailExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#letExpr}.
	 * @param ctx the parse tree
	 */
	void enterLetExpr(FRJSimpleParser.LetExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#letExpr}.
	 * @param ctx the parse tree
	 */
	void exitLetExpr(FRJSimpleParser.LetExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#liftedCallExpr}.
	 * @param ctx the parse tree
	 */
	void enterLiftedCallExpr(FRJSimpleParser.LiftedCallExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#liftedCallExpr}.
	 * @param ctx the parse tree
	 */
	void exitLiftedCallExpr(FRJSimpleParser.LiftedCallExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#callExpr}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(FRJSimpleParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#callExpr}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(FRJSimpleParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#fieldAssignExpr}.
	 * @param ctx the parse tree
	 */
	void enterFieldAssignExpr(FRJSimpleParser.FieldAssignExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#fieldAssignExpr}.
	 * @param ctx the parse tree
	 */
	void exitFieldAssignExpr(FRJSimpleParser.FieldAssignExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#fieldAccessExpr}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccessExpr(FRJSimpleParser.FieldAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#fieldAccessExpr}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccessExpr(FRJSimpleParser.FieldAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRJSimpleParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(FRJSimpleParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRJSimpleParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(FRJSimpleParser.ArgumentListContext ctx);
}