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
    int res=0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return res;
    }
        void dfs(TreeNode root){
        if(root==null){
            return;
          }
        res++;
        dfs(root.left);
        dfs(root.right);

    }
}