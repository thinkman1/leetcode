/**
 * 
 * @author thinkman
 *
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(0, preorder.length-1, preorder, 0, inorder);
    }
    
    public TreeNode builder(int preBegin, int preEnd, int[] preorder, int inBegin, int[] inorder) {
        if (preBegin > preEnd) return null;
        
        int val = preorder[preBegin];
        int index = findIndex(val, inorder);
        int leftSize = index - inBegin;
        
        TreeNode root = new TreeNode(val);
        root.left = builder(preBegin+1, preBegin+leftSize, preorder, inBegin, inorder);
        root.right = builder(preBegin+leftSize+1, preEnd, preorder, inBegin+leftSize+1, inorder);
        
        return root;
    }
    
    public int findIndex(int val, int[] inorder) {
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        return index;
    }
}