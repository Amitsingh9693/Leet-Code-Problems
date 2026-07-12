class Solution {
    void combination(int idx,int n,int k,List<List<Integer>> ans,List<Integer> list){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return ;
        }
        for(int i=idx;i<=n;i++){
            list.add(i);
            combination(i+1,n,k,ans,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        combination(1,n,k,ans,new ArrayList<>());
        return ans;
    }
}