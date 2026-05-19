class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int result = 0;
        while (l < r) {
            int min_height = Math.min(height[l], height[r]);
            result = Math.max(result, (r - l) * min_height);
            while (l < r && height[l] <= min_height) l++;
            while (l < r && height[r] <= min_height) r--;
        }
        return result;
    }
}