class Solution {
    boolean check(int[] piles,int mid,int h){
        int curr=0;
        for(int i:piles){
            curr+=(i+mid-1)/mid;
            if(curr>h) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,hi=0;
        for(int i:piles) hi=Math.max(hi,i);
        int ans=-1;
        while(l<=hi){
            int mid=l+(hi-l)/2;
            if(check(piles,mid,h)){
                ans=mid;
                hi=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}