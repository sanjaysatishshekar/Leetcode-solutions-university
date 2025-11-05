class Solution {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int len = present.length;
        int[] dp = new int[budget + 1];
        for (int i = 0; i < len; i++) {
            int profit = future[i] - present[i];
            for (int j = budget; j >= present[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - present[i]] + profit);
            }
            // System.out.println(Arrays.toString(dp));
        }
        return dp[budget];
    }
}