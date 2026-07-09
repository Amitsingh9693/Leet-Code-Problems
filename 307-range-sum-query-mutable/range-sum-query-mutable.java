class NumArray {
    int[] seg;
    int[] nums;
    int n;
    void build(int i,int l,int r){
        if(l==r) {
            seg[i]=nums[l];
            return;
        }
        int mid=(l+r)/2;
        build(2*i+1,l,mid);
        build(2*i+2,mid+1,r);
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }
    public NumArray(int[] nums) {
        this.n=nums.length;
        this.nums=nums;
        seg=new int[4*n];
        build(0,0,n-1);
    }
    
    void up(int i,int l,int r,int index,int val){
        if(l==r){
            seg[i]=val;
            return;
        }
        int mid=(l+r)/2;
        if(index<=mid) up(2*i+1,l,mid,index,val);
        else up(2*i+2,mid+1,r,index,val);
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }
    public void update(int index, int val) {
        up(0,0,n-1,index,val);
    }
    int sum(int i,int s,int e,int l,int r){
        if(e<l || s>r) return 0;
        if(l<=s && e<=r) return seg[i];
        int mid=(s+e)/2;
        return sum(2*i+1,s,mid,l,r)+sum(2*i+2,mid+1,e,l,r);

    }
    public int sumRange(int left, int right) {
        return sum(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */