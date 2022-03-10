package tech.vladflore.educative.two_pointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 3) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(arr);
        int right = arr.length - 1;
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            while (left < right) {
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0) {
                    return targetSum;
                }

                if (Math.abs(targetDiff) < Math.abs(smallestDiff) ||
                    Math.abs(targetDiff) == Math.abs(smallestDiff) && targetDiff > smallestDiff) {
                    smallestDiff = targetDiff;
                }

                if (targetDiff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return targetSum - smallestDiff;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{0, -2, 1, 2}, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }

}
