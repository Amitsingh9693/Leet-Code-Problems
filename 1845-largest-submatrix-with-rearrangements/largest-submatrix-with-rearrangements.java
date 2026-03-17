class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] height = new int[m][n];

        // Step 1: Build heights
        for (int j = 0; j < n; j++) {
            height[0][j] = matrix[0][j];
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] == 0) height[i][j] = 0;
                else height[i][j] = height[i - 1][j] + 1;
            }
        }

        int res = 0;

        // Step 2: Process each row
        for (int i = 0; i < m; i++) {
            // sort row in descending order
            Arrays.sort(height[i]);

            // try all widths
            for (int j = n - 1; j >= 0; j--) {
                int h = height[i][j];
                int width = n - j;
                res = Math.max(res, h * width);
            }
        }

        return res;
    }
}