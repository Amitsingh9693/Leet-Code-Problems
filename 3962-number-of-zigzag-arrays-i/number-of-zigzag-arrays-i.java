class Solution {
    public int zigZagArrays(int n, int l, int r) {
        long MOD=1000000007;
        int k=r-l+1;
        int[][] dp=new int[k+1][2];
        for(int i=1;i<=k;i++){
            dp[i][0]=k-i;
            dp[i][1]=i-1;
        }
        for(int i=3;i<=n;i++){
            int[][] nextdp=new int[k+1][2];
            long runs0=0;
            for(int v=1;v<=k;v++){
                nextdp[v][1]=(int)runs0;
                runs0=(runs0+dp[v][0])%MOD;
            }
            long runs1=0;
            for(int v=k;v>=1;v--){
                nextdp[v][0]=(int)runs1;
                runs1=(runs1+dp[v][1])%MOD;
            }
            dp=nextdp;
        }
        long total=0;
        for(int i=1;i<=k;i++){
            total=(total+dp[i][0])%MOD;
            total=(total+dp[i][1])%MOD;
        }
        return (int)total;
    }
}