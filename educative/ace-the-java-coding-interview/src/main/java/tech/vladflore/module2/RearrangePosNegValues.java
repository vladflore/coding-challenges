package tech.vladflore.module2;

import java.util.Arrays;

/**
 * Re-arrange the values in the array so that the negatives come before the positives.
 */
public class RearrangePosNegValues {

    public static void main(String[] args) {
        int[] arr = {-6, -5, -10};
        System.out.println("Array before re-arranging: " + Arrays.toString(arr));
        reArrange(arr);
        System.out.println("Array after rearranging: " + Arrays.toString(arr));
    }

    private static void reArrange(final int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != j) { // prevent swapping with itself
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

}
