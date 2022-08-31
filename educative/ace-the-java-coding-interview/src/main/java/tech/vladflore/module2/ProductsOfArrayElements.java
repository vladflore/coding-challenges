package tech.vladflore.module2;

import java.util.Arrays;

/**
 * In this problem, you have to implement the int[] findProduct(int[] arr) method which will modify arr in such a way
 * that in the output, each index i will contain the product of all elements present in arr except the element stored on
 * that index i.
 */
public class ProductsOfArrayElements {

    public static int[] findProduct(int[] arr) {
        int[] result = new int[arr.length];
        int temp = 1;
        // result[i] contains the product of the elements to the left of i in arr
        for (int i = 0; i < arr.length; i++) {
            result[i] = temp;
            temp *= arr[i];
        }

        temp = 1;
        // result[i] contains the product of the elements to the left of i, from before, with the product of the
        // elements to the right of i in arr
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        System.out.println("Array before product: " + Arrays.toString(arr));

        int[] prodArray = findProduct(arr);

        System.out.println("Array after product: " + Arrays.toString(prodArray));
    }

}
