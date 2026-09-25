import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TwoSum {

    public static void main(String[] args) {
        check("twoSum([2, 7, 11, 15], 9)", sorted(twoSum(new int[] {2, 7, 11, 15}, 9)), new int[] {0, 1});
        check("twoSum([3, 2, 4], 6)", sorted(twoSum(new int[] {3, 2, 4}, 6)), new int[] {1, 2});
        check("twoSum([3, 4, 3], 7)", sorted(twoSum(new int[] {3, 4, 3}, 7)), new int[] {0, 1});
        check("twoSum([3, 3], 6)", sorted(twoSum(new int[] {3, 3}, 6)), new int[] {0, 1});
        check("twoSum([-1, -2, -3], -5)", sorted(twoSum(new int[] {-1, -2, -3}, -5)), new int[] {1, 2});
        check("twoSum([0, 0], 0)", sorted(twoSum(new int[] {0, 0}, 0)), new int[] {0, 1});
        check("twoSum([0], 0)", sorted(twoSum(new int[] {0}, 0)), new int[] {-1, -1});
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

    private static int[] sorted(int[] values) {
        int[] copy = values.clone();
        Arrays.sort(copy);
        return copy;
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                // order does not matter
                return new int[]{map.get(complement), i};
                // return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}

