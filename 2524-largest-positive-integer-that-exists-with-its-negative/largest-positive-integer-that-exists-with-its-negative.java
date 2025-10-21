class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1; 
        int result = -1; 
        Arrays.sort(nums);
        int left = 0, right = 0;
        while (l < r) {
            left = 0; right = 0;
            if (nums[l] < 0 && nums[r] > 0) {
                left = Math.abs(nums[l]);
                right = nums[r];
            }
            else {
                return result;
            }
            if (left < right) {
                r--;
            }
            else if (right < left) {
                l++;
            }
            else {
                result = Math.max(result, right);
                return result;
            }
        }
        return result;
    }
}

