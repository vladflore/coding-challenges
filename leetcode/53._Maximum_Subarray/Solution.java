class Solution {
    public int maxSubArray(int[] nums) {
        int curr = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++){
            curr = Math.max(nums[i], nums[i] + curr);
            max = Math.max(max, curr);
        }
        return max;
    }


    public static void main(String args[]) {
    	System.out.println(new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	System.out.println(new Solution().maxSubArray(new int[]{1}));
	System.out.println(new Solution().maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
