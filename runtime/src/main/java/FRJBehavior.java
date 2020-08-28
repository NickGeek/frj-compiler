import akka.actor.typed.Behavior;

public interface FRJBehavior<Impl> {
	static <Impl> FRJBehavior<Impl> of(Impl impl, Behavior<Signal<?>> behavior) {
		return new FRJBehavior<>() {
			@Override
			public Impl getImpl() {
				return impl;
			}

			@Override
			public Behavior<Signal<?>> getBehavior() {
				return behavior;
			}
		};
	}

	Impl getImpl();
	Behavior<Signal<?>> getBehavior();
}
