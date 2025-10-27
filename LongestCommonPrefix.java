import java.util.Arrays;

public class LongestCommonPrefix {

  public static String longestCommonPrefix(String[] strs) {
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
    var strings = new String[] {"flower", "flow", "flight"};
    System.out.println(
        "Longest common prefix of %s is %s"
            .formatted(Arrays.toString(strings), longestCommonPrefix(strings)));

    strings = new String[] {"dog", "racecar", "car"};
    System.out.println(
        "Longest common prefix of %s is %s"
            .formatted(Arrays.toString(strings), longestCommonPrefix(strings)));

    strings = new String[] {"abcd", "abcde", "abcdef"};
    System.out.println(
        "Longest common prefix of %s is %s"
            .formatted(Arrays.toString(strings), longestCommonPrefix(strings)));
  }
}
