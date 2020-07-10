import java.io.*;

public class Solution {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        StringBuilder builder = new StringBuilder(s);
        if (builder.length() == 0) {
            return "Empty String";
        }
        int pos = 0;
        while (builder.length() > 1 && pos < builder.length() - 1) {
            if (builder.charAt(pos) == builder.charAt(pos + 1)) {
                builder.delete(pos, pos + 2);
                pos = 0;
            } else {
                pos++;
            }
        }
        if (builder.length() == 0) {
            return "Empty String";
        }

        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
