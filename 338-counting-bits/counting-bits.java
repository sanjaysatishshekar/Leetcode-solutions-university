class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) offset = i;
            result[i] = 1 + result[i - offset];
        }
        return result;
    }
}