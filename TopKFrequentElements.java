
import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        var nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        var expected = new int[]{1, 2};
        System.out.println(
                "nums=%s, k=%d, expected=%s, got=%s, got=%s"
                        .formatted(
                                Arrays.toString(nums),
                                k,
                                Arrays.toString(expected),
                                Arrays.toString(solve(nums, k)),
                                Arrays.toString(solveWithMinHeap(nums, k))
                        )
        );

        nums = new int[]{1};
        k = 1;
        expected = new int[]{1};
        System.out.println(
                "nums=%s, k=%d, expected=%s, got=%s, got=%s"
                        .formatted(
                                Arrays.toString(nums),
                                k,
                                Arrays.toString(expected),
                                Arrays.toString(solve(nums, k)),
                                Arrays.toString(solveWithMinHeap(nums, k))
                        )
        );

        nums = new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        k = 2;
        expected = new int[]{1, 2};
        System.out.println(
                "nums=%s, k=%d, expected=%s, got=%s, got=%s"
                        .formatted(
                                Arrays.toString(nums),
                                k,
                                Arrays.toString(expected),
                                Arrays.toString(solve(nums, k)),
                                Arrays.toString(solveWithMinHeap(nums, k))
                        )
        );
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
