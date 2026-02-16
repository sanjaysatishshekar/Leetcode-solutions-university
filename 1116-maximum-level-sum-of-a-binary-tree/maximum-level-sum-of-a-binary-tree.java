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
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> levels = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levels.put(level, levels.getOrDefault(level, 0) + node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            level++;
        }
        int maxSum = Integer.MIN_VALUE;
        int result = 0;
        for (int l: levels.keySet()) {
            if (maxSum < levels.get(l)) {
                maxSum = levels.get(l);
                result = l;
            }
        }
        return result;        
    }
}