import java.util.Arrays;
import java.util.Scanner;

public class Problem231A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int ans = 0;
        while (n-- > 0) {
            long count = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).filter(v -> v == 1)
                    .count();
            if (count > 1) {
                ans++;
            }
        }
        System.out.println(ans);
        scanner.close();
    }
}
