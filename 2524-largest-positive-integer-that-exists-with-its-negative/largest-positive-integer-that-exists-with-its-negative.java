class Solution {
    public int findMaxK(int[] nums) {
        // int n = nums.length;
        // int l = 0, r = n - 1; 
        // Arrays.sort(nums);
        // while (l < r) {
        //     if (-nums[l] < nums[r]) {
        //         r--;
        //     }
        //     else if (nums[r] < -nums[l]) {
        //         l++;
        //     }
        //     else {
        //         return nums[r];
        //     }
        // }
        // return -1;

        Set<Integer> seen = new HashSet<>();
        int result = -1;
        for (int num: nums) {
            int l = Math.abs(num);
            if (l > result && seen.contains(-num))
                result = l;
            seen.add(num);
        }
        return result;
    }
}

