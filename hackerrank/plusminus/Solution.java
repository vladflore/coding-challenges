package practice.hackerrank.plusminus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int pos = 0, neg = 0, zero = 0;
        for (Integer element : arr) {
            if (element == 0) {
                zero++;
            } else if (element > 0) {
                pos++;
            } else {
                neg++;
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.######");
        System.out.println(decimalFormat.format(1.0 * pos / arr.size()));
        System.out.println(decimalFormat.format(1.0 * neg / arr.size()));
        System.out.println(decimalFormat.format(1.0 * zero / arr.size()));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
