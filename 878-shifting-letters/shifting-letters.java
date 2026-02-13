class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder result = new StringBuilder();
        int f = 0;
        for (int shift: shifts) {
            f = (f + shift) % 26;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            result.append((char) ((index + f) % 26 + 97));
            f = Math.floorMod(f - shifts[i], 26);
        }
        return result.toString();
    }
}