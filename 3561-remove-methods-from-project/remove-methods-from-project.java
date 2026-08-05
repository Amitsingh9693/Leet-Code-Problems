class Solution {
    void dfs(int k, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[k] = true;
        for (int i : adj.get(k))
            if (!vis[i])
                dfs(i, vis, adj);
    }

    boolean check(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[i] = true;
        for (int j : adj.get(i)) {
            if (!vis[j])
                check(j, vis, adj);
            else
                return true;
        }
        vis[i] = false;
        return false;
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < invocations.length; i++) {
            int u = invocations[i][0];
            int v = invocations[i][1];
            adj.get(u).add(v);
        }
        boolean[] vis = new boolean[n];
        dfs(k, vis, adj);
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!vis[u] && vis[v]) {
                List<Integer> ans1 = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans1.add(i);
                return ans1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i])
                ans.add(i);
        }
        return ans;
    }
}