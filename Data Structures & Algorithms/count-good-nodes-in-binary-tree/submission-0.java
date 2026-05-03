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
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, root.val);
    }

    private int goodNodesHelper(TreeNode node, int value) {
        if(node == null) {
            return 0;
        }

        int res = node.val >= value ? 1 : 0;
        value = Math.max(value, node.val);
        res += goodNodesHelper(node.left, value);
        res += goodNodesHelper(node.right, value);
        return res;
    }
}
