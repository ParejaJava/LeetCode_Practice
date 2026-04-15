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
    List<Integer> paths) { // 严肃学习这段代码，进来第一件事加，出去最后一件事删，完美的递归回溯
        paths.add(root.val);  
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                res.add(new ArrayList<>(paths));
            }
        }
        else { //这个else是灵魂，因为在排除叶子节点的寻找过程中，不需要做paths的回退操作
        if (root.left != null) traversal(root.left, targetSum - root.val, res, paths);
        if (root.right != null) traversal(root.right, targetSum - root.val, res, paths);
        }
        paths.remove(paths.size()-1);
    }
}