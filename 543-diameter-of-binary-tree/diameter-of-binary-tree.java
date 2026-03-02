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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] result = new int[1];
        dfs(root, 0, result);
        return result[0];
    }

    private int dfs(TreeNode node, int level, int[] result) {
        if (node == null) return -1;
        int left = 1 + dfs(node.left, level + 1, result);
        int right = 1 + dfs(node.right, level + 1, result);
        result[0] = Math.max(result[0], left + right);
        return Math.max(left, right); 

    }
}