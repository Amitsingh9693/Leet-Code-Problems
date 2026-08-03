class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int[] dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int b=Integer.MIN_VALUE;
            int r=0;
            for(int k=1;k<=3;k++){
                if(i+k>n) break;
                r+=stoneValue[i+k-1];
                b=Math.max(b,r-dp[i+k]);
            }
            dp[i]=b;
        }
        return dp[0]>0? "Alice": dp[0]<0 ? "Bob" : "Tie";
    }
}