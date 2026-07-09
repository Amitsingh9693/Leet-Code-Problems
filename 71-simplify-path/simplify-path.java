class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        int n = path.length();
        int i = 0;
        while (i < n) {
            while (i < n && path.charAt(i) == '/')
                i++;
            String s = "";
            while (i < n && path.charAt(i) != '/') {
                s += path.charAt(i);
                i++;
            }
            if (s.length() == 0 || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!st.isEmpty())
                    st.pop();
            } else {
                st.push(s);
            }
        }
        if (st.isEmpty())
            return "/";
        StringBuilder str = new StringBuilder();
        for (String s : st) {
            str.append("/").append(s);
        }
        return str.toString();
    }
}