/**
 * Given a string, return whether or not it forms a palindrome ignoring case and
 * non-alphabetical characters.
 * 
 * "level", return true
 * "algorithm", return false
 * "A man, a plan, a canal: Panama.", return true
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        boolean ans = new ValidPalindrome().solve(args[0]);
        System.out.println(ans);
    }

    private boolean solve(String string) {
        string = string.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int len = string.length();
        for (int i = 0; i < len / 2; i++) {
            if (string.charAt(i) != string.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
