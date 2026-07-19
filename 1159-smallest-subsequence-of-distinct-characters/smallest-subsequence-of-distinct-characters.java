class Solution {
    public String smallestSubsequence(String s) {
         int[] f=new int[26];
        boolean[] vis=new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            f[ch-'a']++;
        }

        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            f[ch-'a']--;
            if(vis[ch-'a']) continue;

            while(st.size()>0 && st.peek() >ch && f[st.peek()-'a']>0){
                char rem=st.pop();
                vis[rem-'a']=false;
            }
            st.push(ch);
            vis[ch-'a']=true;
        }

        StringBuilder str=new StringBuilder();
        while(!st.isEmpty()) str.append(st.pop());
        return str.reverse().toString();
    }
}