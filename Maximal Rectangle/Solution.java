/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;

		int row = matrix.length;
		int col = matrix[0].length;

		int[][] res = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0) {
					res[i][j] = matrix[i][j] == '0' ? 0 : 1;
				} else {
					res[i][j] = matrix[i][j] == '0' ? 0 : res[i - 1][j] + 1;
				}
			}
		}

		int area = 0;
		for (int i = 0; i < row; i++) {
			area = Math.max(area, maxArea(res[i]));
		}
		return area;
	}

	public int maxArea(int[] arr) {
		int[] h = Arrays.copyOf(arr, arr.length + 1);

		int i = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int res = 0;
		while (i < h.length) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i++);
			} else {
				int hh = stack.pop();
				res = Math.max(res,
						h[hh] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}

		return res;
	}
}