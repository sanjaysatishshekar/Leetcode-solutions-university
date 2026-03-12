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
    int total = 0;
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return total;
    }
    private void dfs(TreeNode node, StringBuilder sum) {
        
        if (node == null) return;
        if (node.left == null && node.right == null) {
            sum.append(node.val);
            // System.out.println(node.val + " " + sum + " " + total);
            total += Integer.parseInt(sum.toString());
            sum.deleteCharAt(sum.length() - 1);
            return;
        }
        dfs(node.left, sum.append(node.val));
        sum.deleteCharAt(sum.length() - 1);
        dfs(node.right, sum.append(node.val));
        sum.deleteCharAt(sum.length() - 1);
    }
}