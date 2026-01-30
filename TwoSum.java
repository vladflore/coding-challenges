
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String... args) {
        test(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9));
        test(new int[]{1, 0}, twoSum(new int[]{2, 7, 11, 15}, 9));
        test(new int[]{1, 2}, twoSum(new int[]{3, 2, 4}, 6));
        test(new int[]{0, 1}, twoSum(new int[]{3, 4, 3}, 7));
        test(new int[]{1, 2}, twoSum(new int[]{3, 3, 4}, 7));
        test(new int[]{0, 1}, twoSum(new int[]{3, 3}, 6));
        test(new int[]{1, 2}, twoSum(new int[]{-1, -2, -3}, -5));
        test(new int[]{-1, -1}, twoSum(new int[]{0}, 0));
        test(new int[]{0, 1}, twoSum(new int[]{0, 0}, 0));
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

    private static void test(int[] expected, int[] actual) {
        var copyExpected = Arrays.copyOf(expected, expected.length);
        var copyActual = Arrays.copyOf(actual, actual.length);
        Arrays.sort(copyExpected);
        Arrays.sort(copyActual);
        if (!Arrays.equals(copyExpected, copyActual)) {
            throw new WrongAnswerException(
                    "Expected %s, got %s".formatted(Arrays.toString(expected), Arrays.toString(actual)));
        }
    }
}

class WrongAnswerException extends RuntimeException {

    public WrongAnswerException(String message) {
        super(message);
    }
}
