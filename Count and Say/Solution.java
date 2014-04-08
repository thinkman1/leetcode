/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public String countAndSay(int n) {
		String[] res = new String[n];
		res[0] = "1";
		for (int i = 1; i < n; i++) {
			res[i] = generate(res[i - 1]);
		}
		return res[n - 1];
	}

	public String generate(String ss) {
		StringBuilder sb = new StringBuilder();
		int n = ss.length();
		int count = 1;
		for (int i = 0; i < n; i++) {
			if (i > 0 && ss.charAt(i - 1) == ss.charAt(i)) {
				count++;
			} else if (i == 0) {
				continue;
			} else {
				sb.append(count).append(ss.charAt(i - 1));
				count = 1;
			}
		}

		sb.append(count).append(ss.charAt(n - 1));

		return sb.toString();
	}
}