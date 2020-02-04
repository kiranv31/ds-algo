package inplace.reversal;

/*
 * Input : 1->2->3->4->5->6->7->8 i = 3
 * Output : 6->7->8->1->2->3->4->5->6->7->8 
 * 
 * Input : 1->2->3->4->5->6->7->8 i = 10  -> 10%8 = 2
 * Output : 7->8->1->2->3->4->5->6
 */
public class RotationToK {
	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(3);
	    head.next.next.next = new ListNode(4);
	    head.next.next.next.next = new ListNode(5);
	    head.next.next.next.next.next = new ListNode(6);

	    LinkListUtil.listAll(head);
	    ListNode result = RotationToK.rotate(head, 3);
	    System.out.print("Nodes of the rotated LinkedList are: ");
	    LinkListUtil.listAll(result);
		
	}

	private static ListNode rotate(ListNode head, int i) {
		if(i == 1 || head == null) {
			return head;
		}
		
		ListNode current = head;
		ListNode endNode = null;
		int len = 0;
		while(current != null) {
			len++;
			endNode = current;
			current = current.next;
		}
		
		i = i % len;
		int skipNodes = len - i;
		current = head;
		ListNode pre = head;
		for(int j = 0; j < skipNodes; j ++) {
			pre = current;
			current = current.next;
		}
		
		// 1->2->3     4->5->6->null
		// making last node 
		// seeting 3->NULL
		pre.next = null;
		
		// 
		// linking in between
		endNode.next = head;
		
		// setting head
		head = current;		
		
		return head;
	}
}
