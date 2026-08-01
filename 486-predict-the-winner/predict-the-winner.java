class Solution {
    int[][] dp=new int[21][21];
    int solve(int[] nums,int i,int j){
        if(i>j) return 0;
        if(i==j) return nums[i];
        if(dp[i][j]!=-1) return dp[i][j];
        int ti=nums[i]-solve(nums,i+1,j);
        int tj=nums[j]-solve(nums,i,j-1);
        return dp[i][j]=Math.max(ti,tj);
    }
    public boolean predictTheWinner(int[] nums) {
        for(int i=0;i<21;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,0,nums.length-1)>=0;
        
    }
}