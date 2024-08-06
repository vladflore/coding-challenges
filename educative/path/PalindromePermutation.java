import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PalindromePermutation {
    public static void main(String[] args) {
        List<String> strArray = Arrays.asList("baefeab", "abc", "xzz", "jjadd", "kllk");
        strArray.forEach(
            str -> System.out.format("%s -> %s\n", str, hasPermutationPalindrome(str))
        );

    }

    private static boolean hasPermutationPalindrome(String str) {
        var frequencyMap = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        var count = frequencyMap.keySet().stream().mapToLong(c -> frequencyMap.get(c)).filter(v -> v % 2 != 0).count();
        return count <= 1 ? true : false;
    }
}