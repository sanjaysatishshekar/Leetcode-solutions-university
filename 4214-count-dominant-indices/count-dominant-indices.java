class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            int sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
            }
            if (sum == 0) continue;
            double avg = (double) sum / (n - i - 1);
            if (nums[i] > avg) {
                // System.out.println(nums[i] + " " + sum + " " + (n - i - 1) );
                result++;
            }
        }
        return result;
    }
}