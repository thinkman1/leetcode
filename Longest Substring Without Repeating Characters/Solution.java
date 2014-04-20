public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int[] table = new int[256];
		int n = s.length();
		int res = 0;
		int end = 0, start = 0;
		for (end = 0; end < s.length(); end++) {
			if (table[s.charAt(end)] == 0) {
				table[s.charAt(end)]++;
			} else {
				res = Math.max(res, end - start);
				while (s.charAt(start) != s.charAt(end)) {
					table[s.charAt(start++)]--;
				}

				start++;
			}
		}
		res = Math.max(res, s.length() - start);

		return res;
	}
}