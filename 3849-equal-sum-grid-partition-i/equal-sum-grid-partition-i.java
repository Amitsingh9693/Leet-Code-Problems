class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        long total = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += grid[i][j];
                col[j] += grid[i][j];
                total += grid[i][j];
            }
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += row[i];
            if (sum * 2 == total) return true;
        }

        sum = 0;
        for (int j = 0; j < n; j++) {
            sum += col[j];
            if (sum * 2 == total) return true;
        }

        return false;
    }
}