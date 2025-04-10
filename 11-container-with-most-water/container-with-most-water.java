class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            result = Math.max(result, (j - i) * h);
            if (height[i] == h) {
                while (i < j && height[i] <= h)
                    i++;
            }
            else {
            while (j < height.length && height[j] <= h)
                    j--;
            }
        }
        return result;
    }
}