class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (col == 0) {
                    matrix[row][col] += Math.min(matrix[row - 1][col], matrix[row - 1][col + 1]);
                } else if (col == n - 1) {
                    matrix[row][col] += Math.min(matrix[row - 1][col - 1], matrix[row - 1][col]);
                } else {
                    matrix[row][col] += Math.min(
                            Math.min(matrix[row - 1][col - 1], matrix[row - 1][col]),
                            matrix[row - 1][col + 1]
                    );
                }
            }
        }

        int minPathSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minPathSum = Math.min(minPathSum, matrix[n - 1][col]);
        }

        return minPathSum;
    }
}