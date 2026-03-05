class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> table = new HashMap<>();
        for (String s: strs) {
            String key = getFrequency(s);
            if (!table.containsKey(key)) {
                table.put(key, new ArrayList<>());
            }
            table.get(key).add(s);
        }
        return new ArrayList<>(table.values());
    }

    String getFrequency(String s) {
        int[] table = new int[26];
        for (char c: s.toCharArray()) {
            table[c - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        for (int i: table) {
            result.append(i).append('#');
        }
        return result.toString();
    }
}