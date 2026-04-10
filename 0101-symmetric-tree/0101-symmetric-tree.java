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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode l, TreeNode r) {
        if (l == null && r != null) {
            return false;
        }
        if (r == null && l != null) {
            return false;
        }
        if (l == null && r == null) {
            return true;
        }
        if (l.val != r.val) {
            return false;
        }

        boolean outside = compare(l.left, r.right);
        boolean inside = compare(l.right, r.left);
        return outside && inside;
    }

}