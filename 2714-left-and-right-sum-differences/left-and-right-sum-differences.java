class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] sum=new int[n];
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+nums[i-1];
        }
        int s=nums[n-1];
        for(int i=n-2;i>=0;i--){
            sum[i]=Math.abs(sum[i]-s);
            s+=nums[i];
        }
        return sum;
    }
}