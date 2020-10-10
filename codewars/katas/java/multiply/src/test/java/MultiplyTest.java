import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplyTest {
	@Test
	void testAssociativityOfMultiplication() {
		for (int i = 0; i < 100; i++) {
			double a = Math.random();
			double b = Math.random();
			double c = Math.random();
			String message = String.format("(%g * %g) * %g == %g * (%g * %g)", a, b, c, a, b, c);
			assertEquals(Multiply.multiply1(Multiply.multiply1(new BigDecimal(a), new BigDecimal(b)), new BigDecimal(c)),
					Multiply.multiply1(new BigDecimal(a), Multiply.multiply1(new BigDecimal(b), new BigDecimal(c))),
					message);
		}
	}
}
