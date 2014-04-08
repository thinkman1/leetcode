/**
 * 
 * @author thinkman
 * 
 */
public class Solution {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		int[] columns = new int[n];
		Arrays.fill(columns, -1);
		putQueen(0, columns, res);
		return res;
	}

	public void putQueen(int row, int[] columns, ArrayList<String[]> res) {
		if (row == columns.length) {
			String[] sol = convert(columns);
			res.add(sol);
			return;
		}

		for (int i = 0; i < columns.length; i++) {
			if (columns[i] == -1 && isValid(row, i, columns)) {
				columns[i] = row;
				putQueen(row + 1, columns, res);
				columns[i] = -1;
			}
		}
	}

	public boolean isValid(int row, int col, int[] columns) {
		for (int i = 0; i < columns.length; i++) {
			if (columns[i] != -1
					&& (columns[i] == row || Math.abs(col - i) == Math.abs(row
							- columns[i]))) {
				return false;
			}
		}

		return true;
	}

	public String[] convert(int[] columns) {
		int n = columns.length;
		char[][] matrix = new char[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(matrix[i], '.');
		}

		String[] res = new String[n];

		for (int i = 0; i < n; i++) {
			int row = columns[i];
			matrix[row][i] = 'Q';

			res[row] = String.valueOf(matrix[row]);
		}

		return res;
	}
}