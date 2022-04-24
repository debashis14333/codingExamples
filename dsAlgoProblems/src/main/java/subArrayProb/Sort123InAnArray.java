package subArrayProb;

import java.util.Arrays;

//https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
public class Sort123InAnArray {

	// https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

	// Sort the input array, the array is assumed to
	// have values in {0, 1, 2}
	static void sort012(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (a[mid]) {
			case 0: {
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int arr_size = arr.length;
		sort012(arr, arr_size);
		System.out.println("Array after Sort : " + Arrays.toString(arr));
		// printArray(arr, arr_size);
	}

}
