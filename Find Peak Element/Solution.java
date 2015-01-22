public class Solution {
	public int findPeakElement(int[] num) {
		if (num == null || num.length == 0)
			return -1;

		return search(num, 0, num.length - 1);
	}

	public int search(int[] num, int begin, int end) {
		if (begin == end) {
			return begin;
		}

		// element of begin and end are adjacent
		if (end == begin + 1) {
			return num[begin] < num[end] ? end : begin;
		}

		int mid = (end + begin) / 2;

		if (num[mid] < num[mid - 1]) {
			return search(num, begin, mid - 1);
		}

		if (num[mid] < num[mid + 1]) {
			return search(num, mid + 1, end);
		}

		return mid;
	}
}