class Solution {
    void dfs(int[][] image, int sr, int sc, int color,boolean[][] vis,int n){
         if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=n||vis[sr][sc]) return;
        vis[sr][sc]=true;
        image[sr][sc]=color;
        dfs(image,sr-1,sc,color,vis,n);
        dfs(image,sr+1,sc,color,vis,n);
        dfs(image,sr,sc-1,color,vis,n);
        dfs(image,sr,sc+1,color,vis,n);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis=new boolean[image.length][image[0].length];
        dfs(image,sr,sc,color,vis,image[sr][sc]);
        return image;
    }
}