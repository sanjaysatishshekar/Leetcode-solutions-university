class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        for (int k = 0; k < n; k++) {
            result += palindromes(s, k, k);
            result += palindromes(s, k, k + 1);
        }
        return result;
    }

    private int palindromes(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;
    }
}