class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] != nums[j]) continue;
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] == nums[k])
                        result = Math.min(result, Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i));
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1: result;
    }
}