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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> al = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
         while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> al2 = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                 TreeNode temp = q.poll();
                 al2.add(temp.val);
                 if(temp.left!=null){
                    q.offer(temp.left);
                 }
                 if(temp.right!=null){
                    q.offer(temp.right);
                 }
            }
            al.add(al2);
         }
         return al;
    }
}