
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMaxKDistinctChars {

    private static int findLength(String str, int k) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
        int winStart = 0, maxLen = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            Character rCh = str.charAt(winEnd);
            freq.put(rCh, freq.getOrDefault(rCh, 0) + 1);
            while (freq.size() > k) {
                Character lCh = str.charAt(winStart);
                freq.put(lCh, freq.getOrDefault(lCh, 0) - 1);
                if (freq.get(lCh) == 0) {
                    freq.remove(lCh);
                }
                winStart++;
            }
            maxLen = Math.max(maxLen, winEnd - winStart + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(
                "Length of the longest substring: " + LongestSubstringWithMaxKDistinctChars.findLength("araaci", 2));
        System.out.println(
                "Length of the longest substring: " + LongestSubstringWithMaxKDistinctChars.findLength("araaci", 1));
        System.out.println(
                "Length of the longest substring: " + LongestSubstringWithMaxKDistinctChars.findLength("cbbebi", 3));
    }
}
