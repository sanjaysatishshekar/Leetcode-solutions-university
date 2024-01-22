class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        int[] table = new int[128];
        int n = s.length();
        while (right < n) {
            char c = s.charAt(right);
            int i = table[c];

            // check if it is not within the substring
            if (i >= 1 && i >= left) {
                left = i;
            }

            result = Math.max(result, right - left + 1);

            // Add table[c] = right + 1 because it is the next location for left
            table[c] = ++right;
            
        }
        return result;
    }


    public int lengthOfLongestSubstring(String s) {
        int[] table = new int[256];
        int l = 0;
        int n = s.length();
        int result = 0;
        char[] text = s.toCharArray();
        for (int r = 0; r < n; r++) {
            int index = text[r];
            table[index]++;
            while (l <= r && table[index] > 1) {
                table[text[l]]--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
