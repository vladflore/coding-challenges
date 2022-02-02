package ch1;

import java.util.Arrays;

public class ZeroMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][] {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        // int[][] matrix = new int[][]{
        //     {1,0}
        // };
        int[][] ans = solution.setZeroes(matrix);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] setZeroes(int[][] matrix) {
        boolean rHas0 = false, cHas0 = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                cHas0 = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rHas0 = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rHas0) {
            Arrays.fill(matrix[0], 0);
        }
        if (cHas0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
