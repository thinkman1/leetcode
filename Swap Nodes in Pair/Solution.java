/**
 * @author thinkman
 */
public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode foo = dummy;
		ListNode prev = head;
		ListNode curr = head.next;
		while (curr != null) {
			ListNode bar = curr.next;

			prev.next = curr.next;

			foo.next = curr;
			curr.next = prev;

			foo = prev;
			prev = bar;
			if (bar == null) {
				curr = null;
			} else {
				curr = bar.next;
			}
		}

		return dummy.next;
	}
}

/**
 * Neat!
 */
public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode curr = head;
		while (curr != null) {
			if (curr.next == null) break;
			ListNode n1 = curr;
			ListNode n2 = curr.next;
			
			curr = curr.next.next;
			
			pre.next = n2;
			n2.next = n1;
			n1.next = curr;
			pre = n1;
		}
		return dummy.next;
	}
}