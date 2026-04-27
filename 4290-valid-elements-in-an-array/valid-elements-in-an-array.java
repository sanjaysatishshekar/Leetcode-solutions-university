class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);
        int n = nums.length;
        if (n == 1) {
            return result;
        }
        
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefix[i] = max;
        }
        max = nums[n - 1];
        for (int i = n - 1; i > -1; i--) {
            max = Math.max(max, nums[i]);
            suffix[i] = max;
        }
        for (int i = 1; i < n - 1; i++) {
            if (prefix[i - 1] < nums[i] || suffix[i + 1] < nums[i])
                result.add(nums[i]);
        }
        result.add(nums[n - 1]);
        return result;
    }
}