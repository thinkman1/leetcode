/**
 * O(n) space
 * 
 * @author thinkman
 *
 */
public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle.size() == 0) return 0;

		int row = triangle.size();
		int res[] = new int[row];

		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (i == row - 1) {
					res[j] = triangle.get(i).get(j);
				} else {
					res[j] = Math.min(res[j], res[j + 1])
							+ triangle.get(i).get(j);
				}
			}
		}

		return res[0];
	}
}