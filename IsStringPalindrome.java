
import java.util.List;

public class IsStringPalindrome {

    public static boolean isPalindrome(String string) {
        var cleaned = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        var strings = List.of(
                "A man, a plan, a canal: Panama",
                "race a car",
                "",
                "No 'x' in Nixon",
                "Hello, World!",
                "12321",
                "12345"
        );

        for (var string : strings) {
            System.out.println("'%s' %s a palindrome".formatted(string, isPalindrome(string) ? "IS" : "is NOT"));
        }
    }
}
