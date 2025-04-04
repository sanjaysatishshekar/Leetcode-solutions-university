class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target - nums[i]))
                return new int[]{i, table.get(target - nums[i])};
            table.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}