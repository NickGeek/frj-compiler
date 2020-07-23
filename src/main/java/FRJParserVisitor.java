// Generated from /home/nick/Programming/uni/COMP489/compiler/src/main/antlr4/FRJParser.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FRJParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FRJParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FRJParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FRJParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(FRJParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(FRJParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#implementsDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplementsDeclaration(FRJParser.ImplementsDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#extendsDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendsDeclaration(FRJParser.ExtendsDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#genericDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericDeclaration(FRJParser.GenericDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(FRJParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(FRJParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#typeNameGeneric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNameGeneric(FRJParser.TypeNameGenericContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(FRJParser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(FRJParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#methodDeclarationArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarationArgument(FRJParser.MethodDeclarationArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(FRJParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#instantiationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiationExpr(FRJParser.InstantiationExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#signalConstructionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignalConstructionExpr(FRJParser.SignalConstructionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#emptySignalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptySignalExpr(FRJParser.EmptySignalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#headExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeadExpr(FRJParser.HeadExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#tailExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTailExpr(FRJParser.TailExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#letExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExpr(FRJParser.LetExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#liftedCallExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiftedCallExpr(FRJParser.LiftedCallExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#callExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(FRJParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#fieldAssignExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAssignExpr(FRJParser.FieldAssignExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#fieldAccessExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccessExpr(FRJParser.FieldAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FRJParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(FRJParser.ArgumentListContext ctx);
}