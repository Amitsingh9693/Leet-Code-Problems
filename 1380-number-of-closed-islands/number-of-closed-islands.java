class Solution {
    boolean dfs(int[][] grid,int i,int j){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 ) return false;
        if(grid[i][j]==1) return true;
        grid[i][j]=1;
        boolean a = dfs(grid, i + 1, j);
        boolean b = dfs(grid, i - 1, j);
        boolean c = dfs(grid, i, j + 1);
        boolean d = dfs(grid, i, j - 1);

        return a && b && c && d;
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j)) count++;
                }
            }
        }
        return count;
    }
}