import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MergeIntervals {

  public static void main(String[] args) {
    check("merge([[1, 3], [2, 6], [8, 10], [15, 18]])", merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}}), new int[][] {{1, 6}, {8, 10}, {15, 18}});
    check("merge([[1, 4], [4, 5]])", merge(new int[][] {{1, 4}, {4, 5}}), new int[][] {{1, 5}});
    check("merge([[5, 8], [3, 6], [1, 4]])", merge(new int[][] {{5, 8}, {3, 6}, {1, 4}}), new int[][] {{1, 8}});
    check("merge([[1, 4], [2, 3]])", merge(new int[][] {{1, 4}, {2, 3}}), new int[][] {{1, 4}});
    check("merge([[1, 4]])", merge(new int[][] {{1, 4}}), new int[][] {{1, 4}});
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

  private static int[][] merge(int[][] intervals) {

    if (intervals == null || intervals.length <= 1) {
      return intervals;
    }

    Arrays.sort(intervals, (int1, int2) -> int1[0] - int2[0]);

    List<int[]> merged = new ArrayList<>();

    int[] currentInterval = intervals[0];
    merged.add(currentInterval);

    for (int i = 1; i < intervals.length; i++) {
      int[] nextInterval = intervals[i];

      int currStart = currentInterval[0];
      int currEnd = currentInterval[1];
      int nextStart = nextInterval[0];
      int nextEnd = nextInterval[1];

      if (nextStart <= currEnd) {
        currentInterval[1] = Math.max(currEnd, nextEnd);
      } else {
        currentInterval = nextInterval;
        merged.add(currentInterval);
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }

}
