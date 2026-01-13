class Solution {
    public int residuePrefixes(String s) {
        Set<Character> table = new HashSet<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            table.add(s.charAt(i));
            if (table.size() == (i + 1) % 3)
                result++;
        }
        return result;
    }
}