class Solution {
    public int numberOfSpecialChars(String word) {
        int[] up = new int[26];
        int[] low = new int[26];

        Arrays.fill(low, -1);
        Arrays.fill(up, -1);

        int c = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                low[ch - 'a'] = i;  
            } else {
                if (up[ch - 'A'] == -1) {
                    up[ch - 'A'] = i; 
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (low[i] != -1 && up[i] != -1 && low[i] < up[i]) {
                c++;
            }
        }

        return c;
    }
}