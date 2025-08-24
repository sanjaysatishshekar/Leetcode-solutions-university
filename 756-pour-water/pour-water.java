class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        if (volume == 0)
            return heights;

        for (; volume > 0; volume--) {
            var bestOnLeft = flowLeft(heights, k);

            if (bestOnLeft != k)
                heights[bestOnLeft]++;
            else
                heights[flowRight(heights, k)]++;
        }

        return heights;
    }

    private int flowLeft(int[] heights, int k) {
        var lowest = k;

        for (var i = k - 1; i >= 0; i--) {
            if (heights[i] > heights[i + 1])
                break; // uphill, stop
            if (heights[i] < heights[lowest])
                lowest = i; // found lower
        }

        return lowest;
    }

    private int flowRight(int[] heights, int k) {
        var lowest = k;

        for (var i = k + 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1])
                break; // uphill, stop
            if (heights[i] < heights[lowest])
                lowest = i;
        }

        return lowest;
    }
}