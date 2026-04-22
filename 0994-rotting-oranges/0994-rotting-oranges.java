class Solution {
    public int orangesRotting(int[][] grid) {
           int m = grid.length, n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: initialize queue and count fresh
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If no fresh oranges
        if (fresh == 0) return 0;

        int minutes = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] d : dir) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];

                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        fresh--;
                        rottedThisRound = true;
                    }
                }
            }

            if (rottedThisRound) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}