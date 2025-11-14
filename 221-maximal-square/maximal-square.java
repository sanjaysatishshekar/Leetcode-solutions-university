class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        for (int[] s: cache) {
            Arrays.fill(s, Integer.MAX_VALUE);
        }
        
        int result = dfs(matrix, 0, 0, cache);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, cache[i][j]);   
            }
        }
        return result * result;
    }

    private int dfs(char[][] matrix, int i, int j,int[][] cache) {
        if (i >= matrix.length || j >= matrix[0].length)
            return 0;
        if (cache[i][j] == Integer.MAX_VALUE) {
            int down = 0, left = 0, diag = 0;
            down = dfs(matrix, i + 1, j, cache);
            left = dfs(matrix, i, j + 1, cache);
            diag = dfs(matrix, i + 1, j + 1, cache);
            cache[i][j] = 0;
            if (matrix[i][j] == '1') {
                cache[i][j] = 1 + Math.min(down, Math.min(left, diag));
            }
        }
        return cache[i][j];
    }
}