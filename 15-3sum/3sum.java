class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, result, i + 1, n - 1, 0 - nums[i]);
        }
        return result;
    }

    private void twoSum(int[] nums, List<List<Integer>> result, int left, int right, int target) {
        while (left < right) {
            if (nums[left] + nums[right] > target)
                right--;
            else if (nums[left] + nums[right] < target)
                left++;
            else {
                result.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }
}