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
    public int amountOfTime(TreeNode root, int start) {
         Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode startNode = buildParentMap(root, null, parentMap, start);

        // Step 2: BFS
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(startNode);
        visited.add(startNode);

        int minutes = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }

                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }

                // parent
                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    q.offer(parent);
                    visited.add(parent);
                }
            }
        }

        return minutes;
    }

    private TreeNode buildParentMap(TreeNode node, TreeNode parent,
                                    Map<TreeNode, TreeNode> map, int start) {
        if (node == null) return null;

        map.put(node, parent);

        if (node.val == start) return node;

        TreeNode left = buildParentMap(node.left, node, map, start);
        if (left != null) return left;

        return buildParentMap(node.right, node, map, start);
    }
}