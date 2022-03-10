package tech.vladflore.educative.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithSameLettersAfterRepl {

    public static int findLength(String str, int k) {
        int start = 0;
        int maxLen = 0;
        int maxRepeat = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char right = str.charAt(end);
            freq.put(right, freq.getOrDefault(right, 0) + 1);
            maxRepeat = Math.max(maxRepeat, freq.get(right));

            if (end - start + 1 - maxRepeat > k) {
                char left = str.charAt(start);
                freq.put(left, freq.get(left) - 1);
                start++;
            } // else means there are less than k chars that can be replaced

            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubstrWithSameLettersAfterRepl.findLength("aabccbb", 2));
        System.out.println(LongestSubstrWithSameLettersAfterRepl.findLength("abbcb", 1));
        System.out.println(LongestSubstrWithSameLettersAfterRepl.findLength("abccde", 1));
    }
}
