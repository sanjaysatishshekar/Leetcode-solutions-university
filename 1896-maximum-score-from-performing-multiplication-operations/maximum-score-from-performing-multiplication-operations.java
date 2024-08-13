class Solution {

    // private int dp(int i, int left, int[] nums, int[] mults, int[][] memo) {
    //     if (i == mults.length)
    //         return 0;

    //     int mul = mults[i];
    //     int right = nums.length - 1 - (i - left);

    //     if (memo[i][left] == 0) {
    //         memo[i][left] = Math.max(
    //                 mul * nums[left] + dp(i + 1, left + 1, nums, mults, memo),
    //                 mul * nums[right] + dp(i + 1, left, nums, mults, memo));
    //     }
    //     return memo[i][left];
    // }

    // public int maximumScore(int[] nums, int[] multipliers) {
    //     int n = nums.length;
    //     int m = multipliers.length;
    //     int[][] memo = new int[m][m];
    //     return dp(0, 0, nums, multipliers, memo);
    // }

    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int mul = multipliers[i];
                int right = n - 1 - (i - left);
                dp[i][left] = Math.max(
                    mul * nums[left] + dp[i + 1][left + 1],
                    mul * nums[right] + dp[i + 1][left]
                );
            }
        }
        return dp[0][0];
    }
}