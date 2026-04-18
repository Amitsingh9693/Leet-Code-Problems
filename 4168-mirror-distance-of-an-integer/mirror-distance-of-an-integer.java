class Solution {
    public int mirrorDistance(int n) {
        int t=n;
        int r=0;
        while(t>0){
            r=r*10+t%10;
            t/=10;
        }
        return Math.abs(r-n);
    }
}