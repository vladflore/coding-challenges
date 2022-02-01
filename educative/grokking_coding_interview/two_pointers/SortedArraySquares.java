package grokking_coding_interview.two_pointers;

public class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] res = new int[arr.length];
        int idx = arr.length - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquared = (int) Math.pow(arr[left], 2);
            int rightSquared = (int) Math.pow(arr[right], 2);
            if (leftSquared > rightSquared) {
                res[idx--] = leftSquared;
                left++;
            } else {
                res[idx--] = rightSquared;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
