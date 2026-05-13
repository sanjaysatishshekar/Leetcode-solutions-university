class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            int odd = expand(s, i, i);
            if (odd > result[1] - result[0] + 1) {
                int diff = odd / 2;
                result[0] = i - diff;
                result[1] = i + diff;
            }
            int even = expand(s, i, i + 1);
            if (even > result[1] - result[0] + 1) {
                int diff = even / 2 - 1;
                result[0] = i - diff;
                result[1] = i + diff + 1;
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    private int expand(String s, int start, int end) {
        int n = s.length();
        int result = 0;
        while (start > -1 && end < n && s.charAt(start) == s.charAt(end)) {
            result = Math.max(result, end - start + 1);
            start--;
            end++;
        }
        return result;
    }
}
