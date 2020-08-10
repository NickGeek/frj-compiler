package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import typing.TypeError;
import visitors.CollectorVisitor;
import visitors.Visitable;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ProgramNode extends Walkable, Visitable {
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
		public final LinkedHashMap<String, BindingDeclaration> fields;
		public final Map<String, Method> methods;

		public static ClassDeclaration ctxToClassDeclaration(FRJSimpleParser.ClassDeclarationContext ctx) {
			var name = ctx.Identifier().getText();
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
					.sequential()
					.map(fieldCtx -> new ProgramNode.BindingDeclaration(
							new Position(fieldCtx.start),
							Type.typeNameCtxToType(fieldCtx.typeName()),
							fieldCtx.Identifier().getText()
					))
					.collect(Collector.of(
							LinkedHashMap<String, BindingDeclaration>::new,
							(fieldMap, field) -> fieldMap.put(field.name, field),
							(fieldMap1, fieldMap2) -> {
								throw new UnsupportedOperationException("Can't be parallel");
							}
					));

			Map<String, Method> methods;
			Type receiver = new Type(new Position(-1, -1), Modifier.CAPSULE, name);
			if (isInterface) {
				methods = ctx.methodHeader().stream()
						.map(headerCtx -> new Method(
								new Position(headerCtx.start),
								Modifier.mdfTerminalToModifier(headerCtx.MDF()),
								receiver,
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
									receiver,
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
					name,
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
					.map(Walkable::children)
					.flatMap(List::stream)
					.collect(Collectors.toList());
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			if (this.isInterface) {
				visitor.visitInterfaceDeclaration(this);
			} else {
				visitor.visitClassDeclaration(this);
			}
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
		public void accept(CollectorVisitor visitor) {
			visitor.visitBindingDeclaration(this);
		}

		@Override
		public String toString() {
			return String.format("%s %s", this.type.toString(), this.name);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			BindingDeclaration that = (BindingDeclaration) o;
			return type.equals(that.type) &&
					name.equals(that.name);
		}
	}

	class Method implements ProgramNode {
		private final Position pos;
		public final Modifier mdf;
		public final Type returnType;
		public final String name;
		public final BindingDeclaration[] args;
		private final Expression expression;

		public Method(Position pos, Modifier mdf, Type receiver, Type returnType, String name, BindingDeclaration[] args, Expression expression) {
			this.pos = pos;
			this.mdf = mdf;
			this.returnType = returnType;
			this.name = name;
			this.expression = expression;

			// The reciever is always implicitly given as an argument (`this`)
			this.args = new BindingDeclaration[args.length + 1];
			System.arraycopy(args, 0, this.args, 1, args.length);
			this.args[0] = new BindingDeclaration(pos, receiver.withMdf(mdf), "this");
		}

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
		public void accept(CollectorVisitor visitor) {
			visitor.visitMethod(this);
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

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Method method = (Method) o;
			return mdf == method.mdf &&
					returnType.equals(method.returnType) &&
					name.equals(method.name) &&
					Arrays.equals(Arrays.copyOfRange(args, 1, args.length), Arrays.copyOfRange(method.args, 1, method.args.length));
		}
	}

	@AllArgsConstructor
	class Type implements ProgramNode {
		public static final Type ANY = new Any();

		protected final Position pos;
		public final Modifier mdf;
		public final String name;

		public static Type typeNameCtxToType(FRJSimpleParser.TypeNameContext ctx) {
			var mdf = Modifier.mdfTerminalToModifier(ctx.MDF());

			if (ctx.liftedTypeName() != null) {
				return LiftedType.liftedTypeNameCtxToLiftedType(ctx.liftedTypeName());
			}
			return new Type(new Position(ctx.start), mdf, ctx.Identifier().getText());
		}

		public Type compose(Modifier b) {
			if (this.mdf == b || this.mdf == Modifier.ANY || b == Modifier.ANY) return this;

			if (b == Modifier.IMM) return this.withMdf(Modifier.IMM);
			if (b == Modifier.MUT) return this;
			if (b == Modifier.CAPSULE) return this;
			if (this.mdf == Modifier.MUT && b == Modifier.READ) return this.withMdf(Modifier.READ);
			if (this.mdf == Modifier.IMM && b == Modifier.READ) return this.withMdf(Modifier.READ);

			throw new TypeError(
					new ProgramNode.Position(-1, -1),
					String.format("Cannot compose %s and %s", this, b)
			);
		}

		public Type withMdf(Modifier mdf) {
			return new Type(this.pos, mdf, this.name);
		}

		/**
		 * Ensure that T' is valid for T (implementing the (sub) rule).
		 */
		public boolean okayWithSub(Program program, Type tPrime) {
			// T' = T
			if (this.equals(tPrime)) return true;

			// For @T (and @@T, etc) we want to just get the T value and the order to ensure that it matches
			var expectedPlain = this.name.replaceAll("@", "");
			var expectedOrder = this.name.length() - expectedPlain.length();

			var tPrimePlain = tPrime.name.replaceAll("@", "");
			var tPrimeOrder = tPrime.name.length() - tPrimePlain.length();

			// Check the modifier subtyping rules (T'.mdf <= T.mdf)
			boolean isMdfSubtype = Modifier.canInto(tPrime.mdf, this.mdf);

			// The orders must be equal
			boolean sameOrder = tPrimeOrder == expectedOrder;

			// is T' <= T?
			var tPrimeDec = program.classDeclarations.get(tPrimePlain);
			if (tPrimeDec == null) {
				throw new TypeError(
						tPrime.pos(),
						String.format("'%s' does not exist or is not a class.", tPrime)
				);
			}

			boolean isSubtype = Stream.concat(Arrays.stream(tPrimeDec.impl), Arrays.stream(tPrimeDec.extend))
					.anyMatch(expectedPlain::equals);

			return (tPrimePlain.equals(expectedPlain) || isSubtype) && isMdfSubtype && sameOrder;
		}

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			visitor.visitType(this);
		}

		@Override
		public String toString() {
			return this.mdf.toString().toLowerCase() + ' ' + this.name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Type type = (Type) o;
			return  mdf == type.mdf &&
					name.equals(type.name);
		}

		private static class Any extends Type {
			private Any() {
				super(new Position(-1, -1), Modifier.ANY, "//Any//");
			}

			@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
			@Override
			public boolean equals(Object o) {
				return true;
			}
		}
	}

	class LiftedType extends Type implements ProgramNode {
		public static final Type ANY = new LiftedType.Any();

		public final Type innerType;

		public static Type liftedTypeNameCtxToLiftedType(FRJSimpleParser.LiftedTypeNameContext ctx) {
			var pos = new Position(ctx.start);

			final Type innerType;
			if (ctx.liftedTypeName() != null) {
				innerType = liftedTypeNameCtxToLiftedType(ctx.liftedTypeName());
			} else {
				innerType = new Type(pos, Modifier.IMM, ctx.Identifier().getText());
			}

			return new LiftedType(pos, innerType);
		}

		public LiftedType(Position pos, Type innerType) {
			super(pos, Modifier.IMM, '@' + innerType.name);
			this.innerType = innerType;
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			visitor.visitLiftedType(this);
		}

		@Override
		public String toString() {
			return this.name;
		}

		private static class Any extends LiftedType {
			private Any() {
				super(new Position(-1, -1), Type.ANY);
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				return o != null && getClass() == o.getClass();
			}
		}
	}
}
