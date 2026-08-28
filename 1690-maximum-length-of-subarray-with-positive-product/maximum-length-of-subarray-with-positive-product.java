class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int longest = 0;
        int neg = 0;
        int firstNeg = -1;
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (nums[end] == 0) {
                start = end + 1;
                firstNeg = -1;
                neg = 0;
            }
            else {
                if (nums[end] < 0) {
                    neg++;
                    if (firstNeg == -1) {
                        firstNeg = end;
                    }
                }
            }
            if (neg % 2 == 0) 
                longest = Math.max(longest, end - start + 1);
            else
                longest = Math.max(longest, end - firstNeg);

        }
        return longest;
    }
}