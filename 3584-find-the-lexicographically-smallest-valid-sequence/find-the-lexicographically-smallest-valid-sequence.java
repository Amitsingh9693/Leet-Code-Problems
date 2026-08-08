class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[] suff=new int[m];
        Arrays.fill(suff,-1);
        int j=m-1;
        for(int i=n-1;i>=0;i--){
            if(j>=0 && word1.charAt(i)==word2.charAt(j)){
                suff[j]=i;
                j--;
            }
        }
        int[] res=new int[m];
        j=0;
        int skip=0;
        for(int i=0;i<n;i++){
            if(j==m) break;
            if(word1.charAt(i)==word2.charAt(j) || (skip==0 && (j==m-1 || i<suff[j+1]))){
                skip+=word1.charAt(i)!=word2.charAt(j) ? 1:0;
                res[j]=i;
                j++;
            }
        }
        return j==m ? res:new int[0];
    }
}