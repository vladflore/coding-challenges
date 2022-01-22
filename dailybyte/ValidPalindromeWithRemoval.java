/**
 * Given a string and the ability to delete at most one character, return
 * whether or not it can form a palindrome.
 * 
 * "abcba", return true
 * "foobof", return true (remove the first 'o', the second 'o', or 'b')
 * "abccab", return false
 * 
 */
public class ValidPalindromeWithRemoval {
    public static void main(String[] args) {
        System.out.println(new ValidPalindromeWithRemoval().solve(args[0]));
    }

    private boolean solve(String string) {
        int len = string.length();
        int diffs = 0;
        for (int i = 0; i < len / 2; i++) {
            if (string.charAt(i) != string.charAt(len - i - 1)) {
                diffs++;
            }
        }
        return diffs <= 1;
    }
}
