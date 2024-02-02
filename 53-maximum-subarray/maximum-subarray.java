class Solution {
    // public int maxSubArray(int[] nums) {
    //     int maxSoFar = 0;
    //     int maxFinal = Integer.MIN_VALUE;
    //     for (int num: nums) {
    //         maxSoFar = Math.max(maxSoFar, num + maxSoFar);
    //         maxFinal = Math.max(maxFinal, maxSoFar);
    //         if (maxSoFar > 0) maxSoFar = 0;
    //     } 
    //     return maxFinal;
    // }

    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxFinal = nums[0];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (currentSum < 0)
                currentSum = 0;
            currentSum += nums[i];
            maxFinal = Math.max(maxFinal, currentSum);
        }
        return maxFinal;
    }
}