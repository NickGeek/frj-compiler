package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.stream.Collectors;

@ToString
public class Program {
	public static Program fromCtx(FRJSimpleParser.ProgramContext ctx) {
		var classDecs = ctx.classDeclaration()
				.stream()
				.map(Program::ctxToClassDeclaration)
				.collect(Collectors.toMap(cd -> cd.name, cd -> cd));

		var mainExpr = exprCtxToExpression(ctx.main().expr());

		return new Program(classDecs, mainExpr);
	}

	final Map<String, ClassDeclaration> classDeclarations;
	final Expression main;

	public Program(Map<String, ClassDeclaration> classDeclarations, Expression main) {
		this.classDeclarations = classDeclarations;
		this.main = main;
	}

	private static Program.ClassDeclaration ctxToClassDeclaration(FRJSimpleParser.ClassDeclarationContext ctx) {
		var implNode = ctx.implementsDeclaration();
		List<String> impl = Collections.emptyList();
		if (implNode != null) {
			impl = ctx.implementsDeclaration().Identifier().stream()
					.map(ParseTree::getText)
					.collect(Collectors.toList());
		}

		var extendsNode = ctx.extendsDeclaration();
		List<String> extend = Collections.emptyList();
		if (extendsNode != null) {
			extend = ctx.extendsDeclaration().Identifier().stream()
					.map(ParseTree::getText)
					.collect(Collectors.toList());
		}

		var fields = ctx.fieldDeclaration().stream()
				.map(fieldCtx -> new Field(typeNameCtxToType(fieldCtx.typeName()), fieldCtx.Identifier().getText()))
				.collect(Collectors.toMap(f -> f.name, f -> f));

		var methods = ctx.methodDeclaration().stream()
				.map(methodCtx -> {
					var header = methodCtx.methodHeader();
					return new Method(
							mdfTerminalToModifier(header.MDF()),
							typeNameCtxToType(header.typeName()),
							header.Identifier().getText(),
							exprCtxToExpression(methodCtx.expr())
					);
				})
				.collect(Collectors.toMap(meth -> meth.name, meth -> meth));

		return new Program.ClassDeclaration(
				ctx.CAP() != null,
				ctx.INTERFACE() != null,
				ctx.Identifier().getText(),
				impl,
				extend,
				fields,
				methods
		);
	}

	private static Program.Type typeNameCtxToType(FRJSimpleParser.TypeNameContext ctx) {
		var mdf = mdfTerminalToModifier(ctx.MDF());
		return new Type(mdf, ctx.Identifier().getText());
	}

	private static Program.Modifier mdfTerminalToModifier(TerminalNode mdf) {
		return mdf != null ? Modifier.fromLiteral(mdf.getText()) : Modifier.IMM;
	}

	private static Expression exprCtxToExpression(FRJSimpleParser.ExprContext ctx) {
		if (ctx.callExpr() != null) {
			return new Expression.CallExpr(
					exprCtxToExpression(ctx.expr()),
					ctx.callExpr().Identifier().getText(),
					ctx.callExpr()
							.argumentList()
							.expr()
							.stream()
							.map(Program::exprCtxToExpression)
							.collect(Collectors.toList())
			);
		}
		if (ctx.instantiationExpr() != null) {
			return new Expression.InstantiationExpr(
					ctx.instantiationExpr().Identifier().getText(),
					ctx.instantiationExpr()
							.argumentList()
							.expr()
							.stream()
							.map(Program::exprCtxToExpression)
							.collect(Collectors.toList())
			);
		}
		if (ctx.fieldAccessExpr() != null) {
			return new Expression.FieldAccessExpr(exprCtxToExpression(ctx.expr()), ctx.fieldAccessExpr().Identifier().getText());
		}
		if (ctx.THIS() != null) {
			return new Expression.ThisExpr();
		}

		throw new IllegalStateException(String.format("Unexpected expression: %s", ctx.getText()));
	}

	enum Modifier {
		MUT,
		IMM,
		CAPSULE,
		READ;

		public static Modifier fromLiteral(String literal) {
			return Modifier.valueOf(literal.toUpperCase());
		}
	}

	@ToString
	@AllArgsConstructor
	static class ClassDeclaration {
		public final boolean isCapability;
		public final boolean isInterface;
		public final String name;
		public final List<String> impl;
		public final List<String> extend;
		public final Map<String, Field> fields;
		public final Map<String, Method> methods;
	}

	@ToString
	@AllArgsConstructor
	static class Field {
		public final Type type;
		public final String name;
	}

	@ToString
	@AllArgsConstructor
	static class Method {
		public final Modifier mdf;
		public final Type returnType;
		public final String name;
		public final Expression expression;
	}

	@ToString
	@AllArgsConstructor
	static class Type {
		public final Modifier mdf;
		public final String name;
	}
}
