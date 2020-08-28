import akka.actor.typed.ActorRef;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.AskPattern;
import akka.actor.typed.javadsl.Receive;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public abstract class FRJActor<Impl> extends AbstractBehavior<Signal<?>> {
	private static final int MAX_DURATION = 21474835;
	private static final AtomicInteger actorId = new AtomicInteger();

	protected final Impl impl;

	protected FRJActor(ActorContext<Signal<?>> context, Impl impl) {
		super(context);
		this.impl = impl;
	}

	public <ChildImpl> FRJRef<ChildImpl> spawn(FRJBehavior<ChildImpl> actor) {
		final var ref = this.getContext().spawn(actor.getBehavior(), Integer.toString(actorId.getAndIncrement()));

		return FRJRef.of(actor.getImpl(), ref);
	}

	@Override
	public abstract Receive<Signal<?>> createReceive();

	protected <Req extends Signal<?>, Res> CompletableFuture<Res> dispatch(ActorRef<Req> ref, Function<ActorRef<Res>, Req> getMsg) {
		return AskPattern.ask(
				ref,
				getMsg::apply,
				Duration.ofSeconds(MAX_DURATION),
				this.getContext().getSystem().scheduler()
		).toCompletableFuture();
	}
}
