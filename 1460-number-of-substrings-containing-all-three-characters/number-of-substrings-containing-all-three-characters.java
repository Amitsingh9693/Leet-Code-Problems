class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] fre={-1,-1,-1};
        int res=0;
        for(int i=0;i<n;i++){
            fre[s.charAt(i)-'a']=i;
            res+=Math.min(fre[0],Math.min(fre[1],fre[2]))+1;
        }
        return res;
    }
}