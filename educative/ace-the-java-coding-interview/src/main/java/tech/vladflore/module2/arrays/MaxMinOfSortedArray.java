package tech.vladflore.module2.arrays;

import java.util.Arrays;

public class MaxMinOfSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Array before min/max: " + Arrays.toString(arr));
        maxMin(arr);
        System.out.println("Array after min/max: " + Arrays.toString(arr));

        System.out.println(Arrays.equals(arr, new int[]{6, 1, 5, 2, 4, 3}));
    }

    private static void maxMin(final int[] arr) {
        int[] result = new int[arr.length];
        int smallPointer = 0;
        int largePointer = arr.length - 1;
        boolean switchPointer = true;
        for (int i = 0; i < arr.length; i++) {
            if (switchPointer) {
                result[i] = arr[largePointer--];
            } else {
                result[i] = arr[smallPointer++];
            }
            switchPointer = !switchPointer;
        }
        System.arraycopy(result, 0, arr, 0, result.length);
    }

}
