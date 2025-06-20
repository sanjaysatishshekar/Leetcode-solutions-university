class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            total += Math.max(0, prices[i] - prices[i - 1]);
        }
        return total;        
    }
}