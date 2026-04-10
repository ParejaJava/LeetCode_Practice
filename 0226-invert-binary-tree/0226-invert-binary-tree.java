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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        swapChildren(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swapChildren(TreeNode r) {
        TreeNode tmp = r.left;
        r.left = r.right;
        r.right = tmp;
    }
}