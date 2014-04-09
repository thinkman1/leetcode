/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0)
			return 0;

		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;

		int[][] res = new int[row][col];

		for (int i = 0; i < col; i++) {
			if (obstacleGrid[0][i] != 1) {
				res[0][i] = 1;
			} else {
				break;
			}
		}

		for (int i = 0; i < row; i++) {
			if (obstacleGrid[i][0] != 1) {
				res[i][0] = 1;
			} else {
				break;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (obstacleGrid[i][j] != 1) {
					res[i][j] = res[i - 1][j] + res[i][j - 1];
				}
			}
		}

		return res[row - 1][col - 1];
	}
}