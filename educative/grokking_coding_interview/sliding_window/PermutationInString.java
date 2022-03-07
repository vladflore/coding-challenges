import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    private static boolean findPermutation(String str, String pattern) {
        int start = 0, matched = 0;
        Map<Character, Integer> patternFreq = new HashMap<>();
        for (Character c : pattern.toCharArray()) {
            patternFreq.put(c, patternFreq.getOrDefault(c, 0) + 1);
        }

        for (int end = 0; end < str.length(); end++) {
            char right = str.charAt(end);
            if (patternFreq.containsKey(right)) {
                patternFreq.put(right, patternFreq.get(right) - 1);
                if (patternFreq.get(right) == 0) {
                    matched++;
                }
            }
            if (matched == patternFreq.size()) {
                return true;
            }
            if (end >= pattern.length() - 1) {
                char left = str.charAt(start++);
                if (patternFreq.containsKey(left)) {
                    if (patternFreq.get(left) == 0) {
                        matched--;
                    }
                    patternFreq.put(left, patternFreq.get(left) + 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(PermutationInString.findPermutation("oidbcaf", "abc"));
        System.out.println(PermutationInString.findPermutation("odicf", "dc"));
        System.out.println(PermutationInString.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println(PermutationInString.findPermutation("aaacb", "abc"));
    }

}
