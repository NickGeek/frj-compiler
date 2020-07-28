package wellFormedness;

import parser.ProgramNode;

import java.util.HashSet;

/**
 * TODO: Get description from the report
 */
public class MethodArgumentNaming implements WellFormednessRule<ProgramNode.BindingDeclaration[]> {
	@Override
	public void check(ProgramNode.BindingDeclaration[] args) throws MalformedException {
		var names = new HashSet<String>();
		for (var arg : args) {
			var pos = arg.pos();

			if (arg.name.equals("this")) {
				throw new MalformedException(pos.line, pos.col, "Method arguments are not allowed to be named: 'this'.");
			} else if (names.contains(arg.name)) {
				throw new MalformedException(pos.line, pos.col, "Method arguments must be unique.");
			}
			names.add(arg.name);
		}
	}
}
