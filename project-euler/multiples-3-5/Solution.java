import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        int sum = IntStream.range(1, 1000).filter(val -> val % 3 == 0 || val % 5 == 0).sum();
        System.out.println(sum);
    }
}