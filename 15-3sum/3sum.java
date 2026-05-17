class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            twoSum(nums, result, i + 1, n - 1, -nums[i]);
        }
        return result;
    }

    private void twoSum(int[] nums, List<List<Integer>> result, int i, int j, int target) {
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            }
            else if (sum > target) {
                j--;
            }
            else {
                // System.out.println(nums[i] + " " + nums[j] + " " + (-target));
                result.add(Arrays.asList(-target, nums[i], nums[j]));
                i++;
                while (i < j && nums[i] == nums[i - 1])
                    i++;
            }
        }
    }
}