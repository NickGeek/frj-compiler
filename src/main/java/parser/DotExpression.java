package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

public interface DotExpression extends Expression {
    static DotExpression ctxToBiExpression(FRJSimpleParser.ExprContext ctx) {
        if (ctx.liftedCallExpr() != null) {
            return new CallExpr(
                    Expression.ctxToExpression(ctx.expr()),
                    true,
                    ctx.callExpr().Identifier().getText(),
                    Expression.argListCtxToList(ctx.callExpr().argumentList())
            );
        }
        if (ctx.callExpr() != null) {
            return new CallExpr(
                    Expression.ctxToExpression(ctx.expr()),
                    false,
                    ctx.callExpr().Identifier().getText(),
                    Expression.argListCtxToList(ctx.callExpr().argumentList())
            );
        }
        if (ctx.fieldAccessExpr() != null) {
            return new FieldAccessExpr(Expression.ctxToExpression(ctx.expr()), ctx.fieldAccessExpr().Identifier().getText());
        }
        if (ctx.fieldAssignExpr() != null) {
            return new FieldAssignExpr(
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

    @ToString
    @AllArgsConstructor
    class CallExpr implements DotExpression {
        public final Expression receiver;
        public final boolean isLifted;
        public final String methodName;
        public final List<Expression> arguments;

        @Override
        public Expression receiver() {
            return this.receiver;
        }
    }

    @ToString
    @AllArgsConstructor
    class FieldAccessExpr implements DotExpression {
        public final Expression receiver;
        public final String fieldName;

        @Override
        public Expression receiver() {
            return this.receiver;
        }
    }

    @ToString
    @AllArgsConstructor
    class FieldAssignExpr implements DotExpression {
        public final Expression receiver;
        public final String fieldName;
        public final Expression value;

        @Override
        public Expression receiver() {
            return this.receiver;
        }
    }
}
