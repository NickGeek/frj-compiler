import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Supplier;

public class SignalBox<T> {
	public static <T> SignalBox<T> explicit(Supplier<T> head, Supplier<SignalBox<T>> tail) {
		var emptyObj = new ExplicitSignalObj();
		var signal = new Signal<>(head, tail);

		return emptyObj.dispatch(signal);
	}

	public static <T, R extends FRJObj> SignalBox<T> lift(R receiver, String methodName, SignalBox<?>... input) {
		var method = Arrays.stream(receiver.getClass().getMethods())
				.filter(meth -> meth.getName().equals(methodName))
				.findAny()
				.get();

		return lift(receiver, method, input);
	}

	/**
	 * Lifts a method call on a primitive data-type (FRJ prim, so Long/Double/String).
	 */
	public static <T, R> SignalBox<T> lift(R receiver, String methodName, int argc, SignalBox<?>... input) {
		/* It's fairly tricky to get the correct types to do a normal .getMethod(), so we're using argc
			because that should cover the exposed primitive methods. */
		var method = Arrays.stream(receiver.getClass().getMethods())
				.filter(meth -> meth.getName().equals(methodName) && meth.getParameterCount() == argc)
				.findAny()
				.get();

		return new ExplicitSignalObj().dispatch(new Signal<>(
				() -> {
					var heads = Arrays.stream(input).map(SignalBox::head).toArray();
					try {
						return (T) method.invoke(receiver, heads);
					} catch (IllegalAccessException | InvocationTargetException e) {
						throw new RuntimeException(e);
					}
				},
				() -> {
					var tails = Arrays.stream(input).map(SignalBox::tail).toArray(SignalBox<?>[]::new);
					return lift(receiver, methodName, argc, tails);
				}
		));
	}

	private static <T, R extends FRJObj> SignalBox<T> lift(R receiver, Method method, SignalBox<?>[] input) {
		return receiver.dispatch(new Signal<>(
				() -> {
					var heads = Arrays.stream(input).map(SignalBox::head).toArray();
					try {
						return (T) method.invoke(receiver, heads);
					} catch (IllegalAccessException | InvocationTargetException e) {
						throw new RuntimeException(e);
					}
				},
				() -> {
					var tails = Arrays.stream(input).map(SignalBox::tail).toArray(SignalBox<?>[]::new);
					return lift(receiver, method, tails);
				}
		));
	}

	public static <T> T head(SignalBox<T> signal) {
		return signal.getSignal().getMessage().join().head();
	}

	public static <T> SignalBox<T> tail(SignalBox<T> signal) {
		return signal.getSignal().getMessage().join().tail();
	}

	private final Signal<T> signal;
	private final FRJObj self;

	public SignalBox() {
		this.signal = new Signal<>();
		this.self = null;
	}

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
