class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] e1=new int[26];
        int[] o1=new int[26];
        int[] e2=new int[26];
        int[] o2=new int[26];

        for(int i=0;i<s1.length();i++){
            if(i%2==0){
                e1[s1.charAt(i)-'a']++;
                e2[s2.charAt(i)-'a']++;
            }
            else{
                o1[s1.charAt(i)-'a']++;
                o2[s2.charAt(i)-'a']++;
            }
        }
        for(int i=0;i<26;i++){
            if(e1[i]!=e2[i] || o1[i]!=o2[i]) return false;
        }
        return true;
    }
}