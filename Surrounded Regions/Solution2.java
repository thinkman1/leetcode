/**
 * BFS version 
 *  
 * @author thinkman
 * 
 */
public class Solution {
	Queue<Integer> q = new LinkedList<Integer>();

	public void solve(char[][] board) {
		if (board.length == 0)
			return;
		int row = board.length;
		int col = board[0].length;

		for (int i = 0; i < row; i++) {
			if (board[i][0] == 'O')
				bfs(i, 0, board);
			if (board[i][col - 1] == 'O')
				bfs(i, col - 1, board);
		}

		for (int i = 0; i < col; i++) {
			if (board[0][i] == 'O')
				bfs(0, i, board);
			if (board[row - 1][i] == 'O')
				bfs(row - 1, i, board);
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}
	}

	public void bfs(int i, int j, char[][] board) {
		fill(i, j, board);

		while (!q.isEmpty()) {
			int n = q.remove();
			int ii = n / board[0].length;
			int jj = n % board[0].length;

			fill(ii - 1, jj, board);
			fill(ii + 1, jj, board);
			fill(ii, jj - 1, board);
			fill(ii, jj + 1, board);
		}
	}

	public void fill(int i, int j, char[][] board) {
		int row = board.length;
		int col = board[0].length;

		if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O')
			return;

		board[i][j] = '*';
		q.add(i * col + j);
	}
}