class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> qu=new LinkedList<>();
        for(int i=0;i<tickets.length;i++) qu.offer(new int[]{tickets[i],i});
        int sec=0;
        while(!qu.isEmpty()){
            int[] curr=qu.poll();
            curr[0]--;
            sec++;
            if(curr[0]==0){
                if(curr[1]==k) return sec;
            }else{
                qu.offer(curr);
            }
        }
        return sec;
    }
}