class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < 32; j++) {
                int bit = (i >> j) & 1;
                if (bit == 1) count++;
            }
            result[i] = count;
        }
        return result;
    }
}