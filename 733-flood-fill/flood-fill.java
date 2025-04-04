class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int oldcolor, int color) {
        if (i >= image.length || i < 0 || j >= image[0].length || j < 0 || image[i][j] == color)
            return;
        if (image[i][j] == oldcolor){
            image[i][j] = color;
            if (i + 1 < image.length)
                dfs(image, i + 1, j, oldcolor, color);
            if (i - 1 >= 0) 
                dfs(image, i - 1, j, oldcolor, color);
            if (j + 1 < image[0].length) 
                dfs(image, i, j + 1, oldcolor, color);
            if (j - 1 >= 0)
                dfs(image, i, j - 1, oldcolor, color);
        }
    }
}