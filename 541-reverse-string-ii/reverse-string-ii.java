class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] word = s.toCharArray();
        boolean rev = true;
        int i = 0;

        while (i < n) {
            if (rev) {
                reverse(word, i, Math.min(i + k - 1, n - 1));
            } 
            rev = !rev;
            i = i + k;
        }        
        return String.valueOf(word);
    }

    public void reverse(char[] word, int start, int end) {
        int n = word.length;
        while (start < end) {
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            start++;
            end--;
        }
    }
}