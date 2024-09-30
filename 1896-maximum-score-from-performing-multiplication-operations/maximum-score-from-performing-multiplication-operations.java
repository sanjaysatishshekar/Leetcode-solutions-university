class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int n = nums.length;
        int[][] memo = new int[m][m];
        return dp(0, 0, nums, multipliers, memo);
    }

    private int dp(int i, int left, int[] nums, int[] mult, int[][] memo) {
        if (i == mult.length) return 0;
        int mul = mult[i];
        int right = nums.length - (i - left) - 1;

        if (memo[i][left] == 0) {
            memo[i][left] = Math.max(mul * nums[left] + dp(i + 1, left + 1, nums, mult, memo),
            mul * nums[right] + dp(i + 1, left, nums, mult, memo));
        }
        return memo[i][left];
    }
}