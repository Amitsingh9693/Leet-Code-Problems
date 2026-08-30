class Solution {
    public int minimumDeletions(int[] nums) {
        int min=0,max=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[min]>nums[i]) min=i;
            if(nums[max]<nums[i]) max=i;
        }
        int f=Math.max(min,max)+1;
        int b=n-Math.min(min,max);
        int m=Math.min(min,n-min)+Math.min(max,n-max)+1;
        return Math.min(f,Math.min(b,m));
    }
}