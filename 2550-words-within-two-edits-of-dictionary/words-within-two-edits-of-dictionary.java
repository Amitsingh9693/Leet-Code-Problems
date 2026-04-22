class Solution {
    boolean check(String a, String b) {
        int c = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) c++;
            if (c > 2) return false;
        }
        return true;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < dictionary.length; j++) {
                if (queries[i].length() == dictionary[j].length() &&
                    check(queries[i], dictionary[j])) {
                    
                    ans.add(queries[i]);
                    break;
                }
            }
        }

        return ans;
    }
}