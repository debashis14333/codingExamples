package facebook;

import java.util.*;

public class RevenueMileStones {

	static int[] getMilestoneDays(int[] revenues, int[] milestones) {
		// Write your code here
		TreeMap<Integer, Integer> totalRevenueTreemap = new TreeMap<>();
		int totalRevenue = 0;
		for (int i = 0; i < revenues.length; i++) {
			totalRevenue += revenues[i];
			totalRevenueTreemap.put(totalRevenue, i + 1);
		}
		int[] milestonesDay = new int[milestones.length];
		for (int i = 0; i < milestones.length; i++) {
			Map.Entry<Integer, Integer> totalRevenueEntry = totalRevenueTreemap.ceilingEntry(milestones[i]);
			milestonesDay[i] = totalRevenueEntry == null ? -1 : totalRevenueEntry.getValue();
		}
		return milestonesDay;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int revenues_1[] = { 100, 200, 300, 400, 500 };
		int milestones_1[] = { 300, 800, 1000, 1400 };
		int expected_1[] = { 2, 4, 4, 5 };
		int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
		// check(expected_1, output_1);

		int revenues_2[] = { 700, 800, 600, 400, 600, 700 };
		int milestones_2[] = { 3100, 2200, 800, 2100, 1000 };
		int expected_2[] = { 5, 4, 2, 3, 2 };
		int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
		// check(expected_2, output_2);
	}

}
