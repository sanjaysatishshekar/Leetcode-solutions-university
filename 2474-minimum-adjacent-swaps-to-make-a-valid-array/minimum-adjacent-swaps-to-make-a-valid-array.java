class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int leftMostMinIndex = 0;
        int min = nums[0];
        int rightMostMaxIndex = 0;
        int max = nums[0];

        for (int i = 0; i < n; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                rightMostMaxIndex = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                leftMostMinIndex = i;
            }
        }
        if (rightMostMaxIndex < leftMostMinIndex)
            return (n - 1 - rightMostMaxIndex) + leftMostMinIndex - 1;
        else
            return (n - 1 - rightMostMaxIndex) + leftMostMinIndex;
    }
}