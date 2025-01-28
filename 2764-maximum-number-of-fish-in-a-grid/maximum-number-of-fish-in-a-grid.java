class Solution {
    int result = 0;
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && !visit[i][j]) {
                    result = Math.max(result, dfs(grid, visit, i, j));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, boolean[][] visit, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0 || visit[i][j])
            return 0;
        
        visit[i][j] = true;

        return grid[i][j] + dfs(grid, visit, i + 1, j) + 
        dfs(grid, visit, i - 1, j) +
        dfs(grid, visit, i, j + 1) +
        dfs(grid, visit, i, j - 1);
    }
}