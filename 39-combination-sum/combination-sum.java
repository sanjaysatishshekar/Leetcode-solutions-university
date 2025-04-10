class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int index, int target) {
        if (target < 0)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(result, current, candidates, i, target - candidates[i]);
            current.removeLast();
        }
    }
}