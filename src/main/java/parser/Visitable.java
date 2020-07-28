package parser;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public interface Visitable {
	default List<Expression> children() {
		return Collections.emptyList();
	}

	default void visit(Consumer<Visitable> visitor) {
		visitor.accept(this);
		this.children().forEach(child -> child.visit(visitor));
	}
}
