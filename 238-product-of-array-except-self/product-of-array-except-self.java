class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int product = 1;
        prefix[0] = product;
        for (int i = 1; i < n; i++) {
            product = product * nums[i - 1];
            prefix[i] = product;
        }
        product = 1;
        for (int i = n - 2; i >= 0; i--) {
            product = product * nums[i + 1];
            prefix[i] = prefix[i] * product;
        }
        return prefix;
    }
}