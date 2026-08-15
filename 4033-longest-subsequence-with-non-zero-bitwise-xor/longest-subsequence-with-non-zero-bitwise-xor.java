class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int resxor=0;
        boolean zero=true;
        for(int i:nums){
            resxor^=i;
            if(i!=0) zero=false;
        }
        if(zero) return 0;
        return resxor==0 ? n-1:n;
    }
}