public class Solution {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || dict == null)
			return res;

		boolean[][] seg = new boolean[s.length()][s.length() + 1];
		// seg[i][j] means s.substring(i, j) can be segmented into dictionary words
		for (int len = 1; len <= s.length(); len++) {
			for (int i = 0; i < s.length() - len + 1; i++) {
				String t = s.substring(i, i + len);
				if (dict.contains(t)) {
					seg[i][len] = true;
					continue;
				}
				for (int k = 0; k < len; k++) {
					if (seg[i][k] && seg[i + k][len - k]) {
						seg[i][len] = true;
						break;
					}
				}
			}
		}
		if (seg[0][s.length()] == false)
			return res;

		work(0, s.length(), s, res, new StringBuffer(), dict, seg);
		return res;
	}

	protected void work(int index, int length, String s, ArrayList<String> res,
			StringBuffer sb, Set<String> dict, boolean[][] seg) {

		if (index == s.length()) {
			String str = sb.toString();
			res.add(str.substring(0, str.length() - 1));
			return;
		}

		for (int len = 1; len <= length; len++) {
			if (seg[index][len]) {
				String word = s.substring(index, index + len);
				if (dict.contains(word)) {
					int beforeAdd = sb.length();
					sb.append(word).append(" ");
					work(index + len, length, s, res, sb, dict, seg);
					sb.delete(beforeAdd, sb.length());
				}
			}
		}
	}
}