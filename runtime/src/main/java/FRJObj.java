import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class FRJObj {
	private ActorRef<Signal<?>> actorRef;

	public ActorRef<Signal<?>> getActor() {
		// Flyweight pattern to only spawn the actor if and when it's needed
		if (this.actorRef != null) return this.actorRef;

		this.actorRef = AkkaHelpers.spawn(Actor.create(this));
		return this.actorRef;
	}

	protected <T> SignalBox<T> dispatch(Signal<T> signal) {
		this.getActor().tell(signal);
		return new SignalBox<>(signal, this);
	}

	private static class Actor<Impl extends FRJObj> extends AbstractBehavior<Signal<?>> {
		private Impl impl;

		public static <Impl extends FRJObj> Behavior<Signal<?>> create(Impl impl) {
			return Behaviors.setup(ctx -> new Actor<>(ctx, impl));
		}

		private Actor(ActorContext<Signal<?>> ctx, Impl impl) {
			super(ctx);
			this.impl = impl;
		}

		@Override
		public Receive<Signal<?>> createReceive() {
			return newReceiveBuilder()
					.onMessage(Signal.class, signalMsg -> {
						try {
							var signal = ((Signal<?>) signalMsg);
							if (signal.isEmpty()) return this;

							signal.execute();
							return this;
						} catch (Signal.SignalUseAfterFreeException e) {
							return Behaviors.stopped();
						}
					})
					.build();
		}
	}
}
