import java.time.Duration;
import java.util.Random;

public class FRJ_Std extends FRJObj {
	public Number FRJ_add(Number FRJ_a,Number FRJ_b) {
		if ((FRJ_a.getClass().equals(Double.TYPE) || FRJ_a instanceof Double) || (FRJ_b.getClass().equals(Double.TYPE) || FRJ_b instanceof Double)) {
			return FRJ_a.doubleValue() + FRJ_b.doubleValue();
		}
		return FRJ_a.intValue() + FRJ_b.intValue();
	}
	public Double FRJ_randomFloat(Number FRJ_min,Number FRJ_max) {
		return FRJ_min.doubleValue() + new Random().nextDouble() * (FRJ_max.doubleValue() - FRJ_min.doubleValue());
	}
	public SignalBox<FRJ_Bool> FRJ_sleep(Long FRJ_timeMs) {
		var signal = new Signal<>(FRJ_True::new, () -> this.FRJ_sleep(FRJ_timeMs));

		AkkaHelpers.getActorSystem()
				.scheduler()
				.scheduleOnce(Duration.ofMillis(FRJ_timeMs), () -> new ExplicitSignalObj().dispatch(signal), AkkaHelpers.getActorSystem().executionContext());

		return new SignalBox<>(signal, this);
	}
	public Number FRJ_sub(Number FRJ_a,Number FRJ_b) {
		if ((FRJ_a.getClass().equals(Double.TYPE) || FRJ_a instanceof Double) || (FRJ_b.getClass().equals(Double.TYPE) || FRJ_b instanceof Double)) {
			return FRJ_a.doubleValue() - FRJ_b.doubleValue();
		}
		return FRJ_a.intValue() - FRJ_b.intValue();
	}
	public String FRJ_print(String FRJ_msg) {
		System.out.println(FRJ_msg);
		return FRJ_msg;
	}
	public Number FRJ_mul(Number FRJ_a,Number FRJ_b) {
		if ((FRJ_a.getClass().equals(Double.TYPE) || FRJ_a instanceof Double) || (FRJ_b.getClass().equals(Double.TYPE) || FRJ_b instanceof Double)) {
			return FRJ_a.doubleValue() * FRJ_b.doubleValue();
		}
		return FRJ_a.intValue() * FRJ_b.intValue();
	}
	public FRJ_Bool FRJ_gte(Number FRJ_a,Number FRJ_b) {
		if ((FRJ_a.getClass().equals(Double.TYPE) || FRJ_a instanceof Double) || (FRJ_b.getClass().equals(Double.TYPE) || FRJ_b instanceof Double)) {
			return FRJ_a.doubleValue() >= FRJ_b.doubleValue() ? new FRJ_True() : new FRJ_False();
		}
		return FRJ_a.intValue() >= FRJ_b.intValue() ? new FRJ_True() : new FRJ_False();
	}
}

interface FRJ_Bool extends FRJ_Literal {
	FRJ_Bool FRJ_not();
	FRJ_Bool FRJ_or(FRJ_Bool FRJ_b);
	FRJ_Bool FRJ_and(FRJ_Bool FRJ_b);
	FRJ_ProducerN FRJ_thenElse(FRJ_ProducerN FRJ_f1,FRJ_ProducerN FRJ_f2);
}

interface FRJ_Literal {
	String toString();
}

interface FRJ_ProducerN {
	Number FRJ_get();
}