public class FRJ_False extends FRJObj implements FRJ_Bool {
	public FRJ_Bool FRJ_not() {
		return new FRJ_True();
	}
	public FRJ_Bool FRJ_or(FRJ_Bool FRJ_b) {
		return FRJ_b;
	}
	public FRJ_Bool FRJ_and(FRJ_Bool FRJ_b) {
		return this;
	}
	public String toString() {
		return (String)"false";
	}
	public FRJ_ProducerN FRJ_thenElse(FRJ_ProducerN FRJ_f1,FRJ_ProducerN FRJ_f2) {
		return FRJ_f2;
	}
}