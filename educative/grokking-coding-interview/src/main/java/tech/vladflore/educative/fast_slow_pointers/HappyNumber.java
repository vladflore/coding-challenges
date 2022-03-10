package tech.vladflore.educative.fast_slow_pointers;

public class HappyNumber {

    public static boolean find(int num) {
        int slow = num;
        int fast = num;
        do {
            slow = calculateSquareSum(slow);
            fast = calculateSquareSum(calculateSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int calculateSquareSum(int num) {
        int squaredSum = 0;
        while (num != 0) {
            int digit = num % 10;
            squaredSum += digit * digit;
            num /= 10;
        }
        return squaredSum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}
