class Solution {
    public boolean isPalindrome(String s) {
        // StringBuilder sb = new StringBuilder();
        // for (char c: s.toCharArray()) {
        //     if (Character.isAlphabetic(c) || Character.isDigit(c)) {
        //         sb.append(Character.toLowerCase(c));
        //     }
        // }
        // int i = 0, j = sb.length() - 1;
        // while (i < j) {
        //     if (sb.charAt(i) != sb.charAt(j)) return false;
        //     i++; j--;
        // }
        // return true;

        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!isAlphaNumeric(s.charAt(l))) {
                l++;
                continue;
            }
            if (!isAlphaNumeric(s.charAt(r))) {
                r--;
                continue;
            }

            char a = Character.toLowerCase(s.charAt(l));
            char b = Character.toLowerCase(s.charAt(r));
            if (a != b) return false;
            l++; r--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}