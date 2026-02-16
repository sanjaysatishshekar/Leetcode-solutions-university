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

class Pair {
    TreeNode node;
    int index;
    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int index = 0;
            int start = q.peek().index;
            
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                index = p.index;
                if (node.left != null) q.offer(new Pair(node.left, 2 * index + 1));
                if (node.right != null) q.offer(new Pair(node.right, 2 * index + 2));
            }
            result = Math.max(result, index - start + 1);
        }
        return result;
    }
}