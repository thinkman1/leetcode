/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		return isMatch(s, 0, p, 0);
	}

	public boolean isMatch(String s, int i, String p, int j) {
		if (j == p.length())
			return i == s.length();

		if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
			if (!charMatch(s, i, p, j)) {
				return false;
			} else {
				return isMatch(s, i + 1, p, j + 1);
			}
		}

		if (isMatch(s, i, p, j + 2))
			return true;

		while (charMatch(s, i, p, j)) {
			if (isMatch(s, i + 1, p, j + 2)) {
				return true;
			}
			i++;
		}

		return false;
	}

	public boolean charMatch(String s, int i, String p, int j) {
		if (i >= s.length() || j >= p.length())
			return false;

		return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
	}
}