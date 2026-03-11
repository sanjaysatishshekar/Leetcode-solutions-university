class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
                sb.append(Character.toLowerCase(c));
        }
        int start = 0, end = sb.length() - 1;
        while (start < end) {
            if (sb.charAt(start) != sb.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}