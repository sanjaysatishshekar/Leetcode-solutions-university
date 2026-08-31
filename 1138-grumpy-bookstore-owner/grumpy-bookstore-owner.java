class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int alwaysSatisfied = 0;
        int extra = 0;
        int maxExtra = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                alwaysSatisfied += customers[i];
            } else {
                extra += customers[i];
            }

            if (i >= minutes && grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes];
            }

            maxExtra = Math.max(maxExtra, extra);
        }

        return alwaysSatisfied + maxExtra;
    }
}