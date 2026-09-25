import java.util.Arrays;
import java.util.Objects;

public class MaxProductOfTwoElementsInArray {

    public static void main(String[] args) {
        check("solve([3, 4, 5, 2])", solve(new int[] {3, 4, 5, 2}), 12);
        check("solve([1, 5, 4, 5])", solve(new int[] {1, 5, 4, 5}), 16);
        check("solve([3, 7])", solve(new int[] {3, 7}), 12);
        check("solve([1, 1])", solve(new int[] {1, 1}), 0);
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

    private static int solve(int[] nums) {
        int largest = 0, secondLargest = 0;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }

        return (largest - 1) * (secondLargest - 1);
    }
}
