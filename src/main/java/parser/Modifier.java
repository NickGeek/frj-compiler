package parser;

import org.antlr.v4.runtime.tree.TerminalNode;

public enum Modifier {
	MUT,
	IMM,
	CAPSULE,
	READ;

	public static Modifier fromLiteral(String literal) {
		return Modifier.valueOf(literal.toUpperCase());
	}

	public static Modifier mdfTerminalToModifier(TerminalNode mdf) {
		return mdf != null ? Modifier.fromLiteral(mdf.getText()) : Modifier.IMM;
	}
}
