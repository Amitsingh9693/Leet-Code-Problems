class Solution {
    public boolean checkDivisibility(int n) {
        int s=0,p=1,t=n;
        while(t>0){
            int d=t%10;
            s+=d;
            p*=d;
            t/=10;
        }       
        return n%(s+p)==0;
    }
}