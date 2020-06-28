import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsogramTest {

	@Test
	void testIsograms() {
		assertEquals(true, Isogram.isIsogram("Dermatoglyphics"));
		assertEquals(true, Isogram.isIsogram("isogram"));
		assertEquals(false, Isogram.isIsogram("moose"));
		assertEquals(false, Isogram.isIsogram("isIsogram"));
		assertEquals(false, Isogram.isIsogram("aba"));
		assertEquals(false, Isogram.isIsogram("moOse"));
		assertEquals(true, Isogram.isIsogram("thumbscrewjapingly"));
		assertEquals(true, Isogram.isIsogram(""));
		assertEquals(true, Isogram.isIsogram(null));
	}

}
