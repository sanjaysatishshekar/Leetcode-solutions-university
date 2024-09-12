class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxL = new int[n + 1];
        maxL[0] = height[0];
        
        int[] maxR = new int[n + 1];
        maxR[n-1] = height[n-1];
        
        for (int i = 0; i < n ; i++) {
            maxL[i + 1] = Math.max(maxL[i], height[i]);
        }

        System.out.println(Arrays.toString(maxL));
        for (int i = n - 2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], height[i]);
        }
        System.out.println(Arrays.toString(maxR));
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.max(0, Math.min(maxL[i], maxR[i]) - height[i]);
        }
        return result;
    }
}