class Solution {
    private HashMap<Integer, Integer> dp = new HashMap<>();
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        if (!dp.containsKey(n)) {
            dp.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }

        return dp.get(n);
        
    }
}