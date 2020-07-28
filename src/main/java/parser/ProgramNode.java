package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;
import java.util.stream.Collectors;

public interface ProgramNode extends Visitable {
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

	@AllArgsConstructor
	class ClassDeclaration implements ProgramNode {
		private final Position pos;
		public final boolean isCapability;
		public final boolean isInterface;
		public final String name;
		public final String[] impl;
		public final String[] extend;
		public final Map<String, BindingDeclaration> fields;
		public final Map<String, Method> methods;

		public static ClassDeclaration ctxToClassDeclaration(FRJSimpleParser.ClassDeclarationContext ctx) {
			var isInterface = ctx.INTERFACE() != null;

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

			Map<String, Method> methods;
			if (isInterface) {
				methods = ctx.methodHeader().stream()
						.map(headerCtx -> new Method(
								new Position(headerCtx.start),
								Modifier.mdfTerminalToModifier(headerCtx.MDF()),
								Type.typeNameCtxToType(headerCtx.typeName()),
								headerCtx.Identifier().getText(),
								headerCtx.methodDeclarationArgument()
										.stream()
										.map(arg -> new BindingDeclaration(
												new Position(arg.start),
												Type.typeNameCtxToType(arg.typeName()),
												arg.Identifier().getText()
										))
										.toArray(BindingDeclaration[]::new),
								null
						))
						.collect(Collectors.toMap(meth -> meth.name, meth -> meth));
			} else {
				methods = ctx.methodDeclaration().stream()
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
			}

			return new ProgramNode.ClassDeclaration(
					new Position(ctx.start),
					ctx.CAP() != null,
					isInterface,
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

		@Override
		public List<Expression> children() {
			return this.methods.values()
					.stream()
					.map(Visitable::children)
					.flatMap(List::stream)
					.collect(Collectors.toList());
		}

		@Override
		public String toString() {
			var source = new StringBuilder();
			if (this.isCapability) source.append("capability ");
			source.append(this.isInterface ? "interface" : "class").append(' ').append(this.name).append(' ');
			if (this.impl.length > 0) {
				source.append("implements ")
						.append(String.join(", ", Arrays.asList(this.impl)))
						.append(' ');
			}
			if (this.extend.length > 0) {
				source.append("extends ")
						.append(String.join(", ", Arrays.asList(this.extend)))
						.append(' ');
			}

			String fields = this.fields.values()
					.stream()
					.map(f -> f.toString() + ";")
					.collect(Collectors.joining("\n"));

			source.append(" {\n").append(fields);

			String methods = this.methods.values()
					.stream()
					.map(Object::toString)
					.collect(Collectors.joining("\n\n"));

			source.append(methods).append("\n}");

			return source.toString();
		}
	}

	@AllArgsConstructor
	class BindingDeclaration implements ProgramNode {
		private final Position pos;
		public final Type type;
		public final String name;

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public String toString() {
			return String.format("%s %s", this.type.toString(), this.name);
		}
	}

	@AllArgsConstructor
	class Method implements ProgramNode {
		private final Position pos;
		public final Modifier mdf;
		public final Type returnType;
		public final String name;
		public final BindingDeclaration[] args;
		private final Expression expression;

		public Optional<Expression> expression() {
			return Optional.ofNullable(this.expression);
		}

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public List<Expression> children() {
			return this.expression()
					.map(Collections::singletonList)
					.orElse(Collections.emptyList());
		}

		@Override
		public String toString() {
			var source = new StringBuilder();
			source.append(this.mdf.toString().toLowerCase()).append(" method ");
			source.append(this.returnType.toString()).append(' ');
			source.append(this.name);
			source.append('(');
			source.append(
					Arrays.stream(this.args)
					.map(Object::toString)
					.collect(Collectors.joining(", "))
			);
			this.expression()
					.map(expression -> source.append(") =\n").append(this.expression.toString()))
					.orElseGet(() -> source.append(')'))
					.append(';');

			return source.toString();
		}
	}

	@AllArgsConstructor
	class Type implements ProgramNode {
		private final Position pos;
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

		@Override
		public String toString() {
			var source = new StringBuilder();
			source.append(this.mdf.toString().toLowerCase()).append(' ');
			if (this.isLifted) source.append("@");
			source.append(this.name);

			return source.toString();
		}
	}
}
