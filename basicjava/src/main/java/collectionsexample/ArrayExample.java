package collectionsexample;

import java.util.Arrays;

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

	}

}
