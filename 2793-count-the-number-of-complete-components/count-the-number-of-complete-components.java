class Solution {
    int node=0;
    int edge=0;
    void check(int i,boolean[] vis,ArrayList<ArrayList<Integer>> ans){
        vis[i]=true;
        node++;
        edge+=ans.get(i).size();
        for(int j:ans.get(i)){
            if(!vis[j]) check(j,vis,ans);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] vis=new boolean[n];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++) ans.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            ans.get(u).add(v);  
            ans.get(v).add(u);  
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                node=0;
                edge=0;
                check(i,vis,ans);
                if(edge/2==node*(node-1)/2) c++;
            }
        }
        return c;

    }
}