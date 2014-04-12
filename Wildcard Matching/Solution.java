/**
 * TODO re-write needed
 * 
 * @author thinkman
 *
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		int i = 0, j = 0;
		int lastCheck = 0, star = -1;

		while (i < s.length()) {

			while (j < p.length() && p.charAt(j) == '*') {
				star = j;
				j++;
				lastCheck = i;
			}

			if (j == p.length() || s.charAt(i) != p.charAt(j)
					&& p.charAt(j) != '?') {
				if (star == -1)
					return false;
				j = star + 1;
				i = ++lastCheck;
			} else {
				i++;
				j++;
			}
		}

		while (j < p.length() && p.charAt(j) == '*') {
			j++;
		}

		return j == p.length();
	}
}