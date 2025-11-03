
public class LongestCommonPrefix {

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int charIndex = 0; charIndex < prefix.length(); charIndex++) {
            char character = prefix.charAt(charIndex);
            for (int strIndex = 1; strIndex < strs.length; strIndex++) {
                if (charIndex >= strs[strIndex].length() || strs[strIndex].charAt(charIndex) != character) {
                    return prefix.substring(0, charIndex);
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        var strings = new String[]{"flower", "flow", "flight"};
        var expected = "fl";
        var actual = longestCommonPrefix(strings);
        check(expected, actual);

        strings = new String[]{"dog", "racecar", "car"};
        expected = "";
        actual = longestCommonPrefix(strings);
        check(expected, actual);

        strings = new String[]{"abcd", "abcde", "abcdef"};
        expected = "abcd";
        actual = longestCommonPrefix(strings);
        check(expected, actual);
    }

    private static void check(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(
                    "Expected: %s, Actual: %s".formatted(expected, actual)
            );
        }
    }
}
