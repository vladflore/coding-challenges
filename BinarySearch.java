import java.util.Arrays;
import java.util.Objects;

public class BinarySearch {

    public static void main(String[] args) {
        check("binarySearch([-1, 0, 3, 5, 9, 12], 9)", binarySearch(new int[] {-1, 0, 3, 5, 9, 12}, 9), 4);
        check("binarySearch([-1, 0, 3, 5, 9, 12], 2)", binarySearch(new int[] {-1, 0, 3, 5, 9, 12}, 2), -1);
        check("binarySearch([], -1)", binarySearch(new int[] {}, -1), -1);
        check("binarySearch([7], 7)", binarySearch(new int[] {7}, 7), 0);
        check("binarySearch([-1, 0, 3, 5, 9, 12], 12)", binarySearch(new int[] {-1, 0, 3, 5, 9, 12}, 12), 5);
        check("binarySearch([-1, 0, 3, 5, 9, 12], -1)", binarySearch(new int[] {-1, 0, 3, 5, 9, 12}, -1), 0);
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

    private static int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
