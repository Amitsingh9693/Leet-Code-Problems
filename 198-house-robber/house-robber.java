class Solution {
    int f(int[] nums,int i,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!= -1) return dp[i];
        int p=nums[i]+f(nums,i+2,dp);
        int np=f(nums,i+1,dp);

        return dp[i]=Math.max(p,np);
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return f(nums,0,dp);
    }
}