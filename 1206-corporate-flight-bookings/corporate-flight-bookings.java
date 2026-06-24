class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff=new int[n+1];

        for(int i=0;i<bookings.length;i++){
            int l=bookings[i][0];
            int r=bookings[i][1];
            int v=bookings[i][2];
            diff[l-1]+=v;
            if(r<n) diff[r]-=v;
        }

        int curr=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            curr+=diff[i];
            arr[i]=curr;
        }
        return arr;
    }
}