class Solution {
    public boolean canAliceWin(int n) {
        if(n<10) return false;
        int c=0,r=10;
        while(n>0){
            if(n-r<0) break;
            n-=r;
            r--;
            c++;
        }
        return c%2==0 ? false:true;
    }
}