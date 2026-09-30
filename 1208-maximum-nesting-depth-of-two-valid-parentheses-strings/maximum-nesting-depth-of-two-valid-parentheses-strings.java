class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans=new int[seq.length()];
        int c=0,i=0;
        for(char ch:seq.toCharArray()){
            if(ch=='(') ans[i++]=(c++)%2;
            else ans[i++]=(--c)%2;
        }
        return ans;
    }
}