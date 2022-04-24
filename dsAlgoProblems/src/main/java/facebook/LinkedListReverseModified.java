package facebook;

class Node {
	int data;
	Node next;

	Node(int x) {
		data = x;
		next = null;
	}
}

public class LinkedListReverseModified {



	// Add any helper functions you may need here
	public static Node reverse(Node head) {
		    if(head == null) return null;

		    Node curr = head;
		    Node next = null;
		    Node prev = null;

		    while(curr!=null && curr.data%2==0) {
		      next = curr.next;
		      curr.next = prev;
		      prev = curr;
		      curr = next;
		    }

		    if(curr!=head) {
		      head.next = curr;
		      curr = reverse(curr);
		      return prev;
		    } else {
		      head.next = reverse(head.next);
		      return head;
		    }
		  }

	public static Node createLinkedList(int[] arr) {
		Node head = null;
		Node tempHead = head;
		for (int v : arr) {
			if (head == null) {
				head = new Node(v);
				tempHead = head;
			} else {
				head.next = new Node(v);
				head = head.next;
			}
		}
		return tempHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr_1 = {1, 2, 8, 9, 12, 16};
	    //int[] expected1 = {1, 8, 2, 9, 16, 12};
	    Node head_1 = createLinkedList(arr_1);
	    //Node expected_1 = createLinkedList(expected1);
	    Node output_1 = reverse(head_1);
	    while(output_1!=null)
	    {
	    	System.out.println("val = "+output_1.data);
	    	output_1=output_1.next;
	    }
	}

}
