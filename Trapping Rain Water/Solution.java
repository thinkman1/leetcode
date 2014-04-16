/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public int trap(int[] A) {
		int n = A.length;
		int[] leftHighest = new int[n];
		int[] rightHighest = new int[n];

		for (int i = 0; i < n; i++) {
			leftHighest[i] = i > 0 ? Math.max(leftHighest[i - 1], A[i]) : A[i];
		}

		for (int i = n - 1; i >= 0; i--) {
			rightHighest[i] = i < n - 1 ? Math.max(A[i], rightHighest[i + 1]) : A[i];
		}

		int res = 0;
		for (int i = 1; i < n - 1; i++) {
			int h = Math.min(leftHighest[i], rightHighest[i]);
			if (h > A[i]) {
				res += h - A[i];
			}
		}
		return res;
	}
}