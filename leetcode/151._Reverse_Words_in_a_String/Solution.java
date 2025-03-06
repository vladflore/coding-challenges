
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Stream;

class Solution {
    public String reverseWords(String s) {
        // Stream<String> wordsStream = Pattern.compile("\\s+").splitAsStream(s);
        // Deque<String> reversedWords = wordsStream.map(String::trim).filter(str ->
        // !str.isEmpty()).collect(Collector.of(
        // ArrayDeque::new,
        // ArrayDeque::addFirst,
        // (left, right) -> {
        // left.addAll(right);
        // return left;
        // },
        // Collector.Characteristics.IDENTITY_FINISH));
        // return String.join(" ", reversedWords);
        String[] words = s.trim().split("\\s+");
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            swap(words, left, right);
            left++;
            right--;
        }
        return String.join(" ", words);
    }

    private void swap(String[] words, int left, int right) {
        String temp = words[left];
        words[left] = words[right];
        words[right] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("the sky is blue "));
        System.out.println(s.reverseWords("  the   sky  is blue  "));
        System.out.println(s.reverseWords("the"));
        System.out.println(s.reverseWords(""));
    }
}
