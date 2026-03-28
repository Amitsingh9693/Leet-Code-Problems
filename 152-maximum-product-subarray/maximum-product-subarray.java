class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int me=nums[0];
        int le=nums[0];

        for(int i=1;i<nums.length;i++){
            int c=nums[i];
            if(c<0){
                int t=me;
                me=le;
                le=t;
            }

            me=Math.max(c,c*me);
            le=Math.min(c,c*le);

            max=Math.max(max,me);
        }
        return max;
    }
}