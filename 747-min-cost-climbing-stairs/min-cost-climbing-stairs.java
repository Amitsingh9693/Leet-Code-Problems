class Solution {
    int f(int[] nums,int i,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!= -1) return dp[i];
        return dp[i]=nums[i]+Math.min(f(nums,i+2,dp),f(nums,i+1,dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(f(cost,0,dp),f(cost,1,dp));
    }
}