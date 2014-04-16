/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public int largestRectangleArea(int[] height) {
		int[] h = Arrays.copyOf(height, height.length + 1);
		int i = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int res = 0;
		while (i < h.length) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i++);
			} else {
				int foo = stack.pop();
				res = Math.max(res, h[foo] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return res;
	}
}