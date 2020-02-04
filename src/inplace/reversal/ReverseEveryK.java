package inplace.reversal;


/*
 * Input : 1->2->3->4->5->6->7->8 k=3
 * Output : 3->2->1->6->5->4->8->7
 * 
 */
public class ReverseEveryK {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		LinkListUtil.listAll(head);
		ListNode result = ReverseEveryK.reverse(head, 3);
		System.out.print("Nodes of the reversed LinkedList are: ");
		LinkListUtil.listAll(result);
	}

	private static ListNode reverse(ListNode head, int i) {
		if(head == null || i < 2) {
			return head;
		}
		
		ListNode current = head;
		ListNode pre = null;
		while(true) {
			ListNode next = null;
			ListNode endOfPartA = pre;
			ListNode endOfPartB = current;
			int k = 0;
			// k = 3, then start reversing
			while(current != null && k < i) {
				next = current.next;
				current.next = pre;
				pre = current;
				current = next;
				k++;
			}
			
			if(endOfPartA == null) {
				head = pre;
			}else {
				endOfPartA.next = pre;
			}
			
			endOfPartB.next = current;
			
			if (current == null)
				break;
			
			// reset the pre
			pre = endOfPartB;
			
		}
		
		return head;
	}
}
