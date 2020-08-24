import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.AskPattern;
import akka.actor.typed.javadsl.Receive;

import java.io.Serializable;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public abstract class FRJActor<T extends FRJActor.Command> extends AbstractBehavior<T> {
	private static final int MAX_DURATION = 21474835;
	private static final AtomicInteger actorId = new AtomicInteger();

	protected FRJActor(ActorContext<T> context) {
		super(context);
	}

	public <C extends Command> ActorRef<C> spawn(Behavior<C> actor) {
		return this.getContext().spawn(actor, Integer.toString(actorId.getAndIncrement()));
	}

	@Override
	public abstract Receive<T> createReceive();

	protected <Req extends Command, Res> Res dispatch(ActorRef<Req> ref, Function<ActorRef<Res>, Req> getMsg) {
		return this.dispatchAsync(ref, getMsg).toCompletableFuture().join();
	}

	protected <Req extends Command, Res> CompletableFuture<Res> dispatchAsync(ActorRef<Req> ref, Function<ActorRef<Res>, Req> getMsg) {
		return AskPattern.ask(
				ref,
				getMsg::apply,
				Duration.ofSeconds(MAX_DURATION),
				this.getContext().getSystem().scheduler()
		).toCompletableFuture();
	}

	public interface Command extends Serializable {}
}
