import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {

        int start = 0, maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> freq = new HashMap<>();
        for (int end = 0; end < arr.length; end++) {
            freq.put(arr[end], freq.getOrDefault(arr[end], 0) + 1);
            while (freq.size() > 2) {
                freq.put(arr[start], freq.getOrDefault(arr[start], 0) - 1);
                if (freq.get(arr[start]) == 0) {
                    freq.remove(arr[start]);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
