class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int resultLength = 0;
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resultLength) {
                    resultLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                left -= 1;
                right += 1;
            }
            
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resultLength) {
                    resultLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                left -= 1;
                right += 1;
            }
        }
        return result;
    }
}