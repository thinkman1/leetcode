/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public ArrayList<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return generate(1, 0);
		}
		return generate(1, n);
	}

	public ArrayList<TreeNode> generate(int start, int end) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null);
			return res;
		}

		for (int i = start; i <= end; i++) {

			ArrayList<TreeNode> left = generate(start, i - 1);
			ArrayList<TreeNode> right = generate(i + 1, end);

			for (int j = 0; j < left.size(); j++) {
				for (int k = 0; k < right.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(j);
					root.right = right.get(k);
					res.add(root);
				}
			}
		}
		return res;
	}
}