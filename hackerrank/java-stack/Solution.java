import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.next();
            System.out.println(isBalanced(input));
        }

        scanner.close();
    }

    private static boolean isBalanced(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            Character topElement = stack.pop();
            switch (ch) {
                case ')':
                    if (topElement != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (topElement != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (topElement != '[') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }
}