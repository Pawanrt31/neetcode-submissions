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
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] maxi = {Integer.MIN_VALUE};
        getMaxPath(root, maxi);
        return maxi[0];
    }

    private int getMaxPath(TreeNode root, int[] maxi) {
        if(root == null) {
            return 0;
        }
        int leftPath = Math.max(getMaxPath(root.left, maxi), 0);
        int rightPath = Math.max(getMaxPath(root.right, maxi), 0);

        maxi[0] = Math.max(maxi[0], leftPath + rightPath + root.val);

        return Math.max(leftPath, rightPath) + root.val;
    }
}
