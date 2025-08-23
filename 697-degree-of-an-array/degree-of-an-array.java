class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        int maxf = 1;
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }
            maxf = Math.max(maxf, freq.get(nums[i]));
        }
        int result = nums.length;
        Set<Integer> seen = new HashSet<>();
        for (int i = nums.length - 1; i > 0; i--) {
            int num = nums[i];
            if (freq.get(num) == maxf && !seen.contains(nums[i])) {
                result = Math.min(result, i - first.get(nums[i]) + 1);
                seen.add(nums[i]);
            }
        }
        return result;
    }
}