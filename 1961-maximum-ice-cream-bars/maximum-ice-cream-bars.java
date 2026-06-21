class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max=0,c=0;
        for(int i:costs){
            max=Math.max(i,max);
        }

        int[] count=new int[max+1];
        for(int i=0;i<costs.length;i++){
            count[costs[i]]++;
        }

        for(int i=0;i<max+1;i++){
            while(count[i]!=0 && coins>=i){
                coins-=i;
                count[i]--;
                c++;
            }
        }
        return c;
    }
}