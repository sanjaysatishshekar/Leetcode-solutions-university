class Solution {
    public int maxArea(int[] height) {
        int area = 0, n = height.length;
        // int i = 0, j = height.length - 1;
        // for (int i = 0; i < n - 1; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
        //     }
        // }
        // return area;

        int i = 0, j = n - 1;
        while (i < j) {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return area;
    }
}