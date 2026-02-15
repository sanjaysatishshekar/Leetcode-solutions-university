class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String, Integer> groups = new HashMap<>();
        int result = 0;
        for (String word: words) {
            if (word.length() < k) continue;
            String prefix = word.substring(0, k);
            groups.put(prefix, groups.getOrDefault(prefix, 0) + 1);
        }
        for (String key: groups.keySet()) {
            if (groups.get(key) > 1) result++;
        }
        return result;
    }
}