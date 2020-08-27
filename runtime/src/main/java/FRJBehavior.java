import akka.actor.typed.Behavior;

public interface FRJBehavior<T, Impl> {
	Impl getImpl();
	Behavior<T> getBehavior();
}
