class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int n = height.length;
        // for (int i = 0; i < n - 1; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         int area = (j - i) * (Math.min(height[i], height[j]));
        //         result = Math.max(result, area);
        //     }
        // }
        
        int l = 0, r = n - 1;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int area = (r - l) * h;
            result = Math.max(result, area);
            while (l < r && h >= height[l]) l++;
            while (l < r && h >= height[r]) r--;
        }
        return result;
    }
}