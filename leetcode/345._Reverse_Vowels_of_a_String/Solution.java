import java.util.*;

class Solution {
	public String reverseVowels(String s) {
		Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		Deque<Character> stack = new ArrayDeque<>();
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (vowels.contains(c)) {
				stack.push(Character.valueOf(c));
			}
		}
		for (int i = 0; i < chars.length; i++) {
			if (vowels.contains(chars[i])) {
				chars[i] = stack.pop();
			}
		}
		return new String(chars);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		if (!"AceCreIm".equals(s.reverseVowels("IceCreAm"))) {
			throw new IllegalStateException("wrong");
		}
		if (!"leotcede".equals(s.reverseVowels("leetcode"))) {
			throw new IllegalStateException("wrong");
		}

	}

}
