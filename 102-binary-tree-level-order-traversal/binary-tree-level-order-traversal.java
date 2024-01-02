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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, 0, result);
        return result;
    }

    public void levelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() == level) {
            List<Integer> l = new ArrayList<>();
            result.add(l);
        }
        result.get(level).add(root.val);
        levelOrder(root.left, level + 1, result);
        levelOrder(root.right, level + 1, result);
    }
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     Queue<TreeNode> q = new LinkedList<>();
    //     if (root == null) return result;
    //     q.add(root);
    //     while(!q.isEmpty()) {
    //         int size = q.size();
    //         List<Integer> level = new ArrayList<>();
    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = q.poll();
    //             if (node != null) level.add(node.val);
    //             if (node.left != null) q.add(node.left);
    //             if (node.right != null) q.add(node.right); 
    //         }
    //         result.add(level);
    //     }
    //     return result;
    // }
}