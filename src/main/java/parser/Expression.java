package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface Expression extends ProgramNode {
	static Expression ctxToExpression(FRJSimpleParser.ExprContext ctx) {
		if (DotExpression.isBiExpression(ctx)) {
			return DotExpression.ctxToBiExpression(ctx);
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
			return new HeadExpr(new Position(ctx.headExpr().start), ctxToExpression(ctx.headExpr().expr()));
		}
		if (ctx.tailExpr() != null) {
			return new TailExpr(new Position(ctx.tailExpr().start), ctxToExpression(ctx.tailExpr().expr()));
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
			return new ThisExpr(new Position(ctx.THIS().getSymbol()));
		}
		if (ctx.IntegerLiteral() != null) {
			var literal_value = ctx.IntegerLiteral().getText().toUpperCase();
			literal_value = literal_value.replace("L", ""); // L is not allowed to appear for parseLong, think 0L
			literal_value = literal_value.replaceAll("_", "");
			var value = literal_value.startsWith("0B") ? Long.parseLong(literal_value.substring(2), 2) : Long.decode(literal_value);

			return new Literal<>(new Position(ctx.IntegerLiteral().getSymbol()), value);
		}
		if (ctx.FloatingPointLiteral() != null) {
			var literal_value = ctx.FloatingPointLiteral().getText().toUpperCase();
			literal_value = literal_value.replaceAll("_", "");
			if (literal_value.startsWith(".")) {
				literal_value = "0" + literal_value;
			}

			return new Literal<>(new Position(ctx.FloatingPointLiteral().getSymbol()), Double.parseDouble(literal_value));
		}
		if (ctx.StringLiteral() != null) {
			var text = ctx.StringLiteral().getText();
			return new Literal<>(new Position(ctx.StringLiteral().getSymbol()), text.substring(1, text.length() - 1));
		}
		if (ctx.BooleanLiteral() != null) {
			var value = ctx.BooleanLiteral().getText().equals("true");
			return new Literal<>(new Position(ctx.BooleanLiteral().getSymbol()), value);
		}
		if (ctx.Identifier() != null) {
			return new Identifier(new Position(ctx.Identifier().getSymbol()), ctx.Identifier().getText());
		}

		throw new IllegalStateException(String.format("Unexpected expression: %s", ctx.getText()));
	}

	static Expression[] argListCtxToList(FRJSimpleParser.ArgumentListContext ctx) {
		return ctx.expr()
				.stream()
				.map(Expression::ctxToExpression)
				.toArray(Expression[]::new);
	}

	@AllArgsConstructor
	class InstantiationExpr implements Expression {
		private final Position pos;
		public final String name;
		public final Expression[] args;

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
	}

	@AllArgsConstructor
	class SignalConstructionExpr implements Expression {
		private final Position pos;
		public final Expression head;
		public final Expression tail;

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
	}

	@AllArgsConstructor
	class HeadExpr implements Expression {
		private final Position pos;
		public final Expression signalExpr;

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
			return String.format("head(%s)", this.signalExpr.toString());
		}
	}

	@AllArgsConstructor
	class TailExpr implements Expression {
		private final Position pos;
		public final Expression signalExpr;

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
			return String.format("tail(%s)", this.signalExpr.toString());
		}
	}

	@AllArgsConstructor
	class LetExpr implements Expression {
		private final Position pos;
		public final Type type;
		public final String name;
		public final Expression boundTo;
		public final Expression value;

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
					this.boundTo.toString(),
					this.value.toString()
			);
		}
	}

	@AllArgsConstructor
	class ThisExpr implements Expression {
		private final Position pos;

		@Override
		public String toString() {
			return "this";
		}

		@Override
		public Position pos() {
			return this.pos;
		}
	}

	@AllArgsConstructor
	@EqualsAndHashCode
	class Identifier implements Expression {
		private final Position pos;
		public final String name;

		@Override
		public String toString() {
			return this.name;
		}

		@Override
		public Position pos() {
			return this.pos;
		}
	}

	@AllArgsConstructor
	@EqualsAndHashCode
	class Literal<T> implements Expression {
		private final Position pos;
		public final T value;

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
	}
}
