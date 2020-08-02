package parser;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public interface Walkable {
	default List<Expression> children() {
		return Collections.emptyList();
	}

	default void walk(Consumer<Walkable> walker) {
		walker.accept(this);
		this.children().forEach(child -> child.walk(walker));
	}
}
