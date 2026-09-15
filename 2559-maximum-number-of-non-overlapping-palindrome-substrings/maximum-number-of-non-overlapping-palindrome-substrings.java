class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length(),ans=0,start=0;
        for(int i=0;i<2*n-1;i++){
            int l=i/2,r=l+i%2;
            while(l>=start && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>=k){
                    ++ans;
                    start=r+1;
                    break;
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}