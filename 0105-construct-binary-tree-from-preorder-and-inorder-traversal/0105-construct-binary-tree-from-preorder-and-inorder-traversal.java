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
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        int len = inorder.length;
        return cut(inorder, 0, len, preorder, 0, len);
    }

    private TreeNode cut(int[] inorder, int inBegin, int inEnd, 
    int[] preorder, int preBegin, int preEnd) {
        if (inBegin >= inEnd || preBegin >= preEnd) {
            return null;
        }
        int rootVal = preorder[preBegin];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inorderMap.get(rootVal);
        int leftSize = rootIndex - inBegin;
        root.left = cut(inorder, inBegin, rootIndex, 
        preorder, preBegin+1, preBegin+1+leftSize);
        root.right = cut(inorder, rootIndex+1, inEnd, 
        preorder, preBegin+1+leftSize, preEnd);
        return root;
    }
}