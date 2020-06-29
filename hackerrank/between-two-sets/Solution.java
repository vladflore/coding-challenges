import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int getTotalX(List<Integer> aList, List<Integer> bList) {
        int gcd = gcd(bList);
        int lcm = lcm(aList);
        int count = 0;
        int i = lcm;
        while (i <= gcd) {
            if (gcd % i == 0) {
                count++;
            }
            i = i + lcm;
        }
        return count;
    }

    private static int lcm(List<Integer> a) {
        int[] values = a.stream().mapToInt(Integer::intValue).toArray();
        int result = values[0];
        for (int i = 1; i < values.length; i++) {
            result = lcm(values[i], result);
        }
        return result;
    }

    private static int gcd(List<Integer> b) {
        int[] values = b.stream().mapToInt(Integer::intValue).toArray();
        int result = values[0];
        for (int i = 1; i < values.length; i++) {
            result = gcd(values[i], result);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
