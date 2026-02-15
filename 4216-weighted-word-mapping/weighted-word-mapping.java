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
            result.append((char) ('z' - (sum % 26)));
        }
        return result.toString();
    }
}