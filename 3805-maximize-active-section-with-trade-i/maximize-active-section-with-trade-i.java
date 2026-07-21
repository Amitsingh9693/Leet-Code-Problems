class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int one=0,max=0,prev=-1,i=0,n=s.length();
        while(i<n){
            if(s.charAt(i)=='1'){
                one++;
                i++;
            }else{
                int curr=0;
                while(i<n && s.charAt(i)=='0'){
                    curr++;
                    i++;
                }
                if(prev>0) max=Math.max(max,prev+curr);
                prev=curr;
            }
        }
        return max+one;
    }
}