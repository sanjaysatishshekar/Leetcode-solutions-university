class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0, sumSoFar = Integer.MIN_VALUE;
        for (int num: nums) {
            currentSum += num;
            sumSoFar = Math.max(sumSoFar, currentSum);
            currentSum = Math.max(currentSum, 0);
        }
        return sumSoFar;
    }
}