class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int result = Integer.MIN_VALUE;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            result = Math.max(result, (j - i) * h);
            while (i < j && height[i] <= h) {
                i++;
            }
            while (i < j && height[j] <= h) {
                j--;
            }
        }
        return result;
    }
}