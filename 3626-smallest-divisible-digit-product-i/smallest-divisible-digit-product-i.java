class Solution {
    boolean check(int n,int t){
        int p=1;
        while(n>0){
            p*=n%10;
            n/=10;
        }
        return p%t==0;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<n+11;i++){
            if(check(i,t)) return i;
        }
        return 0;
    }
}