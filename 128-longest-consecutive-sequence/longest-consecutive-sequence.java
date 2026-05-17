class Solution {
    public int longestConsecutive(int[] nums) {
        // Have a set will all unique nums
        // iterate through nums 
        // and find num that is smallest in it's sequence
        // start counting the length of that sequence

        int n = nums.length;

        if (n == 0) return 0;
        Set<Integer> table = new HashSet<>();
        for (int num: nums) {
            table.add(num);
        }
        int longest = 1;
        for (int num: table) {
            if (!table.contains(num - 1)) {
                int x = 1;
                while (table.contains(num + x)) {
                    x++;
                }
                longest = Math.max(longest, x);
            }
        }
        return longest;
    }
}