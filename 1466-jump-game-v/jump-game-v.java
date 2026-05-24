class Solution {

    int f(int[] arr, int[] dp, int d, int i) {

        if (dp[i] != -1) return dp[i];

        int ans = 1;

        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d); j++) {

            if (arr[j] >= arr[i]) break;

            ans = Math.max(ans, 1 + f(arr, dp, d, j));
        }

        for (int j = i - 1; j >= Math.max(0, i - d); j--) {

            if (arr[j] >= arr[i]) break;

            ans = Math.max(ans, 1 + f(arr, dp, d, j));
        }

        return dp[i] = ans;
    }

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, f(arr, dp, d, i));
        }

        return ans;
    }
}