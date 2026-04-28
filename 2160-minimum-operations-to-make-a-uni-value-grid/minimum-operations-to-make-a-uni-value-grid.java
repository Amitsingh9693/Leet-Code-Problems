class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        int[] arr=new int[n*m];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[k++]=grid[i][j];
            }
        }
        Arrays.sort(arr);
        k/=2;
        int c=0;
        for(int i=0;i<m*n;i++){
            int a=Math.abs(arr[k]-arr[i]);
            if(a%x!=0) return -1;
            c+=a/x;
        }
        return c;
    }
}