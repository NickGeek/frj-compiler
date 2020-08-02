package visitors;

public interface Visitable {
	void accept(CollectorVisitor visitor);
}
