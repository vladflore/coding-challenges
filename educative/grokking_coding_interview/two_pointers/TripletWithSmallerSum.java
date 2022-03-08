import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets
 * in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three
 * different indices. Write a function to return the count of such triplets.
 */
public class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    public static List<List<Integer>> searchTriplets1(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            searchPair(arr, target - arr[i], i, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int first, List<List<Integer>> triplets) {
        int left = first + 1, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {
                for (int i = right; i > left; i--) {
                    triplets.add(Arrays.asList(arr[first], arr[left], arr[i]));
                }
                left++;
            } else {
                right--;
            }
        }
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets1(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
        System.out.println(TripletWithSmallerSum.searchTriplets1(new int[] { -1, 4, 2, 1, 3 }, 5));

    }

}
