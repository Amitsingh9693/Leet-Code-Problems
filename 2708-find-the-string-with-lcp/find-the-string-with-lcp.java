class Solution {
    public String findTheString(int[][] lcp) {
        int n=lcp.length;
        char[] word=new char[n];
        char ch='a';

        for(int i=0;i<n;i++){
            if(word[i]>0) continue;
            if(ch>'z') return "";
            word[i]=ch;
            for(int j=i+1;j<n;j++){
                if(lcp[i][j]>0) word[j]=word[i];
            }
            ch++;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int pre=0;
                if(word[i]==word[j]){
                    if(i==n-1 || j==n-1) pre=1;
                    else pre=lcp[i+1][j+1]+1;
                }
                else pre=0;
                if(pre!=lcp[i][j]) return "";
            }
        }
        return new String(word);
    }
}