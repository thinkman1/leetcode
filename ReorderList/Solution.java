/**
 * @author thinkman
 * 
 *         break - reverse - merge
 */
public class Solution {
	public void reorderList(ListNode head) {
		if (head == null)
			return;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode l1 = head;
		ListNode l2 = reverse(slow.next);
		slow.next = null;

		merge(l1, l2);
	}

	public ListNode reverse(ListNode head) {
		if (head == null)
			return null;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode prev = head;
		ListNode curr = head.next;

		while (curr != null) {
			ListNode next = curr.next;
			prev.next = next;
			curr.next = pre.next;
			pre.next = curr;
			curr = next;
		}
		head.next = null;

		return dummy.next;
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;

		ListNode curr1 = l1;
		ListNode curr2 = l2;

		while (curr1 != null && curr2 != null) {
			ListNode next1 = curr1.next;
			ListNode next2 = curr2.next;

			curr1.next = curr2;
			curr2.next = next1;

			curr1 = next1;
			curr2 = next2;
		}

		return l1;
	}
}