import java.math.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();
        BigInteger bigInteger = new BigInteger(n);
        System.out.println(bigInteger.isProbablePrime(1) ? "prime" : "not prime");
        scanner.close();
    }
}
