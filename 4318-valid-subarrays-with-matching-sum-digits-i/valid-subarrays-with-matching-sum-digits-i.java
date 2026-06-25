class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            long currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                count = count + check(currentSum, x);
            }
        }
        return count;
    }

    private int check(long sum, int x) {
        int count = 0;
        if (sum % 10 == x) {
            count++;
            long temp = sum;
            while (temp >= 10) {
                temp /= 10;
            }
            if (temp == x) {
                count++;
            }
        }
        return count == 2 ? 1: 0;
    }
}

// 1 100 1
// 1 101 102

// 102 101 1

// a, b, c, d
// a, a+b, a+b+c, a+b+c+d
// 0, 1,    2,     3
