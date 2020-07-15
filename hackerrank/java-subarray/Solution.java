import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(val -> Integer.parseInt(val)).toArray();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = Arrays.stream(array).skip(i).limit(j - i + 1).sum();
                if (sum < 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }
}