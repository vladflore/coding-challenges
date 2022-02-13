import java.util.Arrays;

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if(nums1Copy[i] < nums2[j]){
                nums1[k++] = nums1Copy[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[k++] = nums1Copy[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        } 

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args){
        new Solution().merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        new Solution().merge(new int[]{1}, 1, new int[]{}, 0);
        new Solution().merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
