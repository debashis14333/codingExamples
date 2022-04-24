package collectionsexample;

import java.util.*;

public class QueueExample {
	
	public static void checkQ() {

		Queue<Integer> q = new LinkedList<>();

		// Adds elements {0, 1, 2, 3, 4} to the queue
		for (int i = 0; i < 5; i++)
			q.add(i);

		// Display contents of the queue.
		System.out.println("Elements of queue " + q);

		Queue<Integer> q1 = new LinkedList<>();

		// Adds elements {0, 1, 2, 3, 4} to the queue
		for (int i = 0; i < 5; i++)
			q1.add(i+10);

		// Display contents of the queue.
		System.out.println("Elements of queue " + q1);
		
		q.remove(4); 
		q1.remove(12);
		System.out.println("Elements of queue q " + q);
		System.out.println("Elements of queue q1 " + q1);
		q.addAll(q1);
		System.out.println("Elements of queue q " + q);
		
	}

	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<>();

		// Adds elements {0, 1, 2, 3, 4} to the queue
		for (int i = 0; i < 5; i++)
			q.add(i);

		// Display contents of the queue.
		System.out.println("Elements of queue " + q);

		// To remove the head of queue.
		int removedele = q.remove();
		System.out.println("removed element-" + removedele);

		System.out.println(q);

		// To view the head of queue
		int head = q.peek();
		System.out.println("head of queue-" + head);

		// Rest all methods of collection
		// interface like size and contains
		// can be used with this
		// implementation.
		int size = q.size();
		System.out.println("Size of queue-" + size);
		
		checkQ();

	}

}
