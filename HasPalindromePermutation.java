import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HasPalindromePermutation {

    public static void main(String[] args) {
        check("solve(\"code\")", solve("code"), false);
        check("solve(\"aab\")", solve("aab"), true);
        check("solve(\"carerac\")", solve("carerac"), true);
        check("solve(\"\")", solve(""), true);
        check("solve(\"ab\")", solve("ab"), false);
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

    private static boolean solve(String string) {
        Map<Character, Integer> freq = string
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
        int oddCount = 0;
        for (int count : freq.values()) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}
