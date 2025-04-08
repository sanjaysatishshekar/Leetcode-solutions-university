class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;    
    }

    private void backtrack(List<List<Integer>> result, List<Integer> line, int[] nums) {
        if (line.size() == nums.length) {
            result.add(new ArrayList<>(line));
            return;
        }
        for (int i = 0; i < nums.length; i++) { 
            if (!line.contains(nums[i])) {
                line.add(nums[i]);
                backtrack(result, line, nums);
                line.remove(line.size() - 1);
            }
        }
    }
}