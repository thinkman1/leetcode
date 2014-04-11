/**
 * @author thinkman
 */
public class Solution {
	public int[] plusOne(int[] digits) {
		int i = digits.length - 1;

		while (i >= 0 && digits[i] == 9) {
			digits[i] = 0;
			i--;
		}

		if (i == -1) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}

		digits[i] += 1;
		return digits;
	}
}

/**
 * Neat!
 */
public class Solution {
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				return digits;
			} else {
				digits[i] = 0;
			}
		}

		int[] res = new int[digits.length + 1];
		Arrays.fill(res, 0);
		res[0] = 1;
		return res;
	}
}