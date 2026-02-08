class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int result = 0;
        double suffix = 0;
        int elementToRight = 0;
        for (int i = n - 1; i > -1; i--) {
            if (elementToRight > 0) {
                if (nums[i] > (suffix / elementToRight)) {
                    result++;
                }
            }
            suffix += nums[i];
            elementToRight++;
        }
        return result;
    }
}