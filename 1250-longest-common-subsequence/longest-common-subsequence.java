class Solution {
    private int dp(int i, int j, String a, String b, int[][] memo) {
        if (i < 0 || j < 0) return 0;
        if (i == 0 && j == 0) return a.charAt(i) == b.charAt(j) ? 1 : 0;
        if (memo[i][j] == -1)  {
            if (a.charAt(i) == b.charAt(j))
                memo[i][j] = dp(i - 1, j - 1, a, b, memo) + 1;
            else 
                memo[i][j] = Math.max(dp(i - 1, j, a, b, memo), dp(i, j - 1, a, b, memo));
        }
        return memo[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dp(m - 1, n - 1, text1, text2, memo);
    }
}