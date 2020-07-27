package parser;

import antlrGenerated.FRJLexer;
import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

public interface Expression {
	Expression EMPTY_SIGNAL_EXPR = new EmptySignalExpr();

	static Expression ctxToExpression(FRJSimpleParser.ExprContext ctx) {
		if (DotExpression.isBiExpression(ctx)) {
			return DotExpression.ctxToBiExpression(ctx);
		}
		if (ctx.instantiationExpr() != null) {
			return new InstantiationExpr(
					ctx.instantiationExpr().Identifier().getText(),
					argListCtxToList(ctx.instantiationExpr().argumentList())
			);
		}
		if (ctx.signalConstructionExpr() != null) {
			return new SignalConstructionExpr(
					ctxToExpression(ctx.signalConstructionExpr().expr(0)),
					ctxToExpression(ctx.signalConstructionExpr().expr(1))
			);
		}
		if (ctx.emptySignalExpr() != null) {
			return EMPTY_SIGNAL_EXPR;
		}
		if (ctx.headExpr() != null) {
			return new HeadExpr(ctxToExpression(ctx.headExpr().expr()));
		}
		if (ctx.tailExpr() != null) {
			return new TailExpr(ctxToExpression(ctx.tailExpr().expr()));
		}
		if (ctx.letExpr() != null) {
			return new LetExpr(
					Program.mdfTerminalToModifier(ctx.letExpr().typeName().MDF()),
					ctx.letExpr().typeName().Identifier().getText(),
					ctxToExpression(ctx.letExpr().expr(0)),
					ctxToExpression(ctx.letExpr().expr(1))
			);
		}
		if (ctx.THIS() != null) {
			return new ThisExpr();
		}
		if (ctx.IntegerLiteral() != null) {
			var literal_value = ctx.IntegerLiteral().getText().toUpperCase();
			literal_value = literal_value.replace("L", ""); // L is not allowed to appear for parseLong, think 0L
			literal_value = literal_value.replaceAll("_", "");
			var value = literal_value.startsWith("0B") ? Long.parseLong(literal_value.substring(2), 2) : Long.decode(literal_value);

			return new Literal<>(value);
		}
		if (ctx.FloatingPointLiteral() != null) {
			var literal_value = ctx.FloatingPointLiteral().getText().toUpperCase();
			literal_value = literal_value.replaceAll("_", "");
			if (literal_value.startsWith(".")) {
				literal_value = "0" + literal_value;
			}

			return new Literal<>(Double.parseDouble(literal_value));
		}
		if (ctx.StringLiteral() != null) {
			var text = ctx.StringLiteral().getText();
			return new Literal<>(text.substring(1, text.length() - 1));
		}
		if (ctx.BooleanLiteral() != null) {
			var value = ctx.BooleanLiteral().getText().equals("true");
			return new Literal<>(value);
		}
		if (ctx.Identifier() != null) {
			return new Identifier(ctx.Identifier().getText());
		}

		throw new IllegalStateException(String.format("Unexpected expression: %s", ctx.getText()));
	}

	static List<Expression> argListCtxToList(FRJSimpleParser.ArgumentListContext ctx) {
		return ctx.expr()
				.stream()
				.map(Expression::ctxToExpression)
				.collect(Collectors.toList());
	}

	@ToString
	class InstantiationExpr implements Expression {
		public final String name;
		public final List<Expression> args;

		public InstantiationExpr(String name, List<Expression> args) {
			this.name = name;
			this.args = args;
		}
	}

	@ToString
	@AllArgsConstructor
	class SignalConstructionExpr implements Expression {
		public final Expression head;
		public final Expression tail;
	}

	@ToString
	@AllArgsConstructor
	class EmptySignalExpr implements Expression {
	}

	@ToString
	@AllArgsConstructor
	class HeadExpr implements Expression {
		public final Expression signalExpr;
	}

	@ToString
	@AllArgsConstructor
	class TailExpr implements Expression {
		public final Expression signalExpr;
	}

	@ToString
	@AllArgsConstructor
	class LetExpr implements Expression {
		public final Program.Modifier mdf;
		public final String name;
		public final Expression value;
		public final Expression boundTo;
	}

	class ThisExpr implements Expression {
		@Override
		public String toString() {
			return "this";
		}
	}

	@AllArgsConstructor
	@EqualsAndHashCode
	class Identifier implements Expression {
		public final String name;

		@Override
		public String toString() {
			return this.name;
		}
	}

	@AllArgsConstructor
	@EqualsAndHashCode
	class Literal<T> implements Expression {
		public final T value;

		@Override
		public String toString() {
			return this.value.toString();
		}
	}
}
