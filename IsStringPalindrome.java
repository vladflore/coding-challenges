import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class IsStringPalindrome {

    public static void main(String[] args) {
        check("isPalindrome(\"A man, a plan, a canal: Panama\")", isPalindrome("A man, a plan, a canal: Panama"), true);
        check("isPalindrome(\"race a car\")", isPalindrome("race a car"), false);
        check("isPalindrome(\"\")", isPalindrome(""), true);
        check("isPalindrome(\"No 'x' in Nixon\")", isPalindrome("No 'x' in Nixon"), true);
        check("isPalindrome(\"12321\")", isPalindrome("12321"), true);
        check("isPalindrome(\"12345\")", isPalindrome("12345"), false);
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

    public static boolean isPalindrome(String string) {
        var cleaned = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
