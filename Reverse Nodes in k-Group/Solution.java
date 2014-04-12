/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode beforeStart = dummy;

		while (beforeStart != null) {
			ListNode start = beforeStart.next;
			ListNode end = beforeStart;
			int count = 0;
			while (count != k) {
				end = end.next;
				if (end == null) return dummy.next;
				count++;
			}

			beforeStart.next = reverse(start, end);
			count = 0;

			while (count != k) {
				beforeStart = beforeStart.next;
				count++;
			}
		}

		return dummy.next;
	}

	public ListNode reverse(ListNode start, ListNode end) {
		ListNode afterEnd = end.next;

		ListNode dummy = new ListNode(-1);
		dummy.next = start;

		ListNode curr = start.next;
		while (curr != afterEnd) {
			ListNode next = curr.next;
			ListNode dummyNext = dummy.next;
			dummy.next = curr;
			curr.next = dummyNext;
			curr = next;
		}
		start.next = afterEnd;
		return dummy.next;
	}
}