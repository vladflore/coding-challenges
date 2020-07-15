import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        long n = 600_851_475_143L;
        generatePrimeFactors(n).stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);
    }

    private static List<Integer> generatePrimeFactors(long n) {
        List<Integer> factors = new ArrayList<>();
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        for (int i = 3; i < Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            factors.add((int) n);
        }
        System.out.println(factors);
        return factors;
    }
}