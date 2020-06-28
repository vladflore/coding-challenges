import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        double k = Math.floor(Math.log(n) / Math.log(5));
        int zeros = 0;
        for (int i = 1; i <= k; i++) {
            zeros += Math.floor(n / Math.pow(5, i));
        }
        System.out.println(zeros);
        scanner.close();
    }
}