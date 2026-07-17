class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max=0;
        for(int i:nums) max=Math.max(i,max);
        int[] frq=new int[max+1];
        for(int i:nums) frq[i]++;

        long[] exact=new long[max+1];
        for(int g=max;g>=1;g--){
            long count=0;
            for(int m=g;m<=max;m+=g) count+=frq[m];
            long pair=(count*(count-1))/2;
            for(int m=2*g;m<=max;m+=g){
                pair-=exact[m];
            }
            exact[g]=pair;
        }

        long[] pre=new long[max+1];
        for(int i=1;i<=max;i++) pre[i]=pre[i-1]+exact[i];

        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            long q=queries[i]+1;

            int low=1,high=max;
            while(low<high){
                int m=low+(high-low)/2;
                if(pre[m]>=q) high=m;
                else low=m+1;
            }
            ans[i]=low;
        }
        return ans;
    }
}