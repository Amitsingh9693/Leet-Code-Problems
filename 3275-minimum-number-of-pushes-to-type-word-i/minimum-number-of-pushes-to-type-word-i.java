class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int push=0,i=1;
        while(n>0){
            if(n>8){
                push+=8*i;
            }else{
                push+=n*i;
            }
            n-=8;
            i++;
        }
        return push;
    }
}