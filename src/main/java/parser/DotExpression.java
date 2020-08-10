package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import visitors.CollectorVisitor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface DotExpression extends Expression {
	static DotExpression ctxToDotExpression(FRJSimpleParser.ExprContext ctx) {
		if (ctx.liftedCallExpr() != null) {
			return new CallExpr(
					new Position(ctx.liftedCallExpr().start),
					Expression.ctxToExpression(ctx.expr()),
					true,
					ctx.liftedCallExpr().Identifier().getText(),
					Expression.argListCtxToList(ctx.liftedCallExpr().argumentList())
			);
		}
		if (ctx.callExpr() != null) {
			return new CallExpr(
					new Position(ctx.callExpr().start),
					Expression.ctxToExpression(ctx.expr()),
					false,
					ctx.callExpr().Identifier().getText(),
					Expression.argListCtxToList(ctx.callExpr().argumentList())
			);
		}
		if (ctx.fieldAccessExpr() != null) {
			return new FieldAccessExpr(
					new Position(ctx.fieldAccessExpr().start),
					Expression.ctxToExpression(ctx.expr()),
					ctx.fieldAccessExpr().Identifier().getText()
			);
		}
		if (ctx.fieldAssignExpr() != null) {
			return new FieldUpdateExpr(
					new Position(ctx.fieldAssignExpr().start),
					Expression.ctxToExpression(ctx.expr()),
					ctx.fieldAssignExpr().Identifier().getText(),
					Expression.ctxToExpression(ctx.fieldAssignExpr().expr())
			);
		}

		throw new IllegalStateException(String.format("Unexpected expression: %s", ctx.getText()));
	}

	static boolean isBiExpression(FRJSimpleParser.ExprContext ctx) {
		return ctx.expr() != null;
	}

	Expression receiver();

	default Set<String> bindings() {
		return this.receiver().bindings();
	}

	class CallExpr implements DotExpression {
		private final Position pos;
		public final Expression receiver;
		public final boolean isLifted;
		public final String methodName;
		public final Expression[] args;

		public CallExpr(Position pos, Expression receiver, boolean isLifted, String methodName, Expression[] args) {
			this.pos = pos;
			this.receiver = receiver;
			this.isLifted = isLifted;
			this.methodName = methodName;

			this.args = new Expression[args.length + 1];
			System.arraycopy(args, 0, this.args, 1, args.length);
			this.args[0] = new IdentifierExpr(pos, "this");
		}

		@Override
		public Expression receiver() {
			return this.receiver;
		}

		@Override
		public Set<String> bindings() {
			var result = new HashSet<String>();

			result.addAll(
					Arrays.stream(this.args)
							.filter(arg -> {
								if (arg instanceof IdentifierExpr) {
									return !((IdentifierExpr) arg).name.equals("this");
								}
								return true;
							})
							.flatMap(arg -> arg.bindings().stream())
							.collect(Collectors.toSet())
			);
			result.addAll(this.receiver.bindings());

			return result;
		}

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public List<Expression> children() {
			return Stream.concat(Arrays.stream(this.args), Stream.of(this.receiver))
					.filter(arg -> {
						if (arg instanceof IdentifierExpr) {
							return !((IdentifierExpr) arg).name.equals("this");
						}
						return true;
					})
					.collect(Collectors.toList());
		}

		@Override
		public String toString() {
			var source = new StringBuilder();
			source.append(this.receiver.toString()).append('.');
			if (this.isLifted) source.append('@');
			source.append(this.methodName).append('(');
			source.append(Arrays.stream(args).map(Object::toString).collect(Collectors.joining(", "))).append(')');

			return source.toString();
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			if (this.isLifted) {
				visitor.visitLiftedCall(this);
			} else {
				visitor.visitCall(this);
			}
		}
	}

	@AllArgsConstructor
	class FieldAccessExpr implements DotExpression {
		private final Position pos;
		public final Expression receiver;
		public final String fieldName;

		@Override
		public Expression receiver() {
			return this.receiver;
		}

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public List<Expression> children() {
			return Collections.singletonList(this.receiver);
		}

		@Override
		public String toString() {
			return String.format("%s.%s", this.receiver.toString(), this.fieldName);
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			visitor.visitFieldAccess(this);
		}
	}

	@AllArgsConstructor
	class FieldUpdateExpr implements DotExpression {
		private final Position pos;
		public final Expression receiver;
		public final String fieldName;
		public final Expression value;

		@Override
		public Expression receiver() {
			return this.receiver;
		}

		@Override
		public Set<String> bindings() {
			var result = new HashSet<String>();
			result.addAll(this.receiver.bindings());
			result.addAll(this.value.bindings());

			return result;
		}

		@Override
		public Position pos() {
			return this.pos;
		}

		@Override
		public List<Expression> children() {
			return List.of(this.receiver, this.value);
		}

		@Override
		public String toString() {
			return String.format("%s.%s = %s", this.receiver.toString(), this.fieldName, this.value.toString());
		}

		@Override
		public void accept(CollectorVisitor visitor) {
			visitor.visitFieldUpdate(this);
		}
	}
}
