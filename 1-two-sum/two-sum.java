class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            if (seen.containsKey(diff)) {
                return new int[] {seen.get(diff), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}