package inplace.reversal;

public class LinkListUtil {

	public static void listAll(ListNode head) {
		ListNode current = head;
		System.out.println();
		while(current != null) {
			System.out.print(current.value+" ");
			current = current.next;
		}
		System.out.println();
		
	}
}
