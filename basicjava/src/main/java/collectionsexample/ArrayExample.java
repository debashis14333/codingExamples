package collectionsexample;

import java.util.*;
import java.util.List;

public class ArrayExample {

	public static void buildArray(int a, int b) {
		int arr[][] = new int[a][b];

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
			}
		}

        for (int[] row : arr) {
            Arrays.fill(row, 5); 
        }
        System.out.println("Array Arr : " + arr);
        System.out.println("Array Arr : " + Arrays.deepToString(arr));
        
//		for (int i = 0; i < a; i++) {
//			for (int j = 0; j < b; j++) {
//				System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
//			}
//		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2, b = 4; // c=3;
		buildArray(a, b);
		
		int[] arr = new int[0];
		int[] arr2 = null;
		System.out.println("arr size = " + arr.length);
		if(arr==null||arr2==null||arr.length==0||arr2.length==0)
			System.out.println("Either arr or arr2 is null or empty");
		arr = new int[4];
		System.out.println("arr content" + arr); //prints address
		System.out.println("arr content" + Arrays.toString(arr)); //prints values
		Integer[] arr3 = {1,2,3};
		Integer[] arr4 = new Integer[0];
		List<Integer> arrList = Arrays.asList(arr3);
		arr4 = arrList.toArray(arr4);
		System.out.println("arr3 content" + Arrays.toString(arr4)); //prints values
		
		//List<Integer>arrList = Arrays.asList(arr); //does not work on primitive types.
	
	}

}
