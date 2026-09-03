class Solution {
    public boolean uniformArray(int[] nums1) {
        int so=Integer.MAX_VALUE;
        for(int i:nums1) if(i%2!=0) so=Math.min(i,so);
        if(so==Integer.MAX_VALUE) return true;
        for(int i:nums1) if(i%2==0 && i<=so) return false;
        return true;
    }
}