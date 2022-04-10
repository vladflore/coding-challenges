import java.util.Arrays;

public class ProductArray {

    public static int[] findProduct(int arr[]) {
        int result[] = new int[arr.length];
        int temp = 1;
        for (int i = 0; i < arr.length; i++) {
            // System.out.printf("i=%d, temp=%d, result=%s\n", i, temp,
            // Arrays.toString(result));
            result[i] = temp;
            temp *= arr[i];
        }
        // System.out.printf("temp=%d, result=%s\n", temp, Arrays.toString(result));
        temp = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            // System.out.printf("i=%d, temp=%d, result=%s\n", i, temp,
            // Arrays.toString(result));
            result[i] *= temp;
            temp *= arr[i];
        }
        // System.out.printf("temp=%d, result=%s\n", temp, Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        System.out.println("Array before product: " + Arrays.toString(arr));

        int[] prodArray = findProduct(arr);

        System.out.println("Array after product: " + Arrays.toString(prodArray));
    }

}
