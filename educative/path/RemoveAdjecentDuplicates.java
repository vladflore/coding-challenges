import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjecentDuplicates {
    public static void main(String[] args) {
        System.out
                .println("Original: '%s', processed: '%s'".formatted("aabbccdd", removeAdjecentDuplicates("aabbccdd")));
        System.out.println("Original: '%s', processed: '%s'".formatted("abcdde", removeAdjecentDuplicates("abcdde")));
        System.out.println("Original: '%s', processed: '%s'".formatted("abcde", removeAdjecentDuplicates("abcde")));
        System.out.println("Original: '%s', processed: '%s'".formatted("aaabbb", removeAdjecentDuplicates("aaabbb")));
        System.out.println("Original: '%s', processed: '%s'".formatted("", removeAdjecentDuplicates("")));
        System.out.println("Original: '%s', processed: '%s'".formatted("a", removeAdjecentDuplicates("a")));
    }

    static String removeAdjecentDuplicates(String str) {
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