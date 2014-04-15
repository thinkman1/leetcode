/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> rs = new ArrayList<Integer>();
		rs.add(1);
		if (rowIndex == 0)
			return rs;

		for (int i = 1; i <= rowIndex; i++) {
			rs.add(0, 1);
			for (int j = 1; j <= i - 1; j++) {
				rs.set(j, rs.get(j) + rs.get(j + 1));
			}
		}

		return rs;
	}
}