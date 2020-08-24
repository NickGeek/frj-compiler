import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;

import java.io.Serializable;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class Program {
	private static final int MAX_DURATION = 21474835;
	private static final AtomicInteger actorId = new AtomicInteger();

	interface Command extends Serializable {}

	private abstract static class FRJActor<T extends Command> extends AbstractBehavior<T> {
		private FRJActor(ActorContext<T> context) {
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
					getContext().getSystem().scheduler()
			).toCompletableFuture();
		}
	}

	private static final class SignalActor<T> extends FRJActor<SignalActor.Command> {
		public interface Command extends Program.Command {}
		public record GetHead<T>(ActorRef<T> replyTo) implements SignalActor.Command {}
		public record GetTail<T>(ActorRef<T> replyTo) implements SignalActor.Command {}

		private record ComputeHead<T>(Function<SignalActor<T>, T> head) implements SignalActor.Command {}
		private record ComputeTail<T>(Function<SignalActor<T>, ActorRef<SignalActor.Command>> tail) implements SignalActor.Command {}

		/**
		 * Construct an empty signal.
		 */
		public static Behavior<SignalActor.Command> empty() {
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

		private SignalActor(ActorContext<SignalActor.Command> context) {
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
	}

	private static final class MainSupervisor extends FRJActor<Command> {
		public static Behavior<Command> create() {
			return Behaviors.setup(MainSupervisor::new);
		}

		private MainSupervisor(ActorContext<Command> context) {
			super(context);

			// Main function generation code here
			Object ignored = switch (0) {
				default -> {
					var std = this.spawn(FRJ_Std.create());

					yield "foo";
				}
			};
			var actorRef = this.spawn(FRJ_Std.create());
			this.<FRJ_Std.Command, String>dispatch(actorRef, ref -> new FRJ_Std.M_print(ref, "Hello, World!"));

			var explicit = this.spawn(SignalActor.explicit(
					sa -> 123,
					sa -> sa.spawn(SignalActor.explicit(
							sa2 -> sa2.<FRJ_Std.Command, Number>dispatch(actorRef, ref3 -> new FRJ_Std.M_add(ref3, 0, 1)),
							sa2 -> sa2.spawn(SignalActor.empty())
					))));
			var eHead = this.<SignalActor.Command, Number>dispatch(explicit, SignalActor.GetHead::new);

			System.out.println(eHead);
			var eTail = this.<SignalActor.Command, ActorRef<SignalActor.Command>>dispatch(explicit, SignalActor.GetTail::new);
			System.out.println(this.<SignalActor.Command, Number>dispatch(eTail, SignalActor.GetHead::new));

			var foo = this.<FRJ_A.Command, ActorRef<SignalActor.Command>>dispatch(this.spawn(FRJ_A.create()), ref -> new FRJ_A.M_counter(ref, 0));
			System.out.println(this.<SignalActor.Command, Number>dispatch(foo, SignalActor.GetHead::new));
			var aFewTails = this.<SignalActor.Command, ActorRef<SignalActor.Command>>dispatch(this.dispatch(foo, SignalActor.GetTail::new), SignalActor.GetTail::new);
			System.out.println(this.<SignalActor.Command, Number>dispatch(aFewTails, SignalActor.GetHead::new));
		}

		@Override
		public Receive<Command> createReceive() {
			return newReceiveBuilder().build();
		}
	}

	public static void main(String[] args) {
		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");
		ActorSystem.create(MainSupervisor.create(), "frj-runtime");
	}

	/* User classes */
	private static final class FRJ_A extends FRJActor<FRJ_A.Command> {
		public interface Command extends Program.Command {}
		public static record M_counter(ActorRef<ActorRef<SignalActor.Command>> replyTo, Number current) implements FRJ_A.Command {}

		public static Behavior<FRJ_A.Command> create() {
			return Behaviors.setup(FRJ_A::new);
		}

		private FRJ_A(ActorContext<FRJ_A.Command> context) {
			super(context);
		}

		@Override
		public Receive<Command> createReceive() {
			return newReceiveBuilder()
					.onMessage(M_counter.class, command -> {
						command.replyTo.tell(this.FRJ_counter(command.current()));
						return this;
					})
					.build();
		}

		private ActorRef<SignalActor.Command> FRJ_counter(Number current) {
			return this.spawn(SignalActor.explicit(
					sA -> current,
					sA -> sA.<FRJ_A.Command, ActorRef<SignalActor.Command>>dispatch(
							getContext().getSelf(),
							ref -> new M_counter(
									ref,
									sA.<FRJ_Std.Command, Number>dispatch(
											sA.spawn(FRJ_Std.create()),
											r2 -> new FRJ_Std.M_add(r2, current, 1)
									)
							)
					)
			));
		}
	}

	private static final class FRJ_Stringify extends FRJActor<FRJ_Stringify.Command> {
		public interface Command extends Program.Command {}
		public static record M_fromNum(ActorRef<String> replyTo, Number n) implements FRJ_Stringify.Command {}

		public static Behavior<FRJ_Stringify.Command> create() {
			return Behaviors.setup(FRJ_Stringify::new);
		}

		private FRJ_Stringify(ActorContext<FRJ_Stringify.Command> context) {
			super(context);
		}

		@Override
		public Receive<Command> createReceive() {
			return newReceiveBuilder()
					.onMessage(M_fromNum.class, (command) -> {
						command.replyTo.tell(this.FRJ_fromNum(command.n));
						return this;
					})
					.build();
		}

		private String FRJ_fromNum(Number n) {
			return n.toString();
		}
	}

	private static final class FRJ_Std extends FRJActor<FRJ_Std.Command> {
		public interface Command extends Program.Command {}
		public static record M_print(ActorRef<String> replyTo, String msg) implements FRJ_Std.Command {}
		public static record M_add(ActorRef<Number> replyTo, Number a, Number b) implements FRJ_Std.Command {}
		public static record M_sub(ActorRef<Number> replyTo, Number a, Number b) implements FRJ_Std.Command {}
		public static record M_mul(ActorRef<Number> replyTo, Number a, Number b) implements FRJ_Std.Command {}

		public static Behavior<FRJ_Std.Command> create() {
			return Behaviors.setup(FRJ_Std::new);
		}

		private FRJ_Std(ActorContext<FRJ_Std.Command> context) {
			super(context);
		}

		@Override
		public Receive<Command> createReceive() {
			return newReceiveBuilder()
					.onMessage(M_print.class, (command) -> {
						// Method expr
						var rv = this.FRJ_print(command.msg);
						// Method return value
						command.replyTo.tell(rv);

						// Akka boilerplate
						return this;
					})
					.onMessage(M_add.class, command -> {
						command.replyTo.tell(this.FRJ_add(command.a(), command.b()));
						return this;
					})
					.build();
		}

		private Number FRJ_add(Number a, Number b) {
			if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
				return a.doubleValue() + b.doubleValue();
			}
			return a.intValue() + b.intValue();
		}

		private Number FRJ_sub(Number a, Number b) {
			if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
				return a.doubleValue() - b.doubleValue();
			}
			return a.intValue() - b.intValue();
		}

		private Number FRJ_mul(Number a, Number b) {
			if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
				return a.doubleValue() * b.doubleValue();
			}
			return a.intValue() * b.intValue();
		}

		private String FRJ_print(String msg) {
			System.out.println(msg);
			return msg;
		}
	}
}
