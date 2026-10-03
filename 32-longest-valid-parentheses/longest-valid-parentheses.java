class Solution {
    public int longestValidParentheses(String s) {

        // Stack<Integer> stack = new Stack<>();
        // int finalOutput = 0;
        // stack.push(-1);
        // for(int i=0;i<s.length();i++)
        // {
        //     if(s.charAt(i)=='(')
        //     {
        //         stack.push(i);
        //     }
        //     else
        //     {
        //         if(s.charAt(i) == ')' && stack.size()>1 && s.charAt(stack.peek())=='(')
        //         {
        //             stack.pop();
        //             finalOutput = Math.max(finalOutput, i-stack.peek());
        //         }
        //         else 
        //         {
        //             stack.push(i);
        //         }
        //     }

        // }

        // return finalOutput;

        int left = 0, right = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                max = Math.max(max, 2 * right);
            else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                max = Math.max(max, 2 * left);
            else if (left > right) {
                left = right = 0;
            }
        }

        return max;
    }
}