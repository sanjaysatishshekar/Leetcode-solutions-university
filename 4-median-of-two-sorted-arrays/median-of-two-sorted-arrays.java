class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int na = A.length;
        int nb = B.length;
        int n = na + nb;
        if ((na + nb) % 2 == 1)
            return solve(A, B, n / 2, 0, na - 1, 0, nb - 1);
        else
            return (double) (solve(A, B, n / 2, 0, na - 1, 0, nb - 1) + solve(A, B, n / 2 - 1, 0, na - 1, 0, nb - 1))
                    / 2;
    }

    private double solve(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
        if (aEnd < aStart)
            return B[k - aStart];
        if (bEnd < bStart)
            return A[k - bStart];

        int aIndex = (aStart + aEnd) / 2;
        int bIndex = (bStart + bEnd) / 2;
        int aValue = A[aIndex];
        int bValue = B[bIndex];

        if (aIndex + bIndex < k) {
            if (aValue > bValue)
                return solve(A, B, k, aStart, aEnd, bIndex + 1, bEnd);
            else
                return solve(A, B, k, aIndex + 1, aEnd, bStart, bEnd);
        } else {
            if (aValue > bValue)
                return solve(A, B, k, aStart, aIndex - 1, bStart, bEnd);
            else
                return solve(A, B, k, aStart, aEnd, bStart, bIndex - 1);
        }

    }
    /*
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;
        int m1 = 0, m2 = 0;
        for (int count = 0; count <= (m + n) / 2; count++) {
            m2 = m1;
            if (i != m && j != n) {
                if (nums1[i] > nums2[j])
                    m1 = nums2[j++];
                else
                    m1 = nums1[i++];
            }
            else if (i < m)
                m1 = nums1[i++];
            else
                m1 = nums2[j++];
        }
        if ((n + m) % 2 == 0)
            return (double) (m1 + m2) / 2.0;
        return (double) m1;
    }
    */
}