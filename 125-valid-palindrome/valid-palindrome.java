class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9')
                sb.append(c);
            else if (c >= 'A' && c <= 'Z')
                sb.append(Character.toLowerCase(c));
        }
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
}