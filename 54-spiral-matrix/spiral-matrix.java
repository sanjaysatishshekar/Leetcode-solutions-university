class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        List<Integer> result = new ArrayList<>();
        while (result.size() < m * n) {
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            if (top != bottom) {
                for (int col = right - 1; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
            }
            if (left != right) {
                for (int row = bottom - 1; row > top; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}