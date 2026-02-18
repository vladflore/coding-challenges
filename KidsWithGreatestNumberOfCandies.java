import java.util.Arrays;

public class KidsWithGreatesNumberOfCandies {
  public static void main(String[] args) {

    var result = solve(new int[] {2, 3, 5, 1, 3}, 3);
    var expected = new boolean[] {true, true, true, false, true};
    System.out.println(
        "Got %s, expected %s".formatted(Arrays.toString(result), Arrays.toString(expected)));

    result = solve(new int[] {4, 2, 1, 1, 2}, 1);
    expected = new boolean[] {true, false, false, false, false};
    System.out.println(
        "Got %s, expected %s".formatted(Arrays.toString(result), Arrays.toString(expected)));

    result = solve(new int[] {12, 1, 12}, 10);
    expected = new boolean[] {true, false, true};
    System.out.println(
        "Got %s, expected %s".formatted(Arrays.toString(result), Arrays.toString(expected)));
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
