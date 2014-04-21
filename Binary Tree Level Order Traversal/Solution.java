/**
 * One queue
 * @author thinkman
 *
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        ArrayList<Integer> vals = new ArrayList<Integer>();
        vals.add(root.val);
        
        while (!queue.isEmpty()) {
            res.add(vals);
            vals = new ArrayList<Integer>();
            
            int size = queue.size();
            int i = 0;
            while (i != size) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                    vals.add(node.left.val);
                }
                
                if (node.right != null) {
                    queue.add(node.right);
                    vals.add(node.right.val);
                }
                i++;
            }
        }
        return res;
    }
}