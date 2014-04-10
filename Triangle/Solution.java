/**
 * Using O(n ^ 2) space
 * @author thinkman
 *
 */
public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle.size() == 0) return 0;
		int row = triangle.size();
		int[][] res = new int[row][row];
		res[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (j == 0) {
					res[i][j] = res[i - 1][0] + triangle.get(i).get(j);
				} else if (j == triangle.get(i).size() - 1) {
					res[i][j] = res[i - 1][triangle.get(i - 1).size() - 1] + triangle.get(i).get(j);
				} else {
					res[i][j] = Math.min(res[i - 1][j], res[i - 1][j - 1]) + triangle.get(i).get(j);
				}
			}
		}

		int sum = Integer.MAX_VALUE;
		for (int i = 0; i < row; i++) {
			sum = Math.min(sum, res[row - 1][i]);
		}
		return sum;
	}
}