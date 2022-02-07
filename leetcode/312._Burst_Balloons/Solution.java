/**
 * https://leetcode.com/problems/burst-balloons/
 */
class Solution {
    public int maxCoins(int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxCoins = solution.maxCoins(new int[] { 3, 1, 5, 8 });
        assert maxCoins == 167;

        maxCoins = solution.maxCoins(new int[] { 1, 5 });
        assert maxCoins == 10;

    }
}