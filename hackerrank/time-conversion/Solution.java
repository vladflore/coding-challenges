import java.io.*;
import java.util.*;

public class Solution {

    static String timeConversion(String s) {
        String[] parts = s.split(":");
        String hourConverted = "";
        int hour = Integer.parseInt(parts[0]);
        char[] amOderPmArr = parts[parts.length - 1].toCharArray();
        String amOderPm = amOderPmArr[amOderPmArr.length - 2] + "" + amOderPmArr[amOderPmArr.length - 1];
        if (amOderPm.equals("PM")) {
            hour += 12;
            if (hour == 24) {
                hourConverted = "12";
            } else {
                hourConverted = String.valueOf(hour);
            }
        } else {
            if (hour == 12) {
                hourConverted = "00";
            } else {
                hourConverted = String.valueOf(hour);
            }
        }
        return (hourConverted.length() == 1 ? "0" + hourConverted
                : hourConverted) + ":" + parts[1] + ":" + parts[2].substring(0, 2);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.println(result);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
