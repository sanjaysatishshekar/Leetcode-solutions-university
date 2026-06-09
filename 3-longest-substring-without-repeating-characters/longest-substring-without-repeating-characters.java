class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int l = 0;
        int[] table = new int[256];
        Arrays.fill(table, -1);
        int longest = 0;
        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            if (table[c] >= l) {
                l = table[c] + 1;
            }
            table[c] = r;
            // table[c]++;
            // while (l <= r && table[c] > 1) {
            //     table[s.charAt(l++)]--;
            // }
            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }
}