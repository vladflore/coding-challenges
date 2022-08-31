package tech.vladflore.module2;

import java.util.Arrays;
import java.util.TreeSet;

public class SecondMaximumValue {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 5, 5, 5, 6};
        System.out.println("Array: " + Arrays.toString(arr));

        int secMax = findSecondMaximum1(arr);
        System.out.println("Second maximum: " + secMax);

        secMax = findSecondMaximum2(arr);
        System.out.println("Second maximum: " + secMax);

        secMax = findSecondMaximum3(arr);
        System.out.println("Second maximum: " + secMax);
    }

    private static int findSecondMaximum1(final int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        // find the max element
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }
        // find the second max element, i.e. that element greater than all the elements except max
        for (int element : arr) {
            if (element > secondMax && element != max) {
                secondMax = element;
            }
        }
        return secondMax;
    }

    private static int findSecondMaximum2(final int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int element : arr) {
            if (element > max) {
                secondMax = max;
                max = element;
            } else if (element > secondMax && element != max) {
                secondMax = element;
            }
        }
        return secondMax;
    }

    private static int findSecondMaximum3(final int[] arr) {
        final var ints = new TreeSet<>(Arrays.stream(arr).boxed().toList());
        final var max = ints.last();
        final var result = ints.lower(max);
        if (result != null) {
            return result;
        }
        return Integer.MIN_VALUE;
    }
}
