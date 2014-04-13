/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		// res[i] s[0].. s[i] # of decode ways
		int[] res = new int[s.length() + 1];
		res[0] = 1;
		if (s.charAt(0) == '0') return 0;
		res[1] = 1;

		for (int i = 2; i < s.length() + 1; i++) {
			String b = s.substring(i - 1, i);
			int val = Integer.parseInt(b);

			if (val != 0) {
				res[i] = res[i - 1];
			}
			if (s.charAt(i - 2) != '0') {
				String bb = s.substring(i - 2, i);
				int val2 = Integer.parseInt(bb);
				if (val2 >= 1 && val2 <= 26) {
					res[i] = res[i] + res[i - 2];
				}
			}
		}

		return res[s.length()];
	}
}