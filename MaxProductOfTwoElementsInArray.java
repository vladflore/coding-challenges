
import java.util.Arrays;

public class MaxProductOfTwoElementsInArray {

    public static void main(String[] args) {
        var nums = new int[]{3, 4, 5, 2};
        System.out.println("%s -> %d".formatted(Arrays.toString(nums), solve(nums))); // 12

        nums = new int[]{1, 5, 4, 5};
        System.out.println("%s -> %d".formatted(Arrays.toString(nums), solve(nums))); // 16

        nums = new int[]{3, 7};
        System.out.println("%s -> %d".formatted(Arrays.toString(nums), solve(nums))); // 12

    }

    private static int solve(int[] nums) {
        int largest = 0, secondLargest = 0;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }

        return (largest - 1) * (secondLargest - 1);
    }
}
