public class HappyNumber {
    public static void main(String args[]) {
        int[] a = { 1, 5, 19, 25, 7 };
        for (int j : a) {
            boolean isHappyNumber = isHappy(j);
            System.out.printf("%d %s a happy number%n", j, isHappyNumber ? "is" : "is not");
        }
    }

    static int squaredDigitsSum(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += (int) Math.pow(digit, 2);
            n = n / 10;
        }
        return sum;

    }

    static boolean isHappy(int n) {
        int slow = n;
        int fast = squaredDigitsSum(n);
        while (fast != 1 && slow != fast) {
            slow = squaredDigitsSum(slow);
            fast = squaredDigitsSum(squaredDigitsSum(fast));
        }
        return fast == 1;
    }
}
