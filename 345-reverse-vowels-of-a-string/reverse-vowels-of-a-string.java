class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] word = s.toCharArray();
        List<Character> occur = new ArrayList<>();
        for (int i = 0; i < word.length; i++) {
            if (vowels.contains(word[i])) {
                occur.add(word[i]);
            }
        }   
        int j = 0;
        for (int i = word.length - 1; i >= 0; i--) {
            if (vowels.contains(word[i])) {
                word[i] = occur.get(j);
                j++;
            }
        }
        return String.valueOf(word);
    }
}