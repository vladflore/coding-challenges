import java.util.Arrays;

public class Kata {
    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int leftSum = Arrays.stream(arr, 0, i).sum();
            int rightSum = Arrays.stream(arr, i + 1, arr.length).sum();
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
