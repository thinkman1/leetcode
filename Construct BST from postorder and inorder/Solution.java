/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(inorder, 0, postorder, 0, postorder.length - 1);
	}

	public TreeNode build(int[] inorder, int inBegin, int[] postorder,
			int postBegin, int postEnd) {
		if (postBegin > postEnd)
			return null;

		int val = postorder[postEnd];
		int index = findIndex(val, inorder);
		int leftSize = index - inBegin;

		TreeNode root = new TreeNode(val);
		root.left = build(inorder, inBegin, postorder, postBegin, postBegin
				+ leftSize - 1);
		root.right = build(inorder, inBegin + leftSize + 1, postorder,
				postBegin + leftSize, postEnd - 1);
		return root;
	}

	public int findIndex(int val, int[] inorder) {
		int index = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (val == inorder[i]) {
				index = i;
				break;
			}
		}
		return index;
	}
}