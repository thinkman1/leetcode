/**
 * DP
 * 
 * @author thinkman
 *
 */
public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 0; i <= s.length(); i++) {
			for (int k = 0; k < i; k++) {
				if (dp[k] && dict.contains(s.substring(k, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}
}