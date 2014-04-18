/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2)) return true;
		
		int len1 = s1.length(), len2 = s2.length();
		if (len1 != len2) return false;

		int[] chars = new int[256];

		for (int i = 0; i < len1; i++) {
			chars[s1.charAt(i)]++;
		}
		for (int i = 0; i < len2; i++) {
			chars[s2.charAt(i)]--;
		}
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != 0) return false;
		}

		for (int i = 1; i < len1; i++) {
			boolean valid1 = isScramble(s1.substring(0, i), s2.substring(0, i))
									&& isScramble(s1.substring(i), s2.substring(i));
			boolean valid2 = isScramble(s1.substring(0, i), s2.substring(len1 - i))
									&& isScramble(s1.substring(i), s2.substring(0, len1 - i));

			if (valid1 || valid2) return true;
		}

		return false;
	}
}