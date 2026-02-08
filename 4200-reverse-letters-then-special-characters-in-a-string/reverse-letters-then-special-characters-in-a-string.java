class Solution {
    public String reverseByType(String s) {
        int n = s.length();
        char[] word = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < j && !Character.isLetter(word[i])) i++;
            while (i < j && !Character.isLetter(word[j])) j--;
            if (i < j) {
                char temp = word[i];
                word[i] = word[j];
                word[j] = temp;
                i++; j--;
            }
        }
        i = 0; 
        j = n - 1;
        while (i < j) {
            while (i < j && Character.isLetter(word[i])) i++;
            while (i < j && Character.isLetter(word[j])) j--;
            if (i < j) {
                char temp = word[i];
                word[i] = word[j];
                word[j] = temp;
                i++; j--;
            }
        }
       return new String(word);
    }
}