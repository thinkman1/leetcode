/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	public int sum(TreeNode root, int sum) {
		if (root == null) return 0;

		sum = sum * 10 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		}

		return sum(root.left, sum) + sum(root.right, sum);
	}
}