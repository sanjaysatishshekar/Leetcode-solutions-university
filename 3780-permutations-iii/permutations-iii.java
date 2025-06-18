class Solution {
    public int[][] permute(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) nums[i - 1] = i;
        int[] candidate = new int[n];
        boolean[] used = new boolean[n];

        List<List<Integer>> perms = new ArrayList<>();
        permute(nums, 0, used, candidate, perms);

        int[][] result = new int[perms.size()][n];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = perms.get(i).get(j);
            }
        }
        return result;

    }

    private void permute(int[] nums, int pos, boolean[] used, int[] candidates, List<List<Integer>> perms) {
        if (pos == nums.length) {
            List<Integer> p = new ArrayList<>();
            for (int i = 0; i < candidates.length; i++) p.add(candidates[i]);
            perms.add(p);
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (pos == 0 || candidates[pos - 1] % 2 != nums[i] % 2) {
                    candidates[pos] = nums[i];
                    used[i] = true;
                    permute(nums, pos + 1, used, candidates, perms);
                    used[i] = false;
                }
            }
        }
    }
}