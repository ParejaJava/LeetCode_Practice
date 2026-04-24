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
    public boolean isValidBST(TreeNode root) {
        return ValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean ValidBST(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }

        long x = root.val;
        if (left < x && right > x) {
            Boolean leftBool = ValidBST(root.left, left, x);
            Boolean rightBool = ValidBST(root.right, x, right);
            return leftBool && rightBool;
        }
        else {
            return false;
        }
    }
}