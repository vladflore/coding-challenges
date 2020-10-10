import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestConsecutiveStringsTest {

	@Test
	void test() {
		String longestConsecutive = new LongestConsecutiveStrings().longestConsecutive(new String[] { "zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail" }, 2);
		assertEquals("abigailtheta", longestConsecutive);
	}

	@Test
	void testInvalidInput() {
		String longestConsecutive = new LongestConsecutiveStrings().longestConsecutive(new String[] {}, 1);
		assertEquals("", longestConsecutive);

		longestConsecutive = new LongestConsecutiveStrings().longestConsecutive(new String[] { "a" }, -1);
		assertEquals("", longestConsecutive);

		longestConsecutive = new LongestConsecutiveStrings().longestConsecutive(new String[] { "a" }, 0);
		assertEquals("", longestConsecutive);

		longestConsecutive = new LongestConsecutiveStrings().longestConsecutive(new String[] { "a" }, 2);
		assertEquals("", longestConsecutive);
	}
}
