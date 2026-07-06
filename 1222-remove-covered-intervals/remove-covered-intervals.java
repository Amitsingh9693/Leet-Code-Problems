class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int c=0;
        int i=0,j=1;
        int n=intervals.length;
        while(i<n){
            if(j<n && intervals[i][1]>=intervals[j][1]){
                j++;
            }
            else if(j<n && intervals[i][0]==intervals[j][0] && intervals[i][1]<intervals[j][1]){
                i=j;
                j++;
            }
            else{
                if(i==j) i++;
                else i=j;
                c++;
            }
        }
        return c;
    }
}