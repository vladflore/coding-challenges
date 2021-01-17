import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int[] max = new int[16];
        int idx = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                int sum = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (k == i + 1 && (l == j || l == j + 2)) {
                            continue;
                        }
                        sum += arr[k][l];
                    }
                }
                max[idx++] = sum;
            }
        }
        Arrays.sort(max);
        System.out.println(max[max.length - 1]);
        scanner.close();
    }
}
