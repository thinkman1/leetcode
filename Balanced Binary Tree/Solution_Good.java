/**
 * Bottom - up
 * 
 * @author thinkman
 *
 */
public class Solution {
	public boolean isBalanced(TreeNode root) {

		if (getHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}

	public int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftHeight = getHeight(node.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = getHeight(node.right);
		if (rightHeight == -1)
			return -1;

		int diff = Math.abs(leftHeight - rightHeight);
		if (diff > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}