package grokking_coding_interview.sliding_window_pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithDistinctChars {

    public static int findLength(String str) {

        int winStart = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            char rCh = str.charAt(winEnd);

            if (map.containsKey(rCh)) {
                winStart = Math.max(winStart, map.get(rCh) + 1);
            }

            map.put(rCh, winEnd);
            maxLen = Math.max(maxLen, winEnd - winStart + 1);
        }

        return maxLen;
    }

    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int start = 0, end = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (end < str.length()) {
            char c = str.charAt(end);
            while (set.contains(c)) {
                set.remove(str.charAt(start));
                start++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out
                .println("Length of the longest substring: " + LongestSubstringWithDistinctChars.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + LongestSubstringWithDistinctChars.findLength("abbbb"));
        System.out
                .println("Length of the longest substring: " + LongestSubstringWithDistinctChars.findLength("abccde"));

        System.out
                .println("Length of the longest substring: "
                        + LongestSubstringWithDistinctChars.lengthOfLongestSubstring("aabccbb"));
        System.out.println("Length of the longest substring: "
                + LongestSubstringWithDistinctChars.lengthOfLongestSubstring("abbbb"));
        System.out
                .println("Length of the longest substring: "
                        + LongestSubstringWithDistinctChars.lengthOfLongestSubstring("abccde"));

    }
}
