class Solution {
    boolean f(int[] arr,int i,boolean[] dp){
        if(i<0 || i>=arr.length || dp[i]) return false;
        if(arr[i]==0) return true;
        dp[i]= true;
        return dp[i]=f(arr,i+arr[i],dp)||f(arr,i-arr[i],dp);
    }
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean[] dp=new boolean[n+1];
        return f(arr,start,dp);
    }
}