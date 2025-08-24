class Solution {
    public int compress(char[] chars) {
        int i = 0, res = 0;
        int n = chars.length;
        while (i < n) {
            int groupLength = 1;
            while (i + groupLength < n && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }
}