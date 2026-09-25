import java.util.Arrays;
import java.util.Objects;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        check("longestCommonPrefix([flower, flow, flight])", longestCommonPrefix(new String[] {"flower", "flow", "flight"}), "fl");
        check("longestCommonPrefix([dog, racecar, car])", longestCommonPrefix(new String[] {"dog", "racecar", "car"}), "");
        check("longestCommonPrefix([abcd, abcde, abcdef])", longestCommonPrefix(new String[] {"abcd", "abcde", "abcdef"}), "abcd");
        check("longestCommonPrefix([alone])", longestCommonPrefix(new String[] {"alone"}), "alone");
        check("longestCommonPrefix([])", longestCommonPrefix(new String[] {}), "");
        System.out.println(passed + "/" + total + " passed");
    }

    private static int passed = 0, total = 0;

    private static void check(String label, Object actual, Object expected) {
        total++;
        boolean ok = Objects.deepEquals(actual, expected);
        if (ok) {
            passed++;
        }
        System.out.println(
                (ok ? "PASS  " : "FAIL  ") + label + (ok ? "" : "  -> expected " + show(expected) + ", got " + show(actual)));
    }

    private static String show(Object value) {
        String text = Arrays.deepToString(new Object[] {value});
        return text.substring(1, text.length() - 1);
    }

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

}
