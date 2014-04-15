/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public int maxArea(int[] height) {
		int start = 0, end = height.length - 1;
		int vol = Integer.MIN_VALUE;
		while (start < end) {
			int area = Math.min(height[start], height[end]) * (end - start);
			vol = Math.max(area, vol);

			if (height[start] > height[end]) {
				end--;
			} else {
				start++;
			}
		}
		return vol;
	}
}