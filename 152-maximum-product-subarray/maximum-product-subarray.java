class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int num: nums) {
            result = Math.max(result, num);
        }
        int currMin = 1, currMax = 1;
        for (int num: nums) {
            int temp = currMin * num;
            currMin = Math.min(num, Math.min(num * currMin, num * currMax));
            currMax = Math.max(num, Math.max(temp, num * currMax));
            result = Math.max(result, currMax);
        }
        return result;
    }
}