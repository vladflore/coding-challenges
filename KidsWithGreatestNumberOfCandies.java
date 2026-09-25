import java.util.Arrays;
import java.util.Objects;

public class KidsWithGreatestNumberOfCandies {

  public static void main(String[] args) {
    check("solve([2, 3, 5, 1, 3], 3)", solve(new int[] {2, 3, 5, 1, 3}, 3), new boolean[] {true, true, true, false, true});
    check("solve([4, 2, 1, 1, 2], 1)", solve(new int[] {4, 2, 1, 1, 2}, 1), new boolean[] {true, false, false, false, false});
    check("solve([12, 1, 12], 10)", solve(new int[] {12, 1, 12}, 10), new boolean[] {true, false, true});
    check("solve([1], 0)", solve(new int[] {1}, 0), new boolean[] {true});
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

  private static boolean[] solve(int[] candies, int extraCandies) {

    int maxCandies = 0;
    for (int candy : candies) {
      if (candy > maxCandies) {
        maxCandies = candy;
      }
    }

    boolean[] result = new boolean[candies.length];

    for (int i = 0; i < candies.length; i++) {
      if (candies[i] + extraCandies >= maxCandies) {
        result[i] = true;
      } else {
        result[i] = false;
      }
    }

    return result;
  }
}
