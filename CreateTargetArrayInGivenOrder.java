
import java.util.*;

public class CreateTargetArrayInGivenOrder {

    public static void main(String[] args) {
        System.out.println(
                "Got %s, expected %s"
                        .formatted(
                                Arrays.toString(solve(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})),
                                Arrays.toString(new int[]{0, 4, 1, 3, 2})));
        System.out.println(
                "Got %s, expected %s"
                        .formatted(
                                Arrays.toString(solve(new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0})),
                                Arrays.toString(new int[]{0, 1, 2, 3, 4})));
        System.out.println(
                "Got %s, expected %s".formatted(Arrays.toString(solve(new int[]{1}, new int[]{0})), Arrays.toString(new int[]{1})));
    }

    private static int[] solve(int[] nums, int[] indices) {
        var temp = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            temp.add(indices[i], nums[i]);
        }

        return temp.stream().mapToInt(i -> i).toArray();
    }
}
