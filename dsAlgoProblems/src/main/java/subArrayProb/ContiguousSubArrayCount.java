package subArrayProb;

import java.util.*;

//https://leetcode.com/discuss/interview-question/579606/count-contiguous-subarrays
public class ContiguousSubArrayCount {

	int[] countSubarrays(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				ans[i] += ans[stack.pop()];
			}
			stack.push(i);
			ans[i]++;
		}
		stack.clear();
		int[] temp = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				int idx = stack.pop();
				ans[i] += temp[idx];
				temp[i] += temp[idx];
			}
			stack.push(i);
			temp[i]++;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 4, 1, 6, 2};
		
		ContiguousSubArrayCount obj = new ContiguousSubArrayCount();
		System.out.println("Output Array : " + Arrays.toString(obj.countSubarrays(arr))); //Expected {1, 3, 1, 5, 1}
	}

}
