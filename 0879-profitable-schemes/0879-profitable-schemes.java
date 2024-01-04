class Solution {
    private static final long MOD = 1_000_000_007L;
    public int profitableSchemes(int n, int m, int[] group, int[] profit) {
        long[][] dp = new long[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 0; i < group.length; i++) {
            int g = group[i], p = profit[i];
            for (int j = n - g; j >= 0; j--) {
                for (int k = m; k >= 0; k--) {
                    dp[j + g][Math.min(k + p, m)] += dp[j][k];
                }
            }
            for (int j = 0; j <= n; j++) dp[j][m] %= MOD;
        }
        long res = 0L;
        for (int j = 0; j <= n; j++) res = (res + dp[j][m]) % MOD;
        return (int) res;
    }
}