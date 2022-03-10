package tech.vladflore.educative.sliding_window;

public class MinSizeSubarrayWithGreaterSum {

    private static int findMinSubArray(int targetSum, int[] arr) {

        int winStart = 0;
        int winSum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int winEnd = 0; winEnd < arr.length; winEnd++) {
            winSum += arr[winEnd];
            while (winSum >= targetSum) {
                minLen = Math.min(minLen, winEnd - winStart + 1);
                winSum -= arr[winStart];
                winStart++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int result = MinSizeSubarrayWithGreaterSum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubarrayWithGreaterSum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubarrayWithGreaterSum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
        System.out.println("Smallest subarray length: " + result);
    }

}