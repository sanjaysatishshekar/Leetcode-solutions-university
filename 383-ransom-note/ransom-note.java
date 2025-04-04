class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] table = new int[26];
        for (char c: magazine.toCharArray()) table[c - 'a']++;
        for (char c: ransomNote.toCharArray()) table[c - 'a']--;
        for (int i: table) {
            if (i < 0) return false;
        }
        return true;
    }
}