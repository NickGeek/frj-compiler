package parser;

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
			return new TailExpr(ctxToExpression(ctx.headExpr().expr()));
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
}
