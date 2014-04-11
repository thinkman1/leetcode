/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public int removeDuplicates(int[] A) {
		if (A.length <= 2) return A.length;

		int j = 1;
		for (int i = 2; i < A.length; i++) {
			if (A[i] != A[j] || A[i] != A[j - 1]) {
				A[++j] = A[i];
			}
		}
		return j + 1;
	}
}