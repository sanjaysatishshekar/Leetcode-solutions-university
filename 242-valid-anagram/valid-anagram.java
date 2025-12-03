class Solution {
    public boolean isAnagram(String s, String t) {
        int[] table = new int[256];
        for (char c: s.toCharArray()) {
            table[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            table[c - 'a']--;
        }
        for (int i: table) {
            if (i != 0) return false;
        }
        return true;
    }
}