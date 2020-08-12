package wellFormedness;

import parser.Expression;
import parser.Program;
import parser.ProgramNode;
import parser.Walkable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TODO: Get description from the report
 */
public class NoShadowing implements WellFormednessRule<Program> {
	@Override
	public void check(Program program) throws MalformedException {
		checkLetExprs(new HashSet<>(), program.main);

		program.classDeclarations.values()
				.stream()
				.map(cd -> cd.methods)
				.map(Map::values)
				.flatMap(Collection::stream)
				.forEach(this::checkMethod);
	}

	private void checkMethod(ProgramNode.Method method) {
		var bindings = new HashSet<String>();
		for (var arg : method.args) {
			bindings.add(arg.name);
		}

		this.checkLetExprs(bindings, method);
	}

	private void checkLetExprs(Set<String> bindings, Walkable walkable) {
		walkable.walk(expr -> {
			if (!(expr instanceof Expression.LetExpr)) return;
			Expression.LetExpr letExpr = (Expression.LetExpr) expr;

			LetChecker.check(bindings, letExpr);
			bindings.add(letExpr.name);
		});
	}

	private static class LetChecker {
		public static void check(Set<String> currentBindings, Expression.LetExpr letExpr) {
			if (currentBindings.contains(letExpr.name)) {
				var pos = letExpr.pos();
				throw new MalformedException(
						pos.line,
						pos.col,
						String.format("Names cannot be shadowed (attempted to shadow '%s')", letExpr.name)
				);
			}
		}
	}
}
