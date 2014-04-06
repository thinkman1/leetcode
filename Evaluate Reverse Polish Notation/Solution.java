/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public int evalRPN(String[] tokens) {
		if (tokens.length == 0)
			return 0;
		Stack<String> stack = new Stack<String>();
		int res = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (isNum(tokens[i])) {
				stack.push(tokens[i]);
			} else {
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				res = compute(a, b, tokens[i]);
				stack.push(String.valueOf(res));
			}
		}

		return Integer.parseInt(stack.pop());
	}

	public boolean isNum(String str) {
		return !"*".equals(str) && !"+".equals(str) && !"-".equals(str)
				&& !"/".equals(str);
	}

	public int compute(int i, int j, String op) {
		if ("*".equals(op))
			return i * j;
		if ("+".equals(op))
			return i + j;
		if ("-".equals(op))
			return j - i;

		return j / i;
	}
}