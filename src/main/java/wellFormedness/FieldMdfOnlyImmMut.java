package wellFormedness;

import parser.Modifier;
import parser.ProgramNode;

/**
 * Fields can only have the type modifiers: imm or mut.
 */
public class FieldMdfOnlyImmMut implements WellFormednessRule<ProgramNode.ClassDeclaration> {
	@Override
	public void check(ProgramNode.ClassDeclaration cd) throws MalformedException {
		cd.fields
				.values()
				.stream()
				.map(field -> field.type)
				.filter(type -> type.mdf != Modifier.IMM && type.mdf != Modifier.MUT)
				.findAny()
				.ifPresent(type -> {
					var pos = type.pos();
					throw new MalformedException(pos.line, pos.col, "Fields can only have the type modifiers: imm or mut.");
				});
	}
}
