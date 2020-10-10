import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

	static String toCamelCase1(String str) {
		String[] words = str.split("[-_]");
		return Arrays.stream(words, 1, words.length)
				.map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
				.reduce(words[0], String::concat);
	}

	static String toCamelCase(String s) {
		if (s == null || s.isEmpty())
			return "";

		String[] words = s.split("[-|_]");
		String rest = Arrays.stream(Arrays.copyOfRange(words, 1, words.length))
				.map(Solution::firstLetterToUpperCase)
				.collect(Collectors.joining());

		return words[0] + rest;
	}

	private static String firstLetterToUpperCase(String w) {
		List<String> chars = w.chars().mapToObj(c -> ((char) c) + "").collect(Collectors.toList());
		chars.set(0, chars.get(0).toUpperCase());
		return String.join("", chars);
	}
}
