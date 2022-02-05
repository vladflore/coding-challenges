package practice.hackerrank.timeconversion;

import java.io.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String result = s;
        if (result.contains("AM")) {
            result = result.replace("AM", "");
            if (result.startsWith("12")) {
                result = result.replaceFirst("12", "00");
            }
        } else {
            result = result.replace("PM", "");
            if (!result.startsWith("12")) {
                String substring = result.substring(0, result.indexOf(":"));
                int x = Integer.parseInt(substring);
                x += 12;
                result = result.replaceFirst(substring, String.valueOf(x));
            }
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
