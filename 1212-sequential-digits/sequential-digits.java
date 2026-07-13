class Solution {
    void f(List<Integer> ans,int l,int h,int num,int n){
        if(num>h) return;
        if(num>=l && num<=h) ans.add(num);
        if(n>9) return;
        num=num*10+n;;
        f(ans,l,h,num,n+1);
        return;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=9;i++)
        f(ans,low,high,i,i+1);
        Collections.sort(ans);
        return ans; 
    }
}