class Solution {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int m = nums2.length;
        int n = nums1.length;
        long NEG = Long.MIN_VALUE / 4;
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        for (long[][] a: dp) {
            for (long[] b: a) {
                Arrays.fill(b, NEG);
            }
        }
        dp[0][0][0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int t = 0; t <= k; t++) {
                    if (i > 0) dp[i][j][t] = Math.max(dp[i][j][t], dp[i - 1][j][t]);
                    if (j > 0) dp[i][j][t] = Math.max(dp[i][j][t], dp[i][j - 1][t]);
                    if (i > 0 && j > 0 && t > 0 && dp[i - 1][j - 1][t - 1] != NEG) {
                        dp[i][j][t] = Math.max(dp[i][j][t], dp[i - 1][j - 1][t - 1] + 1L * nums1[i - 1] * nums2[j - 1]);
                    }
                }
            }
        }
        return dp[n][m][k];

        
        // dp = new long[101][101][101];
        // for (long[][] a: dp) {
        //     for (long[] b: a) {
        //         Arrays.fill(b, NEG);
        //     }
        // }
        // return solve(nums1, nums2, 0, 0, k);
    }

    // private long solve(int[] a, int[] b, int i, int j, int k) {
    //     if (k == 0) return 0;
    //     if (i == a.length || j == b.length) return NEG;
    //     if (dp[i][j][k] != NEG) return dp[i][j][k];
    //     long take = (1L * a[i] * b[j]) + solve(a, b, i + 1, j + 1, k - 1);
    //     long skip1 = solve(a, b, i + 1, j, k);
    //     long skip2 = solve(a, b, i, j + 1, k);
    //     return dp[i][j][k] = Math.max(take, Math.max(skip1, skip2));
    // }
}