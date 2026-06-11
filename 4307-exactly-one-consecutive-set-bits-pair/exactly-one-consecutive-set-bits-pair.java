class Solution {
    public boolean consecutiveSetBits(int n) {
        String num = Integer.toBinaryString(n);
        boolean seen = false;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == '1' && num.charAt(i - 1) == '1') {
                if (seen) {
                    return false;
                }
                seen = true;
            }
        }
        return seen;
    }
}