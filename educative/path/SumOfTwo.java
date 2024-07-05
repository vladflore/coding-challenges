import java.util.Arrays;

public class SumOfTwo {
    public static void main(String[] args) {
        System.out.println(findSumOfTwo(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 9));
        System.out.println(findSumOfTwo(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 100));
        System.out.println(findSumOfTwo(new int[] { 1, 2, 3, 4, 5, 6, 7 }, -9));
    }

    static boolean findSumOfTwo(int[] arr, int target) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            var current = arr[low] + arr[high];
            if (current == target) {
                return true;
            }
            if (current < target) {
                low++;
            }
            if (current > target) {
                high--;
            }
        }
        return false;
    }

}
