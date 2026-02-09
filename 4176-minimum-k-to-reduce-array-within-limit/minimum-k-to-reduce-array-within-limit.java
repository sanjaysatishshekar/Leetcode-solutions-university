class Solution {
    public int minimumK(int[] nums) {
        int n = nums.length;
        int max = n;
        for (int num: nums) {
            max = Math.max(max, num);
        }
        long low = 1, high = max;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (check(nums, mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }   
        return (int) low;
    }

    private boolean check(int[] nums, long k) {
        long total = 0;
        for (int i: nums) {
            total += (i + k - 1) / k;
        }
        return total <= k * k;
    }
}