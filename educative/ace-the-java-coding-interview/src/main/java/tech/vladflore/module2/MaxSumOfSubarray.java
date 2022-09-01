package tech.vladflore.module2;

import java.util.Arrays;

public class MaxSumOfSubarray {

    public static void main(String[] args) {
        int[] data = {1, 7, -2, -5, 10, -1};
        System.out.println("Array: " + Arrays.toString(data));
        System.out.println("Sum: " + findMaxSumSubArray(data));
    }

    private static int findMaxSumSubArray(final int[] arr) {
        int currMax = arr[0];
        int globalMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currMax < 0) {
                currMax = arr[i];
            } else {
                currMax += arr[i];
            }
            globalMax = Math.max(currMax, globalMax);
        }
        return globalMax;
    }
}
