import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[][] numsLists = {
                {},
                { 0, 1 },
                { 1, 2, 3 },
                { -1, 0, 3, 5, 9, 12 },
                { -100, -67, -55, -50, -49, -40, -33, -22, -10, -5 }
        };

        int[] targetList = { 12, 1, 3, 9, -22 };

        for (int i = 0; i < numsLists.length; i++) {
            int[] nums = numsLists[i];
            int target = targetList[i];
            int index = binarySearch(nums, target);
            System.out.println((i + 1) + ".\tArray to search: " + Arrays.toString(nums));
            System.out.println("\tTarget: " + target);
            if (index != -1) {
                System.out.println("\t" + target + " exists in the array at index " + index);
            } else {
                System.out.println("\t" + target + " does not exist in the array, so the return value is " + index);
            }
            System.out.println("-".repeat(100));
        }
    }

    private static int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }
}