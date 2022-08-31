package tech.vladflore.module2;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] res = new int[len1 + len2];
        int i = 0, j = 0, k = 0;

        while(i < len1 && j < len2){
            if(arr1[i]<arr2[j]){
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }

        while(i < len1){
            res[k++] = arr1[i++];
        }

        while(j < len2){
            res[k++] = arr2[j++];
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(MergeTwoSortedArrays.mergeArrays(new int[]{1,3,4,5}, new int[]{2,6})));
    }
}
