class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            int res = sum(n);
            if (seen.contains(res)) {
                return false;
            }
            seen.add(res);
            n = res;
        }
        return true;
    }

    private int sum(int num) {
        int result = 0;
        while (num > 0) {
            int digit = num % 10;
            result += (digit * digit);
            num /= 10;
        }
        return result;
    }
}