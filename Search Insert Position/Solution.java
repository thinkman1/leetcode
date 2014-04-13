/**
 * @author thinkman - one time pass
 */
public class Solution {
	public int searchInsert(int[] A, int target) {
		int ins = -1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] > target) {
				return ins + 1;
			} else if (A[i] < target) {
				ins = i;
			} else {
				return i;
			}
		}

		return ins + 1;
	}
}