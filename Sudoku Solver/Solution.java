/**
 * @author thinkman
 */
public class Solution {
	public void solveSudoku(char[][] board) {
		if (board.length == 0)
			return;

		ArrayList<Integer> dots = new ArrayList<Integer>();
		int n = board.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					dots.add(i * n + j);
				}
			}
		}

		solve(0, dots, board);
	}

	public boolean solve(int step, ArrayList<Integer> dots, char[][] board) {
		if (step == dots.size()) {
			return true;
		}

		int row = dots.get(step) / 9;
		int col = dots.get(step) % 9;

		for (char c = '1'; c <= '9'; c++) {
			if (isValid(row, col, c, board)) {
				board[row][col] = c;
				if (solve(step + 1, dots, board)) {
					return true;
				}
				board[row][col] = '.';
				;
			}
		}

		return false;
	}

	public boolean isValid(int row, int col, char c, char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == c)
				return false;
			if (board[i][col] == c)
				return false;

			int ro = 3 * (row / 3) + i / 3;
			int co = 3 * (col / 3) + i % 3;
			if (board[ro][co] == c)
				return false;
		}
		return true;
	}
}