
class Solution {
    public int minInsertions(String s) {
        int ans = 0, l = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') l++;
            else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') i++;
                else ans++;
                if (l > 0) l--;
                else ans++;
            }
        }
        return ans + 2 * l;
    }
}