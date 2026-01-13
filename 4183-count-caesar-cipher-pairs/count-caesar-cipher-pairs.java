class Solution {
    public long countPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        long result = 0;
        for (String word: words) {
            char[] w = word.toCharArray();
            int first = w[0];
            for (int i = 0; i < w.length; i++) {
                w[i] = (char) ((w[i] - first + 26) % 26);
            }
            String res = new String(w);
            int k = map.getOrDefault(res, 0);
            result += k;
            map.put(res, k + 1);
        }
        return result;
    }
}