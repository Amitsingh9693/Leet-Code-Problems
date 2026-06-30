class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0 || m == 0)
            return 0;

        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = matrix[i][j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1)
                    mat[i][j] += mat[i][j - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int width = mat[i][j];
                int curr = width;
                if (width == 0)
                    continue;
                for (int k = i; k < n; k++) {
                    curr = Math.min(mat[k][j], curr);
                    int h = k - i + 1;
                    ans = Math.max(h * curr, ans);
                }
                curr = width;
                for (int k = i; k >= 0; k--) {
                    curr = Math.min(mat[k][j], curr);
                    int h = i - k + 1;
                    ans = Math.max(h * curr, ans);
                }
            }
        }
        return ans;
    }
}