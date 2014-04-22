/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 12) return res;
		restore(0, 0, new StringBuilder(), s, res);
		return res;
	}

	public void restore(int step, int index, StringBuilder sb, String s, ArrayList<String> res) {
		if (step == 4 && index >= s.length()) {
			String dd = sb.toString().substring(0, sb.length() - 1);
			res.add(dd);
			return;
		}

		for (int i = 1; i < 4; i++) {
			if (index + i <= s.length()) {
				String d = s.substring(index, index + i);
				if (isValid(d)) {
					int before = sb.length();
					sb.append(d).append('.');
					restore(step + 1, index + i, sb, s, res);
					sb.delete(before, sb.length());
				}
			}
		}
	}

	public boolean isValid(String s) {
		if (s.charAt(0) == '0')
			return s.equals("0");
		int num = Integer.parseInt(s);
		return num <= 255 && num > 0;
	}
}