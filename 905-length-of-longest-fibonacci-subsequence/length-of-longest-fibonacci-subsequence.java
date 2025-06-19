class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int max = 0;
        int n = arr.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> valToIdx = new HashMap<>();
        for (int curr = 0; curr < n; curr++) {
            valToIdx.put(arr[curr], curr);
            for (int prev = 0; prev < curr; prev++) {
                int diff = arr[curr] - arr[prev];
                int idx = valToIdx.getOrDefault(diff, -1);

                if (diff < arr[prev] && idx >= 0)
                    dp[prev][curr] = dp[idx][prev] + 1;
                else
                    dp[prev][curr] = 2;
                max = Math.max(max, dp[prev][curr]);
            }
        }
        return max > 2 ? max : 0;
    }
}