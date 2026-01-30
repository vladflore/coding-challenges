public class PerfectSquares {
  public static void main(String[] args) {
    test(3, perfectSquares(12));
    test(2, perfectSquares(13));
    test(0, perfectSquares(0));
    test(1, perfectSquares(1));
    test(1, perfectSquares(4));
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

  private static void test(int expected, int actual) {
    if (expected != actual) {
      throw new WrongAnswerException("Expected %d, got %d".formatted(expected, actual));
    }
  }
}

class WrongAnswerException extends RuntimeException {
  public WrongAnswerException(String message) {
    super(message);
  }
}
