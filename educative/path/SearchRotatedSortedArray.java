
import java.util.Arrays;
import java.util.List;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        List<List<Integer>> numList;
        numList = Arrays.asList(
                Arrays.asList(5, 6, 7, 1, 2, 3, 4),
                Arrays.asList(40, 50, 60, 10, 20, 30),
                Arrays.asList(47, 58, 69, 72, 83, 94, 12, 24, 35),
                Arrays.asList(77, 82, 99, 105, 5, 13, 28, 41, 56, 63),
                Arrays.asList(48, 52, 57, 62, 68, 72, 5, 7, 12, 17, 21, 28, 33, 37, 41)
        );

        List<Integer> targetList = Arrays.asList(1, 50, 12, 56, 5);

        for (int i = 0; i < targetList.size(); i++) {
            System.out.println((i + 1) + ".\tSorted array: " + numList.get(i)
                    + "\n\ttarget " + targetList.get(i)
                    + " found at index " + binarySearchRotated(numList.get(i), targetList.get(i)));
            System.out.println("-".repeat(100));
        }
    }

    private static int binarySearchRotated(List<Integer> nums, Integer target) {
        int start = 0;
        int end = nums.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // TODO continue
        }

        return -1;
    }
}
