class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int left = 0, right = n - 1;
        int leftMax = h[left], rightMax = h[right];
        int result = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, h[left]);
                result += leftMax - h[left];
            }
            else {
                right--;
                rightMax = Math.max(rightMax, h[right]);
                result += rightMax - h[right];
            }
        }
        return result;
        
    }
}