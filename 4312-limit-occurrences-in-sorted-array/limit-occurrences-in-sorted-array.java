class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        Map<Integer, Integer> table = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            table.put(nums[i], table.getOrDefault(nums[i], 0) + 1);
            if (table.get(nums[i]) > k) {
                continue;
            }
            result.add(nums[i]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}