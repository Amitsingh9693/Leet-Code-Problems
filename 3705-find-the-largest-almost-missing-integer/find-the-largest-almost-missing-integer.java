class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        int[] freq=new int[51];
        int max=0;
        for(int i:nums){
            freq[i]++;
            max=Math.max(i,max);
        }
        if(k==n) return max;
        if(k==1){
            max=-1;
            for(int i=50;i>=0;i--) if(freq[i]==1){
                max=i;
                break;
            }
            return max;
        }
        n=n-1;
        if(nums[0]==nums[n]) return -1;
        if(freq[nums[0]]==1 && freq[nums[n]]==1) return Math.max(nums[0],nums[n]);
        if(freq[nums[0]]==1 && freq[nums[n]]>1) return nums[0];
        if(freq[nums[0]]>1 && freq[nums[n]]==1) return nums[n];
        return -1;
    }
}