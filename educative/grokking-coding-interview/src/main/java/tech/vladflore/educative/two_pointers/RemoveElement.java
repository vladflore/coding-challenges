package tech.vladflore.educative.two_pointers;

public class RemoveElement {

    public static int remove(int[] arr, int key) {
        int nextEl = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextEl] = arr[i];
                nextEl++;
            }
        }
        return nextEl;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        System.out.println(RemoveElement.remove(arr, 3));

        arr = new int[]{2, 11, 2, 2, 1};
        System.out.println(RemoveElement.remove(arr, 2));
    }
}