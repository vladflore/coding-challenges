import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        check("solve([1, 1, 1, 2, 2, 3], 2)", sorted(solve(new int[] {1, 1, 1, 2, 2, 3}, 2)), new int[] {1, 2});
        check("solve([1], 1)", sorted(solve(new int[] {1}, 1)), new int[] {1});
        check("solve([1, 2, 1, 2, 1, 2, 3, 1, 3, 2], 2)", sorted(solve(new int[] {1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2)), new int[] {1, 2});
        check("solve([4, 4, 5, 5, 5, 6], 1)", sorted(solve(new int[] {4, 4, 5, 5, 5, 6}, 1)), new int[] {5});
        check("solveWithMinHeap([1, 1, 1, 2, 2, 3], 2)", sorted(solveWithMinHeap(new int[] {1, 1, 1, 2, 2, 3}, 2)), new int[] {1, 2});
        check("solveWithMinHeap([1], 1)", sorted(solveWithMinHeap(new int[] {1}, 1)), new int[] {1});
        check("solveWithMinHeap([1, 2, 1, 2, 1, 2, 3, 1, 3, 2], 2)", sorted(solveWithMinHeap(new int[] {1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2)), new int[] {1, 2});
        check("solveWithMinHeap([4, 4, 5, 5, 5, 6], 1)", sorted(solveWithMinHeap(new int[] {4, 4, 5, 5, 5, 6}, 1)), new int[] {5});
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

    private static int[] sorted(int[] values) {
        int[] copy = values.clone();
        Arrays.sort(copy);
        return copy;
    }

    private static int[] solve(int[] nums, int k) {

        // Map<Integer, Integer> freqMap = Arrays.stream(nums)
        //         .mapToObj(i -> i)
        //         .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i -> 1)));
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] freqBuckets = (List<Integer>[]) new List[nums.length + 1];

        for (int number : freqMap.keySet()) {
            int freq = freqMap.get(number);
            if (freqBuckets[freq] == null) {
                freqBuckets[freq] = new ArrayList<>();
            }
            freqBuckets[freq].add(number);
        }

        List<Integer> result = new ArrayList<>();
        for (int frequency = freqBuckets.length - 1; frequency >= 1 && result.size() < k; frequency--) {
            var elements = freqBuckets[frequency];
            if (elements != null) {
                result.addAll(elements);
            }
        }

        // return result.stream().mapToInt(Integer::intValue).toArray();
        int[] toReturn = new int[k];
        for (int i = 0; i < k; i++) {
            toReturn[i] = result.get(i);
        }
        return toReturn;
    }

    private static int[] solveWithMinHeap(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));
        for (int number : freqMap.keySet()) {
            minHeap.offer(number);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

}
