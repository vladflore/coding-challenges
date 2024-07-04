import java.util.Arrays;

void main() {

    System.out.println(findSumOfThree(new int[] {1,-1,0}, -1));
    System.out.println(findSumOfThree(new int[] {3,7,1,2,8,4,5}, 10));
    System.out.println(findSumOfThree(new int[] {3,7,1,2,8,4,5}, 21));
    System.out.println(findSumOfThree(new int[] {-1,2,1,-4,5,-3}, -8));
    System.out.println(findSumOfThree(new int[] {-1,2,1,-4,5,-3}, 0));

}

boolean findSumOfThree(int[] nums, int target) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
        int low = i + 1;
        int high = nums.length - 1;

        while (low < high) {
            var current = nums[i] + nums[low] + nums[high];
            if (current == target) {
                return true;
            }
            if (current < target) {
                low++;
            }
            if (current > target) {
                high--;
            }
        }
    }
    return false;
}