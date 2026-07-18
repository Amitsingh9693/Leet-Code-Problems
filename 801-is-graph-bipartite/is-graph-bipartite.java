class Solution {
    boolean check(int i,ArrayList<ArrayList<Integer>> adj,int[] vis){
        Queue<Integer> q=new ArrayDeque<>();
        q.add(i);
        vis[i]=0;
        while(!q.isEmpty()){
            int n=q.remove();
            for(int a:adj.get(n)){
                if(vis[a]==-1){
                    vis[a]=1-vis[n];
                    q.add(a);
                }
                else if(vis[a]==vis[n]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] vis=new int[n];
        Arrays.fill(vis,-1);

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j:graph[i]){
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
        }

        for(int i=0;i<n;i++){
            if(vis[i]==-1)
            if(!check(i,adj,vis)) return false;
        }
        return true;
    }
}