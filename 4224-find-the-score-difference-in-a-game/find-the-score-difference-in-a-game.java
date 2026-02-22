class Solution {
    public int scoreDifference(int[] nums) {
        int[] s = {0, 0};
        boolean active = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) active = !active;
            if (i % 6 == 5) active = !active;
            if (active)
                s[0] += nums[i];
            else
                s[1] += nums[i]; 
        }
        return s[0] - s[1];
    }
}