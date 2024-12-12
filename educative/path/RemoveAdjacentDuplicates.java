import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        System.out
                .printf("Original: '%s', processed: '%s'%n", "aabbccdd", removeAdjacentDuplicates("aabbccdd"));
        System.out.printf("Original: '%s', processed: '%s'%n", "abcdde", removeAdjacentDuplicates("abcdde"));
        System.out.printf("Original: '%s', processed: '%s'%n", "abcde", removeAdjacentDuplicates("abcde"));
        System.out.printf("Original: '%s', processed: '%s'%n", "aaabbb", removeAdjacentDuplicates("aaabbb"));
        System.out.printf("Original: '%s', processed: '%s'%n", "", removeAdjacentDuplicates(""));
        System.out.printf("Original: '%s', processed: '%s'%n", "a", removeAdjacentDuplicates("a"));
    }

    static String removeAdjacentDuplicates(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char currentChar : str.toCharArray()) {
            Character top = stack.peek();
            if (!stack.isEmpty() && top == currentChar) {
                stack.pop();
            } else {
                stack.push(currentChar);
            }
        }
        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}