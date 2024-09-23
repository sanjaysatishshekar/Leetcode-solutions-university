class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> table = new HashSet<>();
        for (int num: nums) table.add(num);
        while (table.contains(original)) {
            original *= 2;
        }
        return original;
        
    }
}