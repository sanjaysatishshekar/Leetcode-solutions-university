class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int[] table = new int[256];
        int result = 0;
        for (int end = 0; end < n; end++) {
            table[s.charAt(end)] = table[s.charAt(end)] + 1;
            while (start <= end && end < n && table[s.charAt(end)] > 1) {
                table[s.charAt(start)]--;
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}        