class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        if(n==1) return s;
        int[] freq=new int[26];
        for(int i=0;i<n;i++) freq[s.charAt(i)-'a']++;
        int mid=-1;
        String res="";
        for(int i=0;i<26;i++){
            int a=freq[i]/2;
            while(a>0) {
                res+=(char)(i+97);
                a--;
            }
            if(freq[i]%2!=0){
                mid=i;
            }
        }
        StringBuilder str=new StringBuilder(res).reverse();
        return mid==-1? res+str.toString():res+(char)(mid+97)+str.toString();
    }
}