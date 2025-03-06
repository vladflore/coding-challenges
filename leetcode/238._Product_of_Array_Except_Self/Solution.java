import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] answer = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        for (int i = 0; i < len; i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        var result = Arrays.equals(s.productExceptSelf(new int[] { 1, 2, 3, 4 }), new int[] { 24, 12, 8, 6 }); // true
        System.out.println(result ? "correct" : "wrong");

        result = Arrays.equals(s.productExceptSelf(new int[] { -1, 1, 0, -3, 3 }), new int[] { 0, 0, 9, 0, 0 }); // true
        System.out.println(result ? "correct" : "wrong");

    }
}
