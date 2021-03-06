package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import visitors.CollectorVisitor;
import visitors.Visitable;

import java.util.*;
import java.util.stream.Collectors;

public interface Expression extends ProgramNode, Visitable {
	static Expression ctxToExpression(FRJSimpleParser.ExprContext ctx) {
		if (DotExpression.isBiExpression(ctx)) {
			return DotExpression.ctxToDotExpression(ctx);
		}
		if (ctx.instantiationExpr() != null) {
			return new InstantiationExpr(
					new Position(ctx.instantiationExpr().start),
					ctx.instantiationExpr().Identifier().getText(),
					argListCtxToList(ctx.instantiationExpr().argumentList())
			);
		}
		if (ctx.signalConstructionExpr() != null) {
			return new SignalConstructionExpr(
					new Position(ctx.signalConstructionExpr().start),
					ctxToExpression(ctx.signalConstructionExpr().expr(0)),
					ctxToExpression(ctx.signalConstructionExpr().expr(1))
			);
		}
		if (ctx.emptySignalExpr() != null) {
			return new EmptySignalExpr(new Position(ctx.emptySignalExpr().start));
		}
		if (ctx.headExpr() != null) {
			return new LookupExpr(new Position(ctx.headExpr().start), ctxToExpression(ctx.headExpr().expr()), LookupExpr.Lookup.HEAD);
		}
		if (ctx.tailExpr() != null) {
			return new LookupExpr(new Position(ctx.tailExpr().start), ctxToExpression(ctx.tailExpr().expr()), LookupExpr.Lookup.TAIL);
		}
		if (ctx.letExpr() != null) {
			return new LetExpr(
					new Position(ctx.letExpr().start),
					Type.typeNameCtxToType(ctx.letExpr().typeName()),
					ctx.letExpr().Identifier().getText(),
					ctxToExpression(ctx.letExpr().expr(0)),
					ctxToExpression(ctx.letExpr().expr(1))
			);
		}
		if (ctx.THIS() != null) {
			return new IdentifierExpr(new Position(ctx.THIS().getSymbol()), "this");
		}
		if (ctx.IntegerLiteral() != null) {
			var literal_value = ctx.IntegerLiteral().getText().toUpperCase();
			literal_value = literal_value.replace("L", ""); // L is not allowed to appear for parseLong, think 0L
			literal_value = literal_value.replaceAll("_", "");
			var value = literal_value.startsWith("0B") ? Long.parseLong(literal_value.substring(2), 2) : Long.decode(literal_value);

			return new LiteralExpr<>(new Position(ctx.IntegerLiteral().getSymbol()), value, LiteralExpr.LiteralType.INTEGER);
		}
		if (ctx.FloatingPointLiteral() != null) {
			var literal_value = ctx.FloatingPointLiteral().getText().toUpperCase();
			literal_value = literal_value.replaceAll("_", "");
			if (literal_value.startsWith(".")) {
				literal_value = "0" + literal_value;
			}

			return new LiteralExpr<>(new Position(ctx.FloatingPointLiteral().getSymbol()), Double.parseDouble(literal_value), LiteralExpr.LiteralType.FLOAT);
		}
		if (ctx.StringLiteral() != null) {
			var text = ctx.StringLiteral().getText();
			return new LiteralExpr<>(new Position(ctx.StringLiteral().getSymbol()), text.substring(1, text.length() - 1), LiteralExpr.LiteralType.STRING);
		}
//		if (ctx.BooleanLiteral() != null) {
//			var value = ctx.BooleanLiteral().getText().equals("true");
//			return new LiteralExpr<>(new Position(ctx.BooleanLiteral().getSymbol()), value, LiteralExpr.LiteralType.BOOLEAN);
//		}
		if (ctx.Identifier() != null) {
			return new IdentifierExpr(new Position(ctx.Identifier().getSymbol()), ctx.Identifier().getText());
		}

		throw new IllegalStateException(String.format("Unexpected expression: %s", ctx.getText()));
	}

