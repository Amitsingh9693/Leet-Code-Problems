
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[][] dp = new int[n+1][budget+1];
        int[] copy = new int[n];
        int cheap = items[0][1];
        for(int i = 0; i < n; i++) {
            cheap = Math.min(cheap, items[i][1]);
            for(int j = 0; j < n; j++) {
                if(j == i) continue;
                if(items[j][0] % items[i][0] == 0)
                    copy[i]++;
            }
        }
        for(int b = 0; b <= budget; b++)
            dp[0][b] = 0;
        for(int i = 1; i <= n; i++) {
            for(int b = 0; b <= budget; b++) {
                int t = 0;
                if(b >= items[i-1][1]) {
                    t = 1 + copy[i-1]
                        + dp[i-1][b-items[i-1][1]];
                }
                int s = dp[i-1][b];
                dp[i][b] = Math.max(t, s);
            }
        }
        int ans = 0;
        for(int b = 0; b <= budget; b++) {
            ans = Math.max(ans,
                dp[n][b] + (budget-b)/cheap);
        }
        return ans;
    }
}
