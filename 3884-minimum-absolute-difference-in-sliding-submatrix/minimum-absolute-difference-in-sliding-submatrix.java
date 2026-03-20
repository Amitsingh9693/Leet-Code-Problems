class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] res=new int[m-k+1][n-k+1];
        if(k==1) return res;
        for(int i=0;i<m-k+1;i++){
            for(int j=0;j<n-k+1;j++){
                int[] arr=new int[k*k];
                int s=0;
                for(int l=i;l<i+k;l++){
                    for(int h=j;h<j+k;h++){
                        arr[s++]=grid[l][h];
                    }
                }

                Arrays.sort(arr);
                int min=Integer.MAX_VALUE;
                for(int l=1;l<k*k;l++){
                    if(arr[l]!=arr[l-1]){
                        min=Math.min(min,arr[l]-arr[l-1]);
                    }
                }
                res[i][j]=min==Integer.MAX_VALUE? 0:min;
            }
        }
        return res;
    }
}