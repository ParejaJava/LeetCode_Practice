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
    // 这一版是左闭右开写法，以后都坚持这种写法
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return cut(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode cut(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart >= inEnd || postStart >= postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd-1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inorderMap.get(rootVal);
        int leftSize = rootIndex - inStart;
        root.left = cut(inorder, inStart, rootIndex, 
                    postorder, postStart, postStart+leftSize);
        root.right = cut(inorder, rootIndex+1, inEnd, 
                    postorder, postStart+leftSize, postEnd-1);
        return root;
    }
}