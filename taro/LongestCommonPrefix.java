public class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int charIndex = 0; charIndex < prefix.length(); charIndex++) {
            char character = prefix.charAt(charIndex);
            for (int strIndex = 1; strIndex < strs.length; strIndex++) {
                if (charIndex >= strs[strIndex].length() || strs[strIndex].charAt(charIndex) != character) {
                    return prefix.substring(0, charIndex);
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        System.out.println(s.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
    }

}
