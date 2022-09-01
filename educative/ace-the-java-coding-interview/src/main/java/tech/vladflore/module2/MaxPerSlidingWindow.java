package tech.vladflore.module2;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxPerSlidingWindow {

    public static void main(String[] args) {
        int[] windowSizes = {1, 3, 2, 1, 2};
        int[][] numsList = {
            {7},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
            {4, 5, 6, 1, 2, 3}, {9, 5, 3, 1, 6, 3}
        };
        for (int i = 0; i < windowSizes.length; i++) {
            System.out.println("%d. Original list: %s".formatted(i + 1, Arrays.toString(numsList[i])));
            System.out.println("    Window size: %d".formatted(windowSizes[i]));
            System.out.println("    Max: %s".formatted(Arrays.toString(maxSlidingWindow(numsList[i], windowSizes[i]))));
        }
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            throw new IllegalArgumentException();
        }
        final var result = new int[nums.length - k + 1];
        final var indicesQueue = new ArrayDeque<Integer>();
        int left = 0;
        int resIdx = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!indicesQueue.isEmpty() && nums[indicesQueue.getLast()] < nums[right]) {
                indicesQueue.pollLast();
            }
            indicesQueue.addLast(right);
            if (left > indicesQueue.getFirst()) {
                indicesQueue.pollFirst();
            }
            if (right + 1 >= k) {
                result[resIdx++] = nums[indicesQueue.getFirst()];
                left++;
            }
        }
        return result;
    }
}
