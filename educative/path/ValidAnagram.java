import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidAnagram {
    public static void main(String[] args) {
        String[] str1List = { "listen", "race", "elbow", "cat", "inch" };
        String[] str2List = { "silent", "cares", "below", "act", "chin" };

        for (int i = 0; i < str1List.length; i++) {
            var validAnagram = isValidAnagram(str1List[i], str2List[i]);
            System.out.format("%s %s %s\n", str1List[i],
                    validAnagram ? "is valid anagram of" : "is not valid anagram of", str2List[i]);
        }
    }

    static boolean isValidAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Long> freq = str1.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Character c : str2.toCharArray()) {
            if (!freq.containsKey(c)) {
                return false;
            }
            freq.computeIfPresent(c, (k, v) -> v - 1);
        }

        long max = freq.values().stream().max(Long::compare).orElse(0L);

        return max == 0;
    }
}