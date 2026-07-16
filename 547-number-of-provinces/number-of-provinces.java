class Solution {
    void dfs(boolean[] vis,ArrayList<ArrayList<Integer>> graph,int node){
        Stack<Integer> st=new Stack<>();
        st.push(node);
        while(!st.isEmpty()){
            int i=st.pop();
            if(vis[i]) continue;
            vis[i]=true;
            for(int j=graph.get(i).size()-1;j>=0;j--){
                int a=graph.get(i).get(j);
                if(!vis[a]) {
                    st.push(a);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    graph.get(i).add(j);
                }
            }
        }
        boolean[] vis=new boolean[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(vis,graph,i);
                c++;
            }
        }
        return c;
    }
}