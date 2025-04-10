class Solution {
    public List<List<Integer>> subsets(int[] nums) {   
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> set, int index, int[] nums) {
        result.add(new ArrayList<>(set));
        for (int i = index; i < nums.length; i++) {
            set.add(nums[i]);
            backtrack(result, set, i + 1, nums);
            set.remove(set.size() - 1);
        }
    }
}