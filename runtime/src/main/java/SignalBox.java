public class SignalBox<T> {
	public static <T> T head(SignalBox<T> signal) {
		return signal.getSignal().getMessage().join().head();
	}

	public static <T> SignalBox<T> tail(SignalBox<T> signal) {
		return signal.getSignal().getMessage().join().tail();
	}

	private final Signal<T> signal;
	private final FRJObj self;

	public SignalBox(Signal<T> signal, FRJObj self) {
		this.signal = signal;
		this.self = self;
	}

	public Signal<T> getSignal() {
		return this.signal;
	}

	@Override
	public String toString() {
		return this.signal.toString();
	}
}
