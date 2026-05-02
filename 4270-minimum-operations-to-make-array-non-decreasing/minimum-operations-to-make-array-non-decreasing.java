class Solution {
    public long minOperations(int[] nums) {
        long result = 0;
        for (int i = 0; i + 1 < nums.length; i++) {
            result += Math.max(0, nums[i] - nums[i + 1]);
        }
        return result;
    }
}