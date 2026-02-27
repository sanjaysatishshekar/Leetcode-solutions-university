class Solution {
    int mod = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo = new int[n + 1][target + 1];
        for (int[] m: memo) Arrays.fill(m, -1);
        return dp(memo, n, k, target);
    }

    private int dp(int[][] memo, int n, int k, int target) {
        if (target == 0 && n == 0) return 1;
        if (target <= 0 || n == 0) return 0;
        if (memo[n][target] != -1) return memo[n][target]; 

        int ways = 0;
        for (int i = 1; i <= k; i++) {
            ways = (ways + dp(memo, n - 1, k, target - i)) % mod;
        }
        memo[n][target] = ways % mod;
        return memo[n][target];
    }
    
}