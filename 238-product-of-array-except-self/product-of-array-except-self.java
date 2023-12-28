class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        int prod = 1;
        prefix[0] = prod;
        for (int i = 1; i <= n; i++) {
            prod *= nums[i-1];
            prefix[i] = prod;
        }
        int[] suffix = new int[n];
        suffix[n-1] = 1;
        prod = 1;
        for (int i = n - 2; i >= 0; i--) {
            prod *= nums[i+1];
            suffix[i] = prod; 
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}


//    1   2   3   4
//    1   1   2   6  24
//    24  12  4   1 