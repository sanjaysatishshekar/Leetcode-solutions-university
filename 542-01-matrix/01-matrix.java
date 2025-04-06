// class State {
//     int row, col, steps;
//     State(int row, int col, int steps) {
//         this.row = row;
//         this.col = col;
//         this.steps = steps;
//     }
// }
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    q.offer(new int[] { i, j });
                else
                    mat[i][j] = -1;
            }
        }
        int[][] d = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0], c = temp[1];
            for (int i = 0; i < d.length; i++) {
                int nr = r + d[i][0], nc = c + d[i][1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1)
                    continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.offer(new int[] { nr, nc });
            }
        }
        return mat;
    }
}