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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, res, paths);
        return res;
    }

    void traversal(TreeNode root, List<String> res, List<Integer> paths) {
        paths.add(root.val);
        // 终止条件
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            int size = paths.size();
            for (int i = 0; i < size - 1; i++) {
                sb.append(paths.get(i));
                sb.append("->");
            }
            sb.append(paths.get(size-1));
            res.add(sb.toString());
        }

        if (root.left != null) {
            traversal(root.left, res, paths);
            paths.remove(paths.size()-1);
        }
        if (root.right != null) {
            traversal(root.right, res, paths);
            paths.remove(paths.size()-1);
        }
    }
}