package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Map;
import java.util.stream.Collectors;

public interface ProgramNode {
	Position pos();

	@AllArgsConstructor
	@ToString
	class Position {
		public final int line;
		public final int col;

		Position(Token token) {
			this.line = token.getLine();
			this.col = token.getCharPositionInLine();
		}
	}

	@ToString
	@AllArgsConstructor
	class ClassDeclaration implements ProgramNode {
		public final Position pos;
		public final boolean isCapability;
		public final boolean isInterface;
		public final String name;
		public final String[] impl;
		public final String[] extend;
		public final Map<String, BindingDeclaration> fields;
		public final Map<String, Method> methods;

		public static ClassDeclaration ctxToClassDeclaration(FRJSimpleParser.ClassDeclarationContext ctx) {
			var implNode = ctx.implementsDeclaration();
			String[] impl = new String[0];
			if (implNode != null) {
				impl = ctx.implementsDeclaration().Identifier().stream()
						.map(ParseTree::getText)
						.toArray(String[]::new);
			}

			var extendsNode = ctx.extendsDeclaration();
			String[] extend = new String[0];
			if (extendsNode != null) {
				extend = ctx.extendsDeclaration().Identifier().stream()
						.map(ParseTree::getText)
						.toArray(String[]::new);
			}

			var fields = ctx.fieldDeclaration().stream()
					.map(fieldCtx -> new ProgramNode.BindingDeclaration(
							new Position(fieldCtx.start),
							Type.typeNameCtxToType(fieldCtx.typeName()),
							fieldCtx.Identifier().getText()
					))
					.collect(Collectors.toMap(f -> f.name, f -> f));

			var methods = ctx.methodDeclaration().stream()
					.map(methodCtx -> {
						var header = methodCtx.methodHeader();

						return new ProgramNode.Method(
								new Position(methodCtx.start),
								Modifier.mdfTerminalToModifier(header.MDF()),
								Type.typeNameCtxToType(header.typeName()),
								header.Identifier().getText(),
								header.methodDeclarationArgument()
										.stream()
										.map(arg -> new ProgramNode.BindingDeclaration(
												new Position(arg.start),
												Type.typeNameCtxToType(arg.typeName()),
												arg.Identifier().getText()
										))
										.toArray(ProgramNode.BindingDeclaration[]::new),
								Expression.ctxToExpression(methodCtx.expr())
						);
					})
					.collect(Collectors.toMap(meth -> meth.name, meth -> meth));

			return new ProgramNode.ClassDeclaration(
					new Position(ctx.start),
					ctx.CAP() != null,
					ctx.INTERFACE() != null,
					ctx.Identifier().getText(),
					impl,
					extend,
					fields,
					methods
			);
		}

		@Override
		public Position pos() {
			return this.pos;
		}
	}

	@ToString
	@AllArgsConstructor
	class BindingDeclaration implements ProgramNode {
		public final Position pos;
		public final Type type;
		public final String name;

		@Override
		public Position pos() {
			return this.pos;
		}
	}

	@ToString
	@AllArgsConstructor
	class Method implements ProgramNode {
		public final Position pos;
		public final Modifier mdf;
		public final Type returnType;
		public final String name;
		public final BindingDeclaration[] args;
		public final Expression expression;

		@Override
		public Position pos() {
			return this.pos;
		}
	}

	@ToString
	@AllArgsConstructor
	class Type implements ProgramNode {
		public final Position pos;
		public final Modifier mdf;
		public final boolean isLifted;
		public final String name;

		public static Type typeNameCtxToType(FRJSimpleParser.TypeNameContext ctx) {
			var mdf = Modifier.mdfTerminalToModifier(ctx.MDF());
			var isLifted = ctx.AT() != null;

			return new Type(new Position(ctx.start), mdf, isLifted, ctx.Identifier().getText());
		}

		@Override
		public Position pos() {
			return this.pos;
		}
	}
}
