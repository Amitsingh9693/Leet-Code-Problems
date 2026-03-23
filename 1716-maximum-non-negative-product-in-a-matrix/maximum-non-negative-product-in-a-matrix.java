class Solution {
    public int maxProductPath(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        long mod=1000000007;
        long[][] max=new long[m+1][n+1];
        long[][] min=new long[m+1][n+1];

        min[0][0]=max[0][0]=grid[0][0];

        for(int i=1;i<m;i++){
            min[i][0]=max[i][0]=max[i-1][0]*grid[i][0];
        }
        for(int i=1;i<n;i++){
            min[0][i]=max[0][i]=max[0][i-1]*grid[0][i];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                long a=max[i][j-1]*grid[i][j];
                long b=min[i][j-1]*grid[i][j];
                long c=max[i-1][j]*grid[i][j];
                long d=min[i-1][j]*grid[i][j];

                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        if(max[m-1][n-1]<0) return -1;
        return (int)(max[m-1][n-1]%mod);
    }
}