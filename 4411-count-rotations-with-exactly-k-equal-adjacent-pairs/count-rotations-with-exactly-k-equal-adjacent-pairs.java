class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        if (n == 1) return k == 0 ? 1 : 0;
        int total = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                total++;
        }

        if (s.charAt(n - 1) == s.charAt(0))
            total++;
        
        if (k == total) return n - total;

        if (k == total - 1) return total;
        return 0;
        // StringBuilder sb = new StringBuilder(s);
        // int total = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     total += (check(sb) == k ? 1 : 0);
        //     StringBuilder rotated = rotate(sb);
        //     sb = rotated;
        // }
        // return total;
    }

    private int check(StringBuilder sb) {
        int total = 0;
        int n = sb.length();
        for (int i = 1; i < n; i++) {
            if (sb.charAt(i - 1) == sb.charAt(i))
                total++;
        }
        return total;
    }

    private StringBuilder rotate(StringBuilder sb) {
        char c = sb.charAt(sb.length() - 1);
        sb.insert(0, c);
        sb.deleteCharAt(sb.length() - 1);
        return sb;
    }
}