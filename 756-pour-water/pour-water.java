class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        if (volume == 0) return heights;

        for (;volume > 0; volume--) {
        
            int indexOfWater = findLeftIndex(heights, k);
            if (indexOfWater != k) {
                heights[indexOfWater]++;
            }
            else {
                heights[findRightIndex(heights, k)]++;
            }
        }
        return heights;
    }

    private int findLeftIndex(int[] heights, int k) {
        int initial = k;
        for (int i = k - 1; i >= 0; i--) {
            if (heights[i + 1] < heights[i])
                break;
            if (heights[i] < heights[initial])
                initial = i;
        }
        return initial;
    }

    private int findRightIndex(int[] heights, int k) {
        int initial = k;
        for (int i = k + 1; i < heights.length; i++) {
            if (heights[i - 1] < heights[i])
                break;
            if (heights[i] < heights[initial])
                initial = i;
        }
        return initial;
    }
}