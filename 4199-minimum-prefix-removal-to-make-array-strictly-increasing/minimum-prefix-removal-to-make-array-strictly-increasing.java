class Solution {
    public int minimumPrefixLength(int[] nums) {
        int result = 0;
        int top = -1;
        int n = nums.length;
        int prev = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (top == -1) {
                prev = nums[i];
                top = i;
                continue;
            }
            else {
                if (nums[top] <= nums[i]) {
                    return i + 1;
                }
                else {
                    top--;
                    prev = nums[i];
                }
            }
        }
        return 0;
    }
}