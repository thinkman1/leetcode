package leet.code;

import java.util.ArrayList;
import java.util.List;

public class ReplaceString {

	/**
	 * s is the String which contains J, K or ?, replace ? with J and K, return
	 * all possible String
	 * 
	 * @param s
	 * @return
	 */
	public List<String> replaceString(String s) {

		List<String> res = new ArrayList<String>();
		char[] chars = { 'J', 'K' };
		work(0, s, res, chars, new StringBuilder());

		return res;
	}

	private void work(int step, String s, List<String> res, char[] chars, StringBuilder sb) {
		
		
		if (sb.length() == s.length()) {
			res.add(sb.toString());
			return;
		}
		
		for (int i = step; i < s.length(); i++) {
			
			if (s.charAt(i) != '?') {
				sb.append(s.charAt(i));
				if (sb.length() == s.length()) {
					res.add(sb.toString());
					return;
				}
			} else {
				for (int j = 0; j < chars.length; j++) {
					int before = sb.length();
					sb.append(chars[j]);
					work(i+1, s, res, chars, sb);
					sb.delete(before, sb.length());
				}
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReplaceString foo = new ReplaceString();
		List<String> res = foo.replaceString("?J?K?");

		for (String s : res) {
			System.out.println(s);
		}

	}

}
