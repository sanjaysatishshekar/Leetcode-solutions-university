class Solution {
    public int countRotations(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int total = 0;
        // total += (check(sb) == k ? 1 : 0);
        for (int i = 0; i < s.length(); i++) {
            total += (check(sb) == k ? 1 : 0);
            // System.out.println(check(sb) + " " + sb);
            StringBuilder rotated = rotate(sb);
            sb = rotated;
        }
        return total;
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