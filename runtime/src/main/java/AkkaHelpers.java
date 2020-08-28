import akka.actor.typed.*;
import akka.actor.typed.javadsl.AskPattern;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

public class AkkaHelpers {
	private static final int MAX_DURATION = 21474835;
	private static ActorSystem<SpawnProtocol.Command> actorSystem;

	public static void start() {
		if (actorSystem != null) return;
		actorSystem = ActorSystem.create(SpawnProtocol.create(), "frj-runtime");
	}

	public static ActorSystem<SpawnProtocol.Command> getActorSystem() {
		start();
		return actorSystem;
	}

	public static ActorRef<Signal<?>> spawn(Behavior<Signal<?>> actor) {
		start();

		try {
			return AskPattern.<SpawnProtocol.Spawn<Signal<?>>, ActorRef<Signal<?>>>ask(
					actorSystem.narrow(),
					replyTo -> new SpawnProtocol.Spawn<>(actor, "", Props.empty(), replyTo),
					Duration.ofSeconds(MAX_DURATION),
					actorSystem.scheduler()
			).toCompletableFuture().get();
		} catch (ExecutionException | InterruptedException e) {
			throw new RuntimeException("Could not create the actor: " + actor);
		}
	}
}
