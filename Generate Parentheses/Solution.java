/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<String>();
		if (n == 0)
			return res;

		generateParenthesis(res, new StringBuilder(), 0, 0, n);
		return res;
	}

	public void generateParenthesis(ArrayList<String> res, StringBuilder sb,
			int left, int right, int n) {
		if (left + right == 2 * n) {
			res.add(sb.toString());
			return;
		}

		if (left < n) {
			int before = sb.length();
			sb.append("(");
			generateParenthesis(res, sb, left + 1, right, n);
			sb.delete(before, sb.length());
		}

		if (right < left) {
			int before = sb.length();
			sb.append(")");
			generateParenthesis(res, sb, left, right + 1, n);
			sb.delete(before, sb.length());
		}
	}
}