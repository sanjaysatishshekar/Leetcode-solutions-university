class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int m = image.length;
        int n = image[0].length;
        int old = image[sr][sc];
        dfs(image, sr, sc, old, color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int old, int color) {
        if (i < 0 || i == image.length || j < 0 || j == image[0].length || image[i][j] != old)
            return;
        image[i][j] = color;
        dfs(image, i + 1, j, old, color);
        dfs(image, i - 1, j, old, color);
        dfs(image, i, j + 1, old, color);
        dfs(image, i, j - 1, old, color);
    }
}