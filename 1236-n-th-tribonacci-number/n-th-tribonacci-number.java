class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int tribonacci(int n) {
        // return dp(n);
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1; dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    private int dp(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (!memo.containsKey(n))
            memo.put(n, tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
        return memo.get(n);
    }    
}