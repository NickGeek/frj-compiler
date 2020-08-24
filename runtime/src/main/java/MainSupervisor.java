import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import akka.japi.function.Function;

public abstract class MainSupervisor extends FRJActor<FRJActor.Command> {
	public static Behavior<Command> create(final Function<ActorContext<Command>, Behavior<Command>> factory) {
		return Behaviors.setup(factory);
	}

	private MainSupervisor(ActorContext<Command> context) {
		super(context);
	}

	protected abstract void mainExpr();

	@Override
	public Receive<Command> createReceive() {
		return newReceiveBuilder().build();
	}
}
