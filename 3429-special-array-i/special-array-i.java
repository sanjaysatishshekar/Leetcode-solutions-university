class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int x = nums[i] % 2;
            int y = nums[i-1] % 2;
            if (x == y) return false;
        }
        return true;
    }
}