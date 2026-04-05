class Solution {
    public boolean judgeCircle(String moves) {
        int[] a=new int[4];
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U') a[0]++;
            else if(moves.charAt(i)=='D') a[1]++;
            else if(moves.charAt(i)=='L') a[2]++;
            else a[3]++;
        }

        return a[0]==a[1] && a[2]==a[3];
    }
}