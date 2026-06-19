class Solution {
    void conqure(int[] nums,int l,int mid,int r){
        int[] merge=new int[r-l+1];
        int i1=l;
        int i2=mid+1;
        int i3=0;

        while(i1<=mid && i2<=r){
            if(nums[i1]<=nums[i2]) merge[i3++]=nums[i1++];
            else merge[i3++]=nums[i2++];
        }

        while(i1<=mid) merge[i3++]=nums[i1++];
        while(i2<=r) merge[i3++]=nums[i2++];

        for(int i=0,j=l;i<merge.length;i++,j++){
            nums[j]=merge[i];
        }
    }
    void divide(int[] nums,int l,int r){
        if(l>=r) return;
        int mid=l+(r-l)/2;
        divide(nums,l,mid);
        divide(nums,mid+1,r);
        conqure(nums,l,mid,r);
    }
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        divide(nums,0,n-1);
        return nums;
    }
}