class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            boolean halvesAreEven = (r - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    l = mid + 2;
                }
                else {
                    r = mid - 1;
                }
            }
            else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    r = mid - 2; 
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                return nums[mid];
            }
        }
        return nums[l];
    }
}