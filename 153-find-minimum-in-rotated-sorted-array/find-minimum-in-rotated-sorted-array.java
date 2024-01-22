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
    
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0]; 
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[l] <= nums[mid] && nums[l] < nums[r]) {
                return nums[l];
            }
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
       } 
       return nums[l];
    }
}
