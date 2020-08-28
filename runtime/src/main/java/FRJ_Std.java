import java.time.Duration;

public final class FRJ_Std extends FRJObj {
	public String print(String msg) {
		System.out.println(msg);
		return msg;
	}

	public SignalBox<String> lifted_print(SignalBox<String> msg) {
		return this.dispatch(new Signal<>(
				() -> this.print(SignalBox.head(msg)),
				() -> this.lifted_print(SignalBox.tail(msg))
		));
	}

	public Number add(Number a, Number b) {
		if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
			return a.doubleValue() + b.doubleValue();
		}
		return a.intValue() + b.intValue();
	}

	public SignalBox<Number> lifted_add(SignalBox<Number> a, SignalBox<Number> b) {
		return this.dispatch(new Signal<>(
				() -> this.add(SignalBox.head(a), SignalBox.head(b)),
				() -> this.lifted_add(SignalBox.tail(a), SignalBox.tail(b))
		));
	}

	public Number sub(Number a, Number b) {
		if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
			return a.doubleValue() - b.doubleValue();
		}
		return a.intValue() - b.intValue();
	}

	public SignalBox<Number> lifted_sub(SignalBox<Number> a, SignalBox<Number> b) {
		return this.dispatch(new Signal<>(
				() -> this.sub(SignalBox.head(a), SignalBox.head(b)),
				() -> this.lifted_sub(SignalBox.tail(a), SignalBox.tail(b))
		));
	}

	public Number mul(Number a, Number b) {
		if (a.getClass().equals(Double.TYPE) || b.getClass().equals(Double.TYPE)) {
			return a.doubleValue() * b.doubleValue();
		}
		return a.intValue() * b.intValue();
	}

	public SignalBox<Number> lifted_mul(SignalBox<Number> a, SignalBox<Number> b) {
		return this.dispatch(new Signal<>(
				() -> this.mul(SignalBox.head(a), SignalBox.head(b)),
				() -> this.lifted_mul(SignalBox.tail(a), SignalBox.tail(b))
		));
	}

	public SignalBox<Boolean> sleep(int timeMs) {
		var signal = new Signal<>(() -> true, () -> this.sleep(timeMs));

		AkkaHelpers.getActorSystem()
				.scheduler()
				.scheduleOnce(Duration.ofMillis(timeMs), () -> new ExplicitSignalObj().dispatch(signal), AkkaHelpers.getActorSystem().executionContext());

		return new SignalBox<>(signal, this);
	}

	public SignalBox<SignalBox<Boolean>> lifted_sleep(SignalBox<Integer> timeMs) {
		return this.dispatch(new Signal<>(
				() -> this.sleep(SignalBox.head(timeMs)),
				() -> this.lifted_sleep(SignalBox.tail(timeMs))
		));
	}
}
