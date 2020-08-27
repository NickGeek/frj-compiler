import akka.actor.typed.ActorRef;

public interface FRJRef<T, Impl> {
	Impl getImpl();
	ActorRef<T> getActor();
}
