/**
 * DFS version - memory limit exceed
 * 
 * @author thinkman
 * 
 */
public class Solution {
	public void solve(char[][] board) {
		if (board.length == 0)
			return;

		int row = board.length;
		int col = board[0].length;

		for (int i = 0; i < row; i++) {
			if (board[i][0] == 'O')
				dfs(board, i, 0);
			if (board[i][col - 1] == 'O')
				dfs(board, i, col - 1);
		}

		for (int i = 0; i < col; i++) {
			if (board[0][i] == 'O')
				dfs(board, 0, i);
			if (board[row - 1][i] == 'O')
				dfs(board, row - 1, i);
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == '*')
					board[i][j] = 'O';
			}
		}

	}

	public void dfs(char[][] board, int i, int j) {
		int row = board.length;
		int col = board[0].length;

		if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O')
			return;

		board[i][j] = '*';

		if (i > 0 && board[i - 1][j] == 'O') {
			dfs(board, i - 1, j);
		}

		if (i < row - 1 && board[i + 1][j] == 'O') {
			dfs(board, i + 1, j);
		}

		if (j > 0 && board[i][j - 1] == 'O') {
			dfs(board, i, j - 1);
		}

		if (j < col - 1 && board[i][j + 1] == 'O') {
			dfs(board, i, j + 1);
		}
	}
}