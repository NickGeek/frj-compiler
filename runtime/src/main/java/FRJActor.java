import akka.actor.typed.ActorRef;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.AskPattern;
import akka.actor.typed.javadsl.Receive;

import java.io.Serializable;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public abstract class FRJActor<T extends FRJActor.Command, Impl> extends AbstractBehavior<T> {
	private static final int MAX_DURATION = 21474835;
	private static final AtomicInteger actorId = new AtomicInteger();

	protected final Impl impl;

	protected FRJActor(ActorContext<T> context, Impl impl) {
		super(context);
		this.impl = impl;
	}

	public <C extends Command, ChildImpl> FRJRef<C, ChildImpl> spawn(FRJBehavior<C, ChildImpl> actor) {
		final var ref = this.getContext().spawn(actor.getBehavior(), Integer.toString(actorId.getAndIncrement()));

		return new FRJRef<>() {
			@Override
			public ChildImpl getImpl() {
				return actor.getImpl();
			}

			@Override
			public ActorRef<C> getActor() {
				return ref;
			}
		};
	}

	@Override
	public abstract Receive<T> createReceive();

	protected <Req extends Command, Res> CompletableFuture<Res> dispatch(ActorRef<Req> ref, Function<ActorRef<Res>, Req> getMsg) {
		return AskPattern.ask(
				ref,
				getMsg::apply,
				Duration.ofSeconds(MAX_DURATION),
				this.getContext().getSystem().scheduler()
		).toCompletableFuture();
	}

	public interface Command extends Serializable {}
}
