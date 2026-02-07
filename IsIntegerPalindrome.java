
public class IsIntegerPalindrome {

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        if (number % 10 == 0 && number != 0) {
            return false;
        }

        int secondHalfReversed = 0;
        while (number > secondHalfReversed) {
            secondHalfReversed = secondHalfReversed * 10 + number % 10;
            number /= 10;
        }

        return number == secondHalfReversed || number == secondHalfReversed / 10;
    }

    public static void main(String[] args) {
        int[] testCases = {121, -121, 10, 12321, 0, 1234, 123321};
        for (int testCase : testCases) {
            System.out.println("%d is palindrome: %b".formatted(testCase, isPalindrome(testCase)));
        }
    }
}
