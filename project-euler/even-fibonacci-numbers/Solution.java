import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        BigDecimal upperLimit = new BigDecimal(4000000);

        BigInteger secondLast = BigInteger.ZERO;
        BigInteger last = BigInteger.ONE;
        BigInteger next = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;

        while (next.longValue() <= upperLimit.longValue()) {
            next = last.add(secondLast);
            if (next.longValue() % 2 == 0) {
                sum = sum.add(next);
            }
            secondLast = last;
            last = next;
        }

        System.out.println(sum.longValue());
    }
}