import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        String regex = "<(.+)>([^<]+)</\\1>";

        while (testCases > 0) {
            String line = in.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            boolean found = false;

            while (matcher.find()) {
                found = true;
                System.out.println(matcher.group(2));
            }

            if (!found) {
                System.out.println("None");
            }

            testCases--;
        }

        in.close();
    }
}
