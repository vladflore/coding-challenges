import java.util.Arrays;
import java.util.Objects;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        check("solve(\"abc\", \"pqr\")", solve("abc", "pqr"), "apbqcr");
        check("solve(\"ab\", \"pqrs\")", solve("ab", "pqrs"), "apbqrs");
        check("solve(\"abcd\", \"pq\")", solve("abcd", "pq"), "apbqcd");
        check("solve(\"\", \"xy\")", solve("", "xy"), "xy");
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

    private static String solve(String str1, String str2) {
        var sb = new StringBuilder();
        int idx1 = 0, idx2 = 0;
        while (idx1 < str1.length() && idx2 < str2.length()) {
            sb.append(str1.charAt(idx1));
            sb.append(str2.charAt(idx2));
            idx1++;
            idx2++;
        }
        while (idx1 < str1.length()) {
            sb.append(str1.charAt(idx1));
            idx1++;
        }

        while (idx2 < str2.length()) {
            sb.append(str2.charAt(idx2));
            idx2++;
        }

        return sb.toString();
    }
}
