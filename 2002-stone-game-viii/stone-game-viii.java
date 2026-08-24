class Solution {
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        int[] dp=new int[n];
        dp[0]=stones[0];
        for(int i=1;i<n;i++) dp[i]=dp[i-1]+stones[i];
        int[] dp1=new int[n];
        dp1[n-1]=dp[n-1];
        for(int i=n-2;i>=0;i--) dp1[i]=Math.max(dp1[i+1],dp[i]-dp1[i+1]);
        return dp1[1];
    }
}