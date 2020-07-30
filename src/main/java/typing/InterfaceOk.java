// TODO: Currently this check is technically being done by the interface method lookup helper.

//package typing;
//
//import parser.Program;
//import parser.ProgramNode;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
///**
// * (interface)
// */
//public class InterfaceOk implements TypingRule<Program> {
//	@Override
//	public List<TypeError> check(List<TypeError> errors, Program program) {
//		// Cs
//		var interfaces = program.classDeclarations
//				.values()
//				.stream()
//				.filter(cd -> cd.isInterface);
//
//		return interfaces
//				.flatMap(interfaceDec ->
//						// forall C' in Cs
//						Arrays.stream(interfaceDec.extend)
//								.map(program.classDeclarations::get)
//								.filter(Objects::nonNull)
//								.flatMap(superDec -> superDec.methods.values().stream())
//								// overrideOk(C', MH_i)
//								.map(methodHeader -> this.overrideOk(interfaceDec, methodHeader))
//								.filter(Optional::isPresent)
//								.map(Optional::get)
//				)
//				.collect(Collectors.toList());
//	}
//
//	private Optional<TypeError> overrideOk(ProgramNode.ClassDeclaration interfaceDec, ProgramNode.Method methodHeader) {
//		if (!interfaceDec.isInterface) {
//			throw new IllegalArgumentException("Only interface declarations can be used.");
//		}
//
//		var conflictingMethod = interfaceDec.methods.get(methodHeader.name);
//		if (conflictingMethod != null && !conflictingMethod.equals(methodHeader)) {
//			return Optional.of(
//					new TypeError(
//							conflictingMethod.pos(),
//							String.format("%s conflicts with %s", conflictingMethod, methodHeader)
//					)
//			);
//		}
//
//		return Optional.empty();
//	}
//}
