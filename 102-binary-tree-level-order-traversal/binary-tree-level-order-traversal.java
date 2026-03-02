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
        if (root == null) return result;
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (result.size() == level) result.add(new ArrayList<Integer>());
        result.get(level).add(root.val);
        if (root.left != null) dfs(root.left, level + 1, result);
        if (root.right != null) dfs(root.right, level + 1, result);
    }

    // BFS
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     if (root != null) 
    //         queue.offer(root);
    //     List<Integer> level = new ArrayList<>();
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = queue.poll();
    //             level.add(node.val);
    //             if (node.left != null) queue.offer(node.left);
    //             if (node.right != null) queue.offer(node.right);
    //         }
    //         result.add(new ArrayList<>(level));
    //         level.clear();
    //     }
    //     return result;
    // }
}