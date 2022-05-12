import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer prevIndex = positions.put(nums[i], i);
            if (prevIndex != null && (i - prevIndex) <= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
        System.out.println(containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
        System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
    }
}