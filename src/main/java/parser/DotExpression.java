package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import visitors.CollectorVisitor;

import java.util.*;
import java.util.stream.Collectors;

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

    @AllArgsConstructor
    class CallExpr implements DotExpression {
        private final Position pos;
        public final Expression receiver;
        public final boolean isLifted;
        public final String methodName;
        public final Expression[] arguments;

        @Override
        public Expression receiver() {
            return this.receiver;
        }

        @Override
        public Set<String> bindings() {
            var result = new HashSet<String>();

            result.addAll(
                    Arrays.stream(this.arguments)
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
            var children = new ArrayList<>(Arrays.asList(this.arguments));
            children.add(this.receiver);

            return children;
        }

        @Override
        public String toString() {
            var source = new StringBuilder();
            source.append(this.receiver.toString()).append('.');
            if (this.isLifted) source.append('@');
            source.append(this.methodName).append('(');
            source.append(Arrays.stream(arguments).map(Object::toString).collect(Collectors.joining(", "))).append(')');

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
