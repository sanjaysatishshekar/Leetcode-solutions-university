class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int prod = 1;
        result[0] = prod;
        for (int i = 1; i < n; i++) {
            prod = prod * nums[i - 1];
            result[i] = prod; 
        }
        prod = 1;
        result[n - 1] *= prod;
        for (int i = n - 2; i >= 0; i--) {
            prod = prod * nums[i + 1];
            result[i] = result[i] * prod;
        }
        return result;
    }
}