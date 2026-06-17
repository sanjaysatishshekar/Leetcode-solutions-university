class Solution {
    public boolean checkGoodInteger(int n) {
        int sum = 0, sqsum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            sqsum += (digit * digit);
            n = n / 10;
        }
        return sqsum - sum >= 50;
    }
}