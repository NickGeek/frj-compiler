import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class Signal<T> implements Serializable {
//	public static <T> SignalBox<T> explicit(Supplier<T> head, Supplier<SignalBox<T>> tail) {
//		var signal = new Signal<>(head, () -> new FRJObj().dispatch(tail.get().getSignal()));
//		return new FRJObj().dispatch(signal);
//	}

	public static <T> SignalBox<T> explicit(Supplier<T> head, Supplier<SignalBox<T>> tail) {
		var emptyObj = new FRJObj();
		var signal = new Signal<>(head, () -> emptyObj.dispatch(tail.get().getSignal()));
		return emptyObj.dispatch(signal);
	}

	private final CompletableFuture<Message<T>> message = new CompletableFuture<>();

	private final Supplier<T> headSupplier;
	private final Supplier<SignalBox<T>> tailSupplier;

	public Signal() {
		this.headSupplier = null;
//		this.tailSupplier = new WeakReference<>(Signal::new);
		this.tailSupplier = () -> new SignalBox<>(new Signal<>(), null);
	}

	public Signal(Supplier<T> head, Supplier<SignalBox<T>> tail) {
//		this.headSupplier = new WeakReference<>(head);
//		this.tailSupplier = new WeakReference<>(tail);
		this.headSupplier = head;
		this.tailSupplier = tail;
	}

	public void execute() throws SignalUseAfterFreeException {
		if (this.headSupplier == null) {
			throw new IllegalArgumentException("Cannot call head(Signal) on @[].");
		}

//		var headSupplier = this.headSupplier.get();
//		var tailSupplier = this.tailSupplier.get();
//		if (headSupplier == null || tailSupplier == null) {
//			throw new SignalUseAfterFreeException();
//		}

		var head = headSupplier.get();
		this.message.complete(new Message<>(head, tailSupplier.get()));
	}

	public boolean isEmpty() {
		return this.headSupplier == null;
	}

	public CompletableFuture<Message<T>> getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		if (this.message.isDone()) {
			return "@" + this.getMessage().join().toString();
		}
		return this.isEmpty() ? "@[]" : "@[?; ?]";
	}

	public static class Message<T> {
		private final T head;
		private final SignalBox<T> tail;

		public Message(T head, SignalBox<T> tail) {
			this.head = head;
			this.tail = tail;
		}

		public T head() {
			return this.head;
		}

		public SignalBox<T> tail() {
			return this.tail;
		}

		@Override
		public String toString() {
			return String.format("[%s; %s]", this.head, this.tail);
		}
	}

	public static class SignalUseAfterFreeException extends Exception {
		private SignalUseAfterFreeException() {
			super("The signal has been GC'd and cannot be read from");
		}
	}
}
