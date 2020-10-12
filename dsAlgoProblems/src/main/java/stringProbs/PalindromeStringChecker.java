package stringProbs;

import java.util.*;

public class PalindromeStringChecker {

	//Look for this solution.
	//https://leetcode.com/problems/palindrome-pairs/discuss/79199/150-ms-45-lines-JAVA-solution
	static int getCount(int N, List<String> s) {

		// Stores frequency array
		// and its count
		Map<List<Integer>, Integer> mp = new HashMap<>();

		// Total number of pairs
		int ans = 0;

		for (int i = 0; i < N; i++) {

			// Initializing array of size 26
			// to store count of character
			List<Integer> a = new ArrayList<>(26);
			for (int k = 0; k < 26; k++)
				a.add(0);

			// Counting occurrence of each
			// character of current string
			for (int j = 0; j < s.get(i).length(); j++) {
				a.set((s.get(i).charAt(j) - 'a'), a.get(s.get(i).charAt(j) - 'a') + 1);
			}

			// Convert each count to parity(0 or 1)
			// on the basis of its frequency
			for (int j = 0; j < 26; j++) {
				a.set(j, a.get(j) % 2);
			}

			// Adding to anser
			ans += mp.getOrDefault(a, 0);

			// Frequency of single character
			// can be possibly changed,
			// so change its parity
			for (int j = 0; j < 26; j++) {
				List<Integer> changedCount = new ArrayList<>();
				changedCount.addAll(a);

				if (a.get(j) == 0)
					changedCount.set(j, 1);
				else
					changedCount.set(j, 0);

				ans += mp.getOrDefault(changedCount, 0);
			}
			mp.put(a, mp.getOrDefault(a, 0) + 1);
		}
		return ans;
	}

	// Driver code
	public static void main(String[] args) {
		int N = 6;
		List<String> A = Arrays.asList("aab", "abcac", "dffe", "ed", "aa", "aade");

		System.out.print(getCount(N, A));
	}
}
