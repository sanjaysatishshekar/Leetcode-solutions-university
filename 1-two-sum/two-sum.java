class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target-nums[i])) {
                result[0] = i;
                result[1] = table.get(target-nums[i]);
                return result;
            }
            table.put(nums[i], i);
        }
        return result;
    }
}