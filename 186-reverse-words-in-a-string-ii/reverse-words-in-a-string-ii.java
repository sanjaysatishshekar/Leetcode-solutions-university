class Solution {
    public void reverseWords(char[] s) {
        int n = s.length;
        int l = 0, r = n - 1; 
        while (l < r) {
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
            l++;
            r--;
        }
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            while (j < n && s[j] != ' ') {
                j++;
            }
            l = i; r = j - 1 ;
            while (l < n && r < n && l < r) {
                char c = s[l];
                s[l] = s[r];
                s[r] = c;
                l++;
                r--;
            }
            i = j + 1;
            j = i; 
        }
    }
}