	static Expression[] argListCtxToList(FRJSimpleParser.ArgumentListContext ctx) {
		return ctx.expr()
				.stream()
				.map(Expression::ctxToExpression)
				.toArray(Expression[]::new);
	}

	default Set<String> bindings() {
		return Collections.emptySet();
	}

	@AllArgsConstructor
	class InstantiationExpr implements Expression {
		private final Position pos;
		public final String name;
		public final Expression[] args;

		@Override
		public Set<String> bindings() {
			return Arrays.stream(args)
					.flatMap(arg -> arg.bindings().stream())
					.collect(Collectors.toSet());
		}

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public List<Expression> children() {
			return Arrays.asList(this.args);
		}

		@Override
		public String toString() {
			var argStringStream = Arrays.stream(this.args).map(Object::toString);
			var argString = String.join(", ", (Iterable<String>) argStringStream::iterator);

			return String.format("new %s(%s)", this.name, argString);
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			visitor.visitNew(this);
		}
	}

	@AllArgsConstructor
	class SignalConstructionExpr implements Expression {
		private final Position pos;
		public final Expression head;
		public final Expression tail;

		@Override
		public Set<String> bindings() {
			var result = new HashSet<String>();
			result.addAll(this.head.bindings());
			result.addAll(this.tail.bindings());

			return result;
		}

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public List<Expression> children() {
			return List.of(this.head, this.tail);
		}

		@Override
		public String toString() {
			return String.format("@[%s; %s]", this.head.toString(), this.tail.toString());
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			visitor.visitNewSignal(this);
		}
	}

	@AllArgsConstructor
	class EmptySignalExpr implements Expression {
		private final Position pos;

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public String toString() {
			return "@[]";
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			visitor.visitEmptySignal(this);
		}
	}

	@AllArgsConstructor
	class LookupExpr implements Expression {
		private final Position pos;
		public final Expression signalExpr;
		public final Lookup lookup;

		@Override
		public Set<String> bindings() {
			return new HashSet<>(this.signalExpr.bindings());
		}

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public List<Expression> children() {
			return Collections.singletonList(this.signalExpr);
		}

		@Override
		public String toString() {
			var lookup = this.lookup == Lookup.HEAD ? "head" : "tail";
			return String.format("%s(%s)", lookup, this.signalExpr.toString());
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			visitor.visitLookup(this);
		}

		public enum Lookup {
			HEAD,
			TAIL
		}
	}

	@AllArgsConstructor
	class LetExpr implements Expression {
		private final Position pos;
		public final Type type;
		public final String name;
		public final Expression value;
		public final Expression boundTo;

		@Override
		public Set<String> bindings() {
			var bindings = new HashSet<>(this.boundTo.bindings());
			bindings.remove(this.name);
			bindings.addAll(value.bindings());

			return bindings;
		}

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public List<Expression> children() {
			return List.of(this.value, this.boundTo);
		}

		@Override
		public String toString() {
			return String.format(
					"%s %s = %s,\n%s",
					this.type.toString(),
					this.name,
					this.value.toString(),
					this.boundTo.toString()
			);
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			visitor.visitLet(this);
		}
	}

	@AllArgsConstructor
	@EqualsAndHashCode
	class IdentifierExpr implements Expression {
		private final Position pos;
		public final String name;

		@Override
		public Set<String> bindings() {
			return Set.of(name);
		}

		@Override
		public String toString() {
			return this.name;
		}

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			visitor.visitIdentifier(this);
		}
	}

	@AllArgsConstructor
	@EqualsAndHashCode
	class LiteralExpr<T> implements Expression {
		private final Position pos;
		public final T value;
		public final LiteralType type;

		@Override
		public String toString() {
			if (this.value instanceof String) {
				return '"' + this.value.toString() + '"';
			}

			return this.value.toString() + ' ';
		}

		@Override
		public Position pos() {
			return this.pos;
		}

		public enum LiteralType {
			INTEGER,
			FLOAT,
			STRING,
			BOOLEAN
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			visitor.visitLiteral(this);
		}
	}
}
