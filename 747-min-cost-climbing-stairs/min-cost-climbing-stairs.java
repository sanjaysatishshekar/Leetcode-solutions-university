class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length - 1;
        // return Math.min(dp(n, cost), dp(n - 1, cost));
        int r = dp(n, cost);
        int l = dp(n - 1, cost);
        return Math.min(l, r);
    }

    private int dp(int i, int[] cost) {
        if (i < 0) return 0;
        if (i == 0) return cost[0];
        if (i == 1) return cost[1];
        if (!memo.containsKey(i)) {
            memo.put(i, cost[i] + Math.min(dp(i - 1, cost), dp(i - 2, cost)));
        }
        return memo.get(i);
    }
}