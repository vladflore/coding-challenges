import java.util.*;

public class Solution {

    private static Scanner scanner;
    private static int B;
    private static int H;
    private static boolean flag;

    static {
        scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
        if (B <= 0 || H <= 0) {
            flag = false;
            try {
                throw new Exception("Breadth and height must be positive");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            flag = true;
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}
