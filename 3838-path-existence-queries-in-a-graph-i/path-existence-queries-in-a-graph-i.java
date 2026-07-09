class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] arr=new int[n];
        arr[0]=0;
        for(int i=1;i<n;i++){
            if((nums[i]-nums[i-1])<=maxDiff) arr[i]=arr[i-1];
            else arr[i]=arr[i-1]+1;
        }
        boolean[] ans=new boolean[queries.length];
        for(int i=0; i<queries.length;i++){
            ans[i]=arr[queries[i][0]]==arr[queries[i][1]];
        }
        return ans;
    }
}