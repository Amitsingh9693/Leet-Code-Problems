class Solution {
    int solve(int[] piles,int i,int m,int n,int p,int[][][] dp){
        if(i>=n) return 0;
        if(dp[p][i][m]!=-1) return dp[p][i][m];
        int s=0,r= p==1?-1:Integer.MAX_VALUE;
        for(int x=1;x<=Math.min(2*m,n-i);x++){
            s+=piles[i+x-1];
            if(p==1) r=Math.max(r,s+solve(piles,i+x,Math.max(m,x),n,0,dp));
            else r=Math.min(r,solve(piles,i+x,Math.max(m,x),n,1,dp));
        }
        return dp[p][i][m]=r;
    }
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int[][][] dp=new int[2][101][101];
        for(int i=0;i<2;i++){
            for(int j=0;j<101;j++){
                for(int k=0;k<101;k++) dp[i][j][k]=-1;
            }
        }
        return solve(piles,0,1,n,1,dp);
    }
}