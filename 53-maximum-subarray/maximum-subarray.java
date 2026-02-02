class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currentSum = 0;
        for (int num: nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            currentSum = Math.max(0, currentSum);
        }
        return maxSum;
      
    }
}