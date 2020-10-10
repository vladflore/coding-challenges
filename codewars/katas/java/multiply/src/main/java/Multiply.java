import java.math.BigDecimal;

public class Multiply {
	public static Double multiply(Double a, Double b) {
		if (a == null || b == null)
			throw new IllegalArgumentException("Operand cannot be null.");
		// TODO this does not work all the time - precision loss
		return a * b;
	}

	public static BigDecimal multiply1(BigDecimal a, BigDecimal b) {
		if (a == null || b == null)
			throw new IllegalArgumentException("Operand cannot be null.");
		return a.multiply(b);
	}
}
