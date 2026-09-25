import java.util.Arrays;
import java.util.Objects;

public class RotateString {

    public static void main(String[] args) {
        check("solve(\"abcde\", \"cdeab\")", solve("abcde", "cdeab"), true);
        check("solve(\"abcde\", \"abced\")", solve("abcde", "abced"), false);
        check("solve(\"\", \"\")", solve("", ""), true);
        check("solve(\"a\", \"aa\")", solve("a", "aa"), false);
        check("solve(\"ab\", \"ba\")", solve("ab", "ba"), true);
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

    private static boolean solve(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
