class Solution {
    int sum(int n){
        int s=0;
        while(n>0){
            s+=n%10;
            n/=10;
        }
        return s;
    }
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,sum(nums[i]));
        }
        return min;
    }
}