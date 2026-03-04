import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {
  public static void main(String... args) {

    var nums = new int[] {3, 2, 1, 5, 6, 4};
    var k = 2;
    System.out.println(
        "nums = %s, k = %d, expected = %d, got = %d"
            .formatted(Arrays.toString(nums), k, 5, solveWithMinHeap(nums, k)));
    System.out.println(
        "nums = %s, k = %d, expected = %d, got = %d"
            .formatted(Arrays.toString(nums), k, 5, solveWithSorting(nums, k)));

    nums = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
    k = 4;
    System.out.println(
        "nums = %s, k = %d, expected = %d, got = %d"
            .formatted(Arrays.toString(nums), k, 4, solveWithMinHeap(nums, k)));
    System.out.println(
        "nums = %s, k = %d, expected = %d, got = %d"
            .formatted(Arrays.toString(nums), k, 4, solveWithSorting(nums, k)));
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
