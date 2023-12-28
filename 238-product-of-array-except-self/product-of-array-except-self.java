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
        int[] result = new int[n];
        prod = 1;
        result[n-1] = prod * prefix[n-1];
        for (int i = n - 2; i >= 0; i--) {
            prod *= nums[i+1];
            result[i] = prod * prefix[i]; 
        }
        return result;
    }
}


//    1   2   3   4
//    1   1   2   6  24
//    24  12  4   1 