class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        HashSet<Integer> seen = new HashSet<>();
        for (int num: nums) {
            seen.add(num);
        }
        int longest = 1;
        for (int num: seen) {
            if (!seen.contains(num - 1)) {
                int count = 1;
                while (seen.contains(num + count)) {
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}