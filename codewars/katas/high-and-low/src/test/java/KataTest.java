import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {

	@Test
	public void test1() {
		assertEquals("42 -9", Kata.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
		assertEquals("8 7", Kata.highAndLow("8 7"));
		assertEquals("8 8", Kata.highAndLow("8"));
	}

}
