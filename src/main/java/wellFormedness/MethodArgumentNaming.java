package wellFormedness;

import parser.ProgramNode;

import java.util.HashSet;

/**
 * All parameters in a given method are uniquely named and are not called
 * 'this'.
 */
public class MethodArgumentNaming implements WellFormednessRule<ProgramNode.BindingDeclaration[]> {
	@Override
	public void check(ProgramNode.BindingDeclaration[] args) throws MalformedException {
		var names = new HashSet<String>();
		for (var arg : args) {
			var pos = arg.pos();

			if (names.contains(arg.name)) {
				throw new MalformedException(
						pos.line,
						pos.col,
						String.format("Method arguments must be unique ('%s' is not unique).", arg.name)
				);
			}
			names.add(arg.name);
		}
	}
}
