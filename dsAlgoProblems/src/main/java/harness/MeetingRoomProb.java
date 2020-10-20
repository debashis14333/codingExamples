package harness;

import java.util.*;

public class MeetingRoomProb {

	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int[] itv : intervals) {
			if (minHeap.isEmpty()) {
				minHeap.add(itv[1]);
			} else {

				if (itv[0] >= minHeap.peek()) {
					minHeap.poll();
				}
				minHeap.add(itv[1]);
			}
		}
		return  minHeap.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] a = { { 1, 18 }, { 18, 23 }, { 15, 29 }, { 4, 15 }, { 2, 11 }, { 5, 13 } };

		int[][] b = { { 1, 18 }, { 1, 5 }, { 6, 16 }, { 26, 29 }, { 18, 23 } };

		System.out.println(new MeetingRoomProb().minMeetingRooms(b));
	}

}
