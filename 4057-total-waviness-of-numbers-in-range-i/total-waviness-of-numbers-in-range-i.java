class Solution {
    int count=0;
    public void waves(String s){
        for(int i=1;i<s.length()-1;i++){
            int a=s.charAt(i)-'0';
            int b=s.charAt(i-1)-'0';
            int c=s.charAt(i+1)-'0';
            if((a>b && a>c) || (a<b && a<c)) count++;
        }
    }
    public int totalWaviness(int num1, int num2) {
        for(int i=num1;i<=num2;i++) waves(Integer.toString(i));
        return count;
    }
}