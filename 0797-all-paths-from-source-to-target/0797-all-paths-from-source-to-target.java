class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph, path, ans);
        return ans;
    }
    void dfs(int node, int[][] graph,
             List<Integer> path,
             List<List<Integer>> ans) {
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[node]) {
            path.add(next);
            dfs(next, graph, path, ans);
            path.remove(path.size() - 1);
        }
    }
}