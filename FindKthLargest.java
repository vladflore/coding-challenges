import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class FindKthLargest {

  public static void main(String[] args) {
    check("solveWithMinHeap([3, 2, 1, 5, 6, 4], 2)", solveWithMinHeap(new int[] {3, 2, 1, 5, 6, 4}, 2), 5);
    check("solveWithMinHeap([3, 2, 3, 1, 2, 4, 5, 5, 6], 4)", solveWithMinHeap(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4), 4);
    check("solveWithMinHeap([1], 1)", solveWithMinHeap(new int[] {1}, 1), 1);
    check("solveWithMinHeap([2, 1], 1)", solveWithMinHeap(new int[] {2, 1}, 1), 2);
    check("solveWithSorting([3, 2, 1, 5, 6, 4], 2)", solveWithSorting(new int[] {3, 2, 1, 5, 6, 4}, 2), 5);
    check("solveWithSorting([3, 2, 3, 1, 2, 4, 5, 5, 6], 4)", solveWithSorting(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4), 4);
    check("solveWithSorting([1], 1)", solveWithSorting(new int[] {1}, 1), 1);
    check("solveWithSorting([2, 1], 1)", solveWithSorting(new int[] {2, 1}, 1), 2);
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

  private static int solveWithMinHeap(int[] nums, int k) {
    var minHeap = new PriorityQueue<Integer>();
    for (var num : nums) {
      minHeap.add(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return minHeap.peek();
  }

  private static int solveWithSorting(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }
}
