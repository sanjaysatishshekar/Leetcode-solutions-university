class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            sum = 0;
            for (char c: word.toCharArray()) {
                sum += weights[c - 'a'];
            }
            int l = sum % 26;
            result.append((char) (26 - l + 97 - 1));
        }
        return result.toString();
    }
}