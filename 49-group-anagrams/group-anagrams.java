class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> table = new HashMap<>();
        for (String s: strs) {
            char[] word = s.toCharArray();
            Arrays.sort(word);
            String sortedWord = String.valueOf(word);
            if (!table.containsKey(sortedWord)) {
                table.put(sortedWord, new ArrayList<>());
            }
            table.get(sortedWord).add(s);
        }
        return new ArrayList<>(table.values());
    }
}