class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int result = coinCount(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int coinCount(int[] coins, int amount, int[] dp) {
        if (amount < 0) return Integer.MAX_VALUE;
        if (amount == 0) return 0;
        if (dp[amount] != -1) return dp[amount];
        int minCount = Integer.MAX_VALUE;
        for (int coin: coins) {
            int answer = coinCount(coins, amount - coin, dp);
            if (answer != Integer.MAX_VALUE) {
                minCount = Math.min(minCount, answer + 1);
            }
        }
        dp[amount] = minCount;
        return dp[amount];
    }
}