class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        int result = 0;
        
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    count += 1;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}