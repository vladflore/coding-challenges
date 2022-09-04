package tech.vladflore.module2.hashtables;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraySubsetOfAnother {
    public static void main(String[] args) {
        System.out.println(isSubset(new int[]{9, 4, 7, 1, -2, 6, 5}, new int[]{7, 1, -2}));
    }

    public static boolean isSubset(int[] arr1, int[] arr2) {
        // arr2 subset of arr1
        Set<Integer> arr1Elements = IntStream.of(arr1).boxed().collect(Collectors.toSet());
        Optional<Integer> any = Arrays.stream(arr2).boxed().filter(el -> !arr1Elements.contains(el)).findAny();
        return any.isEmpty();
    }
}
