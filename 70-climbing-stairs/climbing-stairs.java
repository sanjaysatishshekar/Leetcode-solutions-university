class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // Find all the way so use Math.max
            dp[i] = Math.max(dp[i - 1] + dp[i - 2], dp[i-2] + 1);

        }
            // The condition is dp[i - 1] + dp[i - 2], dp[i-2] + 1
            // because from dp[i - 2] it costs 1 step to reach dp[i]
            // dp[i - 1] is cost to reach dp[i - 1]
            // dp[i - 2] is cost to reach dp[i - 2]
        // System.out.println(Arrays.toString(dp));
        return dp[n];   
    }
}