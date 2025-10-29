class Solution {
    public int longestMountain(int[] A) {
        int n = A.length;
        int ans = 0, base = 0;
        while (base < n) {
            int end = base;
            if (end + 1 < n && A[end] < A[end + 1]) {
                while (end + 1 < n && A[end] < A[end + 1])
                    end++;
                if (end + 1 < n && A[end] > A[end + 1]) {
                    while (end + 1 < n && A[end] > A[end + 1])
                        end++;
                    ans = Math.max(ans, end - base + 1);
                }
            }
            base = Math.max(base + 1, end);
        }
        return ans;
    }
}