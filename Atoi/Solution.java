/**
 * Implement atoi to convert a string to an integer.
 * 
 * @author thinkman
 *
 */
public class Solution {
	public int atoi(String str) {
		str = str.trim();
		if (str.length() == 0) return 0;

		boolean neg = false;
		int begin = 0;
		int end = str.length() - 1;
		int i = 0;
		int limit = -Integer.MAX_VALUE;
		
		if (str.charAt(i) < '0') {
			if (str.charAt(i) == '-') {
				neg = true;
				limit = Integer.MIN_VALUE;
			} else if (str.charAt(i) == '+') {
				neg = false;
			} else {
				return 0;
			}
			i++;
		}
		
		if (Character.isDigit(str.charAt(i))) {
			begin = i;
			while (i < str.length()) {
				if (Character.isDigit(str.charAt(i))) {
					i++;
					continue;
				}
				break;
			}
			end = i - 1;
		} else {
			return 0;
		}
		
		String s = str.substring(begin, end + 1);
		int sum = 0;
		for (int j = 0; j < s.length(); j++) {
			
			int digit = Character.digit(s.charAt(j), 10);
			if (sum < limit/10) {
				if (neg) return Integer.MIN_VALUE;
				return Integer.MAX_VALUE;
			}
			
			sum *= 10;
			if (sum < limit + digit) {
				if (neg) return Integer.MIN_VALUE;
				return Integer.MAX_VALUE;
			}
			sum -= digit;
		}
		
		return neg ? sum : -sum;
	}
}
