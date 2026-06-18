class Solution {
    public double angleClock(int hour, int minutes) {
        double minangle=minutes*6;
        double hourangle= 30*hour + (minangle/360)*30;
        double ans=Math.abs(minangle-hourangle);
        return Math.min(360-ans,ans);
    }
}