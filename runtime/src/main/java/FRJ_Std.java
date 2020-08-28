import java.util.concurrent.CompletableFuture;

public final class FRJ_Std extends FRJObj {
	public String print(String msg) {
		System.out.println(msg);
		return msg;
	}

	public CompletableFuture<SignalBox<String>> liftedPrint(SignalBox<String> msg) {
		return CompletableFuture.allOf(msg.getSignal().getMessage())
				.thenApply(v -> this.dispatch(new Signal<>(
						() -> this.print(SignalBox.head(msg)),
						() -> this.liftedPrint(SignalBox.tail(msg)).join()
				)));
	}

	public Number add(Number a, Number b) {
		if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
			return a.doubleValue() + b.doubleValue();
		}
		return a.intValue() + b.intValue();
	}

	public SignalBox<Number> liftedAdd(SignalBox<Number> a, SignalBox<Number> b) {
		return this.dispatch(new Signal<>(
				() -> this.add(SignalBox.head(a), SignalBox.head(b)),
				() -> this.liftedAdd(SignalBox.tail(a), SignalBox.tail(b))
		));
	}

	public Number sub(Number a, Number b) {
		if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
			return a.doubleValue() - b.doubleValue();
		}
		return a.intValue() - b.intValue();
	}

	public SignalBox<Number> liftedSub(SignalBox<Number> a, SignalBox<Number> b) {
		return this.dispatch(new Signal<>(
				() -> this.sub(SignalBox.head(a), SignalBox.head(b)),
				() -> this.liftedSub(SignalBox.tail(a), SignalBox.tail(b))
		));
	}

	public Number mul(Number a, Number b) {
		if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
			return a.doubleValue() * b.doubleValue();
		}
		return a.intValue() * b.intValue();
	}

	public SignalBox<Number> liftedMul(SignalBox<Number> a, SignalBox<Number> b) {
		return this.dispatch(new Signal<>(
				() -> this.mul(SignalBox.head(a), SignalBox.head(b)),
				() -> this.liftedMul(SignalBox.tail(a), SignalBox.tail(b))
		));
	}
}
