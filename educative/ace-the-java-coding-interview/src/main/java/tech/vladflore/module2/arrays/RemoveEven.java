package tech.vladflore.module2.arrays;

import java.util.Arrays;

class RemoveEven {

	public static int[] removeEven(int[] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] % 2 == 0){
				count++;
			}
		}
		int[] odd = new int[arr.length- count];
		int idx = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] % 2 != 0){
				odd[idx++] = arr[i];
			}
		}
		return odd;
	}

    public static void main(String[] args){
        System.out.println(Arrays.toString(RemoveEven.removeEven(new int[]{1,2,3,4,5,6,7,8,9})));
    }
}
