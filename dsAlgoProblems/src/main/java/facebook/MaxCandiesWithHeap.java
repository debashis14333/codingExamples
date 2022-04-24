package facebook;

import java.util.*;

public class MaxCandiesWithHeap {

	public static int maxCandies(int[] arr, int k) {
		    // Write your code here
		    PriorityQueue<Integer> maxHeap =  new PriorityQueue<Integer>(Collections.reverseOrder()); 
		    int maxCandyCount = 0;
		    
		    for(int i=0; i<arr.length; i++)
		    {
		        maxHeap.add(arr[i]);
		    }
		     
		    for(int i=0; i<k; i++)
		    {
		        int currentMaxCandyCount = maxHeap.poll();
		        maxCandyCount += currentMaxCandyCount;
		        maxHeap.add(currentMaxCandyCount/2);
		    }
		    return maxCandyCount;
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    int n_2 = 9, k_2 = 3;
	    int[] arr_2 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
	    int expected_2 = 228;
	    int output_2 = maxCandies(arr_2, k_2);
	    System.out.println("Expected : "+expected_2 + ", output : " + output_2);
	}

}
