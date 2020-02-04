package inplace.reversal;

/*
 * 
 * Input: 1->2->3->4->5->6->7->8 p = 2, q = 5
 * Output: 1->5->4->3->2->6->7->8
 * 
 */
public class ReverseSubList {
	
	public static ListNode reverse(ListNode head, int p, int q) {
		if(p == q || head == null)
			return head;
		
		ListNode current = head;
		ListNode pre = null;
		
		int i = 1;
		while(i != p && current != null) {
			pre = current;
			current = current.next;
			i++;
		}
		
		/* 1 -> 2 -> 3 -> 4 -> 5 -> 6 p = 2, q = 4
		PartA = 1 
		PartB = 2 -> 3 -> 4
		endOfPartA = 1
		endOfPartB = 2 ( after reversal )
		*/
		
		ListNode endOfPartA = pre;
		ListNode endOfPartB = current;
		pre = null;
		while(i <= q && current != null) {
			ListNode next = current.next;
			current.next = pre;
			pre = current;
			current = next;
			i++;	
		}
		
		// p = 1 in this case
		if(endOfPartA == null) {
			head = pre;
		}else {
			// current will be on q+1 node
			// pre will be on q
			endOfPartA.next = pre;
		}	
		endOfPartB.next = current;
		
		return head;
	}
	
	public static void main(String[] args) {
		 ListNode head = new ListNode(1);
		    head.next = new ListNode(2);
		    head.next.next = new ListNode(3);
		    head.next.next.next = new ListNode(4);
		    head.next.next.next.next = new ListNode(5);

		    LinkListUtil.listAll(head);
		    ListNode result = ReverseSubList.reverse(head, 2, 4);
		    LinkListUtil.listAll(result);
	}

}
