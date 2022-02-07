class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = x;
        int n = 0;
        while (y != 0) {
            n = n * 10 + (y % 10);
            y /= 10;
        }
        return n == x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(123454321));
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(10));
    }
}