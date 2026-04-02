class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length, m = coins[0].length;
        int[][][] dp = new int[n][m][3];

        // initialize with very small values
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int k = 0; k < 3; k++)
                    dp[i][j][k] = Integer.MIN_VALUE;

        // start
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0; // skip negative
            dp[0][0][0] = coins[0][0]; // take negative
        } else {
            dp[0][0][0] = coins[0][0];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;

                    // move right
                    if (j + 1 < m) {
                        int val = coins[i][j + 1];

                        if (val >= 0) {
                            dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + val);
                        } else {
                            if (k < 2)
                                dp[i][j + 1][k + 1] = Math.max(dp[i][j + 1][k + 1], dp[i][j][k]);
                            dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + val);
                        }
                    }

                    // move down
                    if (i + 1 < n) {
                        int val = coins[i + 1][j];

                        if (val >= 0) {
                            dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + val);
                        } else {
                            if (k < 2)
                                dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1], dp[i][j][k]);
                            dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + val);
                        }
                    }
                }
            }
        }

        return Math.max(dp[n - 1][m - 1][0],
               Math.max(dp[n - 1][m - 1][1], dp[n - 1][m - 1][2]));
    }
}