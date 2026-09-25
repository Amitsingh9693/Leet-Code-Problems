class Solution {
    TreeSet<String> str=new TreeSet<>();
    void solve(String s){
        int i=s.indexOf('}');
        if(i==-1){
            str.add(s);
            return ;
        }

        int j=s.lastIndexOf('{',i);
        String l=s.substring(0,j);
        String r=s.substring(i+1);
        String p=s.substring(j+1,i);
        for(String c:p.split(",")){
            solve(l+c+r);
        }
    }
    public List<String> braceExpansionII(String expression) {
        solve(expression);
        return new ArrayList<>(str);
    }
}