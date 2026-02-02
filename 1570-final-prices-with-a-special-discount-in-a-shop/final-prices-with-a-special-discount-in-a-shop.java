class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        result[n - 1] = prices[n - 1];
        for (int i = 0; i < n - 1; i++) {
            boolean found = false;
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] = prices[i] - prices[j];
                    found = true;
                    break;
                }
            }
            if (!found) result[i] = prices[i];
        }
        return result;
    }
}