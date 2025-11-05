class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int n = matrix.length;
        int m = matrix[0].length;
        int[] result = new int[n * m];
        int k = 0;
        ArrayList<Integer> inter = new ArrayList<>();

        for (int d = 0; d < n + m - 1; d++) {
            inter.clear();

            int r = d < m ? 0: d - m + 1;
            int c = d < m ? d: m - 1;

            while (r < n && c > -1) {
                inter.add(matrix[r][c]);
                r++;
                c--;
            }

            if (d % 2 == 0) {
                Collections.reverse(inter);
            }

            for (int i = 0; i < inter.size(); i++) {
                result[k++] = inter.get(i); 
            }
        }
        return result;
    }
}