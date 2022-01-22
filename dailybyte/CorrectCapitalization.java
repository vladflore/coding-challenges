/**
 * Given a string, return whether or not it uses capitalization correctly. A
 * string correctly uses capitalization if all letters are capitalized, no
 * letters are capitalized, or only the first letter is capitalized.
 * 
 * "USA", return true
 * "Calvin", return true
 * "compUter", return false
 * "coding", return true
 */
public class CorrectCapitalization {
    public static void main(String[] args) {
        System.out.println(new CorrectCapitalization().solve(args[0]));
    }

    private boolean solve(String string) {
        int lower = 0, upper = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isLowerCase(ch)) {
                lower++;
            } else if (Character.isUpperCase(ch)) {
                upper++;
            }
        }
        if (string.length() == lower || string.length() == upper
                || Character.isUpperCase(string.charAt(0)) && upper == 1) {
            return true;
        }
        return false;
    }
}
