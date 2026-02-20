
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HasPalindromePermutation {

    public static void main(String[] args) {

        System.out.println("%s - expected: %s, actual: %s".formatted("code", false, solve("code")));
        System.out.println("%s - expected: %s, actual: %s".formatted("aab", true, solve("aab")));
        System.out.println("%s - expected: %s, actual: %s".formatted("carerac", true, solve("carerac")));

    }

    private static boolean solve(String string) {
        Map<Character, Integer> freq = string
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
        int oddCount = 0;
        for (int count : freq.values()) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}
