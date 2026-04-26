class Solution {
    static int[][] dir={ {0,-1},{0,1},{1,0},{-1,0}};
    boolean dfs(int i,int j,int pr,int pc,boolean[] vis,char[][] grid,int n,int m){
        vis[i*m+j]=true;
        for(int k=0;k<4;k++){
            int nr=i+dir[k][0];
            int nc=j+dir[k][1];

            if((nc!=pc || nr!=pr) && nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==grid[i][j]){
                if(vis[nr*m+nc] || dfs(nr,nc,i,j,vis,grid,n,m)) return true;
            }
        }
            return false;
    }
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[] vis=new boolean[m*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i*m+j] && dfs(i,j,-1,-1,vis,grid,n,m)) return true;
            }
        }
        return false;
    }

}