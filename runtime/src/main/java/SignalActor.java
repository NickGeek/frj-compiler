import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public final class SignalActor<T> extends FRJActor<SignalActor.Command> {
	/**
	 * Construct an empty signal.
	 */
	public static Behavior<Command> empty() {
		return Behaviors.setup(SignalActor::new);
	}

	/**
	 * Construct an explicit signal.
	 */
	public static <T> Behavior<SignalActor.Command> explicit(Function<SignalActor<T>, T> headSupplier, Function<SignalActor<T>, ActorRef<SignalActor.Command>> tailSupplier) {
		return Behaviors.setup(ctx -> new SignalActor<>(ctx, headSupplier, tailSupplier));
	}

	private final CompletableFuture<T> head = new CompletableFuture<>();
	private final CompletableFuture<ActorRef<SignalActor.Command>> tail = new CompletableFuture<>();

	private SignalActor(ActorContext<Command> context) {
		super(context);

		this.head.complete(null);
		this.tail.complete(context.getSelf());
	}

	private SignalActor(ActorContext<SignalActor.Command> context, Function<SignalActor<T>, T> headSupplier, Function<SignalActor<T>, ActorRef<SignalActor.Command>> tailSupplier) {
		super(context);

		context.getSelf().tell(new ComputeHead<>(headSupplier));
		context.getSelf().tell(new ComputeTail<>(tailSupplier));
	}

	@Override
	public Receive<Command> createReceive() {
		return newReceiveBuilder()
				.onMessage(ComputeHead.class, command -> {
					this.head.complete((T) command.head().apply(this));
					return this;
				})
				.onMessage(ComputeTail.class, command -> {
					this.tail.complete((ActorRef<SignalActor.Command>) command.tail().apply(this));
					return this;
				})
				.onMessage(GetHead.class, command -> {
					var head = this.head.join();

					command.replyTo().tell(head);
					return this;
				})
				.onMessage(GetTail.class, command -> {
					command.replyTo().tell(this.tail.join());
					return this;
				})
				.build();
	}

	public interface Command extends FRJActor.Command {}
	public record GetHead<T>(
	ActorRef<T> replyTo) implements SignalActor.Command {}
	public record GetTail<T>(ActorRef<T> replyTo) implements SignalActor.Command {}

	private record ComputeHead<T>(
	Function<SignalActor<T>, T> head) implements SignalActor.Command {}
	private record ComputeTail<T>(Function<SignalActor<T>, ActorRef<SignalActor.Command>> tail) implements SignalActor.Command {}
}
