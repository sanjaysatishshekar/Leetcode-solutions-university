class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int cols = matrix[0].length;
        int rows = matrix.length;

        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;
        while (result.size() < cols * rows) {
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
            top++; bottom--;
            left++; right--;
        }
        return result;
        

        
    }
}