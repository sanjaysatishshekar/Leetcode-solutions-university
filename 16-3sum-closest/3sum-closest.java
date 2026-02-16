class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n && diff != 0; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum < target) l++;
                else r--;
            }
        }
        return target - diff;
        
    }
}