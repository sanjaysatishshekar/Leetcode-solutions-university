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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int depth, List<Integer> result) {
        if (root == null) return;
        if (depth == result.size()) result.add(root.val);
        dfs(root.right, depth + 1, result);
        dfs(root.left, depth + 1, result);
    }
}