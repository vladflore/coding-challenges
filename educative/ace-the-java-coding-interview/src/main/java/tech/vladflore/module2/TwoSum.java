package tech.vladflore.module2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Find two numbers in the given array that sum up to the given target.
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{2, 4, 5, 7, 8}, 9));
        System.out.println(solve(new int[]{}, 0));
        System.out.println(solve(new int[]{2, 4, 5, 7, 8}, 100));

        System.out.println(solve1(new int[]{7, 8, 4, 2, 5}, 9));
        System.out.println(solve1(new int[]{}, 0));
        System.out.println(solve1(new int[]{2, 4, 5, 7, 8}, 100));
    }

    private static TwoNumbers solve(int[] array, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int j : array) {
            int delta = target - j;
            if (seen.contains(delta)) {
                return new TwoNumbers(j, delta);
            }
            seen.add(j);
        }
        return new TwoNumbers(-1, -1);
    }

    private static TwoNumbers solve1(int[] array, int target) {
        Arrays.sort(array);
        int p1 = 0, p2 = array.length - 1;
        if (p2 > 0) {
            while (p1 != p2) {
                int currentSum = array[p1] + array[p2];
                if (currentSum == target) {
                    return new TwoNumbers(array[p1], array[p2]);
                } else if (currentSum < target) {
                    p1++;
                } else {
                    p2--;
                }
            }
        }
        return new TwoNumbers(-1, -1);
    }
}

record TwoNumbers(int a, int b) {
}
