class Solution {

    int[][] memo;
    int[] prefix;

    int sum(int l, int r) {
        if (l == 0) {
            return prefix[r];
        }
        return prefix[r] - prefix[l - 1];
    }

    int solve(int l, int r) {

        if (l == r) {
            return 0;
        }

        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        int ans = 0;

        for (int k = l; k < r; k++) {

            int left = sum(l, k);
            int right = sum(k + 1, r);

            if (left < right) {

                ans = Math.max(
                    ans,
                    left + solve(l, k)
                );

            } else if (left > right) {

                ans = Math.max(
                    ans,
                    right + solve(k + 1, r)
                );

            } else {

                ans = Math.max(
                    ans,
                    left + Math.max(
                        solve(l, k),
                        solve(k + 1, r)
                    )
                );
            }
        }
        return memo[l][r] = ans;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        prefix = new int[n];
        prefix[0] = stoneValue[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stoneValue[i];
        }
        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(0, n - 1);
    }
}