class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            if (nums[i] >= n) return false;
            arr[nums[i]]++;
        }
        for(int i=1;i<n-1;i++) if(arr[i]!=1) return false;
        return arr[n-1]==2;
    }
}