import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long[] vals = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::valueOf).toArray();
        BigDecimal rounds = new BigDecimal(0);

        for (int i = 0; i < n - 1; i++) {
            if (vals[i] > vals[i + 1]) {
                long diff = vals[i] - vals[i + 1];
                rounds = rounds.add(new BigDecimal(diff));
                vals[i + 1] = diff + vals[i + 1];
                continue;
            }
        }

        System.out.println(rounds);
        scanner.close();
    }
}