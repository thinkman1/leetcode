/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode res = new ListNode(head.val);
		ListNode scan = head.next;

		while (scan != null) {
			ListNode innerScan = res;
			ListNode next = scan.next;

			if (innerScan.val >= scan.val) {
				ListNode n = res;
				scan.next = res;
				res = scan;
			} else {
				while (innerScan.next != null) {
					if (scan.val > innerScan.val && scan.val <= innerScan.next.val) {
						ListNode tmp = innerScan.next;
						innerScan.next = scan;
						scan.next = tmp;
						break;
					}
					innerScan = innerScan.next;
				}

				if (innerScan.next == null && innerScan.val < scan.val) {
					innerScan.next = scan;
					scan.next = null;
				}
			}
			scan = next;
		}
		return res;
	}
}