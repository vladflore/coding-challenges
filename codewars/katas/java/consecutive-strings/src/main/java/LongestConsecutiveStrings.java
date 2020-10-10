import java.util.Arrays;

public class LongestConsecutiveStrings {
	public String longestConsecutive(String[] strings, int k) {
		String longest = "";
		if (strings == null || strings.length < k || k <= 0) {
			return longest;
		}

		int maxLength = 0;

		for (int i = 0; i <= strings.length - k; i++) {
			String[] subStrings = Arrays.copyOfRange(strings, i, i + k);
			String candidate = String.join("", subStrings);
			if (maxLength < candidate.length()) {
				maxLength = candidate.length();
				longest = candidate;
			}
		}

		return longest;
	}
}
