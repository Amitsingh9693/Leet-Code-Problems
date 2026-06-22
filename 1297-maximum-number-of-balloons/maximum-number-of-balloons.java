class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq=new int[26];
        int n=text.length();
        for(int i=0;i<n;i++){
            char ch=text.charAt(i);
            freq[ch-'a']++;
        }

        return Math.min(Math.min(freq['b'-'a'],freq['a'-'a']),Math.min(freq['l'-'a']/2,Math.min(freq['o'-'a']/2,freq['n'-'a'])));
    }
}