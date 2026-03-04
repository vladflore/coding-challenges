import java.util.Arrays;

public class BestTimeBuySellTwo {
  public static void main(String... args) {

    int[] prices = new int[] {7, 1, 5, 3, 6, 4};
    System.out.println(
        "%s - expected: %d - got: %d".formatted(Arrays.toString(prices), 7, solve(prices)));

    prices = new int[] {1, 2, 3, 4, 5};
    System.out.println(
        "%s - expected: %d - got: %d".formatted(Arrays.toString(prices), 4, solve(prices)));

    prices = new int[] {7, 6, 4, 3, 1};
    System.out.println(
        "%s - expected: %d - got: %d".formatted(Arrays.toString(prices), 0, solve(prices)));
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
