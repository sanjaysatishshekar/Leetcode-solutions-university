class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int i = 0, j = 0;
        int n = s.length();
        int[] table = new int[256];
        while (i < n && j < n) {
            table[s.charAt(j)]++;
            while (i <= j && i < n && table[s.charAt(j)] > 1) {
                table[s.charAt(i)]--;
                i++;
            }
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}