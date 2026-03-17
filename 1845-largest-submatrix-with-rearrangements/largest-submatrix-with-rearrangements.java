class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] height = new int[m][n];

        for (int j = 0; j < n; j++) {
            height[0][j] = matrix[0][j];
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] == 0) height[i][j] = 0;
                else height[i][j] = height[i - 1][j] + 1;
            }
        }

        int res = 0;

        for (int i = 0; i < m; i++) {
            Arrays.sort(height[i]);

            for (int j = n - 1; j >= 0; j--) {
                int h = height[i][j];
                int width = n - j;
                res = Math.max(res, h * width);
            }
        }

        return res;
    }
}