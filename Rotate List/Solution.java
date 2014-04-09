/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0)
			return head;

		int count = 0;
		ListNode curr = head;

		while (curr != null) {
			count++;
			curr = curr.next;
		}

		int k = n % count;

		if (k == 0)
			return head;

		curr = head;
		count = 0;
		while (count != k) {
			curr = curr.next;
			count++;
		}

		ListNode res = head, prev = null, prevCurr = null;
		while (curr != null) {
			prev = res;
			res = res.next;
			prevCurr = curr;
			curr = curr.next;
		}

		prev.next = null;
		prevCurr.next = head;

		return res;
	}
}