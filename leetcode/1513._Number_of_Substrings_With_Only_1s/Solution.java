import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public int numSub(String s) {
        long count = 0;
        long j = 0;
        for (long i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt((int) i) == '0') {
                count = (count + (i - j) * (i - j + 1) / 2);
                j = i + 1;
            }
        }
        return (int) (count % 1_000_000_007);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution.numSub(scanner.nextLine()));
        scanner.close();
    }
}