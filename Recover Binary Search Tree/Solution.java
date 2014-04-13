/**
 * constant space
 * @author thinkman
 *
 */
public class Solution {
	public void recoverTree(TreeNode root) {
		TreeNode n1 = null, n2 = null;
		TreeNode parent = null;
		while (root != null) {
			if (root.left == null) {

				if (parent != null && parent.val > root.val) {
					if (n1 == null) {
						n1 = parent;
					}
					n2 = root;
				}
				parent = root;
				root = root.right;
			} else {
				TreeNode foo = root.left;
				while (foo.right != null && foo.right != root) {
					foo = foo.right;
				}

				if (foo.right != root) {
					foo.right = root;
					root = root.left;
				} else {
					foo.right = null;
					if (parent.val > root.val) {
						if (n1 == null) {
							n1 = parent;
						}
						n2 = root;
					}
					parent = root;
					root = root.right;
				}
			}
		}

		int val = n1.val;
		n1.val = n2.val;
		n2.val = val;
	}
}