class Solution {
    int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
        for (int num: nums) total += num;
        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row: memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return foo(nums, 0, 0, target, memo);
    }

    private int foo(int[] nums, int i, int sum, int target, int[][] memo) {
        if (i == nums.length) {
            if (sum == target) return 1;
            else return 0;
        }
        else {
            if (memo[i][sum + total] != Integer.MIN_VALUE)
                return memo[i][sum + total];
            int add = foo(nums, i + 1, sum + nums[i], target, memo);
            int sub = foo(nums, i + 1, sum - nums[i], target, memo);
            memo[i][sum + total] = add + sub;
            return memo[i][sum + total];
        }

    }
}