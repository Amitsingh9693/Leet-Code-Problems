class Solution {
    public int trailingZeroes(int n) {
        int c=0;
        while(n>0){
            n=(int)Math.floor(n/5);
            c+=n;
        }
        return c;
    }
}