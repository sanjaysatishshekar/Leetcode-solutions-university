class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length < 3)
            return Math.max(nums[0], nums[1]);
        int n = nums.length;

        int resultFirst = solve(nums, 0, n - 2);
        int resultLast = solve(nums, 1, n - 1);

        return Math.max(resultFirst, resultLast);
    }

    public int solve(int[] nums, int start, int end) {
        if (start == end) return nums[start];

        int[] money = new int[nums.length];

        money[start] = nums[start];
        money[start + 1] = Math.max(nums[start + 1], nums[start]);

        for (int i = start + 2; i <= end; i++) {
            money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        }
        return money[end];
    }
}