
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
            {-1, 0, 3, 5, 9, 12},
            {-1, 0, 3, 5, 9, 12},
            {},
            {7},
            {-1, 0, 3, 5, 9, 12},
            {-1, 0, 3, 5, 9, 12}
        };
        int[] targets = new int[]{9, 2, -1, 7, 12, -1};
        int[] expected_results = new int[]{4, -1, -1, 0, 5, 0};

        for (int i = 0; i < nums.length; i++) {
            int result = binarySearch(nums[i], targets[i]);
            if (result != expected_results[i]) {
                var message = """
                Expected position: %d, got: %d
                Searching for: %d, in array: %s""".formatted(expected_results[i], result, targets[i], Arrays.toString(nums[i]));
                throw new RuntimeException(message);
            }
        }

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
