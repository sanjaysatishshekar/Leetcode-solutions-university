class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] result = new int[]{0, 0};  
        for (int i = 0; i < n; i++) {
            int start = i, end = i;
            int len = 0;
            while (start > -1 && end < n && s.charAt(start) == s.charAt(end)) {
                len = Math.max(len, end - start + 1);
                start--; end++;
            }
            if (len > result[1] - result[0] + 1) {
                int diff = len / 2;
                result[0] = i - diff;
                result[1] = i + diff;
            }
            start = i;
            end = i + 1;
            len = 0;
            int even = 0;
            while (start > -1 && end < n && s.charAt(start) == s.charAt(end)) {
                len = Math.max(len, end - start + 1);
                start--; end++;
            }
            if (len > result[1] - result[0] + 1) {
                int diff = len / 2 - 1;
                result[0] = i - diff;
                result[1] = i + diff + 1;
            }
        }
        return s.substring(result[0], result[1] + 1);
    }
}