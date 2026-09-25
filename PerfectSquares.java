import java.util.Arrays;
import java.util.Objects;

public class PerfectSquares {

  public static void main(String[] args) {
    check("perfectSquares(12)", perfectSquares(12), 3);
    check("perfectSquares(13)", perfectSquares(13), 2);
    check("perfectSquares(0)", perfectSquares(0), 0);
    check("perfectSquares(1)", perfectSquares(1), 1);
    check("perfectSquares(4)", perfectSquares(4), 1);
    check("perfectSquares(7)", perfectSquares(7), 4);
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

  private static int perfectSquares(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j * j <= i; j++) {
        int square = j * j;
        dp[i] = Math.min(dp[i], dp[i - square] + 1);
      }
    }
    return dp[n];
  }

}

