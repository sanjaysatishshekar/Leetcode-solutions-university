class Solution {
    public int maxSumDivThree(int[] nums) {
        // int[] dp = new int[3];
        // for (int a: nums) {
        //     for (int i: Arrays.copyOf(dp, dp.length)) {
        //         dp[(i + a) % 3] = Math.max(dp[(i + a) % 3], i + a);
        //     }
        // }
        // return dp[0];

        int sum = 0;
        int oneRemainder = 20000;
        int twoRemainder = 20000;

        for (int num: nums) {
            sum += num;

            if (num % 3 == 1) {
                twoRemainder = Math.min(twoRemainder, oneRemainder + num);
                oneRemainder = Math.min(oneRemainder, num);
            }

            if (num % 3 == 2) {
                oneRemainder = Math.min(oneRemainder, twoRemainder + num);
                twoRemainder = Math.min(twoRemainder, num);
            }
        }

        if (sum % 3 == 0) return sum;
        if (sum % 3 == 1) return sum - oneRemainder;
        if (sum % 3 == 2) return sum - twoRemainder;
        return 0;
    }
}