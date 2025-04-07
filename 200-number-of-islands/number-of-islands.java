class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    explore(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void explore(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        explore(grid, i + 1, j);
        explore(grid, i - 1, j);
        explore(grid, i, j + 1);
        explore(grid, i, j - 1);
    }
}