public class LongestSubarrayWithOnesAfterRepl {

    public static int findLength(int[] arr, int k) {
        int start = 0, maxLen = 0, maxOnesCount = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 1) {
                maxOnesCount++;
            }
            if (end - start + 1 - maxOnesCount > k) {
                if (arr[start] == 1) {
                    maxOnesCount--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out
                .println(LongestSubarrayWithOnesAfterRepl.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(
                LongestSubarrayWithOnesAfterRepl.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));

    }

}
