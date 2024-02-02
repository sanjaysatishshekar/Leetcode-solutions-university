class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i; 
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                result += 1;
                left -= 1;
                right += 1;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                result += 1;
                left -= 1;
                right += 1;
            }
        }
        return result;
    }
}