class Solution {
    public long sumAndMultiply(int n) {
        int sum=0;
        StringBuilder str=new StringBuilder();
        while(n>0){
            if(n%10==0){
                n/=10;
                continue;
            }
            int digit=n%10;
            str.append(digit);
            sum+=digit;
            n/=10;
        }
        if(str.toString()=="") return 0;
        long num= Integer.parseInt(str.reverse().toString());
        return num*sum;
    }
}