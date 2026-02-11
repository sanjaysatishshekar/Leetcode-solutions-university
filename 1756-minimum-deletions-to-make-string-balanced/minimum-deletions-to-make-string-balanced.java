class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] a = new int[n];
        int[] b = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            b[i] = count;
            if (s.charAt(i) == 'b') count++;
        }

        count = 0;
        for (int i = n - 1; i > -1; i--) {
            a[i] = count;
            if (s.charAt(i) == 'a') count++;
        }

        int result = n;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, a[i] + b[i]);
        }
        return result;
    }
}