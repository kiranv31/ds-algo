package inplace.reversal;

/*
 * Input : 1->2->3->4->5->6->7->8 k = 2
 * Output : 2->1->3->4->6->5->7->8
 * 
 */
public class ReverseAlternateK {
	
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
	    ListNode result = ReverseAlternateK.reverse(head, 2);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    LinkListUtil.listAll(result);
	    
	}

	private static ListNode reverse(ListNode head, int k) {
		if(head == null || k <= 1) {
			return head;
		}
		
		ListNode pre = null;
		ListNode current = head;
		
		while(current != null) {
			ListNode next = null;
			ListNode endNodeOfPartA = pre;
			ListNode endNodeOfPartB = current;
			int i = 0;
			while(current != null && i < k) {
				next = current.next;
				current.next = pre;
				pre = current;
				current = next;
				i++;
			}
			
			if(endNodeOfPartA == null) {
				head = pre;
			}else {
				endNodeOfPartA.next = pre;
			}
			
			if(current == null) {
				break;
			}
			
			
			endNodeOfPartB.next = current;
			
			// moving to next k nodes
			for (int j = 0; current != null && j < 2; j++) {
				pre = current;
				current = current.next;
			}	
		}
		return head;
	}


}
