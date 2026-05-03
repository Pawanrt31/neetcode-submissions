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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int depth = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pairNode = stack.pop();
            TreeNode node = pairNode.getKey();
            int currentDepth = pairNode.getValue();
            if(node != null) {
                depth = Math.max(depth, currentDepth);
                stack.push(new Pair<>(node.left, currentDepth + 1));
                stack.push(new Pair<>(node.right, currentDepth + 1));
            }
        }
        return depth;
    }
}
