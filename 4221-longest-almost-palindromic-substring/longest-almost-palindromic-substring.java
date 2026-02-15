class Solution {
    public int almostPalindromic(String s) {
        int n = s.length();
        int result = 2;
        int odd = 0, even = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, check(s, i, i, true));
            result = Math.max(result, check(s, i, i + 1, true));
        }
        return result;
    }

    private int check(String s, int start, int end, boolean skip) {
        if (start < 0 && end >= s.length()) return 0;

        if (start < 0 || end >= s.length()) return skip ? 1: 0;

        if (s.charAt(start) == s.charAt(end)) {
            int match = (start == end) ? 1: 2;
            return match + check(s, start - 1, end + 1, skip);
        }
        if (skip) {
            return 1 + Math.max(check(s, start - 1, end, false), 
                check(s, start, end + 1, false));
        }
        return 0;
    }
}