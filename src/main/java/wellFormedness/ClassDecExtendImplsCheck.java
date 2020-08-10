package wellFormedness;

import parser.Program;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ClassDecExtendImplsCheck implements WellFormednessRule<Program> {
	@Override
	public void check(Program program) throws MalformedException {
		var exceptions = program.classDeclarations
				.values()
				.stream()
				.flatMap(cd -> {
					if (cd.isInterface) {
						return Arrays.stream(cd.extend)
								.filter(name -> {
									var referredCd = program.classDeclarations.get(name);
									if (referredCd == null) {
										throw new MalformedException(
												cd.pos().line,
												cd.pos().col,
												String.format("'%s' cannot extend '%s' because it does not exist.", cd.name, name)
										);
									}
									return cd.name.equals(name) || !referredCd.isInterface;
								})
								.map(name -> cd);
					} else {
						return Arrays.stream(cd.impl)
								.filter(name -> {
									var referredCd = program.classDeclarations.get(name);
									if (referredCd == null) {
										throw new MalformedException(
												cd.pos().line,
												cd.pos().col,
												String.format("'%s' cannot implement '%s' because it does not exist.", cd.name, name)
										);
									}

									return !referredCd.isInterface;
								})
								.map(name -> cd);
					}
				})
				.map(badClassDec -> {
					var pos = badClassDec.pos();
					var rule = badClassDec.isInterface
							? "interfaces can only extend other interfaces and can't extend themselves"
							: "classes can only implement interfaces";

					return new MalformedException(
							pos.line,
							pos.col,
							String.format("'%s' is not well-formed: %s", badClassDec.name, rule)
					);
				})
				.collect(Collectors.toList());

		if (!exceptions.isEmpty()) {
			throw new MalformedException(exceptions);
		}
	}
}
