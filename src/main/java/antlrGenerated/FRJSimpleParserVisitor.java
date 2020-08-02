// Generated from /home/nick/Programming/uni/COMP489/compiler/src/main/antlr4/FRJSimpleParser.g4 by ANTLR 4.8
package antlrGenerated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FRJSimpleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FRJSimpleParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FRJSimpleParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(FRJSimpleParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(FRJSimpleParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#implementsDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplementsDeclaration(FRJSimpleParser.ImplementsDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#extendsDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendsDeclaration(FRJSimpleParser.ExtendsDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(FRJSimpleParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(FRJSimpleParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#liftedTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiftedTypeName(FRJSimpleParser.LiftedTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(FRJSimpleParser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(FRJSimpleParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#methodDeclarationArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarationArgument(FRJSimpleParser.MethodDeclarationArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(FRJSimpleParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#instantiationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiationExpr(FRJSimpleParser.InstantiationExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#signalConstructionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignalConstructionExpr(FRJSimpleParser.SignalConstructionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#emptySignalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptySignalExpr(FRJSimpleParser.EmptySignalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#headExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeadExpr(FRJSimpleParser.HeadExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#tailExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTailExpr(FRJSimpleParser.TailExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#letExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExpr(FRJSimpleParser.LetExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#liftedCallExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiftedCallExpr(FRJSimpleParser.LiftedCallExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#callExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(FRJSimpleParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#fieldAssignExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAssignExpr(FRJSimpleParser.FieldAssignExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#fieldAccessExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccessExpr(FRJSimpleParser.FieldAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJSimpleParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(FRJSimpleParser.ArgumentListContext ctx);
}