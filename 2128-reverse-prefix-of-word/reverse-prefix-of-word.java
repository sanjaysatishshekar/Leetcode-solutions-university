class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        int start = 0; 
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == ch) {
                end = i;
                break;
            }
        }
        if (end == -1) return word;
        char[] charWord = word.toCharArray();
        while (start < end) {
            char temp = charWord[start];
            charWord[start] = charWord[end];
            charWord[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(charWord);
    }
}