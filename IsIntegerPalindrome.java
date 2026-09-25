import java.util.Arrays;
import java.util.Objects;

public class IsIntegerPalindrome {

    public static void main(String[] args) {
        check("isPalindrome(121)", isPalindrome(121), true);
        check("isPalindrome(-121)", isPalindrome(-121), false);
        check("isPalindrome(10)", isPalindrome(10), false);
        check("isPalindrome(0)", isPalindrome(0), true);
        check("isPalindrome(12321)", isPalindrome(12321), true);
        check("isPalindrome(1234)", isPalindrome(1234), false);
        check("isPalindrome(123321)", isPalindrome(123321), true);
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

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        if (number % 10 == 0 && number != 0) {
            return false;
        }

        int secondHalfReversed = 0;
        while (number > secondHalfReversed) {
            secondHalfReversed = secondHalfReversed * 10 + number % 10;
            number /= 10;
        }

        return number == secondHalfReversed || number == secondHalfReversed / 10;
    }

}
