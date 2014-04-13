/**
 * O(1) space, non-recusion
 * @author thinkman
 *
 */
public class Solution {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left == null) {
				res.add(curr.val);
				curr = curr.right;
			} else {
				TreeNode foo = curr.left;
				while (foo.right != null && foo.right != curr) {
					foo = foo.right;
				}

				if (foo.right == null) {
					foo.right = curr;
					curr = curr.left;
				} else {
					res.add(curr.val);
					foo.right = null;
					curr = curr.right;
				}
			}
		}

		return res;
	}
}