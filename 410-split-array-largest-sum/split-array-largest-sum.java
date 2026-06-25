class Solution {
    boolean possible(int[] nums,int k,int mid){
        int s=1,sum=0;
        for(int i:nums){
            if(i+sum>mid){
                s++;
                sum=i;
                if(s>k) return false;
            }else{
                sum+=i;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(k>n) return 0;
        int l=0,h=0;
        for(int i:nums){
            l=Math.max(l,i);
            h+=i;
        }
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;

            if(possible(nums,k,mid)){
                ans=mid;
                h=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}