class Solution {
    public int sumOfPrimesInRange(int n) {
        String s = String.valueOf(n);
        String r = (new StringBuilder(s)).reverse().toString();
        // System.out.println(s + " " + r);
        int a = Integer.parseInt(s);
        int b = Integer.parseInt(r);
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        int result = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                result += i;
            }
        }
        return result;
    }

    private boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}