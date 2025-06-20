class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        boolean[][] seen = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, dfs(grid, seen, i, j));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, boolean[][] seen, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || seen[i][j] || grid[i][j] == 0)
            return 0;
        seen[i][j] = true;
        return 1 + dfs(grid, seen, i + 1, j) + dfs(grid, seen, i - 1, j) + dfs(grid, seen, i, j + 1)
                + dfs(grid, seen, i, j - 1);
    }
}