import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class ExplicitSignalObj extends FRJObj {
	public ActorRef<Signal<?>> getActor() {
		// Flyweight pattern to only spawn the actor if and when it's needed
		if (this.actorRef != null) return this.actorRef;

		this.actorRef = AkkaHelpers.spawn(Actor.create(this));
		return this.actorRef;
	}

	protected static class Actor<Impl extends FRJObj> extends AbstractBehavior<Signal<?>> {
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
							return Behaviors.stopped();
						} catch (Signal.SignalUseAfterFreeException e) {
							// I think this is wrong, we don't want to seppuku ourselves, we want
							// to kill the actor that executed the signal.
							return Behaviors.stopped();
						}
					})
					.build();
		}
	}
}
