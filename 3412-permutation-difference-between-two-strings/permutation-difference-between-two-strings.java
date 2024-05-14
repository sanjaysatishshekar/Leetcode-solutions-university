import java.lang.Math;
class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] table = new int[26];
        int result = 0;
        Arrays.fill(table, -1);
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < t.length(); i++) {
            if (table[t.charAt(i) - 'a'] != -1) {
                result += Math.abs(i - table[t.charAt(i) - 'a']);
            }
        }
        return result;
    }
}