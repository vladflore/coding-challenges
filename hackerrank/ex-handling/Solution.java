import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String x = scanner.nextLine();
            String y = scanner.nextLine();

            try {
                int xInt = Integer.parseInt(x);
                int yInt = Integer.parseInt(y);
                System.out.println(xInt / yInt);
            } catch (NumberFormatException e) {
                System.out.println(new InputMismatchException());
            } catch (ArithmeticException e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
