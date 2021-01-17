import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if (s.trim().length() == 0) {
            System.out.println(0);
        } else {
            String[] tokens = s.trim().split("[\\s!,?._'@]+");
            System.out.println(tokens.length);
            for (String token : tokens) {
                System.out.println(token);
            }
        }

        scan.close();
    }
}
