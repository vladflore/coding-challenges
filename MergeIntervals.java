import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  public static void main(String... args) {

    var intervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    System.out.println("merged %s is: %s".formatted(print(intervals), print(merge(intervals))));

    intervals = new int[][] {{1, 4}, {4, 5}};
    System.out.println("merged %s is: %s".formatted(print(intervals), print(merge(intervals))));

    intervals = new int[][] {{5, 8}, {3, 6}, {1, 4}};
    System.out.println("merged %s is: %s".formatted(print(intervals), print(merge(intervals))));
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

  private static String print(int[][] intervals) {
    var sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < intervals.length; i++) {
      sb.append(Arrays.toString(intervals[i]));
      if (i < intervals.length - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
