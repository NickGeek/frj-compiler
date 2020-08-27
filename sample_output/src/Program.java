import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class Program {
	public static void main(String[] args) {
		ActorSystem.create(MainSupervisor.create(ctx -> new MainSupervisor(ctx) {
			@Override
			protected void mainExpr() {
				var std = this.spawn((FRJBehavior<? extends Command, FRJ_Std.Impl>) FRJ_Std.create(new FRJ_Std.Impl()));
				System.out.println(std.getImpl().FRJ_add(1, 2));
				System.out.println(this.<FRJ_Std.Command, Number>dispatch(std.getActor(), r -> new FRJ_Std.M_add(r, 1, 2)).join());
			}
		}), "frj-runtime");
	}

	/* User classes */
	private static final class FRJ_A extends FRJActor<FRJ_A.Command, FRJ_A.Impl> {
		public static Behavior<Command> create(FRJ_A.Impl impl) {
			return Behaviors.setup(ctx -> new FRJ_A(ctx, impl));
		}

		private FRJ_A(ActorContext<Command> context, Impl impl) {
			super(context, impl);
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
									sA.spawn(FRJ_Std.create(new FRJ_Std.Impl())).getImpl().FRJ_add(current, 1)
							)
					).join()
			)).getActor();
		}

		public interface Command extends FRJActor.Command {}
		public static record M_counter(ActorRef<ActorRef<SignalActor.Command>> replyTo, Number current) implements FRJ_A.Command {}

		public static class Impl {}
	}
}
