/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> tree = new ArrayList<>();
        inorder(root, tree);
        for (int i = 1; i < tree.size(); i++) {
            if (tree.get(i) <= tree.get(i - 1))
                return false;
        }    
        return true;
    }

    private void inorder(TreeNode root, List<Integer> tree) {
        if (root == null) return;
        inorder(root.left, tree);
        tree.add(root.val);
        inorder(root.right, tree);
    }
}