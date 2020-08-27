import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public final class FRJ_Std extends FRJActor<FRJ_Std.Command, FRJ_Std.Impl> {
	public static void main(String[] args) {
		FRJ_Std.create(new FRJ_Std.Impl());
	}

	public static Behavior<Command> create(Impl impl) {
		return Behaviors.setup(ctx -> new FRJ_Std(ctx, impl));
	}

	protected FRJ_Std(ActorContext<Command> context, Impl impl) {
		super(context, impl);
	}

	@Override
	public Receive<Command> createReceive() {
		return newReceiveBuilder()
//				.onMessage(M_print.class, command -> {
//					command.replyTo.tell(this.impl.FRJ_print(command.msg));
//					return this;
//				})
//				.onMessage(M_add.class, command -> {
//					command.replyTo.tell(this.impl.FRJ_add(command.a(), command.b()));
//					return this;
//				})
//				.onMessage(M_sub.class, command -> {
//					command.replyTo.tell(this.impl.FRJ_sub(command.a(), command.b()));
//					return this;
//				})
//				.onMessage(M_mul.class, command -> {
//					command.replyTo.tell(this.impl.FRJ_mul(command.a(), command.b()));
//					return this;
//				})
				.build();
	}

	public interface Command extends FRJActor.Command {}
	public static record M_print(ActorRef<String> replyTo, String msg) implements FRJ_Std.Command {}
	public static record M_add(ActorRef<Number> replyTo, Number a, Number b) implements FRJ_Std.Command {}
	public static record M_sub(ActorRef<Number> replyTo, Number a, Number b) implements FRJ_Std.Command {}
	public static record M_mul(ActorRef<Number> replyTo, Number a, Number b) implements FRJ_Std.Command {}

	public static final class Impl {
		public String FRJ_print(String msg) {
			System.out.println(msg);
			return msg;
		}

		public Number FRJ_add(Number a, Number b) {
			if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
				return a.doubleValue() + b.doubleValue();
			}
			return a.intValue() + b.intValue();
		}

		public Number FRJ_sub(Number a, Number b) {
			if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
				return a.doubleValue() - b.doubleValue();
			}
			return a.intValue() - b.intValue();
		}

		public Number FRJ_mul(Number a, Number b) {
			if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
				return a.doubleValue() * b.doubleValue();
			}
			return a.intValue() * b.intValue();
		}
	}
}
