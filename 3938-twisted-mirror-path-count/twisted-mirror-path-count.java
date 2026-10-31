
import java.util.*;

class Solution {
    int MOD = 1000000007;
    int m, n;

    int[][] dp;
    int[][][] memo;

    // dir = 0 -> Right
    // dir = 1 -> Down
    int resolve(int i, int j, int dir) {

        if (i >= m || j >= n) return -1;

        if (memo[i][j][dir] != -2)
            return memo[i][j][dir];

        // Empty cell: reflection stops
        if (grid[i][j] == 0) {
            return memo[i][j][dir] = i * n + j;
        }

        // Mirror encountered
        if (dir == 0) {
            // Entered from left, reflected down
            return memo[i][j][dir] =
                resolve(i + 1, j, 1);
        } 
        else {
            // Entered from above, reflected right
            return memo[i][j][dir] =
                resolve(i, j + 1, 0);
        }
    }

    int[][] grid;

    int solve(int i, int j) {

        if (i == m - 1 && j == n - 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        long ans = 0;

        // Try moving right
        int right = resolve(i, j + 1, 0);

        if (right != -1) {
            ans += solve(right / n, right % n);
        }

        // Try moving down
        int down = resolve(i + 1, j, 1);

        if (down != -1) {
            ans += solve(down / n, down % n);
        }

        return dp[i][j] = (int)(ans % MOD);
    }

    public int uniquePaths(int[][] grid) {

        this.grid = grid;

        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];
        memo = new int[m][n][2];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        for (int[][] row : memo) {
            for (int[] cell : row)
                Arrays.fill(cell, -2);
        }

        return solve(0, 0);
    }
}

