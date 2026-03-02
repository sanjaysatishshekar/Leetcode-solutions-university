class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    dfs(grid, i, j, visit);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visit) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || visit[row][col] || grid[row][col] != '1')
            return;
        visit[row][col] = true;
        dfs(grid, row + 1, col, visit);
        dfs(grid, row - 1, col, visit);
        dfs(grid, row, col + 1, visit);
        dfs(grid, row, col - 1, visit);
    }
}