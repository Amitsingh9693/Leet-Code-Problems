class Solution {
    public int minChanges(String s) {
        int c=0,i=0,n=s.length();
        // while(i<n){
        //     if(s.charAt(i)=='1'){
        //         int c_1=0;
        //         while(i<n && s.charAt(i)=='1'){
        //             c_1++;
        //             i++;
        //         }
        //         if(c_1%2!=0){
        //             c++;
        //             i++;
        //         }
        //     }
        //     else{
        //         int c_0=0;
        //         while(i<n && s.charAt(i)=='0'){
        //             c_0++;
        //             i++;
        //         }
        //         if(c_0%2!=0){
        //             c++;
        //             i++;
        //         }
        //     }
        // }
        // return c;
        for(i=0;i<n;i+=2) if(s.charAt(i)!=s.charAt(i+1)) c++;
        return c;
    }
}