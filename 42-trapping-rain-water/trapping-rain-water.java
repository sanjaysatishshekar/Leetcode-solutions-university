class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        int result = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l = l + 1;
                leftMax = Math.max(leftMax, height[l]);
                result = result + leftMax - height[l];
            }
            else {
                r = r - 1;
                rightMax = Math.max(rightMax, height[r]);
                result = result + rightMax - height[r];
            }
        }
        return result;
    }
}