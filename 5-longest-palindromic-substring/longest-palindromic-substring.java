class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            int start = i;
            int end = i;
            int odd = expand(s, start, end);
            if (odd > result[1] - result[0] + 1) {
                int dist = odd / 2;
                result[0] = i - dist;
                result[1] = i + dist;
            }
            start = i;
            end = i + 1;
            int even = expand(s, start, end);
            if (even > result[1] - result[0] + 1) {
                int dist = (even / 2) - 1;
                result[0] = i - dist;
                result[1] = i + 1 + dist;
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    private int expand(String s, int i, int j) {
        int result = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if ((j - i + 1) > result) {
                result = j - i + 1;
            }
            i--;
            j++;
        }
        return result;
    }
}