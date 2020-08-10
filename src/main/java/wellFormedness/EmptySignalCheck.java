package wellFormedness;

import parser.DotExpression;
import parser.Expression;
import parser.Program;

public class EmptySignalCheck implements WellFormednessRule<Program> {
	@Override
	public void check(Program program) throws MalformedException {
		program.walk(visitable -> {
			if (visitable instanceof DotExpression.CallExpr) {
				DotExpression.CallExpr expr = (DotExpression.CallExpr) visitable;
				if (!expr.isLifted) return;

				for (var argument : expr.args) {
					throwIfEmptySignal(argument);
				}
			}

			if (visitable instanceof Expression.SignalConstructionExpr) {
				Expression.SignalConstructionExpr expr = (Expression.SignalConstructionExpr) visitable;
				this.throwIfEmptySignal(expr.head);
			}
		});
	}

	private void throwIfEmptySignal(Expression e) {
		if (e instanceof Expression.EmptySignalExpr) {
			throw new MalformedException(e.pos().line, e.pos().col, "The empty signal (@[]) is not allowed here.");
		}
	}
}
