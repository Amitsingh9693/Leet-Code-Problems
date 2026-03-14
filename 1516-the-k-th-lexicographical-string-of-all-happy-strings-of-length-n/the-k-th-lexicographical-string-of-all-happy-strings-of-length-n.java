class Solution {
    void f(ArrayList<String> ans,char[] a,int n,ArrayList<Character> ch){
        if(ch.size()==n){
            String s="";
            for(int i=0;i<ch.size();i++){
                s+=ch.get(i);
            }
            ans.add(s);
            return;
        }
        for(int i=0;i<3;i++){
            if(ch.isEmpty()||ch.get(ch.size()-1)!=a[i]){
                ch.add(a[i]);
                f(ans,a,n,ch);
            }
            else continue;
            ch.remove(ch.size()-1);
        }
    }
    public String getHappyString(int n, int k) {
        char[] a={'a','b','c'};
        ArrayList<String> ans=new ArrayList<>();
        f(ans,a,n,new ArrayList<>());
        String ab=k<=ans.size()?ans.get(k-1):"";
        return ab;
    }
}