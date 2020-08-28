import akka.actor.typed.ActorRef;

public interface FRJRef<Impl> {
	static <Impl> FRJRef<Impl> of(Impl impl, ActorRef<Signal<?>> behavior) {
		return new FRJRef<>() {
			@Override
			public Impl getImpl() {
				return impl;
			}

			@Override
			public ActorRef<Signal<?>> getActor() {
				return behavior;
			}
		};
	}

	Impl getImpl();
	ActorRef<Signal<?>> getActor();
}
