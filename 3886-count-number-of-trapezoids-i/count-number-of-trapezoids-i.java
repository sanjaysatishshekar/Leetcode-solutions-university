class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length, mod = 1000000007;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        long result = 0, total = 0;
        for (int i = 0, j; i < n; i = j) {
            j = i + 1;
            while (j < n && points[i][1] == points[j][1])
                j++;
            long count = j - i;
            long lines = count * (count - 1) / 2;
            result = (result + total * lines) % mod;
            total = (total + lines) % mod; 
        }
        return (int) result;
    }
}