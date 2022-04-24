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

	public static boolean checkIfStringHasRepeatingSubString(String input) {
		int n = input.length();
		int matchingLength = 0;

		for (int i = 0; i < n / 2; i++) {
			String prefix = input.substring(0, i + 1);
			String suffix = input.substring(n - i - 1, n);
			if (prefix.equals(suffix) && i >= matchingLength && i != n / 2) {
				matchingLength = i + 1;
				//System.out.println("Hi1 matchingLength = " + matchingLength);
			}
		}
		System.out.println("Debug + length " + matchingLength);
		if(matchingLength<1)
			return false;
		
		String matchingString = input.substring(0, matchingLength); // ab
		//System.out.println("matching string : " + matchingString);
		for (int i = matchingLength; i < n; i += matchingLength) {
			if (!matchingString.equals(input.substring(i, i + matchingLength))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input1 = "abcdabc";
		System.out.println("Input String : " + input1 + " = " + checkIfStringHasRepeatingSubString(input1));

//		String arr[] = {"aaaa", "ababab", "abcabcabcabc", "abab", "abcabcd", "ab" };
//		for (String input : arr) {
//			System.out.println("Input String : " + input + " = " + checkIfStringHasRepeatingSubString(input));
//		}

//		int[] arr = {3, 4, 1, 6, 2};
//		
//		ContiguousSubArrayCount obj = new ContiguousSubArrayCount();
//		System.out.println("Output Array : " + Arrays.toString(obj.countSubarrays(arr))); //Expected {1, 3, 1, 5, 1}
	}

}
