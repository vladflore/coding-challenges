import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

	@Test
	public void testSomeUnderscoreLowerStart() {
		String input = "the_Stealth_Warrior";
		System.out.println("input: " + input);
		assertEquals("theStealthWarrior", Solution.toCamelCase(input));
	}

	@Test
	public void testSomeDashLowerStart() {
		String input = "the-Stealth-Warrior";
		System.out.println("input: " + input);
		assertEquals("theStealthWarrior", Solution.toCamelCase(input));
	}

	@Test
	void testInvalid() {
		assertEquals("", Solution.toCamelCase(""));
		assertEquals("", Solution.toCamelCase(null));
		assertEquals("a", Solution.toCamelCase("a"));
		assertEquals("aB", Solution.toCamelCase("a_b"));
		assertEquals("BCCD", Solution.toCamelCase("B_C_c_d"));
	}
}
