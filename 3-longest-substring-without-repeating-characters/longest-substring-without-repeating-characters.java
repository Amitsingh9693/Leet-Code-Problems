class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> list=new ArrayList<>();
        int max=0,i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            while(list.contains(ch)) list.remove(0);
            list.add(ch);
            max=Math.max(max,list.size());
            i++;
        }
        return max;
    }
}