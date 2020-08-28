public class Program {
	private static class FRJ_A extends FRJObj {
		public SignalBox<Number> counter(Number current) {
			return Signal.explicit(
					() -> current,
					() -> this.counter(new FRJ_Std().add(current, 1))
			);
		}

//		public SignalBox<SignalBox<Number>> liftedCounter(SignalBox<Number> current) {
//			return this.dispatch(new Signal<SignalBox<Number>>(
//					() -> this.counter(SignalBox.head(current)),
//					() -> this.liftedCounter(SignalBox.tail(current))
//			));
//		}
	}

	private static class FRJ_Stringify extends FRJObj {
		public String fromNum(Number n) {
			return n.toString();
		}

		public SignalBox<String> liftedFromNum(SignalBox<Number> n) {
			return this.dispatch(new Signal<String>(
					() -> this.fromNum(SignalBox.head(n)),
					() -> this.liftedFromNum(SignalBox.tail(n))
			));
		}
	}

	public static void main(String[] args) {
		switch (1) {
			default -> {
				FRJ_Std std = new FRJ_Std();
				std.liftedPrint(new FRJ_Stringify().liftedFromNum(new FRJ_A().counter(0)));
			}
		}
	}
}
