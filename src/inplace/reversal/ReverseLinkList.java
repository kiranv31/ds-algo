package inplace.reversal;

/*
 * Input: 1->2->3->4->5->6->7->8
 * Output : 8->7->6->5->4->3->2->1
 * 
 */
public class ReverseLinkList {
	
	public static ListNode reverse(ListNode head) {
		ListNode current = head;
	    ListNode pre = null;
	    ListNode next = null;
	    while(current != null) {
	    	next = current.next;
	    	current.next = pre;
	    	pre = current;
	    	current = next;
	    }
	    return pre;
	}
	
	public static void main(String[] args) {	
		ListNode head = new ListNode(2);
	    head.next = new ListNode(4);
	    head.next.next = new ListNode(6);
	    head.next.next.next = new ListNode(8);
	    head.next.next.next.next = new ListNode(10);
	    LinkListUtil.listAll(head);
	    ListNode result = ReverseLinkList.reverse(head);
	    LinkListUtil.listAll(result);
		
	}

}
