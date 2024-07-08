
import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String args[]) {
        var a = new int[] { 0, 1, 2, 0, 3, 4, 0 };
        moveToEnd(a);
        System.out.println(Arrays.equals(new int[] { 1, 2, 3, 4, 0, 0, 0 }, a));
        a = new int[] { 1, 2, 3, 0 };
        moveToEnd(a);
        System.out.println(Arrays.equals(new int[] { 1, 2, 3, 0 }, a));
        a = new int[] { 1, 0, 2, 0 };
        moveToEnd(a);
        System.out.println(Arrays.equals(new int[] { 1, 2, 0, 0 }, a));
        a = new int[] {};
        moveToEnd(a);
        System.out.println(Arrays.equals(new int[] {}, a));

    }

    static void moveToEnd(int[] arr) {
        var j = 0;
        for (var i = 0; i < arr.length; i++) {
            System.out.print("i=" + i);
            if (arr[i] != 0) {
                var tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j++;
            }
            System.out.print(" j=" + j);
            System.out.println(" " + Arrays.toString(arr));
        }
    }
}
