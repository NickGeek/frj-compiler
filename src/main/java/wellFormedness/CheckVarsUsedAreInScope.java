package wellFormedness;

import parser.Expression;
import parser.Program;
import parser.ProgramNode;
import parser.Visitable;

import java.util.HashSet;
import java.util.Set;

public class CheckVarsUsedAreInScope implements WellFormednessRule<Program> {
	@Override
	public void check(Program program) throws MalformedException {
		checkExpr(new HashSet<>(), program.main);

		for (var cd : program.classDeclarations.values()) {
			for (var method : cd.methods.values()) {
				this.checkMethod(method);
			}
		}
	}

	private void checkMethod(ProgramNode.Method method) {
		var bindings = new HashSet<String>();
		bindings.add("this");

		for (var arg : method.args) {
			bindings.add(arg.name);
		}

		this.checkExpr(bindings, method);
	}

	private void checkExpr(Set<String> bindings, Visitable visitable) {
		visitable.visit(v -> {
			if (!(v instanceof Expression)) return;
			Expression expr = (Expression) v;

			if (expr instanceof Expression.LetExpr) {
				Expression.LetExpr letExpr = (Expression.LetExpr) expr;
				bindings.add(letExpr.name);
			}

			if (!bindings.containsAll(expr.bindings())) {
				throw new MalformedException(
						expr.pos().line,
						expr.pos().col,
						String.format("'%s' uses variables that are not in scope.", expr)
				);
			}
		});
	}
}
