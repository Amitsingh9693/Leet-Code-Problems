class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(') st1.add(i);
            else if(ch==')'){
                if(!st1.isEmpty()) st1.pop();
                else if(!st2.isEmpty()) st2.pop();
                else return false;
            }
            else if(ch=='*') st2.add(i);
        }
        while(!st1.isEmpty()){
            if(st2.isEmpty() || st2.peek()<st1.peek()) return false;
            st1.pop();
            st2.pop();
        }
        return st1.isEmpty();
    }
}