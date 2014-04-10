/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		int index = m + n - 1;
		int curA = m - 1;
		int curB = n - 1;

		while (curA >= 0 && curB >= 0) {
			if (A[curA] > B[curB]) {
				A[index--] = A[curA];
				curA--;
			} else {
				A[index--] = B[curB];
				curB--;
			}
		}

		while (curB >= 0) {
			A[index--] = B[curB--];
		}
	}
}