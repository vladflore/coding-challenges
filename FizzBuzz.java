import java.util.Arrays;
import java.util.Objects;

public class FizzBuzz {

  public static void main(String[] args) {
    check("solve(1)", solve(1), new String[] {"1"});
    check("solve(3)", solve(3), new String[] {"1", "2", "Fizz"});
    check("solve(5)", solve(5), new String[] {"1", "2", "Fizz", "4", "Buzz"});
    check("solve(15)", solve(15), new String[] {"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"});
    System.out.println(passed + "/" + total + " passed");
  }

  private static int passed = 0, total = 0;

  private static void check(String label, Object actual, Object expected) {
    total++;
    boolean ok = Objects.deepEquals(actual, expected);
    if (ok) {
      passed++;
    }
    System.out.println(
        (ok ? "PASS  " : "FAIL  ") + label + (ok ? "" : "  -> expected " + show(expected) + ", got " + show(actual)));
  }

  private static String show(Object value) {
    String text = Arrays.deepToString(new Object[] {value});
    return text.substring(1, text.length() - 1);
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
