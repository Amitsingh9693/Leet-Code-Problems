class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        if(n==0) return new int[]{};
        int[][] copy=new int[n][2];
        for(int i=0;i<n;i++){
            copy[i][0]=arr[i];
            copy[i][1]=i;
        }
        Arrays.sort(copy,(a,b)->Integer.compare(a[0],b[0]));
        int idx=1;
        arr[copy[0][1]]=idx;
        for(int i=1;i<n;i++){
            if(copy[i][0]==copy[i-1][0]) arr[copy[i][1]]=arr[copy[i-1][1]];
            else{
                idx++;
                arr[copy[i][1]]=idx;
            }
        }
        return arr;
    }
}