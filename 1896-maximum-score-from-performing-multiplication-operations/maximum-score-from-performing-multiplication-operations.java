class Solution {

    private int dp(int i, int left, int[] nums, int[] mults, int[][] memo) {
        if (i == mults.length)
            return 0;

        int mul = mults[i];
        int right = nums.length - 1 - (i - left);

        if (memo[i][left] == 0) {
            memo[i][left] = Math.max(
                    mul * nums[left] + dp(i + 1, left + 1, nums, mults, memo),
                    mul * nums[right] + dp(i + 1, left, nums, mults, memo));
        }
        return memo[i][left];
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] memo = new int[m][m];
        return dp(0, 0, nums, multipliers, memo);
    }
}