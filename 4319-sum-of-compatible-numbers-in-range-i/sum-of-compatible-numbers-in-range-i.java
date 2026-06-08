class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int sum = 0;
        int start = Math.max(1, n - k);
        for (int i = start; i <= (n + k); i++) {
            if (Math.abs(n - i) <= k && (n & i) == 0) {
                sum += i;
            }
        }
        return sum;
    }
}