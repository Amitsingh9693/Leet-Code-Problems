class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        int n=nums.length;
        sum=new int[n];
        int s=0;
        for(int i=0;i<n;i++){
            s+=nums[i];
            sum[i]=s;
        }
    }
    
    public int sumRange(int left, int right) {
        return left==0 ?sum[right]:sum[right]-sum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */