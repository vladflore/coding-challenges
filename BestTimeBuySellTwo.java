import java.util.Arrays;
import java.util.Objects;

public class BestTimeBuySellTwo {

  public static void main(String[] args) {
    check("solve([7, 1, 5, 3, 6, 4])", solve(new int[] {7, 1, 5, 3, 6, 4}), 7);
    check("solve([1, 2, 3, 4, 5])", solve(new int[] {1, 2, 3, 4, 5}), 4);
    check("solve([7, 6, 4, 3, 1])", solve(new int[] {7, 6, 4, 3, 1}), 0);
    check("solve([])", solve(new int[] {}), 0);
    check("solve([5])", solve(new int[] {5}), 0);
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

  private static int solve(int[] prices) {
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }

    return profit;
  }
}
