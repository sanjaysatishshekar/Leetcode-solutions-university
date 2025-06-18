class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (explore(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean explore(char[][] board, int i, int j, String word, int k) {
        if (k >= word.length()) return true;
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || word.charAt(k) != board[i][j]) return false;
        board[i][j] = '#';
        int[] r = {0, 0, 1, -1};
        int[] c = {1, -1, 0, 0};
        for (int d = 0; d < 4; d++) {
            if (explore(board, i + r[d], j + c[d], word, k + 1))
                return true;
        }
        board[i][j] = word.charAt(k);
        return false;

    }
}