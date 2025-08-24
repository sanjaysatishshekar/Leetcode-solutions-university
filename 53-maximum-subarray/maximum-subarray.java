class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0, maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            currentSum = Math.max(0, currentSum);
        }
        return maxSum;
    }
}