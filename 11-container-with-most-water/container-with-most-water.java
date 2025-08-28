class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int result = 0;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            result = Math.max(result, (r - l) * h);
            while (l < r && height[l] <= h) {
                l++;
            }
            while (l < r && height[r] <= h) {
                r--;
            }
        }
        return result;
    }
}