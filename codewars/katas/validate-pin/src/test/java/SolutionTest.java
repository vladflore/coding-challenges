import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

	@Test
	public void validPins() {
		assertTrue(Solution.validatePin("1234"));
		assertTrue(Solution.validatePin("0000"));
		assertTrue(Solution.validatePin("1111"));
		assertTrue(Solution.validatePin("123456"));
		assertTrue(Solution.validatePin("098765"));
		assertTrue(Solution.validatePin("000000"));
		assertTrue(Solution.validatePin("090909"));
	}

	@Test
	public void nonDigitCharacters() {
		assertFalse(Solution.validatePin("a234"));
		assertFalse(Solution.validatePin(".234"));
		assertFalse(Solution.validatePin(null));
		assertFalse(Solution.validatePin(""));
	}

	@Test
	public void invalidLengths() {
		assertFalse(Solution.validatePin("1"));
		assertFalse(Solution.validatePin("12"));
		assertFalse(Solution.validatePin("123"));
		assertFalse(Solution.validatePin("12345"));
		assertFalse(Solution.validatePin("1234567"));
		assertFalse(Solution.validatePin("-1234"));
		assertFalse(Solution.validatePin("1.234"));
		assertFalse(Solution.validatePin("00000000"));
	}

}
