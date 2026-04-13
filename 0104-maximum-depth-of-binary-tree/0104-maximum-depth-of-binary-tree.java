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
    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return res;
    }
    void dfs(TreeNode root,int c){
        if(root==null){
            return;
        }
        c++;
        res=Math.max(res,c);
        if(root.left!=null){
            dfs(root.left,c);
        }
        if(root.right!=null){
            dfs(root.right,c);
        }
    }

}