class Solution {
    public int findMin(int[] nums) {
        int result = nums[0];
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] <= nums[right])
                result = Math.min(result, nums[left]);
            int mid = left + (right - left) / 2;
            result = Math.min(result, nums[mid]);
            if (nums[mid] >= nums[left])
                left = mid + 1;
            else
                right = mid - 1;                
        }
        return result;
    }
}