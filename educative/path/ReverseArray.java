import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        reverseArray(a);
        System.out.println(Arrays.equals(new int[] { 7, 6, 5, 4, 3, 2, 1 }, a));

        a = new int[] {};
        reverseArray(a);
        System.out.println(Arrays.equals(new int[] {}, a));

        a = new int[] { 6, 7 };
        reverseArray(a);
        System.out.println(Arrays.equals(new int[] { 7, 6 }, a));

        a = new int[] { 7 };
        reverseArray(a);
        System.out.println(Arrays.equals(new int[] { 7 }, a));
    }

    static void reverseArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
