class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++) nums[i]=Math.abs(nums[i]);
        Arrays.sort(nums);
        int i=0,j=n-1;
        while(i<=j){
            ans+=nums[j]*nums[j];
            if(i!=j) ans-=nums[i]*nums[i];
            i++;j--;
        }
        return ans;
    }
}