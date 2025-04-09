class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> table = new HashMap<>();
        for (String word: words) {
            table.put(word, table.getOrDefault(word, 0) + 1);
        }
        Map<Integer, List<String>> elasti = new HashMap<>();
        for (String word: table.keySet()) {
            elasti.putIfAbsent(table.get(word), new ArrayList<>());
            elasti.get(table.get(word)).add(word);
        }
        for (int i = words.length - 1; i >= 0; i--) {
            if (k == 0) return result;
            if (elasti.containsKey(i)) {
                List<String> a = elasti.get(i);
                Collections.sort(a);
                for (String word: a) {
                    if (k == 0) break;
                    result.add(word);
                    k--;
                }
            }
        }
        return result;
    }
}