class Solution {
    // public int climbStairs(int n) {
    //     int[] memo = new int[n + 1];
    //     Arrays.fill(memo, -1);
    //     return dp(n, memo);
    // }

    // private int dp(int n, int[] memo) {
    //     if (n <= 1) return 1;
    //     if (memo[n] != -1) return memo[n];
    //     return memo[n] = dp(n - 2, memo) + dp(n - 1, memo);
    // }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}