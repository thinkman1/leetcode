/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode prev = null;

		while (!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					res.add(stack.pop().val);
				}
			} else if (prev == curr.left) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					res.add(stack.pop().val);
				}
			} else if (prev == curr.right) {
				res.add(stack.pop().val);
			}

			prev = curr;
		}

		return res;
	}
}