class Solution {
    
    int[][][] dirs = {
        {},
        {{0,-1},{0,1}},   
        {{-1,0},{1,0}},   
        {{0,-1},{1,0}},   
        {{0,1},{1,0}},    
        {{0,-1},{-1,0}},  
        {{0,1},{-1,0}}    
    };

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        return dfs(grid, 0, 0, vis);
    }

    boolean dfs(int[][] grid, int i, int j, boolean[][] vis) {
        int n = grid.length, m = grid[0].length;

        if(i == n-1 && j == m-1) return true;
        vis[i][j] = true;

        for(int[] d : dirs[grid[i][j]]) {
            int ni = i + d[0];
            int nj = j + d[1];

            if(ni<0 || nj<0 || ni>=n || nj>=m || vis[ni][nj]) continue;

            for(int[] back : dirs[grid[ni][nj]]) {
                if(ni + back[0] == i && nj + back[1] == j) {
                    if(dfs(grid, ni, nj, vis)) return true;
                }
            }
        }
        return false;
    }
}