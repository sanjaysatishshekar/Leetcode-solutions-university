class Solution {
    
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (!Character.isLetterOrDigit(c1)) {
                i++;
            }
            else if (!Character.isLetterOrDigit(c2)) {
                j--;
            }
            else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2))
                    return false;
                i++;
                j--;
            }
        }
        return true;
    }
    
    /*
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
    */
}