class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        if (n == 0) return 0;
        
        long skip = 0;
        long take = nums[0];

        for (int i = 1; i < n; i++) {
            long bestPrev = Math.max(skip, take);
            long newSkip = bestPrev;

            long newTake;
            if (colors[i] == colors[i - 1])
                newTake = nums[i] + skip;
            else
                newTake = nums[i] + bestPrev;
            
            skip = newSkip;
            take = newTake;
        }
        return Math.max(skip, take);
    }
}