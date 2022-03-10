package tech.vladflore.educative.two_pointers;

public class RemoveDuplicates {

    public static int remove(int[] arr) {
        int nextNonDupl = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDupl - 1] != arr[i]) {
                arr[nextNonDupl] = arr[i];
                nextNonDupl++;
            }
        }
        return nextNonDupl;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[]{2, 2, 2, 11};
        System.out.println(RemoveDuplicates.remove(arr));
    }
}