class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int left = 0;
        int longest = 1;
        int[] table = new int[128];
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            table[c]++;
            while (left <= right && table[c] >= 2) {
                table[s.charAt(left)]--;
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}