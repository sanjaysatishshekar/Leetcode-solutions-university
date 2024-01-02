class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i - 2] + nums[i - 1]);
            // Condition is dp[i-1], dp[i - 2] + nums[i - 1]
            // Because dp[i - 1] is the highest bounty till i - 1
            // dp[i - 2] + nums[i - 1] if you are stealing the current house
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}

// 1 2 3 1