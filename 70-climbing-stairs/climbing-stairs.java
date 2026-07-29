class Solution {
    int step(int n,int[] ans){
        if(n==1) return 1;
        if(n==2) return 2;
        if(ans[n]!=-1) return ans[n];
        return ans[n]=step(n-1,ans)+step(n-2,ans);
    }
    public int climbStairs(int n) {
        int[] ans=new int[n+1];
        Arrays.fill(ans,-1);
        return step(n,ans);
    }
}