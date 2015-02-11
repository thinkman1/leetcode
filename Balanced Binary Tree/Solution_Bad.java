/**
 * top-down
 * 
 * @author thinkman
 *
 */
public class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		int left = depth(root.left);
		int right = depth(root.right);
		
		if (Math.abs(left - right) > 1) {
			return false;
		}
		
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		if (node.left != null || node.right != null) {
			return 1 + Math.max(depth(node.left), depth(node.right));
		}
		
		return 1;
	}
}