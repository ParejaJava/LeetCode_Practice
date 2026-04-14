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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        if (root == null) {
            return res;
        }
        traversal(root, targetSum, res, paths);
        return res;
    }

    private void traversal(TreeNode root, int targetSum, List<List<Integer>> res, 
    List<Integer> paths) {
        paths.add(root.val);  
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                res.add(new ArrayList<>(paths));
                return;
            }
            else {
                return;
            }
        }
        if (root.left != null){
            traversal(root.left, targetSum - root.val, res, paths);
            paths.remove(paths.size()-1);
        }
        if (root.right != null) {
            traversal(root.right, targetSum - root.val, res, paths);
            paths.remove(paths.size()-1);
        }
        return;
    }
}