class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
        String sss = new String(ss);
        String tss = new String(ts);
        return sss.equals(tss);
    }
    /*
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] table = new int[26];
        for (char c: s.toCharArray())
            table[c - 'a']++;
        for (char c: t.toCharArray()) {
            int idx = c - 'a';
            table[idx]--;
            if (table[idx] < 0) 
                return false;
        }
        for (int i : table) 
            if (i < 0) return false;
        return true;
    }
    */
    
}