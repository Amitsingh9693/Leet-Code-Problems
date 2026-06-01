class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n=cost.length;
        int sum=0;
        int c=0;
        for(int i=n-1;i>=0;i--){
            if(c==2){
                c=0;
                 continue;
            }
            sum+=cost[i];
            c++;
        }
        return sum;
    }
}