class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int c = encodedText.length() / rows;
        int s = 0;
        char[][] ans = new char[rows][c];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = encodedText.charAt(s++);
            }
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < c; i++) {
            int r = 0, col = i;
            while (r < rows && col < c) {
                res.append(ans[r++][col++]);
            }
        }

        return res.toString().replaceAll("\\s+$", "");
    }
}