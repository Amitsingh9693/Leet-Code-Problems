class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && dfs(i, graph, state)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, int[] state) {
        state[node] = 1;
        for (int next : graph.get(node)) {
            if (state[next] == 1) {
                return true; 
            }
            if (state[next] == 0 && dfs(next, graph, state)) {
                return true;
            }
        }
        state[node] = 2;
        return false;
    }
}