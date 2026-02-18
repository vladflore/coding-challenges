import java.util.Arrays;

public class FizzBuzz {
  public static void main(String[] args) {
    System.out.println("%d -> %s".formatted(3, Arrays.toString(solve(3))));
    System.out.println("%d -> %s".formatted(5, Arrays.toString(solve(5))));
    System.out.println("%d -> %s".formatted(15, Arrays.toString(solve(15))));
  }

  private static String[] solve(int number) {
    String[] result = new String[number];

    for (int i = 1; i <= number; i++) {

      String current = "";

      if (i % 3 == 0) {
        current += "Fizz";
      }

      if (i % 5 == 0) {
        current += "Buzz";
      }

      if (current.isEmpty()) {
        current = String.valueOf(i);
      }

      result[i - 1] = current;
    }

    return result;
  }
}
