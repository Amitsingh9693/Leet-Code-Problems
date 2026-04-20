class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int d=0;
        for(int i=n-1;i>=0;i--){
            if(colors[0]!=colors[i]) d=Math.max(d,i);
        }
        for(int i=0;i<n;i++){
            if(colors[i]!=colors[n-1]) d=Math.max(d,n-i-1);
        }
        return d;
    }
}