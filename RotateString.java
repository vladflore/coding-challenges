
public class RotateString {

    public static void main(String[] args) {
        System.out.println("string: %s, goal: %s, expected: %s, output: %s".formatted("abcde", "cdeab", true, solve("abcde", "cdeab")));
        System.out.println("string: %s, goal: %s, expected: %s, output: %s".formatted("abcde", "abced", false, solve("abcde", "abced")));
    }

    private static boolean solve(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
