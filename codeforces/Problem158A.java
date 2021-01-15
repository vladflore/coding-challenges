import java.util.Arrays;
import java.util.Scanner;

public class Problem158A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        int[] scores = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int kthScore = scores[--k];
        int ans = k;
        if (kthScore == 0) {
            int i = 0;
            while (k >= 0 && scores[k] == kthScore) {
                i++;
                k--;
            }
            System.out.println(ans + 1 - i);
        } else {
            int i = 0;
            while (k < n && scores[k] == kthScore) {
                i++;
                k++;
            }
            System.out.println(ans + i);
        }
        scanner.close();
    }
}
