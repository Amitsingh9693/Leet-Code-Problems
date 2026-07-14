class Solution {
    int[][][] dp;
    int solve(int[] nums,int i,int seq1,int seq2){
        if(i==nums.length){
            return (seq1!=0 && seq2!=0 && seq1==seq2) ? 1:0;
        }
        if(dp[i][seq1][seq2]!=-1) return dp[i][seq1][seq2];
        long ans=0;
        ans+=solve(nums,i+1,seq1,seq2);
        ans+=solve(nums,i+1,gcd(nums[i],seq1),seq2);
        ans+=solve(nums,i+1,seq1,gcd(nums[i],seq2));

        return dp[i][seq1][seq2]=(int)(ans%1000000007);
    }
    int gcd(int a,int b){
        if(a==0) return b;
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
    public int subsequencePairCount(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i:nums) max=Math.max(i,max);
        dp=new int[n+1][max+1][max+1];
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=max;j++){
        //         Arrays.fill(dp[i][j],-1);
        //     }
        // }
        // return solve(nums,0,0,0);
        for(int i=0;i<=max;i++){
            for(int j=0;j<=max;j++){
                if(i==j && i!=0 && j!=0)
                dp[n][i][j]=1;
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int seq1=max;seq1>=0;seq1--){
                for(int seq2=max;seq2>=0;seq2--){
                    long ans=0;
                    ans+=dp[i+1][seq1][seq2];
                    ans+=dp[i+1][gcd(nums[i],seq1)][seq2];
                    ans+=dp[i+1][seq1][gcd(nums[i],seq2)];
                    dp[i][seq1][seq2]=(int)(ans%1000000007);
                }
            }
        }
        return dp[0][0][0];
    }
}