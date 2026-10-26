class Solution {
    public long dfs(int[][]grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return 0;
        long ans=grid[i][j];
        grid[i][j]=0;
        ans+=dfs(grid,i+1,j);
        ans+=dfs(grid,i-1,j);
        ans+=dfs(grid,i,j+1);
        ans+=dfs(grid,i,j-1);
        return ans;
    }
    public int countIslands(int[][] grid, int k) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0){
                    long sum=dfs(grid,i,j);
                    if(sum%k==0) count++;
                }
            }
        }
        return count;
    }
}