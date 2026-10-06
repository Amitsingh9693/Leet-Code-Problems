class Solution {
    public int minAddToMakeValid(String s) {
        int ans=0,c=0;
        for(char ch:s.toCharArray()){
            if(ch=='(') c++;
            else{
                if(c==0) ans++;
                else c--;
            }
        }
        return ans+c;
    }
}