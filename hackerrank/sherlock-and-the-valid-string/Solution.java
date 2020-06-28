import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    static String isValid(String s) {
        Map<Character, Long> frequencyMap = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Long> frequenciesList = new ArrayList<>(frequencyMap.values());
        long minFreq = frequenciesList.stream().mapToLong(Long::longValue).min().getAsLong();
        long maxFreq = frequenciesList.stream().mapToLong(Long::longValue).max().getAsLong();
        long countMinFreq = frequenciesList.stream().filter(l -> l == minFreq).count();
        long countMaxFreq = frequenciesList.stream().filter(l -> l == maxFreq).count();
        if (minFreq == maxFreq) {
            return "YES";
        }
        if (minFreq == 1 && countMaxFreq == frequenciesList.size() - 1) {
            return "YES";
        }
        if (maxFreq - minFreq == 1
                && (countMinFreq == frequenciesList.size() - 1 || countMaxFreq == frequenciesList.size() - 1)) {
            return "YES";
        }
        return "NO";
    }

    // aaaabbcc -> NO
    // 4 2 2
    // aabbcd -> NO
    // 2 2 1 1
    // aabbccddeefghi -> NO
    // 2 2 2 2 2 1 1 1 1
    // abcdefghhgfedecba -> YES
    // 2 2 2 2 3 2 2 2
    // aabbcd -> NO
    // 2 2 1 1
    // aaaaabbbbba -> YES
    // 5 5 1

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
