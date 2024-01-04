class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // int[][] m = new int[n][n];
        // int[] row = new int[n];
        // for (int i = 0; i < n; i++) {
        // row = matrix[i];
        // for (int j = 0; j < n; j++) {
        // m[j][n - i - 1] = row[j];
        // }
        // }
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // matrix[i][j] = m[i][j];
        // }
        // }
        // int num = 0;
        // 00, 02, 22, 20, 00;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {

                // 00->02
                // 20 -> 00
                // 22 -> 20
                // 02->22

                // 10 -> 01
                // 21 -> 10
                // 12 -> 21
                // 01 -> 12

                // System.out.println(i + " " + j);
                int temp = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = matrix[j][i];
                matrix[j][i] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }
    }
}