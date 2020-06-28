import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int sumAll = IntStream.iterate(1, i -> i + 1).limit(n).sum();
        int sumGiven = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::valueOf).sum();
        System.out.println(sumAll - sumGiven);
        s.close();
    }
}