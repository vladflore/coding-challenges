
import java.util.HashMap;

public class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                return new int[] { left, right };
            } else {
                if (currentSum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new int[] { -1, -1 };
    }

    public static int[] searchWithHashTable(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int pairValue = targetSum - arr[i];
            if (nums.containsKey(pairValue)) {
                return new int[] { nums.get(pairValue), i };
            } else {
                nums.put(arr[i], i);
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        int[] result1 = PairWithTargetSum.searchWithHashTable(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result1[0] + ", " + result1[1] + "]");
        result1 = PairWithTargetSum.searchWithHashTable(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result1[0] + ", " + result1[1] + "]");

    }
}
