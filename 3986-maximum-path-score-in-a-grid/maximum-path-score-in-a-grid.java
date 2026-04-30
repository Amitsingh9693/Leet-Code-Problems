// class Solution {
//     int m,n;
//     int[][] grid;
//     int[][][] dp;

//     int f(int i,int j,int k){
//         if(i>=m || j>=n) return -1;
        
//         int cost=(grid[i][j]==0) ? 0:1;
//         if(k<cost) return -1;

//         int score=grid[i][j];

//         if(i==m-1 && j==n-1) return score;

//         if(dp[i][j][k]!=-1) return dp[i][j][k];
//          int r= f(i,j+1,k-cost);
//          int d= f(i+1,j,k-cost);

//         int ms=Math.max(r,d);

//         if(ms!=-1)
//         return dp[i][j][k]=score+ms;

//         return dp[i][j][k]=-1;
//     }
//     public int maxPathScore(int[][] grid, int k) {
//         this.m=grid.length;
//         this.n=grid[0].length;
//         this.grid=grid;
//         dp=new int[m+1][n+1][k+1];
//          for(int i=0;i<=m;i++){
//             for(int j=0;j<=n;j++){
//                 Arrays.fill(dp[i][j],-1);
//             }
//          }

//         return f(0,0,k);


        
//     }
// }


class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int cost = (grid[0][0] == 0) ? 0 : 1;
        if (k >= cost) {
            dp[0][0][k] = grid[0][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int rem = 0; rem <= k; rem++) {

                    if (dp[i][j][rem] == -1) continue;

                    int curr = dp[i][j][rem];

                    if (j + 1 < n) {
                        int nextCost = (grid[i][j + 1] == 0) ? 0 : 1;
                        if (rem >= nextCost) {
                            dp[i][j + 1][rem - nextCost] = Math.max(
                                dp[i][j + 1][rem - nextCost],
                                curr + grid[i][j + 1]
                            );
                        }
                    }

                    if (i + 1 < m) {
                        int nextCost = (grid[i + 1][j] == 0) ? 0 : 1;
                        if (rem >= nextCost) {
                            dp[i + 1][j][rem - nextCost] = Math.max(
                                dp[i + 1][j][rem - nextCost],
                                curr + grid[i + 1][j]
                            );
                        }
                    }
                }
            }
        }

        int ans = -1;
        for (int rem = 0; rem <= k; rem++) {
            ans = Math.max(ans, dp[m - 1][n - 1][rem]);
        }

        return ans;
    }
}