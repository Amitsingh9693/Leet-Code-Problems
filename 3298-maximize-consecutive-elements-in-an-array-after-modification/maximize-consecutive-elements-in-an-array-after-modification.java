class Solution {
    public int maxSelectedElements(int[] nums) {
        int max=0;
        Arrays.sort(nums);
        int[] dp=new int[nums[nums.length-1]+2];
        for(int x:nums){
            dp[x+1]=dp[x]+1;
            dp[x]=dp[x-1]+1;
            max=Math.max(max,Math.max(dp[x+1],dp[x]));
        }
        return max;
    }
}