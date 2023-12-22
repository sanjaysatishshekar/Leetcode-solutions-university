class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList<>();
        }
        Map<String, List<String>> table = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String word: strs) {
            char[] c = word.toCharArray();
            Arrays.sort(c);
            String sortedWord = String.valueOf(c);
            if (!table.containsKey(sortedWord))
            {
                table.put(sortedWord, new ArrayList<>());
            }
            table.get(sortedWord).add(word);
        }
        return new ArrayList<>(table.values());
    }
}