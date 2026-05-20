class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int k = n - 1;
        int[] result = new int[n];
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[k] = nums[left] * nums[left];
                left++;
            }
            else {
                result[k] = nums[right] * nums[right];
                right--;
            }
            k--;
        }
        return result;
        
    }
}